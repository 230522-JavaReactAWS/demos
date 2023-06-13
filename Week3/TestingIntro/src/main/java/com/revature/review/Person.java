package com.revature.review;

public class Person {

    private String name;

    private int age;

    private int yearsOfService;

    public int yearsLeftBeforePension(){
       if (yearsOfService >= 15) {
           return 0;
       }
       return 15 - yearsOfService;
    }

    public Person() {
    }

    public Person(String name, int age, int yearsOfService) {
        this.name = name;
        this.age = age;
        this.yearsOfService = yearsOfService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18){
            this.age = age;
        } else{
            this.age = 18;
        }

    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        if (yearsOfService >= 1){
            this.yearsOfService = yearsOfService;
        } else{
            yearsOfService = 1;
        }

    }
}
