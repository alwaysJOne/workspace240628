import React, { useState } from 'react'

/*
    Hook이란
    함수형 컴포넌트에서 react state와 생명주기메서드의 기능을 사용할 수 있게 해주는 함수이다.
    hook은 class안에서는 동작하지 않는다. 대신 class없이 react를 사용할 수 있게 해준다.

    state : 컴포넌트의 상태값
    useState : 컴포넌트의 상태를 생성하고 관리할 수 있게 해주는 react hook

    -> 컴포넌트는 state값이 변경되면 이를 확인하고 요소를 리랜더링 해준다.

    [사용법]
    const [변수명, setState변수명] = useState(초기값);
    변수명 : 원하는 state명을 설정
    set변수명 : 해당 state값을 변경할 함수
*/

const UseStateTest = () => {
    // let num = 0;
    const [num, setNum] = useState(0);

    const onClick1 = () => {
        // num += 1;
        setNum(num + 1);
        console.log("num : " + num);
    }

    const onClick2 = () => {
        // num -= 1;
        setNum(num - 1);
        console.log("num : " + num);
    }

    return (
        <div>
            <span>COUNT : {num} </span>
            <button onClick={onClick1}> + </button>
            <button onClick={onClick2}> - </button>
        </div>
    )
}

export default UseStateTest