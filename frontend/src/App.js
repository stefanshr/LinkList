import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import UserList from "./components/UserList";
import Login from "./components/Login";
import EditUser from "./components/EditUser";

function App() {
  return (
      <div>
        <Router>
          <Switch>
            <Route path={'/users'} component={UserList}/>
            <Route path={'/login'} component={Login}/>
            <Route path={'/EditUser/:id'} component={EditUser}/>
          </Switch>
        </Router>
      </div>
  );
}

export default App;
