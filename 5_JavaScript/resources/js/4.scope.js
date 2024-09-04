/*
    Scope
    변수나 함수가 접근할 수 있는 유효범위
*/

var number1 = 20;

function test1(){
    console.log(number1);
}

//test1();

function test2(){
    var number1 = 40;
    console.log(number1);
}

//test2();

var number1 = 20;

function test3(){
    var number1 = 40;
    test4();
    console.log("number1 : " + number1);
}

function test4(){
    var number2 = 11;
    console.log("number1 : " + number1);
    console.log("number2 : " + number2);
}

test3();
console.log(number1);

/*
    JS -> Lexical Scope
    성너된 위치가 상위 스코프를 정한다.

    Dynamic Scope
    실핸하 위치가 상위 스코프를 정한다.
*/

// var i = 1000;
// for(var i = 0; i < 10; i++){
//     console.log(i);
// }
// console.log("i = " + i);

let i = 1000;
for(let i = 0; i < 10; i++){
    console.log(i);
}
console.log("i = " + i);