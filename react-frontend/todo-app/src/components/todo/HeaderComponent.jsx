import { Link } from "react-router-dom";

export default function HeaderComponent({ username }) {
    return (
        <>
            <div class="container">
                <header class="d-flex justify-content-center py-3">
                    <ul class="nav nav-pills">
                        <li class="nav-item"><Link to={`/welcome/${username}`} class="nav-link" aria-current="page">Home</Link></li>
                        <li class="nav-item"><Link to="/list-todos" class="nav-link">Todos</Link></li>
                        <li class="nav-item"><a href="#" class="nav-link">Pricing</a></li>
                        <li class="nav-item"><a href="#" class="nav-link">FAQs</a></li>
                        <li class="nav-item"><a href="#" class="nav-link">About</a></li>
                    </ul>
                </header>
            </div>
        </>
    )
}