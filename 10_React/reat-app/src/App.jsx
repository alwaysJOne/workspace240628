import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './pages/Home';
import Page1 from './pages/Page1';
import Page2 from './pages/Page2';
import Products from './components/05_styledComponents/Products';
import Counter from './components/06_redux/counter';

/*
  react-router-dom
  react로 생성된 SPA 내부에서 페이지 이동이 가능하도록 만들어주는 라이브러리

  BrowserRouter
  history객체를 생성하여 사용한다.
  라우팅을 진행할 컴포넌트 상위에 BrowserRouter컴포넌트를 생성하고 감싸주어야한다.

  Routes
  모든 Route의 상위경로에 존재해야하며, location변경시 하위에 있는 모든 Route중에
  현재 location에 맞는 Route를 찾아준다.  

  Route
  현재 브라우저의 location(window.href.location 정보를 가져온다)
  => 상태에 따라서 매칭되는 element를 랜더링한다.

*/

function App() {
  return (
    // <BrowserRouter>
    //   <div className="App">
    //     <nav>
    //       <ul>
    //         <li><Link to="/">Home</Link></li>
    //         <li><Link to="/p1">page1로 이동</Link></li>
    //         <li><Link to="/p2">page2으로 이동</Link></li>
    //       </ul>
    //     </nav>
    
    //     <Routes>
    //       <Route path="/" element={<Products />}/>
    //       <Route path="/p1" element={<Page1 />}/>
    //       <Route path="/p2" element={<Page2 />}/>
    //     </Routes>
    //   </div>
    // </BrowserRouter>
    <Counter />
  );
}

export default App;
