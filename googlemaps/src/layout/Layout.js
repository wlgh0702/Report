import Header from "../common/JS/Header";
import {Outlet} from "react-router-dom";
import Footer from "../common/JS/Footer";

const Layout = () => {

    return (
        <>
            <Header/>
            <Outlet/>
            <Footer/>
        </>
    )
}

export default Layout;