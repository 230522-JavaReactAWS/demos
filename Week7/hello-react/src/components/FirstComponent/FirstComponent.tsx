//the first step in any React component is to import React from "react" (You can autocomplete)
import React from "react";

//For our first component, we're build a CLASS BASED COMPONENT. This takes two parameters:
//The parameters are "props" and "state", which we'll talk about later
export class FirstComponent extends React.Component<{}, {}> {

    //we will databind the value of this String below
    words:String = "I am stored in a variable in a class component";

    //Every Class Component must contain the render() function
    //This is what the component will actually display (aka render) onto the webpage
    render() { 
        return(
            <div>
                <h3>Hello from our first component! This is a Class-based component</h3>
                <p>Data bound value: {this.words}</p>
            </div>
        )
    }

}