import { useState } from "react";
import "../../../src/Login.css";

export default function LoginComponent() {
    const [username, setUserName] = useState("in28minutes")
    const [password, setPassword] = useState("dummy")

    function usernameHandler(event) {
        setUserName(event.target.value);
    }

    function passwordHandler(event) {
        setPassword(event.target.value);
    }

    return (
        <div className="login">
            <div className="wrapper fadeInDown">
                <div id="formContent">
                    <div className="fadeIn first">
                        <img src="" id="icon" alt="Todo Management App" />
                    </div>

                    <form>
                        <input type="text" id="login" className="fadeIn second" name="login" placeholder="username" value={username} onChange={usernameHandler} />
                        <input type="password" id="password" className="fadeIn third" name="login" placeholder="password" value={password} onChange={passwordHandler} />
                        <input type="submit" className="fadeIn fourth" value="Log In" />
                    </form>

                    <div id="formFooter">
                        <a className="underlineHover" href="#">Forgot Password?</a>
                    </div>
                </div>
            </div>
        </div>
    )
}