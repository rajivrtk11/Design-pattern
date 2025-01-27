package Splitwise;

import Splitwise.enums.Operation;

import java.util.Scanner;

public class Application {


    public static void main(String[] args) {
        Splitcontroller splitcontroller = new Splitcontroller();
        Scanner scn = new Scanner(System.in);

        while(scn.hasNext()) {
            String input = scn.nextLine();
            String[] inputArr = input.split(" ");
            switch (inputArr[0]) {
                case Operation.SHOW -> {
                    splitcontroller.showController(inputArr);
                }
                case Operation.EXPENSE -> {
                    splitcontroller.splitController(input);
                }
            }
        }
    }
}
