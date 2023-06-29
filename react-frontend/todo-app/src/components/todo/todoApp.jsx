import LoginComponent from "./LoginComponent"
import ErrorComponent from "./ErrorComponent"
import { BrowserRouter, Routes, Route } from "react-router-dom"

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LoginComponent />}></Route>
                    <Route path="login" element={<LoginComponent />}></Route>
                    <Route path="welcome" element={<WelcomeComponent />}></Route>
                    <Route path="*" element={<ErrorComponent />}></Route>
                </Routes>
            </BrowserRouter>
        </div>
    )
}

function WelcomeComponent() {
    return (
        <>
            <h1>Welcome to Todos</h1>
            <div className="welcome">
                WelcomeComponent
            </div>
        </>
    )
}