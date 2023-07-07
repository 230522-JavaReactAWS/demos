import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import "./Login.css"
import axios from 'axios'
import { state } from '../../store'

export const Login: React.FC<any> = () => {

    //useState hooks to declare some state variables that will hold username and password
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")

    //we need useNavigate to allow us to navigate between components... no more manual URL changing!!
    const navigate = useNavigate()

    /* when the user updates the username OR password, this will be called thanks to onChange below 
    the username OR password state variables will get updated based on the name of the input that's changing*/
    const gatherInput = (input:any) => {
        if(input.target.name === "username"){
            setUsername(input.target.value)
        } else {
            setPassword(input.target.value)
        }
        console.log(input.target.value)
    }


    //this function will gather the user input for username/password, and send a POST request to our backend
    const login = async () => {

        //send an HTTP POST request with axios, and store the response in a variable that we can use
        const response = await axios.post("http://localhost:8080/auth/login", {username, password})
        .then((response) => {
                //if the login was successful, log the user in and store the JWT
                state.JWT = response.data.accessToken //STORED IN GLOBAL STATE IN STORE.TS

                console.log(state.JWT) //the store.ts file has been changed! And now we can use JWT in our auth headers.
                console.log(response.data.accessToken)


                //we can use the useNavigate variable above to switch URLs (thus switching components)
                navigate("/home")
            }
        )
        .catch((error) => {
            alert("Login failed! Please try again...")
        })



        //TODO: hey Ben see what happens if we don't have async/await



    }

    return(
        <div className="login">

            <div className="text-container">
                <h1>Welcome to The Pokemon Exchange</h1>
                <h3>Sign in the browse for a Pokemon!</h3>

                <div className="input-container">
                    <input type="text" placeholder="username" name="username" onChange={gatherInput}/>
                </div>
                <div className="input-container">
                    <input type="password" placeholder="password" name="password" onChange={gatherInput}/>
                </div>

                <button className="login-button" onClick={login}>Login</button>
            </div>

        </div>
    )
    /* TODO: white outer glow */

}