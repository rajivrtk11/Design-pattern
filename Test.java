public enum Test {
    RAJIV("rajiv"),
    MODIN("modin"),
    VINAY("vinay");

    String name;
    Test(String name) {
        this.name = name;
    }

    public String getName() { return this.name; };

    public Test getNameFrom(String value) {
        for(Test test: values()) {
             if(test.name == value) return test;
        }
        return null;
    }
}
