import produce from "immer"

const initialState = {
    isLoading: false, //사용자가 로그인 중인지를 판단할 변수
    data: null, // 로그인 사용자 정보
}

//const nextState = produce(prevState, (draft) => {})
//immer또한 prevState로 nextState를 만들어주는 라이브러리
//draft -> prevState복사본

const userReducer = (prevState = initialState, action) => {
    return produce(prevState, (draft) => {
        //prevState의 복사본인 draft를 가지고 nextState를 만들어준다.
        switch(action.type){
            case "LOG_OUT":
                draft.data = null;
                break;
            case "LOG_IN_SUCCESS":
                draft.data = action.data;
                draft.isLoading = false;
                break;
            case "LOG_IN_FAIL":
                draft.data = null;
                draft.isLoading = false;
                break;
            case "LOG_IN_REQUEST":
                draft.data = null;
                draft.isLoading = true;
                break;
            default:
                break;
        }
    })
}

export default userReducer

// data.detailInfo.grade.name = 2

// return {
//     detailInfo: {
//         ...detailInfo,
//         grade: {
//             ...grade,
//             name: 2
//         }
//     }
// }
