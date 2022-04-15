import React,{useState} from 'react'
import { useEffect } from 'react';

const Button = () => {
    const [people, setPeople] = useState([]);
    const [OpenList , setOpenLiST] = useState(false);

    useEffect(() => {
        console.log("hiiiii");
        fetch('https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0')
            .then(response => response.json())
            
            .then(response => setPeople(response.results))
    }, []);

    const handleClick=(e)=>{
        setOpenLiST(!OpenList);
        console.log(OpenList);
    }
    if(OpenList){
        return (

            <div>
                <button onClick={handleClick} >Fetch Pokemon</button>
                <div>Fetch to see the list</div>
                </div>
                )
    }
    else{
    return (
            <div>
                <button onClick={handleClick} >Fetch Pokemon</button>
            {people.length > 0 && people.map((person, index)=>{
                return (<div key={index}>{person.name}</div>)
            })}
            </div>
    )
        }
        
    
}
    
            

export default Button