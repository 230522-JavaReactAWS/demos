import React from 'react';
import logo from './logo.svg';
import './App.css';

/* The App.tsx is the root of our application (at least when it comes to component rendering)
Most of our coding will be done elsewhere, but the App.tsx lets us control WHAT gets rendered
We put the components we want to render in the div of the return() in this file
We can render standard TSX directly inside the div in the return() */

/* Some TSX quirks:
 className instead of class attribute 
 comments in TSX are block comments, like the one we're in */
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
