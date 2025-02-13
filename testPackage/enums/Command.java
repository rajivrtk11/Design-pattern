package testPackage.enums;

public enum Command {
    DISPLAY("display"),
    INPUT("input"),
    QUIET("quiet"),
    PLAY("play");

    private String str;

    Command(String str) {
        this.str = str;
    }

    public String getString() {
        return this.str;
    }

    public static Command getFromString(String str) {
        for(Command c: values()) {
            if(c.str.equals(str)) return c;
        }

        System.out.println("No command found with the given input string");
        return null;
    }
}
