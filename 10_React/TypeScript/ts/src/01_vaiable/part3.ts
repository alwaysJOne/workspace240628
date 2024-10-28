//타입 별칭부여
type User = {
    user_id: number;
    id: string;
    password: string;
    age: number;
    address: string;
}

let user1 : User = {
    user_id: 1,
    id: "user01",
    password: "pass01",
    age: 20,
    address: "경기도 광명",
}

function test(){
    type id = string;
    let user02:id = "user02";
}

type SidoCode = {
    [key: string] : string; //키, 벨류를 모두 string으로 정의하겠다
    seoul : string; //키가 seoul인 값이 필수이며 값은 string으로 하겠다.
}

let sidoCodeList: SidoCode = {
    "경기도": "k1",
    "전라도": "j1",
    "충청도": "c1",
    "seoul": "s1"
}