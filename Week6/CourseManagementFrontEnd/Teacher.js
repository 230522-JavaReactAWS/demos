//get the data out of the JWT to use its values
let loggedInUser = parseJwt(document.cookie)

console.log(loggedInUser) //view our user data

//use our loggedInUser data to fill the page header
//here, we're using the sub (which is username), as well as Role and Id
document.getElementById("greeting").innerText = "Welcome " + loggedInUser.sub + ", " + loggedInUser.Role + " " + loggedInUser.Id

//for P1, you'll do something similar to put an User's Id in a new Reimbursement 

const url = "http://localhost:8080/"

//make sure that the createCourseButton invokes the createCourse() method onclick
document.getElementById("createCourseButton").onclick = createCourse

//GET ALL COURSES
//Thanks to window.onload, get all courses will happen automatically
window.onload = async function(){

    //we need to send a fetch request to get all courses. Remember, fetch requests send GETs by default
    await fetch(url + "courses")

    .then((response) => response.json()) //extracting the JSON data, and turning it into JS
    .then((data) => {

        //print out the incoming data to make sure we can see it
        console.log(data)

        //for every Course object we get from our fetch request, populate a new table row 
        for(let course of data){

            //create a new table row
            let row = document.createElement("tr")

            //create a new cell (td) for each course variable
            let cell = document.createElement("td")
            //fill the cell with the appropriate course data
            cell.innerText = course.id
            //add the td element to the tr element
            row.appendChild(cell)

            //we will do this^^^ for every column in courses
            let cell2 = document.createElement("td")
            cell2.innerText = course.name
            row.appendChild(cell2)

            let cell3 = document.createElement("td")
            cell3.innerText = course.description
            row.appendChild(cell3)

            let cell4 = document.createElement("td")
            cell4.innerText = course.credits
            row.appendChild(cell4)

            //putting approve/deny buttons in the table
            let cell5 = document.createElement("td")
            //make approve button
            var approveButton = document.createElement("button")
            approveButton.innerText = "Approve"
            //make deny button
            var denyButton = document.createElement("button")
            denyButton.innerText = "Deny"
            //add the new buttons!
            cell5.appendChild(approveButton)
            cell5.appendChild(denyButton)
            row.appendChild(cell5)

            //append the tr (table row) to the tbody (table body)
            //a new row will be added FOR EVERY course that got returned in the fetch()
            document.getElementById("tableBody").appendChild(row)

            //in P1 you'll do something very similar for get all pending requests and get requests by user id

            //when either of these buttons are clicked, a course can be approved OR denied
            approveButton.onclick = () => approveDenyFunction(1, course.id)
            denyButton.onclick = () => approveDenyFunction(2, course.id)

        } //end of for loop

      

    })

} //end of get all courses


//CREATE COURSE (analogous to create reimbursement in P1)
async function createCourse(){

    //put the user's inputs into an object (doing this the shorter way than we did with login)
    let newCourse = {
        name: document.getElementById("courseName").value,
        description: document.getElementById("courseDesc").value,
        credits: document.getElementById("courseCreds").value
    }

    console.log(newCourse) //printing out the object to make sure our data is valid

    //remember, fetch takes two parameters. (url, {configuration object})
    await fetch(url + "courses", {
        method: "POST", //make this a POST request

        headers:{
            "Content-Type":"application/json",
            "Authorization": "Bearer " + document.cookie
        },

        body: JSON.stringify(newCourse) //turn our newCourse object into JSON
    })
    .then((response) => response.json()) //extract the body of the HTTP response, and turn it into a JS object
    .then((data) => {
        console.log(data)
        alert("course created!")
    })
    .catch((error) => {alert("failed to create! " + error)})

}


function approveDenyFunction(newStatus, id){

    //Depending on the number given, the course will either be approved or denied
    //THIS WILL ACTUALLY BE FETCH REQUESTS. WITH A "PUT" VERB, MOST LIKELY
    //You will need to provide the id of the reimbursement to update, as well as the new status id fk.
    //you can either send that ID as path params or in the body for which you'll need to make a Reimbursement object for
    if(newStatus === 1){
        alert("course " + id + " approved!")

        //example of an object we'd send in the fetch request body
        //THIS SHOULD MATCH THE MODEL IN JAVA
        let updatedCourse = {
            id: data.id,
            name: data.name,
            description: data.description,
            credits: data.credits
        }

        //PUT requests are quite similar to POSTs, except for specific distinctions
        //for instance the method will be "PUT" instead of POST

    } 
    else if(newStatus === 2){
        alert("course " + id + " denied!")
    }

    //yes, this could just be an else

}


//JWT UTILITY FUNCTION---

//I didn't write this. It's a standard JWT parser, which should give us our payload (important user info)
function parseJwt (token) {
    console.log(token)
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}