import { useState } from "react";
import "../../../src/Login.css";

export default function LoginComponent() {
    const [username, setUserName] = useState("in28minutes")
    const [password, setPassword] = useState("dummy")
    const [showSuccessMsg, setShowSuccessMsg] = useState(false)
    const [showFailureMsg, setShowFailureMsg] = useState(false)


    function usernameHandler(event) {
        setUserName(event.target.value);
    }

    function passwordHandler(event) {
        setPassword(event.target.value);
    }

    function handleLogin() {
        if (username === 'in28minutes' && password === 'dummy') {
            console.log("success");
            setShowSuccessMsg(true)
            setShowFailureMsg(false)
        }
        else {
            console.log('failure');
            setShowSuccessMsg(false)
            setShowFailureMsg(true)
        }
    }

    return (
        <div className="login">
            <SuccessMsgComponent showSuccessMsg={showSuccessMsg} />
            <FailureMsgComponent showFailureMsg={showFailureMsg} />
            <div className="wrapper fadeInDown">
                <div id="formContent">
                    <div className="fadeIn first">
                        {/* <img src="" id="icon" alt="Todo Management App" /> */}
                    </div>

                    {/* <form> */}
                    <input type="text" id="login" className="fadeIn second" name="login" placeholder="username" value={username} onChange={usernameHandler} />
                    <input type="password" id="password" className="fadeIn third" name="login" placeholder="password" value={password} onChange={passwordHandler} />
                    <input type="submit" className="fadeIn fourth" value="Log In" onClick={handleLogin} />
                    {/* </form> */}

                    <div id="formFooter">
                        <a className="underlineHover" href="#">Forgot Password?</a>
                    </div>
                </div>
            </div>
        </div>
    )
}

function SuccessMsgComponent({ showSuccessMsg }) {
    if (showSuccessMsg)
        return <div className="alert alert-primary" role="alert">Authentication successful</div>
}

function FailureMsgComponent({ showFailureMsg }) {
    if (showFailureMsg)
        return <div className="alert alert-danger" role="alert">Authentication Failure, incorrect username and password</div>
}