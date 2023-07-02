import LoginComponent from "./LoginComponent"
import ErrorComponent from "./ErrorComponent"
import { BrowserRouter, Routes, Route} from "react-router-dom"
import ListTodoComponent from "./ListTodoComponent"
import WelcomeComponent from "./WelcomeComponent"
import LogoutComponent from "./LogoutComponent"

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LoginComponent />} />
                    <Route path="login" element={<LoginComponent />} />
                    <Route path="welcome/:username" element={<WelcomeComponent/>} />
                    <Route path="list-todos" element={<ListTodoComponent />} />
                    <Route path="logout" element={<LogoutComponent />} />
                    <Route path="*" element={<ErrorComponent />} />
                    
                </Routes>
            </BrowserRouter>
        </div>
    )
}