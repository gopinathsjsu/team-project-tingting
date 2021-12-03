import React, { Component } from "react";
import { Route, Routes } from "react-router-dom";
// import Login from './Login/Login';
import Home from "./Home/Home";
import About from "./About/About";
import Contact from "./Contact/Contact";
import Login from "./Login/Login";
import Flight from "./Flight/Flight";
import Checkout from "./Checkout/Checkout";
import Signup from "./Signup/Signup.js";
import Reservation from "./Reservation/Reservation.js";
import Logout from "./Logout/Logout.js";




// import Navbar from './Navigation/Navbar';
//Create a Main Component
class Main extends Component {
  render() {
    return (
      <div>
        <Routes>
          {/* <Route path='/' element={<Navbar/>} /> */}
          <Route path="/" element={<Home />} />
          <Route path='/login' element={<Login/>} /> 
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />



          <Route path="/flight" element={<Flight />} />
          <Route path="/checkout" element={<Checkout />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/reservation" element={<Reservation />} />
          <Route path="/logout" element={<Logout />} />

        </Routes>
      </div>
    );
  }
}
//Export The Main Component
export default Main;
