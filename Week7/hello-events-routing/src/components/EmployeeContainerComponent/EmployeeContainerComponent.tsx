import React, { useEffect, useState } from 'react'
import { EmployeeComponent } from '../EmployeeComponent/EmployeeComponent'

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
        //using .map() to render an EmployeeComponent for every piece of data in employees
        <div>
            {employees.map((employee:any) => {
                console.log("hey")
                return <EmployeeComponent {...employee} key={employee.userId}/>
            })}
        </div>
        /* Looks confusing, let me elaborate. We use .map on our employees state variable. 
        So, for every element in the employees Array (which holds the data from data.ts),
        Render one EmployeeComponent! 
        In that EmployeeComponent, we send the appropriate employee and key*/

        //what is ...employee again? This means "the entire object" 
        //... is known as the "spread operator". It "spreads" the data across the function
        //we are sending an entire employeee object as props to the EmployeeComponent
    )

}