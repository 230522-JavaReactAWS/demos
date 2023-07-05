import React, { useEffect, useState } from 'react'

export const EmployeeContainerComponent: React.FC<any> = (incomingData:any) => {

    //remember, useState lets us declare and mutate state values
    //we need a state object to send data to a child component's props
    const [employees, setEmployees] = useState([])
    //[empty array] as the default value since data.ts contains an Array

    //and useEffect lets us execute some code when triggered (like an eventListener)
    useEffect(() => {

        //we will set the employee state object to the Array found in data.ts on page load
        setEmployees(incomingData.data)

    }, []) //remember, [] means this triggers on page load

    return(
        <div>
            
        </div>
    )

}