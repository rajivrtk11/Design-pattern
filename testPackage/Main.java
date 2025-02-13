package testPackage;

import testPackage.enums.Command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while(true) {
            Command fromString = Command.getFromString(scn.next());
            switch (fromString) {
                case INPUT -> System.out.println("Input");
                case DISPLAY -> System.out.println("Display");
                case PLAY -> System.out.println("Play");
                case QUIET -> System.out.println("Quiet");
                case null -> { return; }
            }
        }
    }
}
