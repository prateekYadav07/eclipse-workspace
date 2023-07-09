import { Link } from "react-router-dom"
import { useAuth } from "./security/AuthContext"
import axios from "axios";
import { useState } from "react";

export default function WelcomeComponent() {
    const authContext = useAuth()
    const isAuth = authContext.isAuth
    const user = authContext.username
    const [message, setMessage] = useState(null)

    function handleHelloWorldCall() {
        console.log("hello world api");
        let res = axios.get("http://localhost:8080/hello-world", authContext.config)
            .then((message) => console.log(message))
            .catch((error) => console.log(error))
        setMessage()
    }

    return (
        <>
            <div className="container welcome">
                <div className="card" style={{ width: "18rem;" }}>
                    <div className="card-body">
                        {isAuth ? <h1 className="card-title">Welcome to Todos, {user}</h1> :
                            <h1 className="card-title">Welcome to Todos</h1>}

                        <div>
                            {isAuth && <Link className="btn btn-info" to="/list-todos">Manage your todos</Link>}
                        </div>
                        <div>
                            <button className="btn btn-success" onClick={handleHelloWorldCall}>Call Hello world API</button>
                        </div>
                        <div>{message}</div>
                    </div>
                </div>
            </div>
        </>
    )
}