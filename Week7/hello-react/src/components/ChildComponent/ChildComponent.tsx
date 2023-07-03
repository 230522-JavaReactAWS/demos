import React from "react";

/* Notice props is of "any", since parent state is "any"... but why put state as "any" here?? 
it's good for scalability. Imagine we DO end up making a component a child of this component.
then, we could send state no problem without changing any original source code*/

//ParentComponent will send state of "any" type. ChildComponent accepts props of "any" type
//The state from the ParentComponent will ALWAYS be the props in the ChildComponent
export class ChildComponent extends React.Component<any, any>{

    /* we can use constructor to initialize a Class Component's state (like a java constructor with fields) 
    Remember, "props" is the object in the left parameter of this component, which is data from the parent
    this constructor below takes in the "props" object, and initializes this component's "state"*/
    constructor(props:any) {
        super(props) //this is a call to the parent constructor (a default no-args constructor)

        //initialize the ChildComponent's state, using the props it got from the parent
        this.state = {
            color:props.color,
            animal:props.animal
        }

    }

    //render some elements using the data from the props object
    render(){
        return(
            <div>
                <h3>Hello from the Child Component</h3>
                <h3 style={{color: this.state.color}}>My parent's fav color is: {this.state.color}</h3>
                <h4>My parent's fav animal is: {this.state.animal}</h4>
            </div>
        )
        /*We are accessing color and animal from state, which we got from props (AKA data from the parents)*/
    }

}