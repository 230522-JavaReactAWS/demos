//DOM Selection/Manipulation

//I want to select my two divs with class = coolDivs
let divElements = document.getElementsByClassName("coolDivs") //DOM SELECTION!!

console.log(divElements)

//Every time one of the divs is clicked, execute the alarm function
let div1 = divElements[0]
div1.addEventListener("click", alarm)

let div2 = divElements[1]
div2.addEventListener("click", alarm)

//this function will display a popup with some given message
function alarm(){
    alert("A DIV WAS CLICKED!!")
}