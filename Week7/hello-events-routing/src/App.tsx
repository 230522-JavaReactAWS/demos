import React from 'react';
import logo from './logo.svg';
import './App.css';
import { EmployeeContainerComponent } from './components/EmployeeContainerComponent/EmployeeContainerComponent';
import { data } from './data';

function App() {
  return (
    <div className="App">
      <EmployeeContainerComponent incomingData={data}/>
    </div>
  );
}

export default App;
