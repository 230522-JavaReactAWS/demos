import React from 'react';
import logo from './logo.svg';
import './App.css';

/* 
The App.tsx is the root of our application (at least when it comes to component rendering)
Most of our coding will be done elsewhere, but the App.tsx lets us control WHAT gets renderd
*/
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
