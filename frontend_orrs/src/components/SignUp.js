import React, { useState } from "react";
import './RegistrationForm.css'
import { Link, useHistory } from "react-router-dom";
import {Jumbotron} from 'react-bootstrap'

const SignUp = () => {
  let navigate = useHistory();
  const [credentials, setCredentials] = useState({
    id:"",
    userName: "",
    password: "",
    phoneNumber: "",
    gender:""
  });
  const host = "http://localhost:9055";
  const onChange = (e) => {
    setCredentials({
      ...credentials,
      [e.target.name]: e.target.value,
    });
  };
  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      fetch("/user/createuser", {
        method: "POST", 
        headers: {
              'Content-Type': 'application/json'// 'Content-Type': 'application/x-www-form-urlencoded',
          },
        body: JSON.stringify({
                id: (1000+(Math.floor((Math.random()*10000 + 1)))),
                 userName: credentials.userName,
                 password: credentials.password,
                 phoneNumber: credentials.phoneNumber,
                 gender: credentials.gender,
        }),
      })
      .then(res => res.json())
      .then(res => {
              console.log(res);
          const json = res;
          console.log(json);
          if (json.response) {
            localStorage.setItem("token", json.token);
            localStorage.setItem("success", json.success);
            alert("Registration Successfull");
            navigate.push("/");
          } else {
            alert("Registration failed");
            navigate.push("/signUp");
          }
      })
    }
    catch(error){
      console.log(error)
    }
    console.log(credentials);
  };

  return (
    
    <div className="login">
      <div className="loginHeader">
      <div className="col-md-3 register-left">
                        <h3 style={{marginTop:'20px'}}>Welcome</h3>
                        <p>You are 1 step away from being a part of us!
                          <br></br>
                          <br></br>
                          Already have an account then click on login!!
                          <br></br> <br/>
                          <Link  to="/loginUser">
                          <input className="btn-sm btn-primary auth-button block" type="submit" name="" value="Login" style={{textAlign:'center', borderRadius:'10px' }}/><br/>
                          </Link>
                          </p> 
                        </div>
        <form onSubmit={handleSubmit}>
          <div className="col-md-4 main-register">
           <h3 style={{textAlign:'center'}}>User Registration</h3> 
            <br />
            <label className="form-label" htmlFor="email">User Name</label>
            <input
              className="form-control"
              type="text"
              value={credentials.userName}
              onChange={onChange}
              placeholder='Enter username!!'
              required
              name="userName"
              id="userName"
            />
            <br />
            <label className="form-label" htmlFor="password">Password</label>
            <input
              type="password"
              className="form-control"
              placeholder='Enter password!!'
              required
              name="password"
              id="password"
              value={credentials.password}
              onChange={onChange}
            />
            <br></br>
            <label className="form-label" htmlFor="password">Phone Number</label>
            <input
              type="number"
              required
              className="form-control"
              placeholder='Enter phone number!!'
              name="phoneNumber"
              id="phoneNumber"
              value={credentials.phoneNumber}
              onChange={onChange}
            />
            <br />
            <label className="form-label" htmlFor="email">Gender</label>
            <input
              type="text"
              className="form-control"
              placeholder='Enter gender!!'
              required
              name="gender"
              id="gender"
              value={credentials.gender}
              onChange={onChange}
            />
            <br />
            <button className="btn-sm btn-primary auth-button block" type="submit" style={{borderRadius:'10px'}}>SignUp
            </button>
          </div>
        </form>
        </div>     
       </div>
  );
};

export default SignUp;

