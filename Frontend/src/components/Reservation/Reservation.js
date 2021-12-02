import React, { Component } from "react";

class Reservation extends Component {
  constructor(props) {
    super(props);

    this.state = {
      flights: [{orderId: "1", name: "Joghn Doe" ,  fromLoc: "SFO",
      toLoc: "LAX",
      departDate: "12/19/20021", price: "$342"}]
    };
  }

//   flightList() {
//     fetch("http://localhost:3001")
//       .then((response) => {
//         if (!response.ok) {
//           throw new Error(response.statusText);
//         }
//         return response.json().then((data) => {
//           this.setState({ flights: data});
//         });
//       })
//       .catch((err) => {
//         console.log(error);
//       });
//   }

//   componentDidMount() {
//     this.flightList();
//   }


//   cancelClick(orderId) {
//     if (window.confirm("Are you sure you want to cancel?")) {
//       fetch("http://localhost:3001" + orderId, {
//         method: "DELETE",
//         headers: {
//           Accept: "application/json",
//           "Content-Type": "application/json",
//         },
//       })
//         .then((res) => res.json())
//         .then(
//           (result) => {
//             alert(result);
//             this.flightList();
//           },
//           (error) => {
//             alert("Failed");
//           }
//         );
//     }
//   }

  render() {

    const { flights, orderId, name,  fromLoc, toLoc, departDate, price} = this.state;

    return (
      <div>
        <h1 className="headerh1"> Reservation</h1>

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
            {flights.map(x => 
              <tr key={x.orderId}>
                <td>{x.orderId}</td>
                <td>{x.name}</td>
                <td>{x.fromLoc}</td>
                <td>{x.toLoc}</td>
                <td>{x.departDate}</td>
                <td>{x.price}</td>
                <td>

                  <button
                    type="button"
                    className="btn btn-light mr-1"
                    onClick={() => this.cancelClick(x.orderId)}
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="16"
                      height="16"
                      fill="currentColor"
                      className="bi bi-trash-fill"
                      viewBox="0 0 16 16"
                    >
                      <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z" />
                    </svg>
                  </button>
                </td>
              </tr>
            )}
          </tbody>
          
        </table>
      </div>
    );
  }
}
export default Reservation;
