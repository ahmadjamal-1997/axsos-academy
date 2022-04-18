import React from 'react'
import { useParams } from 'react-router'
// import './App.css';

const Number = () => {
    const {input} = useParams();
    const {color1} = useParams();
    const {color2} = useParams();


  return (
      <>
   {isNaN(input)?<div style={{backgroundColor : color1,color:color2}}>the Word is {input}</div> :<div style={{backgroundColor : color1,color:color2}}> the Number is {input}</div>} 
   </>
  )
}

export default Number