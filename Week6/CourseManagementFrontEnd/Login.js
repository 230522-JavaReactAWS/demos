const url = "http://localhost:8080/" //storing the base URL in this variable for cleaner code below

//when the user clicks the login button (onclick), execute the login function below
document.getElementById("loginButton").onclick = login

//you can imagine that we'd probably add an onclick to the register button and assign it to some register function


//this function will involve a promise object (since we're using fetch) so we need it to be an "async function"
//"await", which we see in the fetch requests is what tells the method to pause until the promise comes back
async function login(){

    //put the user's inputs for username/password into variables
    let username = document.getElementById("username").value
    let password = document.getElementById("password").value

    //create a LoginDTO object to send to the backend
    //the name of the object doesn't matter. 
    //you want to variables to match your Java LoginDTO class though.
    let loginDTO = {
        username:username,
        password:password
    }
    //left of the colon is VARIABLE NAMES. right of the colon is VALUES. Just like in JSON (JavaScript Object Notation)

    console.log(loginDTO) //print out the values, to make sure they look good 

    //send a request with the LoginDTO to the backend using fetch!
    //REMEMBER - two parameters. URL (where the request is going), and Config Object (instructions for the request)
    await fetch(url + "auth/login", {

        method: "POST", //send a POST request (would be a GET if we didn't specify)
        headers: {"Content-Type":"application/json"}, //specifies the type of data we're sending (JSON)
        body: JSON.stringify(loginDTO) //turn our LoginDTO in JSON to send in the request body

    })

    //we need to use .then(), .catch(), and .finally() to handle successful and unsuccessful fetch requests
    //remember, .then() handles successful requests, .catch() provides error handling, and .finally() always happens


    .then((response) => response.json()) //extract the body of the HTTP Response (which came from the backend)
    .then((data) => { 

        //notice our JWT returned in the response body
        console.log(data)
        console.log(data.accessToken)

        //we need to translate our JWT to gather the incoming user data (name, id, role, etc)
        console.log(parseJwt(data.accessToken))

        //use the data to determine what landing page the user gets sent to (teacher page vs student page)
        if(parseJwt(data.accessToken).Role === "Teacher"){
            //switch to the teacher page
            window.location.href = "Teacher.html"

        } else {
            //send them to the student page

            //window.loction.href = "Student.html"
        }
        

    })
    .catch((error) => {document.getElementById("header").innerHTML = "Login Failed! Try again..."})
    .finally(() => alert("hi"))

    //TODO: Ben will fix the catch block. Why is it not catching? :(

}



//I didn't write this. It's a standard JWT parser, which should give us our payload (important user info)
function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}