package Splitwise;

import Splitwise.entity.User;
import Splitwise.enums.*;

import java.util.HashMap;

public class Splitcontroller {
    public HashMap<String, User> expenseDb;
    SplitService splitService;
    ShowExpense showExpense;

    Splitcontroller() {
        expenseDb = new HashMap<>();
        splitService = new SplitService();
        this.showExpense = new ShowExpense(expenseDb);
        expenseDb.put("u1", new User("u1", "Rajiv", "rajiv@gmail.com", "1212"));
        expenseDb.put("u2", new User("u2", "Sachin", "sachin@gmail.com", "1212"));
        expenseDb.put("u3", new User("u3", "Kapil", "kapil@gmail.com", "1212"));
        expenseDb.put("u4", new User("u4", "Sahil", "sahil@gmail.com", "1212"));

    }

    public void showController(String[] input) {
        switch (input.length) {
            case 1 -> {
                showExpense.showAllExpense();
            }
            case 2 -> {
                showExpense.showExpense(input[1]);
            }
        }
    }

//    EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL
//    EXPENSE u1 1250 2 u2 u3 EXACT 370 880
//    EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
    public void splitController(String input) {
        String[] inputArr = input.split(" ");
        int userCount = Integer.parseInt(inputArr[3]);
        String splitType = inputArr[userCount+3+1];

        switch (splitType) {
            case SplitType.EQUAL: {
                splitService.splitEqually(inputArr, expenseDb);
                break;
            }
            case SplitType.EXACT: {
                splitService.splitExact(inputArr);
                break;
            }
            case SplitType.PERCENT: {
                splitService.splitPercent(inputArr);
                break;
            }
            default:
                System.out.println("Please enter valid input");
                break;
        }

    }
}
