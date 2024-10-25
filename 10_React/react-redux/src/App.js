import logo from './logo.svg';
import './App.css';
import { useSelector, useDispatch } from 'react-redux';
import { logIn, logOut } from './actions/user';

function App() {
  //useSelector()를 통해서 전역state에 접근할 수 있음
  const user = useSelector((state) => state.user)
  const boards = useSelector((state) => state.boards)

  const dispatch = useDispatch();

  const onClick = () => {
    dispatch(logIn({
      id: "user01",
      password: "pass01",
    }))
  }

  const onLogout = () => {
    dispatch(logOut())
  }

  return (
    <div className="App">
      {user.isLoading 
        ? <h3>로그인 하는 중</h3>
        : (user.data
            ? <h3>{user.data.nickname}님 반갑습니다.</h3>
            : <h3>로그인이 필요합니다.</h3>
        )}
      {user.data
        ? <button onClick={onLogout}>로그아웃</button>
        : <button onClick={onClick}>로그인</button>
      }
    </div>
  );
}

export default App;
