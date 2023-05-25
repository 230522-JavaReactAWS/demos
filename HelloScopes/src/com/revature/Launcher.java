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

        //instantiate a new ScopeTester object to demonstate changing static/nonstatic variables
        ScopeTester st2 = new ScopeTester(); //so now we have st and st2. two different objects

        //above, we printed out i, i2, and i3.
        //let's print them out from st2 this time
        System.out.println(st2.i1);
        System.out.println(st2.i2);
        System.out.println(st2.i3);

        //now, let's change these in st2.
        st2.i1 = 100;
        st2.i2 = 200;
        st2.i3 = 300;

        //now, let's see what the values are between both ScopeTest objects st and st2
        System.out.println("i1 of st: " + st.i1);
        System.out.println("i1 of st2: " + st2.i1);
        //Since i1 is static, when we change it in one ScopeTester object, it changes for both

        System.out.println("i2 of st: " + st.i2);
        System.out.println("i2 of st2: " + st2.i2);
        //Same as with i1, i2 is static so the value changes for both objects

        System.out.println("i3 of st: " + st.i3);
        System.out.println("i3 of st2: " + st2.i3);
        //Since i3 is NON STATIC, and we only changed it in one object, the other object is unchanged

        //for every static variable, the most recent value will be shared amongst every object
        //for non static variables, only the object you changed the value in will change

        System.out.println("=========================(Method/Block Scope)");

        //System.out.println(methodScopedInt); Java doesn't know what this is. It's method scoped

        scopedMethod();

    } //end of main method

    public static void scopedMethod(){

        int methodScopedInt = 25; //this variable is METHOD SCOPED. Only visible within this method

        if(true){
            int blockScopedInt = 52; //this variable is BLOCK SCOPED. Only visible within its {block}

            //these print out, they're being accessed within the scope they were defined in
            System.out.println(methodScopedInt);
            System.out.println(blockScopedInt);
        }

        //Java doesn't like this. We're trying to access it outside the scope it was defined in
        //System.out.println(blockScopedInt);

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
