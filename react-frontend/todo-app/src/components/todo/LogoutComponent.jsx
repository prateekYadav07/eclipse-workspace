import { useNavigate } from "react-router-dom"
import { useAuth } from "./security/AuthContext"

export default function LogoutComponent() {
    const authContext = useAuth()
    const navigate = useNavigate()
    const username = authContext.username

    function handleLogout(){
        authContext.logout()
        navigate('/login')
    }

    function handleCancel(){
        navigate(`/welcome/${username}`)
    }

    return (
        <>
            <div className="container logout">
                <div className="card" style={{ width: "18rem;" }}>
                    <div className="card-body">
                        <h2 className="card-title">Logout</h2>
                        <p className="card-text">Are you sure want to logout?</p>
                        <div class="btn-group" role="group" aria-label="Basic outlined example">
                            <button type="button" className="card-link btn btn-danger" onClick={handleLogout}>Logout</button>
                            <button type="button" class="card-link btn btn-success" onClick={handleCancel}>Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

function loggedOutMessage() {
    return (
        <>
            <h1>You are logged out</h1>
            <div>
                login in again to manage your todos
            </div>
        </>
    )
}