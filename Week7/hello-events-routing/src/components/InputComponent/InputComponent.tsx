import React from 'react'

export const InputComponent: React.FC<any> = (props:any) => {


    /*What is <> </>?? these are fragment tags. better/cleaner to use these if there are no attributes
    They're like a shorthand parent/root tag*/
    return(
        <>
            <p>Enter {props.name} value:</p>
            <input type="number" name={props.name}/>
        </>
    )

}