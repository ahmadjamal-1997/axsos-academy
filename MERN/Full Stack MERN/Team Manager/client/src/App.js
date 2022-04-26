import React, { useState } from 'react';
import {
  BrowserRouter,
  Switch,
  Route
} from "react-router-dom";
import TeamList from './components/TeamList';
import './App.css';
import TeamForm from './components/TeamForm';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
    <Switch>
        <div className="App">
          <Route exact path="/teams">
            <TeamList />
          </Route>
          <Route exact path="/new">
            <TeamForm />
          </Route>
        </div>
      </Switch>
    </BrowserRouter>
    </div>
  );
}

export default App;
