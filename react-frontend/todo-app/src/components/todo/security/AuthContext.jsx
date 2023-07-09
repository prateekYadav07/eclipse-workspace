import { createContext, useContext, useState } from "react";

// create a context
export const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)

// provide context to every children present
export default function AuthProvider({ children }) {

    //put some state in the context
    const [isAuth, setAuth] = useState(false)
    const [username, setUsername] = useState("")
    const config = {
        headers: {
            'origin' : 'http://localhost:3000'
        }
    }

    function login(usernameFromLogin, password) {
        if (usernameFromLogin === 'prateek' && password === 'dummy') {
            setAuth(true)
            setUsername(usernameFromLogin)
            return true
        }
        else {
            setAuth(false)
            return false
        }
    }

    function logout() {
        setAuth(false)
    }

    return (
        <AuthContext.Provider value={{ isAuth, username, login, logout, config }}>
            {children}
        </AuthContext.Provider>
    )
}

