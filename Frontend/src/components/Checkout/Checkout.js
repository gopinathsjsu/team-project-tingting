import React, { Component } from "react";

class Checkout extends Component {
  constructor(props) {
    super(props);

    this.state = {
      searchValue: "",
      
    };

    this.handleChange = this.handleChange.bind(this);
  
  }


  handleChange(event) {
    this.setState({ searchValue: event.target.value });
    fetch("http://localhost:3001")
      .then((response) => {
        if (!response.ok) {
          throw new Error(response.statusText);
        }
        return response.json().then((data) => {
          console.log(data)
        });
      })
      .catch((err) => {
        console.log(err);
      });
  }




  render() {
    return (
      <div >
      <h1 className='headerh1'> Checkout</h1>

      <form className="form">
              <input
                type="text"
                placeholder="Input"
                value={this.state.searchValue}
                onChange={this.handleChange}
                ></input>
                </form>

      </div>
    );
  }
}
export default Checkout;
