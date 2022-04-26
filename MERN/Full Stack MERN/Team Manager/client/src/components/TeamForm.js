import React,{useState} from "react";
import { useHistory } from "react-router-dom";
import axios from 'axios';

export default props =>{
    
    const [name,setName] = useState("");
    const [position,setPosition] = useState("")
    const [role,setRole] = useState("")
    const history = useHistory();
    const onSubmitHandler = e=>{
        e.preventDefault();
        axios.post('http://localhost:8000/api/team', {
            name,
            position
        })
            .then(res=>console.log(res))
            .catch(err=>console.log(err))
    
    
        history.push("/teams")
        

    }

    return (
        <form onSubmit={onSubmitHandler}>
            <p>
                <label>Name</label><br />
                <input 
                    type="text" 
                    name="name" 
                    value={name} 
                    onChange={(e) => { setName(e.target.value) }} />
            </p>
            <p>
                <label>Prefered Position</label><br />
                <input 
                    type="text" 
                    name="position" 
                    value={position} 
                    onChange={(e) => { setPosition(e.target.value) }} />
            </p>
            <input type="submit" />
        </form>
    )
}