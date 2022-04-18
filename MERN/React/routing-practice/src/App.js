import logo from './logo.svg';
import './App.css';
import Welcome from './component/Welcome';
import Number from './component/Number';
import {
  BrowserRouter,
  Switch,
  Route,
  Link 
} from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/home">
          <Welcome/>
        </Route>
        <Route path="/:input/:color1/:color2">
          <Number/>
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
