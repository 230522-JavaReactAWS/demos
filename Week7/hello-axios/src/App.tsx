import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Login } from './components/Login/Login';

function App() {
  return (
    /* To make a component show up when the application starts, you can put the path as "" */
    <div className="App">

        <BrowserRouter>
          <Routes>
            <Route path="" element={<Login/>}></Route>
          </Routes>
        </BrowserRouter>

    </div>
  );
}

export default App;
