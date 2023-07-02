import FooterComponent from "./FooterComponent"
import HeaderComponent from "./HeaderComponent"

export default function ListTodoComponent() {
    const today = new Date()
    const targetDate = new Date(today.getFullYear(), today.getMonth() + 3, today.getDay())
    const todos = [
        { id: 1, "description": "Learn AWS", "done": false, "targetDate": targetDate },
        { id: 2, "description": "Learn React", "done": false, "targetDate": targetDate },
        { id: 3, "description": "Learn DevOps", "done": false, "targetDate": targetDate },
    ]


    return (
        <div className="listtodoscomponent">
            <HeaderComponent />
            <h1>Things you want to do</h1>
            <div>
                Todo details
            </div>
            <table className="table">
                <thead>
                    <tr>
                        {Object.keys(todos[0]).map((key, index) => (
                            <th scope="col" key={index}>{key}</th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                    {
                        todos.map((todo) => (
                            <tr key={todo.id}>
                                <th scope="row">{todo.id}</th>
                                <td >{todo.description}</td>
                                <td >{todo.done.toString()}</td>
                                <td >{todo.targetDate.toString()}</td>
                            </tr>
                        ))
                    }

                </tbody>
            </table>
            <FooterComponent />
        </div>
    )
}