package com.dev5151.acmchallenge2.Activities;
public class Student  {
private String regNo,name,age,city,phone,imageUrl;
public Student(){}
public Student(String regNo,String name,String age,String city,String phone){
    this.regNo=regNo;
    this.name=name;
    this.age=age;
    this.city=city;
    this.phone=phone;
    this.imageUrl=imageUrl;
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
    public String getPhone(){return phone;}
    public String getImageUrl() {
        return imageUrl;
    }
}
