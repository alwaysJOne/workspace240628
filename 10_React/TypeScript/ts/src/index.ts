const test = (text : string) : string => {
    console.log(text)
    return "안녕";
}

let str = test("안녕 타입스크립트.")
type Human = {
    name : string
}

let human : Human = {
    name: "jiwon"
}