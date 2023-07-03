import React from "react";
import { UserInterface } from "../../interfaces/UserInterface";


//This component has props of "any" so it could take any data from a parent class
//It also takes state of UserInterface, so it can only ever hold a state object that has those fields
    //(UserInterface: firstName, lastName, username, email)
export class UserComponent extends React.Component<any, UserInterface>{

    //constructor that initializes the User's variables to empty Strings (we'll change this later)
    constructor(props:any){
        super(props)

        this.state = {
            firstName:"",
            lastName:"",
            username:"",
            email:""
        }

    }

    //componentDidMount is a LIFECYCLE HOOK often used for populating data after the component loads (mounts)
    //but this can pretty much be used to do ANY as soon as the component renders
    componentDidMount(): void {

    //hardcoding - but imagine we're making some HTTP call to a server (with axios) which grabs user data (maybe login?)
    //to set the fields of the state object in the class component, we use this.setState()
        this.setState({
            firstName:"Beanjamin",
            lastName:"P",
            username:"bigbon",
            email:"reactluvr111@revature.com"
        })

    }

}