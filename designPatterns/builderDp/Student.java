package designPatterns.builderDp;

public class Student {
    private String fName;
    private String lName;
    private String age;
    private String weight;

    private Student(Builder builder) {
        this.fName = builder.fName;
        this.lName = builder.lName;
        this.age = builder.age;
        this.weight = builder.weight;
    }

    public String getlName() {
        return lName;
    }

    public String getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String fName;
        private String lName;
        private String age;
        private String weight;

        public  Student build() {
            return new Student(this);
        }
        public String getfName() {
            return fName;
        }

        public Builder setfName(String fName) {
            this.fName = fName;
            return this;
        }

        public String getlName() {
            return lName;
        }

        public Builder setlName(String lName) {
            this.lName = lName;
            return this;
        }

        public String getAge() {
            return age;
        }

        public Builder setAge(String age) {
            this.age = age;
            return this;
        }

        public String getWeight() {
            return weight;
        }

        public Builder setWeight(String weight) {
            this.weight = weight;
            return this;
        }
    }
}
