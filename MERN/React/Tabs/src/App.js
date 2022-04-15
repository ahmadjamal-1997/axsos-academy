import logo from './logo.svg';
import './App.css';
import Tab from './component/Tab';
import {useState} from 'react'
import Display from './component/Display'

function App() {
  const [tab,setTab]=useState("")
  const anyTab = (newTab) =>{
    setTab(newTab)
  }
 
  return (
    <div className="App">
      <Tab myFun={anyTab}/>
      <Display content={tab}/>
    </div>
  );
}

export default App;
