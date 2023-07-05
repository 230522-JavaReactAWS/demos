import React from "react";
import { UserInterface } from "../../interfaces/UserInterface";

/* export CONST instead of export CLASS. We're in a function component!
Recall how arrow functions work. they take in some arguments, and execute some code
In this case, we take in a User Interface as props to use in this function */
export const PostComponent: React.FC<UserInterface> = (user:UserInterface) => {

    /*Destructuring 
    We're breaking apart the UserInterface object that was passed in as props
    Destructuring essentially lets us break up a props object into individual variables 
    The name inside the curly braces must match the variable in the props that was sent in */
    const {username} = user
    const {email} = user
    //we could have also said const {username, email} = user


    /* useState and useEffect - two lifecycle hooks */


    //in function components, we only need return(), no render()
    return(
        <div className="post-container">
            <div className="profile-container">
                <img className="profile-pic" src="https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg" alt="PROFILE PIC" />
                <h4 className="profile-username">{username}</h4>
            </div>

            <div className="content-container">
                <h5>{username} says:</h5>
                <p>SOME DATA WILL GO HERE</p>
            </div>
        </div>
    )

}