package splitwise1;

import splitwise1.entity.OperationType;
import splitwise1.entity.User;
import splitwise1.services.ExpenseService;
import splitwise1.services.ShowService;

import java.util.Scanner;

import static splitwise1.repository.ExpenseRepository.expenseDb;

public class Application {
    static ExpenseService expenseService = new ExpenseService();
    static ShowService showService = new ShowService();

    public static void main(String[] args) {
        expenseDb.put("u1", new User("u1", "Rajiv Singh", "rajivrtk11@gmail.com", "12345"));
        expenseDb.put("u2", new User("u2", "Sidharth Singh", "sidharth11@gmail.com", "12345"));
        expenseDb.put("u3", new User("u3", "Modin Singh", "modin11@gmail.com", "12345"));
        expenseDb.put("u4", new User("u4", "Vinay Singh", "vinay11@gmail.com", "12345"));

        Scanner scn = new Scanner(System.in);
        while (scn.hasNext()) {
            String str = scn.nextLine();
            String[] inputArr = str.split(" ");

            if(OperationType.EXPENSE.toString().equals(inputArr[0])) {
                expenseService.splitAmount(inputArr);
            }
            else if(OperationType.SHOW.toString().equals(inputArr[0])) {
                showService.showExpense(inputArr);
            }
            else {
                System.out.println("Invalid operation");
            }
        }
    }
}
