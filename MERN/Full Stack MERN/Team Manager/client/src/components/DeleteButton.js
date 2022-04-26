import React from 'react'
import axios from 'axios';

const DeleteButton = (props) => {
    const {successCallBack,teamId} = props;
    const deleteTeam = e =>{
        axios.delete('http://localhost:8000/api/team/' + teamId)
        .then(res => {successCallBack()})
    }
  return (
    <div>
        <button onClick={deleteTeam}>Delete</button>
    </div>
  )
}

export default DeleteButton