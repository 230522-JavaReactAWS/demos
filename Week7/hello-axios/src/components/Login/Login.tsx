import React from 'react'
import { useNavigate } from 'react-router-dom'
import "./Login.css"

export const Login: React.FC<any> = () => {

    //we need useNavigate to allow us to navigate between components... no more manual URL changing!!
    const navigate = useNavigate()

    //this function will gather the user input for username/password, and send a POST request to our backend
    const login = async () => {

        //a bunch of login logic...
        //TODO: hey Ben see what happens if we don't have async/await

        //we can use the useNavigate variable above to switch URLs (thus switching components)
        navigate("/home")

    }

    return(
        <div className="login">

            <h1>Welcome to The Pokemon Exchange</h1>
            <h3>Sign in the browse for a Pokemon!</h3>

            <button className="login-button" onClick={login}>Login</button>

        </div>
    )

}