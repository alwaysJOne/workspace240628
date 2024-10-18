import React from 'react'
import Food from './Food';

const Menu = () => {
  return (
    <div>
        <Food name={"짜장면"} price={7000}/>
        <Food name={"짬뽕"} price={8000}/>
        <Food name={"탕수육"} price={21000}/>
    </div>
  )
}

export default Menu;