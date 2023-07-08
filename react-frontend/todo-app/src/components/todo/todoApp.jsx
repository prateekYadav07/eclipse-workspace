import LoginComponent from "./LoginComponent"
import ErrorComponent from "./ErrorComponent"
import { BrowserRouter, Routes, Route, Navigate, useNavigate } from "react-router-dom"
import ListTodoComponent from "./ListTodoComponent"
import WelcomeComponent from "./WelcomeComponent"
import LogoutComponent from "./LogoutComponent"
import HeaderComponent from "./HeaderComponent"
import FooterComponent from "./FooterComponent"
import AuthProvider, { useAuth } from "./security/AuthContext"

function AuthenticatedRoute({ children }) {
    const authContext = useAuth()
    if (authContext.isAuth)
        return children

    return <Navigate to={"/"} />
}

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent />
                    <Routes>
                        <Route path="/" element={<LoginComponent />} />
                        <Route path="/login" element={<LoginComponent />} />

                        <Route path="/welcome/:username" element={
                            <AuthenticatedRoute >
                                <WelcomeComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path="/welcome" element={<AuthenticatedRoute >
                            <WelcomeComponent />
                        </AuthenticatedRoute>} />
                        <Route path="/list-todos" element={
                            <AuthenticatedRoute>
                                <ListTodoComponent />
                            </AuthenticatedRoute>} />
                        <Route path="/logout" element={
                            <AuthenticatedRoute>
                                <LogoutComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path="*" element={<ErrorComponent />} />
                    </Routes>
                    <FooterComponent />
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}