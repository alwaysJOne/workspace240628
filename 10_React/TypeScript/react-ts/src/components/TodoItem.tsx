import React from 'react'
import { Todo } from '../types'
import { useTodoDispatch } from '../hooks/useTodoDispatch'

interface Props extends Todo {}

const TodoItem = (props: Props) => {
    const dispatch = useTodoDispatch();

    const onClickButton = () => {
        dispatch.onClickRemove(props.id)
    }

    return (
        <div>
            {props.id}번 : {props.content}
            <button onClick={onClickButton}>삭제</button>
        </div>
    )
}

export default TodoItem