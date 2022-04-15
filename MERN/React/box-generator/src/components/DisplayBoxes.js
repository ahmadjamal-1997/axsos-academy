import React from 'react'


const DisplayBoxes = (props) => {
    // const myStyle={
    //     width:200,
    //     height:200,
    // }
    const style=props.color
  return (
    <div style={{display:"flex"}}>
        {
          style.map((box, i) =>
            <div key={i} style={{ backgroundColor: box, width: 200, height: 200, marginRight: 10,marginTop:15,}}
            >
            </div>
          )
        }
      </div>

  )
}

export default DisplayBoxes