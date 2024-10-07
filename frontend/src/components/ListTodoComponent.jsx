import React, { useEffect, useState } from "react";
import { getAllTodos } from "../services/TodoService";

const ListTodoComponent = () => {
  // const dummyData = [
  //   {
  //     id: 1,
  //     title: "Learn Core Java",
  //     description: "learn core java with examples",
  //     completed: false,
  //   },
  //   {
  //     id: 2,
  //     title: "Learn spring boot",
  //     description: "learn spring boot with examples",
  //     completed: true,
  //   },
  //   {
  //     id: 3,
  //     title: "Learn spring core",
  //     description: "learn spring core with examples",
  //     completed: false,
  //   },
  // ];

  const [todos, setTodos] = useState([]);

  useEffect(() => {
    listTodos();
  }, []);

  function listTodos() {
    getAllTodos()
      .then((response) => {
        setTodos(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <div className="container">
      <h2 className="text-center">List of todos</h2>
      <div>
        <table className="table table-bordered table-striped">
          <thead>
            <tr>
              <th>Todo Title</th>
              <th>Todo Description</th>
              <th>Todo Completed</th>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.title}</td>
                <td>{todo.description}</td>
                <td>{todo.completed ? "yes" : "no"}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ListTodoComponent;
