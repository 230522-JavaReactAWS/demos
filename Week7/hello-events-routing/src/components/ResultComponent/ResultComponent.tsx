import React from 'react'

export const ResultComponent: React.FC<any> = (props:any) => {

    return(
        /* If one or more values is missing, the user sees "Please Enter Both Numbers!" */
        <>
            <p style={{color:"red"}}>
                {props.first && props.second ? '' : "Please Enter Both Numbers!"}
            </p>
            <div>
                {props.result ? <p> You Calculated: {props.result}</p> : "Click Calculate to find the product!"}
            </div>

        </>
    )

}