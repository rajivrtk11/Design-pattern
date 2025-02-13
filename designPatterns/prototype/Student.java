package designPatterns.prototype;

public class Student implements Prototype<Student> {
    private String name;
    private String age;
    private String mobileNo;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public Student clone() {
        Student newSt = new Student();
        newSt.name = this.name;
        newSt.age = this.age;
        newSt.mobileNo = this.mobileNo;

        return newSt;
    }

    @Override
    public Student copy() {
        Student newSt = new Student();
        newSt.name = this.name;
        newSt.age = this.age;
        newSt.mobileNo = this.mobileNo;

        return newSt;
    }


}
