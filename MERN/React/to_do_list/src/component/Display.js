import { string } from 'prop-types'
import React from 'react'


const Display = (props) => {
    const row = props.string;
    
    return (
        <div>
            {
              row.map((item, i) =>
                <div>
                    <p key={i}>{item}</p>
                    <input type="checkbox" value="checked"/>
                    <input type="submit" value="delete"/>
                </div>
              )
            }
          </div>
    
      )
    }


export default Display


