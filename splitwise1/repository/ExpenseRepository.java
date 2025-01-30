package splitwise1.repository;

import splitwise1.entity.Expense;
import splitwise1.entity.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseRepository {
    public static Map<String, User> expenseDb = new HashMap<>();

    public ExpenseRepository() {
        expenseDb = new HashMap<>();
    }

    public void updateExpenseInDb(String lender, List<Expense> expensesList) {
        Map<String, Expense> lendToMap = expenseDb.get(lender).getLendToMap();

        for(Expense expense: expensesList) {
            // forward mapping lender -> ower mapping
            if(!lendToMap.containsKey(expense.getUserId())) {
                lendToMap.put(expense.getUserId(), expense);
            }
            else {
                // get existing expense and update that
                double newExpenseAmount = lendToMap.get(expense.getUserId()).getAmount() + expense.getAmount();
                Expense newExpense = new Expense(expense.getUserId(), newExpenseAmount);
                if(newExpenseAmount != 0) {
                    lendToMap.put(expense.getUserId(), newExpense);
                }
            }

            // backward mapping ower -> lender mapping
            String owerId = expense.getUserId();
            Map<String, Expense> owerLendToMap = expenseDb.get(owerId).getLendToMap();
            double previousBalance = 0;
            if(owerLendToMap.containsKey(lender)) {
                previousBalance = owerLendToMap.get(lender).getAmount();
            }

            double netOwerAmount = previousBalance - expense.getAmount();
            if(netOwerAmount != 0) {
                owerLendToMap.put(lender, new Expense(lender, netOwerAmount));
            }
        }
    }
}

