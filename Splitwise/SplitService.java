package Splitwise;

import Splitwise.entity.Expense;
import Splitwise.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SplitService {
    HashMap<String, User> expenseDb;

    //    EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL
    public void splitEqually(String[] inputArr, HashMap<String, User> expenseDb) {
        this.expenseDb = expenseDb;

        String lender = inputArr[1];
        int amount = Integer.parseInt(inputArr[2]);
        int totalPeople = Integer.parseInt(inputArr[3]);
        double splitAmount = amount / (totalPeople * 1.0);
        List<Double> splitAmountList = new ArrayList<>();
        List<String> userList = new ArrayList<>();

        for(int i = 0; i < totalPeople; i++) {
            splitAmountList.add(splitAmount);
            userList.add(inputArr[4+i]);
        }

        List<Expense> expenseList = getExpenseList(splitAmountList, userList);

        // split amount
        updateAmountInDb(lender, expenseList);
    }

    public void splitExact(String[] inputArr) {

    }

    public void splitPercent(String[] inputArr) {

    }

    private List<Expense> getExpenseList(List<Double> splitAmountList, List<String> userList) {
        List<Expense> list = new ArrayList<>();
        for(int i = 0; i < splitAmountList.size(); i++) {
            list.add(new Expense(userList.get(i), splitAmountList.get(i)));
        }

        return list;
    }

    private void updateAmountInDb(String lender, List<Expense> expenseList) {
        HashMap<String, Expense> lendToMap = expenseDb.get(lender).getLendToMap();

        for(Expense expense: expenseList) {
            if(lender.equals(expense.getUserId())) continue;
            else {
                // keep mapping in lender
                if(lendToMap.containsKey(expense.getUserId())) {
                    Expense old = lendToMap.get(expense.getUserId());
                    Expense newExpense = new Expense(expense.getUserId(), old.getAmount() + expense.getAmount());
                    lendToMap.put(expense.getUserId(), newExpense);
                }
                else {
                    lendToMap.put(expense.getUserId(), expense);
                }

                // update amount in borrower
                HashMap<String, Expense> borrowerMap = expenseDb.get(expense.getUserId()).getLendToMap();
                if(borrowerMap.containsKey(lender)) {
                    Expense old = borrowerMap.get(lender);
                    Expense newExpense = new Expense(lender, old.getAmount() - expense.getAmount());
                    if(newExpense.getAmount() != 0)
                        borrowerMap.put(lender, newExpense);
                    else {
                        borrowerMap.remove(lender);
                    }
                }
                else {
                    Expense newExpense = new Expense(lender, -expense.getAmount());
                    borrowerMap.put(lender, newExpense);
                }
            }
        }
    }
}
