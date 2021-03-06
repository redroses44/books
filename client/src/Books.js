import React, { Component } from 'react';
import axios from 'axios';
import Book from './Book';
import SortingSelector from './SortingSelector';

class Books extends Component {
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
  render() {
    let bookItems;
    const { books } = this.state;
    bookItems = books.map(book => (
      <Book ratings={book.ratings} key={book.iSBN} books={book} />
    ));
    return (
      <div>
        <div className="container">
          <SortingSelector />
          <div className="row p-4">{bookItems}</div>
        </div>
      </div>
    );
  }
}

export default Books;
