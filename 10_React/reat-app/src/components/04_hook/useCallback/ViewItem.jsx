import React, { useEffect, useState } from 'react'

const ViewItem = ({getItems}) => {
    const [items, setItems] = useState([]);

    useEffect(() => {
        setItems(getItems(3))
        console.log("숫자를 가져왔습니다.")
    }, [getItems])

    return (
        items.map((item, index) => <div key={index}>{item}</div>)
    )
}

export default ViewItem