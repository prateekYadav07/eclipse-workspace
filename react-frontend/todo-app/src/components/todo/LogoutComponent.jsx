import FooterComponent from "./FooterComponent";
import HeaderComponent from "./HeaderComponent";

export default function LogoutComponent() {
    return (
        <>
            <div className="logout">
                <HeaderComponent />
                <h1>You are logged out</h1>
                <div>
                    login in again to manage your todos
                </div>
                <FooterComponent />
            </div>
        </>
    )
}