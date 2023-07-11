import React from 'react'

import "./Pokemon.css"

export const Pokemon: React.FC<any> = (props:any) => {



    //If there is no value for pokePic (if it's falsy) then we render an empty <p> tag. Otherwise, we render the pokemon image 
    //This is sometimes referred to as "conditional rendering"
    return(
        <div className="pokemon-container">
            <div>
                {props.pokemon.pokePic ? <img className="pokemon-pic" src={props.pokemon.pokePic} alt="POKEPIC" /> : <p></p> }
            </div>
            
            <h3>{props.pokemon.pokeName}</h3>
        </div>
    )
}