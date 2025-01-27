package Splitwise;

import Splitwise.entity.Expense;
import Splitwise.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShowExpense {
    private HashMap<String, User> expenseDb;

    ShowExpense(HashMap<String, User> expenseDb) {
        this.expenseDb = expenseDb;
    }

    public void showAllExpense() {

    }

    public void showExpense(String lenderId) {
//        User4 owes User1: 250
        HashMap<String, Expense> lendToMap = expenseDb.get(lenderId).getLendToMap();
        Set<Map.Entry<String, Expense>> entries = lendToMap.entrySet();

        for(Map.Entry<String, Expense> entry: lendToMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            if(entry.getValue().getAmount() == 0) continue;
            else {
                if(entry.getValue().getAmount() > 0) {
                    sb.append(entry.getKey() +" owes " + lenderId +": "+ entry.getValue().getAmount());
                }
                else {
                    sb.append(lenderId +"owes" + entry.getKey() +": "+ entry.getValue().getAmount());
                }
            }
            System.out.println(sb.toString());
        }

    }
}
