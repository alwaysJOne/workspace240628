import { createStore, compose, applyMiddleware } from 'redux';
import reducer from './reducers';

//초기 전역state 설정
const initialState = {
    user: {
        isLoading: false, //사용자가 로그인 중인지를 판단할 변수
        data: {
            id: "user01",
            nickname: "jiwon00",
        }, // 로그인 사용자 정보
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

const enhancer = compose(
    applyMiddleware(
        loggingMiddleware
    )
)

const store = createStore(reducer, initialState, enhancer);

//생성된 스토어를 모듈에 등록
export default store;