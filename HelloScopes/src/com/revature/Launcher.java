package com.revature;

public class Launcher extends ScopeTester{

    public static void main(String[] args) {

        System.out.println("==========================(Using ScopeTester's variables)");

        //since i1 and i2 are STATIC, we can call them directly from the class
        //we don't need to instantiate a ScopeTester object
        System.out.println(ScopeTester.i1);
        System.out.println(ScopeTester.i2);

        //Java doesn't like this. i3 is non-static so we cannot access it directly in a static method
        //System.out.println(ScopeTester.i3);

        //Instantiate a ScopeTester object. We didn't define a constructor, so the default no-args is used.
        ScopeTester st = new ScopeTester();

        //Now that we've DEFINED a ScopeTester object, we can access all of its variables (even nonstatics)
        System.out.println(st.i3);

        System.out.println("===========================(Manipulating ScopeTester's variables)");



    }


    //nonstatic methods can call statics no problem. The strictness is with static methods calling things
    public static void hello(){

    }

    public void hi(){
        System.out.println(ScopeTester.i1);
        hello();
    }

    //can't override static methods

//    @Override
//    public static void yo(){
//
//    }

}
