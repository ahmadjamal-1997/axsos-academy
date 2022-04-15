import logo from './logo.svg';
import './App.css';
import Add from './component/Add'
import Display from './component/Display'
import {useState,useEffect} from 'react'

function App() {
  const [anyString,setAnyString] = useState([])
  const anyAdd = (newAdd) => {
    setAnyString([...anyString,newAdd])
    console.log(anyString)

  }
  
  return (
    <div className="App">
      <Add Myfun={anyAdd}/>
      <Display string = {anyString}/>
    </div>
  );
}

export default App;
