import Header from "./common/JS/Header";
import Footer from "./common/JS/Footer";
import Content from "./main/JS/content";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Layout from "./layout/Layout";
import National from "./national/JS/National";
import Seasonal from "./seasonal/JS/Seasonal";
import More from "./More/JS/More";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Layout/>}>
                    <Route path="/" element={<Content/>}/>
                    <Route path="/nation" element={<National/>}/>
                    <Route path="/season" element={<Seasonal/>}/>
                    <Route path="/more" element={<More/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
