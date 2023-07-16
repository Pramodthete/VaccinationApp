import Header from './Header';
import Footer from './Footer';
import Home from './Home';
import Contact from './Contact';
import About from './About';
 import { Link, Route, Routes, useNavigate } from 'react-router-dom';
import './common.css'
import NotFound from './NotFound';
import Dashboard from './Dashboard';
import CenterLogin from './CenterLogin';
import Register from './Register';
import ProtectedRoute from './ProtechtedRoute';
import Users from './Users';
import Booking from './Booking';

function MainUI()
{
    return <div className='content'>
        <div>
            <Header></Header>
            <hr></hr>

            <Link to={"/CenterLogin"}>Login</Link> {" "}
            <Link to={"/register"}>Register</Link> {" "}
            <Link to={"/home"}>Home</Link> {" "}
            <Link to={"/about"}>About Us</Link> {" "}
            <Link to={"/dashboard"}>Dashboard</Link> {" "}
            <Link to={"/booking"}>Bookings</Link> {" "}
            <Link to={"/contact"}>Contact Us</Link> {" "}
            
            {/* <button onClick={Navigate}>Navigate Me To Dashboard</button> */}
            
            <hr></hr>
                <Routes>
                    <Route path='/CenterLogin'  element={<CenterLogin/>} />
                    
                    <Route path='/Register'  element={<Register/>} />
                    <Route path='/'  element={<Home/>} />
                    <Route path='/home'  element={<Home/>} />
                    <Route path='/about'  element={<About/>} />
                    <Route path='/contact'  element={<Contact/>} />
                    {/* <ProtectedRoute element={<Dashboard/>} /> */}
                    <Route path='/dashboard' element={<Dashboard/>} />
                    <Route path='/booking' element={<Booking/>} />
                    <Route path='*'  element={<NotFound/>} />
                </Routes>
                <hr/>
            <hr></hr>
            <Footer></Footer>
           </div>
           </div>
}

export default MainUI; 