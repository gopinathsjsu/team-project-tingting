import React, { Component } from "react";
import Login from "../Login/Login";

class Home extends Component {
  constructor(props) {
    super(props);

  }

  render() {
  
    return (
      <>
        <div className="container-fluid">
         <Login/>   
          
        </div>
      </>
    );
  }
}
export default Home;









