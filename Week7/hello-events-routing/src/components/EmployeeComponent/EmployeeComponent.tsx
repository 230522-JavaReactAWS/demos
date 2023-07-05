import React from 'react' //"rafce" to auto-generate a function component skeleton
//this is thanks to a VSCode extension called "ES7+ React/Redux/React-Native Snippets"

//I could have made an Employee interface to use that data type, but I won't
export const EmployeeComponent: React.FC<any> = (employee:any) => {

    //this will render an individual employee, with props data coming from EmployeeContainerComponent
    return(
        <div className="employee-container">
            <div className="employee-name">
                <h3>{employee.name}</h3>
            </div>
            <div className="employee-data">
                <p>{employee.quote}</p>
            </div>
        </div>
    )

}