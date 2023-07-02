import { useParams, Link } from "react-router-dom"
import HeaderComponent from "./HeaderComponent"
import FooterComponent from "./FooterComponent"

export default function WelcomeComponent() {
    const { username } = useParams()

    return (
        <>
            <div className="welcome">
                <HeaderComponent username={username}/>
                <h1>Welcome to Todos, {username}</h1>
                <div>
                    <Link to="/list-todos">Manage your todos</Link>
                </div>
                <FooterComponent />
            </div>
        </>
    )
}