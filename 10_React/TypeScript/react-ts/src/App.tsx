import React, { useEffect, useReducer, useRef, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import TodoItem from './components/TodoItem';
import { Todo } from './types';
import { TodoDispatchContext, TodoStateContext } from './TodoState';
import SearchBar from './components/SearchBar';

type Action = {
  type: "CREATE";
  data: {
    id: number,
    content: string,
  }
} | {
  type: "DELETE";
  id: number;
}

function reducer(prevState: Todo[], action: Action) {
  switch (action.type) {
    case "CREATE": {
      return [...prevState, action.data]
    }
    case "DELETE": {
      return prevState.filter(todo => todo.id !== action.id)
    }
  }
}

function App() {
  //todos -> 전역상태로 변경해서 사용하려고 한다.
  //useState, useReducer는 둘다 상태관리를 위한 hook이다.
  //useState : component에 종속되어 간단한 상태를 관리할 때 사용
  //useReducer : 전역에서 사용하는 경우같은 복잡하거나 여러개의 상태를 관리해야할 때 사용
  // const [todos, setTodos] = useState<Todo[]>([]);
  const [todos, dispatch] = useReducer(reducer, []);
  const idRef = useRef(0);

  const onClickAdd = (text: string) => {
    // setTodos([
    //   ...todos,
    //   {
    //     id: idRef.current++,
    //     content: text,
    //   }
    // ])
    dispatch({
      type: "CREATE",
      data: {
        id: idRef.current++,
        content: text,
      }
    })
  }

  const onClickRemove = (id: number): void => {
    // setTodos(todos.filter(todo => todo.id !== id));
    dispatch({
      type: "DELETE",
      id: id,
    })
  }

  useEffect(() => {
    console.log(todos)
  }, [todos])

  return (
    <div className="App">
      <TodoStateContext.Provider value={todos}>
        <TodoDispatchContext.Provider value={{
          onClickAdd,
          onClickRemove,
        }}>
          <SearchBar/>
          <div>
            {todos.map(todo => (
              <TodoItem key={todo.id} {...todo} />
            ))}
          </div>
        </TodoDispatchContext.Provider>
      </TodoStateContext.Provider>
    </div>
  );
}

export default App;
