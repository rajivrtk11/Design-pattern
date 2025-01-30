package splitwise1.services;

import splitwise1.entity.Expense;
import splitwise1.entity.ExpenseType;
import splitwise1.repository.ExpenseRepository;
import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService() {
        expenseRepository = new ExpenseRepository();
    }

    public void splitAmount(String[] inputArr) {
        String splitType = inputArr[3+Integer.parseInt(inputArr[3])+1];

        if(ExpenseType.EQUAL.toString().equals(splitType)) {
            splitEqual(inputArr);
        }
        else if(ExpenseType.EXACT.toString().equals(splitType)) {

        }
        else if(ExpenseType.PERCENT.toString().equals(splitType)) {

        }
    }

    private void splitEqual(String[] inputArr) {
        String lender = inputArr[1];
        int spendAmount = Integer.parseInt(inputArr[2]);
        int totalPeople = Integer.parseInt(inputArr[3]);
        double individualShare = spendAmount / (totalPeople * 1.00);
        List<String> usersList = new ArrayList<>();

        for(int i = 0; i < totalPeople; i++) {
            usersList.add(inputArr[4+i]);
        }

        List<Expense> expensesList = getExpenseList(lender, usersList, individualShare);
        expenseRepository.updateExpenseInDb(lender, expensesList);
    }

    private void splitExact(String[] inputArr) {

    }

    private void splitPercent(String[] inputArr) {

    }

    private List<Expense> getExpenseList(String lender, List<String> userList, Double amount) {
        List<Expense> expensesList = new ArrayList<>();
        for(String user: userList) {
            if(lender.equals(user)) continue;
            expensesList.add(new Expense(user, amount));
        }

        return expensesList;
    }
}
