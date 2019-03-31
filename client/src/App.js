import React, { Component } from 'react';
import './App.css';
import 'popper.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'jquery';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.js';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Books from './Books';
import BookDetails from './BookDetails';
import AddBook from './AddBook';
import EditBook from './EditBook';
import Navbar from './Navbar';

class App extends Component {
  render() {
    return (
      <Router>
        <Navbar />
        <Switch>
          <Route exact path="/" component={Books} />
          <Route exact path="/book/:isbn" component={BookDetails} />
          <Route exact path="/add" component={AddBook} />
          <Route exact path="/update/:isbn" component={EditBook} />
        </Switch>
      </Router>
    );
  }
}

export default App;
