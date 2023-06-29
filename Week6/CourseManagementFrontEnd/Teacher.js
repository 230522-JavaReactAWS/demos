const url = "http://localhost:8080/"

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

        }

    })

}