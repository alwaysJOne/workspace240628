// const testAPI = (data, callback) => {
//     setTimeout(() => { //비동기 실행
//         callback("안녕~ 나야 GTP")
//     },2000)
// }

// testAPI({prompt: "안녕"}, (response) => {
//     console.log(response);
// });


// const testAPI2 = new Promise((resolve, reject) => {
//     setTimeout(() => { //비동기 실행
//         resolve("안녕~ 나야 GTP")

//         //실패시 reject();
//     },2000)
// });


// testAPI2.then((res) => {
//     console.log(res)
// }).catch(() => {
    
// })


const getPromise = function(seconds){
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("완료")
        }, seconds * 1000)
    })
}

// getPromise(1).then((res) => {
//     console.log(res)
//     getPromise(2).then((res) => {
//         console.log(res)
//         getPromise(3).then((res) => {
//             console.log(res)
//             console.log("도착")
//         })
//     })
// })

//async키워드가 선언된 함수에서는 await을 사용할 수 있음
//await키워드를 사용하면 비동기통신을 마치 동기코드처럼 사용할 수 있다.
const runner = async() => {
    const res1 = await getPromise(1);
    console.log(res1);

    const res2 = await getPromise(2);
    console.log(res2);

    const res3 = await getPromise(3);
    console.log(res3);
}

runner();


// const data = {
//     url : ~~,
//     method: "get",
//     data: {prompt: "안녕"},
//     success: function(res){

//     }, error: function(){

//     }
// }


// $.ajax(data)


// function ajax(requestJson){
//     let xhr = new XMLHttpRequest();

//     requestJson.method = requestJson.method ? requestJson.method : "GET";

//     xhr.open(requestJson.method, requestJson.url, true);

//     //응답이 왔을 때 실행하는 이벤트 핸들러
//     xhr.onreadystatechange = function(){
//         if(xhr.readyState === XMLHttpRequest.DONE) {
//             if(xhr.status === 200) {
//                 let result = JSON.parse(xht.responseText)
//                 requestJson.success(result)
//             } else{
//                 requestJson.error(xht.status)
//             }
//         }
//     }
// }