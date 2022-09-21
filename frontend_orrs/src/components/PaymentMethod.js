import React, { Component } from "react";
import {SOURCE, DESTINATION, NOOFTICKETS } from "./TicketBooking";


export const TOTAL = "TOTAL";

class PaymentMethod extends Component {
  constructor(props) {
    super(props);
    this.state = {
      method: "",
   
      source: "",
      destination: "",
      nooftickets: "",
      total: ""
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    //setting the state value to session storage value



    this.setState({ source: sessionStorage.getItem(SOURCE) });
    this.setState({ destination: sessionStorage.getItem(DESTINATION) });
    this.setState({ nooftickets: sessionStorage.getItem(NOOFTICKETS) });
    this.setState({ total: sessionStorage.getItem(NOOFTICKETS) * 340 });
    this.setState({
    });
    this.setState({
      total:
        sessionStorage.getItem(NOOFTICKETS) * 340 -
        sessionStorage.getItem(NOOFTICKETS) * 340 * (10 / 100)
    });
  }

  handleChange(e) {
    this.setState({
      method: e.target.value
    });

    let total = this.state.total;
    sessionStorage.setItem(TOTAL, total);
  }
  handleSubmit(e) {
    e.preventDefault();
    let method = this.state.method;

  if (method === "mobile") {
      this.props.history.push(`/submitPaymentDetail`);
    }
    if(this.componentDidMount()){
    }

  }
  

  render() {
    return (
      <div style={{ backgroundColor: "transparent" }}>
        <div className="container" style={{ marginTop: 0 }}>
          <center>
            <div className="card" style={{ width: 600 }}>
              <h5
                className="card-header info-color white-text text-center py-4"
                style={{ backgroundColor: "whitesmoke" }}
              >
                <strong style={{ color: "black" }}>
                  {" "}
                  <h5>Your Details</h5>
                  <h6>
                    {" "}
                    Source :{" "}
                    &#160;    &#160; &#160;&#160; &#160;&#160;
                    
                    <input
                      type="text"
                      value={this.state.source}
                      readOnly
                      style={{ backgroundColor:"#C8C8C8" }}
                    />{" "}
                  </h6>
                  <h6>
                    {" "}
                    Destination :{" "}
                    &#160;
                    &#160;
                    <input
                      type="text"
                      value={this.state.destination}
                      readOnly
                      style={{ backgroundColor: "#C8C8C8" }}
                    />
                  </h6>
                  <h6>
                    {" "}
                    No of Tickets :{" "}
                    <input
                      type="text"
                      value={this.state.nooftickets}
                      readOnly
                      style={{ backgroundColor: "#C8C8C8" }}
                    />
                  </h6>{" "}
              
                  <h6>
                    {" "}
                    Your Total Bill :{" "}
                    <input
                      type="text"
                      value={this.state.total}
                      readOnly
                      style={{ backgroundColor: "#C8C8C8" }}
                    />
                  </h6>
                  Proceed To Payment
                  <br />
                </strong>
              </h5>

              <div className="card-body px-lg-5">
                <form
                  className="text-center"
                  style={{ color: "#757575" }}
                  onSubmit={this.handleSubmit}
                >
                  <div className="custom-radio">
                    <input
                      type="radio"
                      className="custom-control-input"
                      id="mobilenum"
                      name="method"
                      value="mobile"
                      onChange={this.handleChange}
                    />
                    <label className="custom-control-label" for="mobilenum">
                      Paytm gateway (Support for 100+ countries!!)
                    </label>
                  </div>
                  <button
                    className="btn btn-outline-primary btn-rounded btn-block z-depth-0 my-4 waves-effect"
                    type="submit"
                  >
                    NEXT
                  </button>
                </form>
              </div>
            </div>
          </center>
        </div>
      </div>
    );
  }
}

export default PaymentMethod;