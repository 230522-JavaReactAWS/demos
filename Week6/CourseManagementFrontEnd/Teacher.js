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

            //append the tr (table row) to the tbody (table body)
            //a new row will be added FOR EVERY course that got returned in the fetch()
            document.getElementById("tableBody").appendChild(row)

            //in P1 you'll do something very similar for get all pending requests and get requests by user id

        }

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

    console.log(window.jwt)

    //remember, fetch takes two parameters. (url, {configuration object})
    await fetch(url + "courses", {
        method: "POST", //make this a POST request

        headers:{
            "Content-Type":"application/json",
            "Authorization": "Bearer " + window.jwt
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