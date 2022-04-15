import React,{useState,useEffect} from 'react'

const Add = (props) => {
    const [add,setAdd] = useState("")
    
    const handleClick = (e) => {  
       
        setAdd(e.target.value)
        
    }
    const clicked = (e)=>{
        e.preventDefault()
        props.Myfun(add)
    }
  return (
    <div>
        <form onSubmit={clicked}>
            <input type="text" onChange={handleClick}/>
            <input type="submit" value="Add" />
        </form>
    </div>
  )
}

export default Add