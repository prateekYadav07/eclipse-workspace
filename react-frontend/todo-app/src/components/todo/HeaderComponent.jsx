import { Link } from "react-router-dom";
import { useAuth } from "./security/AuthContext";
// import { useAuth } from "./security/AuthContext";

export default function HeaderComponent() {
    const authContext = useAuth()
    const isAuth = authContext.isAuth
    const username = authContext.username

    return (
        <>
            <header className="border-bottom border-light border-5 mb-3 p-2">
                <div className="container">
                    <div className="row">
                        <nav className="navbar navbar-expand-lg">
                            <Link className="navbar-brand ms-2 fs-2 fw-bold text-black" to={username ? '/welcome' : `/welcome/${username}`}>TODOS</Link>
                            <div className="collapse navbar-collapse">
                                <ul className="navbar-nav">
                                    {isAuth && <li className="nav-item fs-5"><Link className="nav-link" to={`/welcome/${username}`}>Home</Link></li>}
                                    {isAuth && <li className="nav-item fs-5"><Link className="nav-link" to="/list-todos">Todos</Link></li>}
                                </ul>
                            </div>
                            <ul className="navbar-nav">
                                {!isAuth && <li className="nav-item fs-5"><Link className="nav-link" to="/login">Login</Link></li>}
                                {isAuth && <li className="nav-item fs-5"><Link className="nav-link" to="/logout">Logout</Link></li>}
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>
        </>
    )
}