import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Book extends Component {
  render() {
    const { books } = this.props;
    return (
      <div className="card col-md-3  mt-3">
        <img
          style={{ height: '200px', margin: 'auto' }}
          className="card-img-top img-fluid"
          src={books.largeImageURL}
        />
        <div className="card-body">
          <h5 className="card-title">{books.title}</h5>
          <p className="card-text lead">
            Author : {books.author ? books.author : '-'}
          </p>
          <Link to={`/book/${books.iSBN}`} className="btn btn-outline-dark">
            See More
          </Link>
          <Link className="btn btn-outline-primary ml-2" to="/update">
            Change
          </Link>
        </div>
      </div>
    );
  }
}

export default Book;
