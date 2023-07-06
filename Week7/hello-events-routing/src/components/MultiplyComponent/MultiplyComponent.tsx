import React from 'react'

import "./MultiplyComponent.css"
import { InputComponent } from '../InputComponent/InputComponent'

export const MultiplyComponent: React.FC<any> = () => {



    return(
        <div className="input-container">
            <h3>Multiply Two Numbers!</h3>
            <InputComponent name="first"/>
            <InputComponent name="second"/>
            <p>result goes here</p>
            <button>Calculate!</button>
        </div>
    )
}