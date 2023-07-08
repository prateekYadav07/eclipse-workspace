import { Link } from "react-router-dom"
import { useAuth } from "./security/AuthContext"

export default function WelcomeComponent() {
    const authContext = useAuth()
    const isAuth = authContext.isAuth
    const user = authContext.username

    return (
        <>
            <div className="container welcome">
                <div className="card" style={{ width: "18rem;" }}>
                    <div className="card-body">
                        {isAuth ? <h1 className="card-title">Welcome to Todos, {user}</h1> :
                            <h1 className="card-title">Welcome to Todos</h1>}

                        <div>
                            {isAuth && <Link to="/list-todos">Manage your todos</Link>}
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}