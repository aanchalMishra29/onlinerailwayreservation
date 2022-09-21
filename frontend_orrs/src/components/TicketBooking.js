import React, { Component } from "react";
import { BrowserRouter as Router } from "react-router-dom";
import axios from 'axios'

//export the variable to access from other components

export const SOURCE = "SOURCE";
export const DESTINATION = "DESTINATION";
export const NOOFTICKETS = "NOOFTICKETS";

class TicketBooking extends Component {
  constructor(props) {
    super(props);

    this.checkSource = this.checkSource.bind(this);
    this.checkDestination = this.checkDestination.bind(this);
    this.checkTickets = this.checkTickets.bind(this);
    this.storeDetails = this.storeDetails.bind(this);

    //Equal the state to empty
    this.state = {
    
      
      source: "",
      destination: "",
      nooftickets: ""
    };
  }
  

  //get the input data and store it on variable and
  //display the input data value in console

  //store the input data into states

  checkSource(e) {
    var soList = document.getElementById("soList").value;
    this.setState({
      source: e.target.value
    });
    console.log("Source : " + soList);
  }
  checkDestination(e) {
    var deList = document.getElementById("deList").value;
    this.setState({
      destination: e.target.value
    });
    console.log("Destination : " + deList);
  }
  checkTickets(e) {
    var tickets = document.getElementById("tickets").value;
    this.setState({
      nooftickets: e.target.value
    });
    console.log("No of Tickets : " + tickets);
  }

  //store the state value into variable
  //check if state is not equal to empty if not then save
  //that data into session storage
  storeDetails(e) {
    e.preventDefault();
  
   
    let source = this.state.source;
    let destination = this.state.destination;
    let nooftickets = this.state.nooftickets;

    //Validating the source, If validated store the data to sessionStorage.
    if (source === "") {
      alert("SOURCE cannot be empty");
      //Redirect the same component when storeMethod is called
      this.props.history.push(`/booking`);
    } else if (source !== "") {
      sessionStorage.setItem(SOURCE, source);
      //go to another component when storeMethod is called
      this.props.history.push(`/payment`);
    }

    //Validating the destination, If validated store the data to sessionStorage.
    if (destination === "") {
      alert("DESTINATION cannot be empty");
      //Redirect the same component when storeMethod is called
      this.props.history.push(`/booking`);
    } else if (destination !== "") {
      sessionStorage.setItem(DESTINATION, destination);
      //go to another component when storeMethod is called
      this.props.history.push(`/payment`);
    }

    //Validating the nooftickets, If validated store the data to sessionStorage.
    if (nooftickets === "") {
      alert("NO OF TICKETS cannot be empty");
      //Redirect the same component when storeMethod is called
      this.props.history.push(`/booking`);
    } else if (nooftickets !== "") {
      sessionStorage.setItem(NOOFTICKETS, nooftickets);
      //go to another component when storeMethod is called
      this.props.history.push(`/payment`);
    }
  }

  submitHandler = e => {
    e.preventDefault()
    console.log();
    if(this.validateForm()) {
        axios.post('/orders/addorder', this.state)
        .then(res => {
            this.setState({
                response : res.data
            })
        })
    }      
}

  render() {
    return (
      <Router>
        <div style={{ backgroundColor: "#D3D3D3" }}>
          <div className="container" style={{ marginTop: 0 }}>
            <center>
              <div className="card" style={{ width: 600 }}>
                <h5
                  className="card-header info-color white-text text-center py-4"
                  style={{ backgroundColor: " #0000FF " }}
                >
                  <strong style={{ color: "white" }}>
                    {" "}
                    Book Train Tickets Online{" "}
                  </strong>
                </h5>

                <div className="card-body px-lg-5">
                  <form
                    className="text-center"
                    style={{ color: "#757575" }}
                    onSubmit={this.storeDetails}
                    
                  >
                
                    <label> From : </label>
                    <select
                      class="browser-default custom-select mb-4"
                      id="soList"
                      onChange={this.checkSource}
                    >
                      <option value="" disabled selected>
                        Choose option
                      </option>
                      <option value="KANPUR"> KANPUR </option>
                      <option value="Puri"> Delhi </option>
                      <option value="Bandel"> Banglore </option>
                      <option value="Siliguri"> Chennai </option>
                      <option value="Dumdum"> Hyderabad </option>
                    </select>
                    <label> To : </label>
                    <select
                      class="browser-default custom-select mb-4"
                      id="deList"
                      onChange={this.checkDestination}
                    >
                      {/* <option value="" disabled selected>
                        Choose option
                      </option> */}
                      <option value="Dumdum"> TAMILNADU </option>
                      <option value="Siliguri"> Siliguri </option>
                      <option value="Bandel"> Bandel </option>
                      <option value="Puri"> Puri </option>
                      <option value="Howrah"> Howrah </option>
                    </select>

                    
                    <label>Train Name </label>
                    <input
                      type="text"
                      placeholder="train Name"
                      className="form-control mb-4"
                      id="tickets"
                      onChange={this.checkTickets}
                    /><label> Train Id </label>
                    <input
                      type="text"
                      placeholder="Triain Id"
                      className="form-control mb-4"
                      id="tickets"
                      onChange={this.checkTickets}
                    />
                    <label> Username </label>
                    <input
                      type="text"
                      placeholder="username"
                      className="form-control mb-4"
                      id="tickets"
                      onChange={this.checkTickets}
                    />
                    <label> No of Tickets : </label>
                    <input
                      type="text"
                      placeholder="No of tickets"
                      className="form-control mb-4"
                      id="tickets"
                      onChange={this.checkTickets}
                    />

                        <p>Select Date</p>

                          <input type="date" />

                    <button
                      className="btn btn-outline-primary btn-rounded btn-block z-depth-0 my-4 waves-effect"
                      type="submit" onClick={this.submitHandler}
                    >
                      NEXT
                    </button>
                  </form>
                </div>
              </div>
            </center>
          </div>
        </div>
      </Router>
    );
  }
}

export default TicketBooking;