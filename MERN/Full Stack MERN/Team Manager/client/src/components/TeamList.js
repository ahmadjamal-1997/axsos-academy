import React,{useState,useEffect} from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom';
import DeleteButton from '../components/DeleteButton';
import * as ReactBootStrap from 'react-bootstrap';



const TeamList = (props) => {
  const [team,setTeam] = useState([])
  
  useEffect(() => {
    axios.get('http://localhost:8000/api/team')
        .then(res => setTeam(res.data))
}, [])
const removeFromDom = teamId => {
  setTeam(team.filter(team => team._id != teamId))
  
}
  
  return (
      <div className='App'>
        <div><Link to={"/teams"}>List</Link> | <Link to={"/new"}>Add Player</Link></div> 
       <ReactBootStrap.Table striped bordered hover variant="dark">
          <thead>
            <tr>
              <th>Team Name</th>
              <th>Prefered Position</th>
              <th>Actions</th>
            </tr>
          </thead>
          {team.map( (team, i) =>   
          <>
          <tbody>
            <tr>
              <th key={i}>{team.name}</th>
              <th key={i}>{team.position}</th>
              <td><DeleteButton teamId={team._id} successCallback={()=>removeFromDom(team._id)}/></td>
            </tr>
          </tbody>
          </>       
          )}
        </ReactBootStrap.Table>
    </div>
  

    
  )
}

export default TeamList