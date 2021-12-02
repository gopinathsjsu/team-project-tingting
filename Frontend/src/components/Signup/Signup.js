import React, { Component } from "react";

class Signup extends Component {
	
	render() {
	  
		let redirectVar = null;
    
    return (
      <div>
        {redirectVar}
        <div class="container">
          <div class="singup-form">
            <div class="main-div">
              <div class="panel">
                <h2>New Customer</h2>
              </div>

              <div class="form-group">
                <input
                  type="text"
                  class="form-control"
                  name="firstName"
                  placeholder="First Name"
                />
              </div>
			  <div class="form-group">
                <input
                  type="text"
                  class="form-control"
                  name="middleName"
                  placeholder="Middle name"
                />
              </div>
			  <div class="form-group">
                <input
                  type="text"
                  class="form-control"
                  name="lastName"
                  placeholder="Last name"
                />
              </div>
			  <div class="form-group">
                <input
                  type="date"
                  class="form-control"
                  name="dataOfBith"
                />
              </div>
			  <div class="form-group">
                <input
                  type="text"
                  class="form-control"
                  name="address1"
                  placeholder="Address"
                />
              </div>
              <div class="form-group">
                <input
                  type="text"
                  class="form-control"
                  name="address2"
                  placeholder="Address 2"
                />
              </div>
			  <div class="form-group">
                <input
                  type="text"
                  class="form-control"
                  name="city"
                  placeholder="City"
                />
              </div>
			  <div class="form-group">
                <input
                  type="text"
                  class="form-control"
                  name="state"
                  placeholder="State"
                />
              </div>
			  <div class="form-group">
                <input
                  type="text"
                  class="form-control"
                  name="country"
                  placeholder="Country"
                />
              </div>
			  <div class="form-group">
                <input
                  type="text"
                  class="form-control"
                  name="zipCode"
                  placeholder="Zipcode"
                />
              </div>
			  <div class="form-group">
                <input
                  type="text"
                  class="form-control"
                  name="email"
                  placeholder="Email"
                />
              </div>
			  <div class="form-group">
                <input
                  type="text"
                  class="form-control"
                  name="phoneNumber"
                  placeholder="Phone number"
                />
              </div>
			  <div class="form-group">
                <input
                  type="Password"
                  class="form-control"
                  name="password"
                  placeholder="Password"
                />
              </div>
              <button onClick={this.submitLogin} class="btn btn-primary">
                Create
              </button>
            </div>
          </div>
        </div>
      </div>
    );
	}

}
export default Signup;
