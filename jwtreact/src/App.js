import { BrowserRouter, Route, Routes } from "react-router-dom";
import SignIn from "./Login";
import SignUp from "./SignUp";
import Dashboard from "./Dashboard";
import Blog from "./Blog";
import {getCookie} from "./Cookie";
import {decodeJwt} from "./TokenUtil";

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path='/login' element={<SignIn/>}/>
        <Route path='/signup' element={<SignUp/>}/>
        <Route path='/' element={<Dashboard/>}/>
        <Route path='/detail' element={<Blog/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App;