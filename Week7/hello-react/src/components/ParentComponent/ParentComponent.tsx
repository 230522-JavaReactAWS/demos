import React from "react";

/* Again, every Class Component has two parameters - <props, and state>
 by leaving the state parameter as "any", we can define whatever object we want to store in the state
 we will leave the props parameter empty, since we don't intend to receive any data to this component */
export class ParentComponent extends React.Component<{}, any>{

    //creating a state object to store data
    //this object can be sent to a child component!
    state = {
        color:"green",
        animal:"dog"
    }

    //we will nest a child component in this parent component to demonstrate props/state
    //specifically, we always send the state to the child's props, not the other way around
    render(){
        return(
            <div>
                <h1>Hello from the Parent Component! My favorite color is: {this.state.color}</h1>
                
            </div>
        )
    }

}