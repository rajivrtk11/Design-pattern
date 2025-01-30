package splitwise1.services;

import splitwise1.entity.Expense;
import splitwise1.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static splitwise1.repository.ExpenseRepository.expenseDb;
import static splitwise1.utils.CommonUtils.showArrayList;

public class ShowService {

    public void showExpense(String[] inputArr) {
        if(inputArr.length == 1) {
            showAllExpense();
        }
        else {
            showExpenseByUserId(inputArr[1]);
        }
    }

    private void showExpenseByUserId(String userId) {
        Map<String, Expense> lendToMap = expenseDb.get(userId).getLendToMap();
        List<String> listToShow = new ArrayList<>();

        for(Map.Entry<String, Expense> entries: lendToMap.entrySet()) {
            double amount = lendToMap.get(entries.getKey()).getAmount();
            if(amount > 0) {
                String str = entries.getKey()+" owes "+userId+ ": "+amount;
                if(!listToShow.contains(str)) {
                    listToShow.add(str);
                }
            }
            else {
                String str = userId +" owes "+entries.getKey()+ ": "+(-1*amount);
                if(!listToShow.contains(str)) {
                    listToShow.add(str);
                }
            }
        }
        System.out.println(listToShow);
        showArrayList(listToShow);
    }

    private void showAllExpense() {
        for(Map.Entry<String, User> entries: expenseDb.entrySet()) {
            showExpenseByUserId(entries.getKey());
        }
    }
}
