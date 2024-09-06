let todoList = [];

//할일을 todoList에 넣기
function addTodo(){
    //input요소 가져오기
    const searchInput = document.querySelector("#search-bar input");
    todoList.push({
        title : searchInput.value,
        date : new Date().getTime(),
        isDone : false
    });

    searchInput.value = "";
    drawTodoList();
}

//할일목록을 ui에 나타내기
function drawTodoList(){
    //숙제하기, 1725582055367
    const removeTodo = function(removeTodo){
        todoList = todoList.filter(t => !(t.date === removeTodo.date && removeTodo.title === t.title))

        drawTodoList();
    }

    const toggleStatus = function(targetTodo){
        todoList = todoList.map(function(t){
            if (t.date === targetTodo.date && t.title === targetTodo.title) {
                t.isDone = !t.isDone;
            }
            return t;
        })

        drawTodoList();
    }

    const todoUl = document.querySelector(".todo-list");
    todoUl.innerHTML = "";

    for(let todo of todoList){
        const todoLi = document.createElement('li') // <li></li>
        todoLi.innerText = todo.title;// <li>숙제하기</li>
        todoLi.className = todo.isDone ? 'done' : '';
        todoUl.appendChild(todoLi);

        todoLi.onclick = function(){
            toggleStatus(todo);
        }

        const removeBtn = document.createElement('div');
        removeBtn.className = 'todo-remove-btn';
        removeBtn.innerHTML = '<i class="fa-solid fa-x"></i>';
        todoLi.appendChild(removeBtn);
    
        removeBtn.onclick = function(){
            removeTodo(todo)
        }
    }
}






















/*
function addTodo(){
    const searchInput = document.querySelector("#search-bar input")

    const todoLi = document.createElement('li') // <li></li>
    todoLi.innerText = searchInput.value;// <li>밥먹기</li>

    const removeBtn = document.createElement('div');
    removeBtn.className = 'todo-remove-btn';
    removeBtn.innerHTML = '<i class="fa-solid fa-x"></i>';
    todoLi.appendChild(removeBtn);

    removeBtn.onclick = function(){
        $(this.parentNode).remove();
    }

    const todoUl = document.querySelector(".todo-list");
    todoUl.appendChild(todoLi);
}
*/