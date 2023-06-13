package com.revature.review;

public class Driver {

    public static void main(String[] args) {
        Firefighter ff = new Firefighter();
        ff.setYearsOfService(12);

        ff.setAge(-123);

        PoliceOfficer po = new PoliceOfficer();

        po.setYearsOfService(-1);


        System.out.println(ff.getAge());
        System.out.println(po.yearsLeftBeforePension());
    }
}
