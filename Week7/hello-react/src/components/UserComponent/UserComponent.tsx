import React from "react";
import { UserInterface } from "../../interfaces/UserInterface";
import { PostComponent } from "../PostComponent/PostComponent";


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

    //componentDidMount is a LIFECYCLE METHOD often used for populating data after the component loads (mounts)
    //but this can pretty much be used to do ANYTHING as soon as the component renders
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

    //as usual, we need a render method that renders the view of this component
    render(){
        return(
            <div>
                <h2>User: {this.state.firstName} {this.state.lastName}</h2>
                <h3>Email: {this.state.email}</h3>
                <PostComponent {...this.state}></PostComponent>
            </div>
            //to send the entire state object to a child's props, we can use {...this.state}
            //...is like saying "all of this" "the entire state object"
        )
    }

}