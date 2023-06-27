import LoginComponent from "./LoginComponent"

export default function TodoApp() {
    return (
        <div className="TodoApp">
            Todo Management App
            <LoginComponent />
            {/* <WelcomeComponent /> */}
        </div>
    )
}

function WelcomeComponent() {
    return (
        <div className="welcome">
            WelcomeComponent
        </div>
    )
}