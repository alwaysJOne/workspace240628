import React, {useState} from 'react'

const UseRefTmp = () => {
  // let name = "", gender = "";
  const [name, setName] = useState("");
  const [gender, setGender] = useState("man");

  const handleChangeName = (ev) => {
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
  }

  return (
      <form onSubmit={handleSubmit}>
          <label>
              이름 : 
              <input type="text" value={name} onChange={handleChangeName} />
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