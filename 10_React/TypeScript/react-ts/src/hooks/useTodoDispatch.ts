import { useContext } from "react"
import { TodoDispatchContext } from "../TodoState"

export const useTodoDispatch = () => {
    const dispatch = useContext(TodoDispatchContext);
    if(!dispatch) throw new Error("TodoDispatchContext정보를 가져올 수 없습니다.");
    return dispatch;
}