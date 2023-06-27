//First we'll make a basic named function
//because of "hoisting", we can call this method before it's declared
helloWorld();

function helloWorld(){
    console.log("Hola Mundo")
}

//--------------------

//Here's an anonymous function, it hasn't been named, but it's assigned to a variable
//so basically, it's a function stored in a variable
var anon = function(){
    console.log("I'm an anonymous function... shhhhhh")
}

//so we can call this function from this variable
anon();
console.log(anon) //cool

//---------------------

//Arrow functions are basically like lambdas in Java
//takes in some argument(s) and perform some functionality
let testEquality = (var1, var2) => {
    console.log(var1 == var2) //we ONLY want to compare value
}

//let's call our arrow function to test some equalities
testEquality(1, true) //true, 1 is truthy
testEquality("", false) //true, "" is falsy

//----------------------

//Callback functions take in another function as a parameter

function f1(x){
    console.log("Inside function 1")
    console.log("x is: " + x)
}

function f2(y, func){
    console.log("Inside function 2")
    func(y) //"func" is intended to be a function, which takes "y" as its argument
}

//using the callback function
f2(100, f1)

//-------------------

//Closures - an older way of achieving encapsulation in JS
let helloName = function(name){
    return function(){
        console.log("Hello, " + name)
    }
}

//the nested function can access the "name" argument, but can't change it

//assign the function call to a variable, and give it an argument for "name"
let nameBen = helloName("Ben")
nameBen()

//BUT... once we assign the helloName variable, it can't ever change
helloName = helloName("Jamie")
helloName()

//attempting to change the name argument
let newName = helloName("Eggward")

helloName() //Hello, Jamie still prints, despite us trying to set a new value

console.log("====================(Global Scope)")

//anything that is globally scoped is visible throughout the script

console.log(a) //this is legal... but we get "undefined"
//var a exists, but at this point in the script, no value has been defined for it

/* This is an example of HOISTING. 
any function, and any variable defined with "var" are HOISTED
what does this mean? this means they will be visible throughout their entire scope
They're "hoisted to the top of their scope" */

var a = 5 //defining the variable

console.log(a)

//let's try this with a let

//console.log(b) //ReferenceError! let and const are not hoisted

//once we define b, then of course we can use it
let b = 10
console.log(b)

console.log("===================(Local Scopes)")

//block scope------------

if(true){
    var c = "I'm a var in a block! Block Scoped."
    let d = "I'm a let in a block! Block Scoped."
    console.log(c)
    console.log(d)
}

console.log(c) //this variable is visible outside of its block, since it's a var

//console.log(d) //d is a let! this isn't legal


//functional scope-------

function scopeTest(){
    console.log(e)
    var e = "I'm a var in a function!"
    console.log(e)
}

//console.log(e) //we get an error here, because variables are SCOPELOCKED if they are inside a function



/* MAIN DIFFERENCE BETWEEN BLOCK AND FUNCTIONAL SCOPES?

-vars are visible outside of the block they were declared in
-vars are NOT VISIBLE outside of the function they were declared in */