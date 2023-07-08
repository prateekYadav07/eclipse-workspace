import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

export default function LoginComponent() {
    const [username, setUserName] = useState("prateek")
    const [password, setPassword] = useState("dummy")
    const [showFailureMsg, setShowFailureMsg] = useState(false)
    const navigate = useNavigate();
    const authContext = useAuth();

    function usernameHandler(event) {
        setUserName(event.target.value);
    }

    function passwordHandler(event) {
        setPassword(event.target.value);
    }

    function handleLogin() {
        const authenticated = authContext.login(username, password)
        if (authenticated) {
            navigate(`/welcome/${username}`)
        }
        else {
            setShowFailureMsg(true)
        }
    }

    return (
        <div className="container-sm" style={{ textAlign: "start" }}>
            <FailureMsgComponent showFailureMsg={showFailureMsg} />
            <div className="card" style={{ width: "18rem;" }}>
                <div className="card-body">
                    <form>
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label me-auto">Email address</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="login" placeholder="username" value={username} onChange={usernameHandler} />
                            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">Password</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" name="login" placeholder="password" value={password} onChange={passwordHandler} />
                        </div>
                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="exampleCheck1" />
                            <label class="form-check-label" for="exampleCheck1">Remember me</label>
                        </div>
                        <button type="submit" class="btn btn-primary" onClick={handleLogin}>Submit</button>
                    </form>
                </div>
            </div>
        </div>
    )
}

function FailureMsgComponent({ showFailureMsg }) {
    if (showFailureMsg)
        return <div className="alert alert-danger" role="alert">Authentication Failure, incorrect username and password</div>
}