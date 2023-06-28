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

    })

}