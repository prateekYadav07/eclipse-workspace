import LoginComponent from "./LoginComponent"
import ErrorComponent from "./ErrorComponent"
import { BrowserRouter, Routes, Route, useParams } from "react-router-dom"
import ListTodoComponent from "./ListTodoComponent"

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LoginComponent />} />
                    <Route path="login" element={<LoginComponent />} />
                    <Route path="welcome/:username" element={<WelcomeComponent />} />
                    <Route path="list-todos" element={<ListTodoComponent />} />
                    <Route path="*" element={<ErrorComponent />} />
                </Routes>
            </BrowserRouter>
        </div>
    )
}

function WelcomeComponent() {
    const { username } = useParams()

    return (
        <>
            <h1>Welcome to Todos, {username}</h1>
            <div className="welcome">
                WelcomeComponent
            </div>
        </>
    )
}