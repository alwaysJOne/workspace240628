let members = [
    "최지원",
    "김지원",
    "이지원",
    "박지원",
    "남궁지원"
]

//push
console.log(members.push("신지원")) //값을 넣고 길이 반환
console.log(members)

//splice(인덱스, 갯수) -> 원본에 영향을 준다
console.log(members.splice(1,3))
console.log(members)

//slice(인덱스, 마지막인덱스 - 1) -> 원본에 영향x
console.log(members.slice(1,5))
console.log(members)
console.log("-----------------------------------")


members = [
    "최지원",
    "김지원",
    "이지원",
    "박지원",
    "남궁지원"
]

let member2 = [
    ...members
]

let choi = {
    name : "jiwon",
    age : 21,
    gender : "남",
}

choi = {
    ...choi,
    age : 20
}

let choi2 = {
    ...choi
}

console.log(choi2)

console.log("-----------------------------------------")

//join() -> 배열을 문자열로 변경해줌
console.log(member2.join())
console.log(member2.join('/'))
console.log(member2.join(' '))

//sort()
member2.sort();
console.log(member2)
console.log(member2.reverse())

let numbers = [1,9,7,5,3]
console.log(numbers);

//a,b를 비교한다
// 1) a를 b보다 나중에 정렬하고 싶다면(뒤에두고 싶다면) 0보다 큰수를 반환
// 2) a를 b보다 먼저 정렬하려면 (앞에두려면) 0보다 작은 숫자를 반환
// 3) 원래순서 유지하고 싶다면 0을 반환
numbers.sort((a, b) => {
    // return a > b ? 1 : -1; //오름차순정렬
    return a < b ? 1 : -1; //내림차순정렬
});
console.log(numbers);