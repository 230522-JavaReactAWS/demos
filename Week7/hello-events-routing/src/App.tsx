import React from 'react';
import logo from './logo.svg';
import './App.css';
import { EmployeeContainerComponent } from './components/EmployeeContainerComponent/EmployeeContainerComponent';
import { data } from './data';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { MultiplyComponent } from './components/MultiplyComponent/MultiplyComponent';


//To establish routes, we need <BrowserRouter>, followed by <Routes>, followed by individual Route(s) 
//<Route> needs: a path (the URL to reach the component) & an element (the component to render)
function App() {
  return (
    <div className="App">

    <BrowserRouter>
      <Routes>
        <Route path="/emp" element={<EmployeeContainerComponent data={data}/>}></Route>
        <Route path="/mult" element={<MultiplyComponent/>}></Route>
      </Routes>
    </BrowserRouter>

    </div>
  );
}

export default App;
