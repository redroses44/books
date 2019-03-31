import React, { Component } from 'react';
import axios from 'axios';

class SortingSelector extends Component {
  constructor() {
    super();
    this.state = {
      books: []
    };
  }

  componentDidMount() {
    axios
      .get('http://localhost:8080/books')
      .then(response => {
        this.setState({ books: response.data });
      })
      .catch(err => console.log(err));
  }
  sortBooksAscending = e => {
    e.preventDefault();
    axios.get('http://localhost:8080/books/sorted/desc').then(response => {
      response.data.map(book => {
        console.log(book.ratings.length);
      });
    });
  };
  render() {
    return (
      <div className="col-md-6 mt-4">
        <form onSubmit={this.onSubmit} className="form-inline">
          <div className="form-group">
            <select className="form-control" id="exampleFormControlSelect1">
              <option defaultValue disabled>
                Choose Filter
              </option>
              <option>Get top 10</option>
              <option>Get top 50</option>
            </select>
            <input
              type="submit"
              className="btn btn-outline-dark ml-2"
              value="Filter"
              onClick={this.sortBooksAscending}
            />
          </div>
        </form>
      </div>
    );
  }
}

export default SortingSelector;
