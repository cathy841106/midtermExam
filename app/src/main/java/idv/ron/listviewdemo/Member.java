package idv.ron.listviewdemo;

import android.text.Editable;

public class Member { // VO- Value Object

    private int id;
    private String name;
    private int age;
    private String sex;
    private String major;


    //建構子
    public Member() {
        super();
    }

    //建構子
    public Member(int id, String name, int age, String sex, String major) {

        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.major = major;

    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {this.sex = sex;}

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {this.major = major;}
}
