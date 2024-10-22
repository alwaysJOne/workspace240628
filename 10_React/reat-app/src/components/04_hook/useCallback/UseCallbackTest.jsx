import React, { useCallback, useState } from 'react'
import ViewItem from './ViewItem';

/*
    useCallback
    메모이제이션 기법으로 컴포넌트 성능을 최적화시켜주는 도구이다.
    함수를 메모이제이션하여 불필요한 재생성을 방지한다.
    컴포넌트가 리랜더링될 때, 의존성 배열에 있는 값이 변경되지 않으면 이전의 함수를 반환합니다.
    자식 컴포넌트가 불필요하게 리랜더링되는 것을 방지하는데 유용하다.

    사용법
    useCallback(() => {
        
    }, [])

    첫번째 인자는 메모이제이션하고 사용할 함수를 전달하고
    두번째 인자는 의존성배열을 전달한다.
*/

const UseCallbackTest = () => {
    const [num, setNum] = useState(1);
    const [dark, setDark] = useState(false);

    // const getItems = () => {
    //     return [num, num + 1, num + 2]
    // }

    const getItems = useCallback((addNum) => {
        return [num, num + addNum, num + addNum]
    }, [num])

    const theme = {
        backgroundColor: dark ? "#333" : "#fff",
        color: dark ? "#fff" : "#333",
    }

    const onChangeNum = (ev) => {
        setNum(parseInt(ev.target.value))
    }

    return (
        <div style={theme}>
            <input 
                type="number"
                value={num}
                onChange={onChangeNum} 
            />
            <button
                onClick={() => {setDark(!dark)}}
            > 테마변경 
            </button>

            <ViewItem getItems={getItems}/>
        </div>
    )
}

export default UseCallbackTest