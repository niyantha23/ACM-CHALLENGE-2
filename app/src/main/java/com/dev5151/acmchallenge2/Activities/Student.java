package com.dev5151.acmchallenge2.Activities;

import android.widget.ArrayAdapter;

public class Student  {
private String regNo,name,age,city;
public Student(){}
public Student(String regNo,String name,String age,String city){
    this.regNo=regNo;
    this.name=name;
    this.age=age;
    this.city=city;
}

    public String getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getRegNo() {
        return regNo;
    }
}
