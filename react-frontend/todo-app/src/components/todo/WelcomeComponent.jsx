import { useParams, Link } from "react-router-dom"

export default function WelcomeComponent() {
    const { username } = useParams()

    return (
        <>
            <div className="welcome">
                <h1>Welcome to Todos, {username}</h1>
                <div>
                    <Link to="/list-todos">Manage your todos</Link>
                </div>
            </div>
        </>
    )
}