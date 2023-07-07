import { createContext, useContext, useState } from "react";

// create a context
export const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)

// provide context to every children present
export default function AuthProvider({ children }) {

    //put some state in the context
    const [isAuth, setAuth] = useState(false)
    // setInterval(() => setNumber(number+1), 2000)

    return (
        <AuthContext.Provider value={{ isAuth, setAuth }}>
            {children}
        </AuthContext.Provider>
    )
}

