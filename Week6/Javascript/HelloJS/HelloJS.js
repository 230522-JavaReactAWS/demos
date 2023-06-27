//This is a print statement in JS. In your browser hit ctrl + shift + i to jump straight to the console
console.log("=====================(Printing/Declaring Variables")

a = 5; //Javascript is loosely typed! We don't need to declare a datatype
//and since we didn't declare var, let, or const, it's var by default

console.log(a)

//unassigned variables are "undefined"
var b;
console.log(b)

//JS Arrays can hold any variation of data types
numbersAndMore = [1, "string", true]

console.log(numbersAndMore)


//== compares value (and only value)
console.log("5" == 5)

//=== compares value AND DATATYPE
console.log("5" === 5)

/*
=== is good for type safety
yes, value is probably usually all you care about... 
but why not take the extra steps to ensure you're getting appropriate datatypes? 
this helps remedy user error or avoid malicious attacks
*/

console.log("======================Type Coercion")

var tc1 = "5" * 5
console.log("String times number is: " + typeof tc1)

var tc2 = "5" + 5
console.log("String plus number is: " + typeof tc2)

//order doesn't matter if there are only two variables in the mix

//order DOES matter when we have multiple operators

var tc3 = 5 + 5 + "5"
console.log(tc3) //105 (10 + "5")
console.log("number + number + string is: " + typeof tc3)

var tc4 = "5" + 5 + 5
console.log(tc4) //555 ("5" + 5 = "55") ("55" + 5 = "555")
console.log("number + number + string is: " + typeof tc4)

var tc5 = "5" * 5 + 5
console.log(tc5) //30 ("5" * 5 = 25) (25 + 5 = 30)

//"it's all numbers UNTIL a String gets mixed in"

//type coercion depends on 2 things:
// - the math operators involved (is there a +)
// - the data types involved (is there a string)

console.log("=====================Truthy/Falsy")

//I want to declare a function that compares two vars
function testTrueFalse(var1, var2){

    console.log(var1 + " compared to " + var2)
    console.log(var1 == var2) //checking for value equality

}

//let's use the above function to talk about truthy/falsy
testTrueFalse(0, false) //true, 0 is falsy
testTrueFalse(1, true) //true, 1 is truthy
testTrueFalse("", false) //true, "" is falsy
testTrueFalse(2, true) //false... WHY?? see below:

//while 2 IS considered truthy, the boolean true evaluates to the number 1, while the boolean false evaluates to 0
//so comparing true with any number besides 1 will return false

//proving that 2 is truthy:
if(2){
    console.log("2 is truthy")
}

/*for the sake of study, the falsy values are:

false
0
""
null
NaN
undefined

*/

//NaN (Not a Number) gets returned when a mathematical operation does not return a number
console.log(0/0)