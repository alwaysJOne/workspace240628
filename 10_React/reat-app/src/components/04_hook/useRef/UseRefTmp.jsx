import React, {useRef, useState} from 'react'

/*
    useRef는 React에서 DOM요소에 직접 접근하거나 컴포넌트 랜거링 간 상태 변화 없이 값을 \
    저장하는데 사용된다. state와 다르게 값이 변경되어도 컴포넌트가 리랜더링되지 않고
    초기화되지 않고 참조값을 유지한다. 주로 DOM요소 포커스나 스크롤 위치를 추천하거나 또는 이전값을
    기억하는데 유용하다.
*/

const UseRefTmp = () => {
  // let name = "", gender = "";
  const [name, setName] = useState("");
//   const [beforeName, setBeforeName] = useState("");
  const [gender, setGender] = useState("man");

  const beforeName = useRef("");
  const useInput = useRef(null);

  const handleChangeName = (ev) => {
    //   setBeforeName(name)
    beforeName.current = name;
    setName(ev.target.value);
  }

  const handleChangeGender = (ev) => {
      setGender(ev.target.value);
  }

  const handleSubmit = (ev) => {
      alert(`이름 : ${name}, 성별 : ${gender}`);

      ev.preventDefault();
  }

  const handleReset = () => {
    setName("")
    setGender("man")
    useInput.current.focus();
  }

  return (
      <form onSubmit={handleSubmit}>
          <label>
              이름 : 
              <input 
                type="text" 
                value={name} 
                onChange={handleChangeName} 
                ref={useInput}
              />
          </label>
          <label>
            이전이름 : {beforeName.current}
          </label>
          <br /><br />
          <label>
              성별 : 
              <select value={gender} onChange={handleChangeGender}>
                  <option value="man">남자</option>
                  <option value="woman">여자</option>
              </select>
          </label>
          <br /><br />
          <button type='submit'>제출</button>
          <button type='button' onClick={handleReset}>초기화</button>
      </form>
  )
}

export default UseRefTmp