import React, { useContext, useState } from 'react'
import { TodoDispatchContext } from '../TodoState';
import { useTodoDispatch } from '../hooks/useTodoDispatch';

interface Props{}

const SearchBar = (props: Props) => {
    const dispath = useTodoDispatch();
    const [text, setText] = useState("");

    const onChangeInput = (e: React.ChangeEvent<HTMLInputElement>) => {
        setText(e.target.value)
    }

    const onClickButton = () => {
        dispath.onClickAdd(text)
    }

    return (
        <div>
            <input
                type="text"
                value={text}
                onChange={onChangeInput}
            />
            <button onClick={onClickButton}>추가</button>
        </div>
    )
}

export default SearchBar