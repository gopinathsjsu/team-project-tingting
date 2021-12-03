import React, { Component } from "react";
import Select from "react-select";
import AsyncSelect from "react-async-select";

class Flight extends Component {
  constructor(props) {
    super(props);

    this.state = {
      flights: [],
      fromLoc: "",
      toLoc: "",
      departTime: "",
      arrivetTime: "",
      name: "",
      passenger: 0,
      flights: [],
      error: null,

      flightx: [{orderId: "1", name: "Joghn Doe" ,  fromLoc: "SFO",
      toLoc: "LAX",
      departDate: "12/19/20021", price: "342"}]
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSearch = this.handleSearch.bind(this);
  }

  handleChange(event) {
    this.setState({ searchValue: event.target.value });
    // fetch("http://localhost:3001")
    //   .then((response) => {
    //     if (!response.ok) {
    //       throw new Error(response.statusText);
    //     }
    //     return response.json().then((data) => {
    //       this.setState({ flights: data });
    //       this.setState({ fromLoc: data.fromLoc });
    //       this.setState({ toLoc: data.toLoc });
    //       this.setState({ departTime: data.departTime });
    //       this.setState({ arrivetTime: data.arrivetTime });
    //       this.setState({ passenger: data.passenger });
    //     });
    //   })
    //   .catch((err) => {
    //     console.log(err);
    //   });
  }

  handleSearch(event) {
    event.preventDefault();
    console.log(this.state.searchValue);

    let x = false;

    if (
      this.state.fromLoc == this.state.searchValue1 &&
      this.state.toLoc == this.state.searchValue2 &&
      this.state.departTime == this.state.searchValue3
    ) {
      console.log("working");
      x = true;
    } else console.log("flag is false");

    console.log(x);

    x == true
      ? fetch(`http://localhost:3001}`, {
          method: "GET",
        })
          .then((response) => {
            return response.json();
          })
          .then((data) => {
            console.log(data.map((x) => x.flights));
            console.log(data);
            this.setState({ flights: data });
            this.setState({ error: null });
          })
      : this.setState({ error: "Please enter all fields." });
    console.log(this.state.error);
  }

  errorHandle() {
    return (
      <div style={{ color: "#fff", textAlign: "center" }}>{<h1>error</h1>}</div>
    );
  }

  render() {

const { error, flightx, orderId, name,  fromLoc, toLoc, departDate, price} = this.state;


    return (
      <>
        <div>
          <div>
            <h3 style={{ fontFamily: "Copperplate" }}> Search for flights</h3>

            <form className="form">
              <input
                type="text"
                placeholder="From"
                value={this.state.searchValue1}
                onChange={this.handleChange}
              />
              <input
                label="from"
                type="text"
                placeholder="To"
                value={this.state.searchValue2}
                onChange={this.handleChange}
              />
              <input
                type="text"
                placeholder="Date"
                value={this.state.searchValue3}
                onChange={this.handleChange}
              />
            </form>
            <button
              value="Submit"
              className="button"
              onClick={this.handleSearch}
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="30"
                height="16"
                fill="currentColor"
                className="bi bi-search"
                viewBox="0 0 16 16"
              >
                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
              </svg>
              Search
            </button>
          </div>
        </div>

        <div className="center">
          <div className="row">
            {this.state.error !== null ? (
              <div
                style={{
                  color: "#000000",
                  textAlign: "center",
                  fontFamily: "Copperplate",
                  fontSize: "25px",
                }}
              >
                {error}
              </div>
            ) : (
              <table className="table table-striped">
                <thead>
                  <tr>
                    <th>Order#</th>
                    <th>Name</th>

                    <th>Depart from</th>

                    <th>Destination</th>
                    <th>Date</th>
                    <th>Price</th>
                  </tr>
                </thead>

                <tbody>
                  {flightx.map((x) => (
                    <tr key={x.orderId}>
                      <td>{x.orderId}</td>
                      <td>{x.name}</td>
                      <td>{x.fromLoc}</td>
                      <td>{x.toLoc}</td>
                      <td>{x.departDate}</td>
                      <td>${x.price}</td>
                      <td>
                        <button
                          type="button"
                          className="btn btn-light mr-1"
                          onClick={() => this.cancelClick(x.orderId)}
                        >
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="20"
                            height="20"
                            fill="currentColor"
                            class="bi bi-cart"
                            viewBox="0 0 16 16"
                          >
                            <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                          </svg>
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            )}
          </div>
        </div>
      </>
    );
  }
}

export default Flight;
