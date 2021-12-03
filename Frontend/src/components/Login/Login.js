import React, { Component } from "react";
import axios from "axios";
import cookie from "react-cookies";
import { Navigate } from "react-router";
import Signup from "../Signup/Signup.js";


class Login extends Component {
  constructor(props) {

    super(props);
    this.state = {
      username: "",
      password: "",
      authFlag: false,
    };
    this.usernameChangeHandler = this.usernameChangeHandler.bind(this);
    this.passwordChangeHandler = this.passwordChangeHandler.bind(this);
    this.submitLogin = this.submitLogin.bind(this);
  }

  //set auth to false
  componentWillMount() {
    this.setState({
      authFlag: false,
    });
  }
  usernameChangeHandler = (e) => {
    this.setState({
      username: e.target.value,
    });
  };
  passwordChangeHandler = (e) => {
    this.setState({
      password: e.target.value,
    });
  };
  
  //submit Login handler to send a request to the backend
  submitLogin = (e) => {
    var headers = new Headers();
    e.preventDefault();
    const data = {
      username: this.state.username,
      password: this.state.password,
    };
    //set the with credentials to true
    axios.defaults.withCredentials = true;
    //make a post request with the user data
    axios.post("http://localhost:3001/login", data).then((response) => {
      console.log("Status Code : ", response.status);
      if (response.status === 200) {
        this.setState({
          authFlag: true,
        });
      } else {
        this.setState({
          authFlag: false,
        });
      }
    });
  };

  submitSignup = (e) => {
    window.location.assign("signup");
  };
  render() {
    //redirect based on successful login
    let redirectVar = null;
    if (cookie.load("cookie")) {
      redirectVar = <Navigate to="/flight" />;
    }
    return (
      <div>
        {redirectVar}
        <div class="container" style={{fontFamily:"Copperplate", fontSize:"20px", width: "600px"}}>
          <div class="login-form">
            <div class="main-div">
              <div class="panel">
                <h2>Login</h2>
                <p>Please enter your username and password</p>
              </div>

              <div class="form-group">
                <input
                  onChange={this.usernameChangeHandler}
                  type="text"
                  class="form-control"
                  name="username"
                  placeholder="Username"
                />
              </div>
              <div class="form-group">
                <input
                  onChange={this.passwordChangeHandler}
                  type="password"
                  class="form-control"
                  name="password"
                  placeholder="Password"
                />
              </div>
              <button onClick={this.submitLogin} class="btn btn-primary">
                Login
              </button>
            </div>
            <div style={{marginTop: "10px"}}>
              <button onClick={this.submitSignup} class="btn btn-primary" >
                Signup
              </button>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
//export Login Component
export default Login;
