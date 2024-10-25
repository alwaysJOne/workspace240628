import { createStore, compose, applyMiddleware } from 'redux';
import { composeWithDevTools } from "@redux-devtools/extension";
import reducer from './reducers';

//초기 전역state 설정
const initialState = {
    user: {
        isLoading: false, //사용자가 로그인 중인지를 판단할 변수
        data: null, // 로그인 사용자 정보
    },
    boards: [], //게시글
}

const loggingMiddleware = (store) => {
    return (next) => {
        return (action) => {
            console.log("로깅", action);
            next(action);
        }
    }
}

//store : redux 스토어에 접근할 수 있는 객체
//next: 다음 미들웨어나 리듀서로 액션을 전달하는 함수
//action: 현재 처리중인 액션

//thunk 미들웨어를 정의 -> 비동기처리를 위해서 사용함.
const thunkMiddleware = (store) => (next) => (action) => {
    if (typeof action === "function") { //액션이 함수인 경우(비동기액션)
        return action(store.dispatch, store.getState); //thunk함수
    }

    return next(action);
}
    


const enhancer = process.env.NODE_ENV === "production"
    ? compose(
        applyMiddleware(
            loggingMiddleware,
            thunkMiddleware,
        )
      )
    : composeWithDevTools(
        applyMiddleware(
            loggingMiddleware,
            thunkMiddleware
        )
      )

const store = createStore(reducer, initialState, enhancer);

//생성된 스토어를 모듈에 등록
export default store;