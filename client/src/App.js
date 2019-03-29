import React, { Component } from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Books from './Books';
import BookDetails from './BookDetails';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route exact path="/" component={Books} />
          <Route exact path="/book/:isbn" component={BookDetails} />
        </Switch>
      </Router>
    );
  }
}

export default App;
