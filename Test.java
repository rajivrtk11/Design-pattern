import java.util.Objects;

public enum Test {
    RAJIV("rajiv"),
    MODIN("modin"),
    VINAY("vinay");

    String name;
    Test(String str) {
        this.name = str;
    }

    public String getName(){
        return this.name;
    }

    public static Test getFromString(String str) {
        for(Test t: values()) {
            if(Objects.equals(t.name, str)) return t;
        }

        throw new IllegalArgumentException("No matching status found for given description: "+ str);
    }
}
