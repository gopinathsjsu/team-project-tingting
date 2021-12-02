import React, { Component } from "react";
import { NavLink } from "react-router-dom";

class Navbar extends Component {
  render() {
    return (
      <div className="navigationBar">
        {/* <nav className="justify-content-end navbar navbar-dark navbar-expand-sm bg-light">
          <ul className="navbar-nav"> */}

        <nav id="navbar-example2" fixed="top" className="navbar navbar-dark bg-secondary ">
          <h2 style = {{color: "#1a1b1d" }}className="title">



            Airline
            
            
          </h2>

          <ul  className="nav nav-pills">
            <li className="nav-item ">
              <NavLink className="btn btn-light btn-outline-secondary" to="/">
                Home
              </NavLink>
            </li>


             <li className="nav-item ">
              <NavLink
                className="btn btn-light btn-outline-secondary "
                to="/login"
              >
                Login
              </NavLink>
            </li>

            <li className="nav-item ">
              <NavLink
                className="btn btn-light btn-outline-secondary "
                to="/flight"
              >
                Flight
              </NavLink>
            </li>

            <li className="nav-item ">
              <NavLink
                className="btn btn-light btn-outline-secondary "
                to="/signup"
              >
                Create
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink
                className="btn btn-light btn-outline-secondary "
                to="/checkout"
              >
                Checkout
              </NavLink>
            </li>

            <li className="nav-item ">
              <NavLink
                className="btn btn-light btn-outline-secondary "
                to="/about"
              >
                About
              </NavLink>
            </li>

            <li className="nav-item">
              <NavLink
                className="btn btn-light btn-outline-secondary "
                to="/contact"
              >
                Contact
              </NavLink>
            </li>
          </ul>
          
        </nav>
      </div>
    );
  }
}

export default Navbar;
