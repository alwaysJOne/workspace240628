// import { createStore } from "redux"; //ES6 모듈
const { createStore } = require('redux'); //CommonJS 모듈

//리듀서의 정의
//액션이 발생했을 때 새로운 상태로 기존상태를 업데이트해주는 역할을 함
const reducer = (prevState, action) => {
    console.log("action : ", action.type)
    switch(action.type){
        case 'CHANGE_AGE':
            return {
                ...prevState,
                age: action.data,
            };
        default:
            return prevState;
    }

}

//전연 state
const initialState = {
    name: "jiwon",
    age: 15,
    address: null,
}

//스토어 생성
//전역 state가 저장된 저장소
const store = createStore(reducer, initialState)

console.log(store.getState())


//액션 생성 함수
const changeAge = (data) => {
    return {
        type: 'CHANGE_AGE',
        data,
    }
}

//액션 디스패치
store.dispatch(changeAge(20))

console.log(store.getState())