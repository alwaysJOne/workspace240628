//any
//특정 변수의 타입을 확실하게 정할 수 없을 때

let num1: any = 10;
let num2: number = 20;

num2 = num1; // 타입안정성 없음

let num3: unknown;

if (typeof num3 === "number") {
    let num4 = num3; 
}

//void -> 함수가 아무것도 반환하지 않을 때 사용함

function func01(): string{
    return "안녕 ~"; //문자열 반환
}

function func02(text:  string): void{
    console.log(text) //함수가 아무것도 반환하지 않음
}

//never
//never은 존재하지 않는 것
//절대 종료되지 않거나 값을 반환하지 않을 경우 사용

function func03(): never{
    while(true) {}
}

function func04(): never{
    throw new Error(); //오류발생으로 인해 함수가 종료되지 않음
}

let num8: never;
//num8 = null;   never타입 변수에는 어떠한 값도 넣을 수 없음