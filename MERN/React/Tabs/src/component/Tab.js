import React,{useState} from 'react'


const Tab = (props) => {
    const [tab,setTab] = useState("")
    const openTab=(e) => {
        e.preventDefault();
        setTab(e.target.value);
        props.myFun(tab);
    }
  return (
    <>
    <input type="submit" value="Tab 1" onClick={ (e) => openTab(e) }/>
    <input type="submit" value="Tab 2" onClick={ (e) => openTab(e) }/>
    <input type="submit" value="Tab 3" onClick={ (e) => openTab(e) }/>
    </>
  )}

export default Tab