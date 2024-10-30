import React, { useState } from 'react'

const SearchBar = () => {
    const [text, setText] = useState("");

    const onChangeInput = (e: React.ChangeEvent<HTMLInputElement>) => {
        setText(e.target.value)
    }

    return (
        <div>
            <input
                type="text"
                value={text}
                onChange={onChangeInput}
            />
            <button onClick={onClickAdd}>추가</button>
        </div>
    )
}

export default SearchBar