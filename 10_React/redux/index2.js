// import { createStore } from "redux"; //ES6 모듈
const { createStore } = require('redux'); //CommonJS 모듈

//리듀서의 정의
//액션이 발생했을 때 새로운 상태로 기존상태를 업데이트해주는 역할을 함
const reducer = (prevState, action) => {
    
    switch(action.type){
        case 'LOG_IN':
            return {
                ...prevState,
                isLoading: false,
                loginUser: action.data,
            };
        case 'LOG_OUT':
            return {
                ...prevState,
                loginUser: null,
            };
        case 'ADD_BOARD':
            return {
                ...prevState,
                boardList : [...prevState.boardList, action.data]
            };
        case 'LOG_IN_REQUEST':
            return {
                ...prevState,
                isLoading: true,
            };
        case 'DELETE_BOARD':
            return {
                ...prevState,
                boardList: prevState.boardList.filter((board) => board.id != action.data)
            }
        default:
            return prevState;
    }

}

//전연 state
const initialState = {
    loginUser: null,
    isLoading: false,
    boardList: [],
}

//스토어 생성
//전역 state가 저장된 저장소
const store = createStore(reducer, initialState)

console.log(store.getState())


//액션 생성 함수
const logIn = (data) => {
    return {
        type: 'LOG_IN',
        data,
    }
}

const logOut = (data) => {
    return {
        type: 'LOG_OUT',
    }
}

const addBoard = (data) => {
    return {
        type: 'ADD_BOARD',
        data,
    }
}

const deleteBoard = (data) => {
    return {
        type: 'DELETE_BOARD',
        data,
    }
}

//------------------------------------------------

store.dispatch({
    type: "LOG_IN_REQUEST",
})
console.log("로그인요청중... ")
console.log(store.getState())

store.dispatch(logIn({
    userId: "user01",
    id: 1,
    name: "김지수",
}))

console.log("로그인완료... ")
console.log(store.getState())

store.dispatch(addBoard({
    id: 1,
    title: "안녕 리덕스...",
    content: "리덕스 너무 쉬워요."
}))

console.log("게시글 작성... ")
console.log(store.getState())

store.dispatch(addBoard({
    id: 2,
    title: "잘있어 리덕스...",
    content: "리덕스 쉽지 않아요."
}))

console.log("게시글 작성... ")
console.log(store.getState())

store.dispatch(deleteBoard(1))

console.log("게시글 삭제... ")
console.log(store.getState())

store.dispatch(logOut());

console.log("로그아웃... ")
console.log(store.getState())
