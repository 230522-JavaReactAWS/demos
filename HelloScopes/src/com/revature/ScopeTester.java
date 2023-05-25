package com.revature;

public class ScopeTester {

    //This is a Class scoped primitive variable *Note the "static" non-access modifier
    //we will initialize it with the value 5.
    public static int i1 = 5;

    //This is another Class scoped primitive, but it is UNinitialized. No value yet.
    public static int i2;

    //This is an INSTANCE scoped primitive variable *Note the lack of the "static" non-access modifier
    public int i3 = 10;

    /* BIG PICTURE?

    Each instance (object) of this class will share the values for i and i2 (class scoped)
    Each instance of this class will have its OWN value for i3 (instance scoped)

    This is one of the reasons we may or may not want to use static variables

    If you change the value of i or i2, it will change for every object
    If you change the value of i3, it will only change for the object you changed it in
     */


}
