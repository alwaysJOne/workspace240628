import React from 'react'
import { Todo } from '../types'

interface Props extends Todo {
    onClickRemove: (id: number) => void
}

const TodoItem = (props: Props) => {
    const onClickButton = () => {
        props.onClickRemove(props.id)
    }

    return (
        <div>
            {props.id}번 : {props.content}
            <button onClick={onClickButton}>삭제</button>
        </div>
    )
}

export default TodoItem