const initialState = {
    isLoading: false, //사용자가 로그인 중인지를 판단할 변수
    data: {
        id: "user01",
        nickname: "jiwon00",
    }, // 로그인 사용자 정보
}

const userReducer = (prevState = initialState, action) => {
    switch(action.type){
        case "LOG_OUT":
            return {
                ...prevState,
                data: null,
            }
        default:
            return prevState;
    }
}

export default userReducer
