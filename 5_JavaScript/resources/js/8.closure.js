/**
 * 클로저
 * 
 * "클로저는 어떤 함수와 해당 함수가 선언된 정적 환경의 조합이다."
 * 
 * "내부 함수에서 외부 함수의 변수를 사용할 때 우리는 클로저라고한다."
 * (상위 함수보다 하위함수가 더 오래 살아있는 경우)
 */

let num = 5;
let num1 = 5;
let num2 = 5;
let num3 = 5;

function getNum(){
    let num = 5;

    function inner(){
        num++;
        return num;
    }

    return inner;
}

let run = getNum();

console.log(run());
console.log(run());
console.log(run());
console.log(run());
console.log(run());
console.log(run());

function out(outValue){
    function inner(innerValue){
        console.log("outValue : " + outValue)
        console.log("innerValue : " + innerValue)
    }

    return inner;
}

const numOutFunk = out('외부함수');
numOutFunk('내부함수');


function getNumber(){
    let number = 5;

    function inner(){
        number++;
        return number;
    }

    return inner;
}

let run2 = getNumber();
let run3 = getNumber();
let run4 = getNumber();

console.log("run2 :" + run2())
console.log("run2 :" + run2())
console.log("run2 :" + run2())
console.log("run3 :" + run3())
console.log("run3 :" + run3())
console.log("run4 :" + run4())
console.log("run4 :" + run4())
console.log("run4 :" + run4())