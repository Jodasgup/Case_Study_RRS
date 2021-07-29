import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route, Switch, Link } from "react-router-dom";

//importing the components
import TrainList from "./components/TrainList";
import HomeSlider from "./components/HomeSlider";
import TicketBooking from "./components/TicketBooking";
import SignUp from "./components/SignUp";
import Login from "./components/Login";
import PaymentMethod from "./components/PaymentMethod";
import PaytmPG from "./components/PaytmPG";
import SBIBankPG from "./components/SBIBankPG";
import ThankYouMessage from "./components/ThankYouMessage";
import adminSignIn from './components/adminSignIn';
import createTrain from './components/createTrain';
import deleteTrain from "./components/deleteTrain";
//importing the images
import navImage from "./resources/navnew3.jpg";
import trainicon from "./resources/trainicon.png";

function App() {
  return (
    <Router>
      <div className="navImage">
        <a href="">
          <img src={navImage} />
        </a>
      </div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
            <li className="navbar-item">
              <Link to="/" className="nav-link" style={{ color: "white" }}>
                Home
              </Link>
            </li>
          </ul>
        </div>
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
            <li className="navbar-item">
              <Link
                to="/trainlist"
                className="nav-link"
                style={{ color: "white" }}
              >
                Train Availability
              </Link>
            </li>
          </ul>
        </div>
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
            <li className="navbar-item">
              <Link
                to="/signUp"
                className="nav-link"
                style={{ color: "white" }}
              >
                Register
              </Link>
            </li>
          </ul>
        </div>
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
            <li className="navbar-item">
              <Link
                to="/booking"
                className="nav-link"
                style={{ color: "white" }}
              >
                Book Train Tickets
              </Link>
            </li>
          </ul>
        </div>
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
            <li className="navbar-item">
              <Link
                to="/payment"
                className="nav-link"
                style={{ color: "white" }}
              >
                Payment
              </Link>
            </li>
          </ul>
        </div>
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
            <li className="navbar-item">
              <Link
                to="/adminSignIn"
                className="nav-link"
                style={{ color: "white" }}
              >
                Admin
              </Link>
            </li>
          </ul>
        </div>
      </nav>

      {/* Switching between components */}
      <Switch>
        <Route path="/" exact component={HomeSlider} />
        <Route path="/trainlist" exact component={TrainList} />
        <Route path="/booking" exact component={TicketBooking} />
        <Route path="/signUp" exact component={SignUp} />
        <Route path="/login" exact component={Login} />
        <Route path="/payment" exact component={PaymentMethod} />
        <Route path="/submitPaymentDetail" exact component={PaytmPG} />
        <Route path="/thankyou" exact component={ThankYouMessage} />
        <Route path="/sbipg" exact component={SBIBankPG} />
        <Route path="/adminSignIn" exact component={adminSignIn} />
        <Route path="/addTrain" exact component={createTrain} />
        <Route path="/delTrain" exact component={deleteTrain} />

        
       
      </Switch>
      <div
        className="footer"
        style={{ backgroundColor: "blue", width: 1365, height: 60 }}
      >
        <center>
          {" "}
          <div>
            <img src={trainicon} width="40" />{" "}
          </div>{" "}
          <div style={{ color: "white" }}></div>
        </center>
      </div>
    </Router>
  );
}

export default App;
