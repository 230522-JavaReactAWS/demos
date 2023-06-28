//DOM Selection/Manipulation

//I want to select my two divs with class = coolDivs
let divElements = document.getElementsByClassName("coolDivs") //DOM SELECTION!!

console.log(divElements)

/* We can set attributes of elements directly (DOM MANIPULATION!), though it's not best practice

one possible case this would be preferable? 
Maybe if a user does something wrong, you can change a preexisting text to red
(But even then, there may be better ways to tell the user they're wrong) */

let div1 = divElements[0]
div1.setAttribute("style", "background-color:pink")

let div2 = divElements[1]
div2.setAttribute("style", "font-family:arial; color:blue")

//Every time one of the divs is clicked, execute the alarm function
div1.addEventListener("click", alarm)
div2.addEventListener("click", alarm)

//this function will display a popup with some given message
function alarm(){
    alert("A DIV WAS CLICKED!!")
}

//the way I prefer to do event listeners:
document.getElementById("btn").onclick = populateData

//hoisted!
function populateData(){

    //I want the button's text to change after click
    document.getElementById("btn").textContent = "Thanks :)"

    //set the previously empty paragraph's text to something else
    document.getElementById("p3").textContent = "SURPRISE! YOU THOUGHT YOU SAW THE LAST OF ME"

    //note that this new text is blue and arial, because of the manipulation of its parent div

}

//lastly, when we scroll over the h3, we can change its text and the color
//when we scroll OFF of it, we'll revert the changes

//first we need to add an event listener with DOM selection
//let's save this one into a variable since we intend to use it multiple times
let header = document.getElementById("header")
header.addEventListener("mouseover", toggleDarkMode)

function toggleDarkMode(){
    if(header.textContent === "Scroll over me!"){
        header.textContent = "Dark mode enabled"
        document.body.style = "background-color:gray"
    } else {
        header.textContent = "Scroll over me!"
        document.body.style = "background-color:white"
    }
    //that's crazyyyyy we have access to a style property
    //so maybe setAttribute above isn't necessary for style changes
    //but still know the syntax because there are other attributes you can set
}

//for this toggle we COULD HAVE made a separate function, and made it revert the changes when the mouse scrolls off.

//ALSO... buttons are probably your best for dark mode toggle. So the user will have to deliberately change the mode, instead of scrolling somewhere