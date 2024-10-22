import React from 'react'
import styled from 'styled-components'

const Product = styled.div`
    border: 1px solid black;
    border-radius: 1rem;
    color: white;
    font-size: 2rem;
    font-weight: bold;
    text-align: center;
    padding: ${(props) => props.padding};
    background-color: ${(props) => props.backgroundColor};
`

const Wrapper = styled.div`
    padding: 1rem;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: flex-start;
    background-color: lightgrey;
`

const productItems = [
    {
        label: "삼성 TV",
        padding: "1rem",
        backgroundColor: "red",
    },
    {
        label: "LG TV",
        padding: "3rem",
        backgroundColor: "blue",
    },
    {
        label: "샤오미 TV",
        padding: "2rem",
        backgroundColor: "green",
    },
]

const Products = () => {
  return (
    <Wrapper>
        {
            productItems.map(item => {
                return (
                <Product
                    padding = {item.padding}
                    backgroundColor= {item.backgroundColor}
                >
                    {item.label}
                </Product>)
            })
        }
    </Wrapper>
  )
}

export default Products