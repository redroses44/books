import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Book extends Component {
  rateBook = (iSBN, e) => {
    e.preventDefault();
    console.log(iSBN);
  };
  render() {
    const { books } = this.props;
    const ratings = [];
    books.ratings.map(rating => {
      ratings.push(rating.bookRating);
    });

    let rating = ratings.reduce((a, b) => a + b, 0) / ratings.length;
    return (
      <div className="card  col-md-6 col-lg-4  mt-3">
        <img
          style={{ height: '200px', margin: 'auto' }}
          className="card-img-top img-fluid"
          src={books.largeImageURL ? books.largeImageURL : books.smallImageURL}
        />
        <div className="card-body">
          <h5 className="card-title">{books.title}</h5>
          <p className="card-text lead">
            Author : {books.author ? books.author : '-'}
          </p>
          <p className="card-text lead">
            Rating :{' '}
            {books.ratings.length > 0
              ? rating.toFixed(2)
              : 'No Rating at the moment.'}
          </p>
          <Link to={`/book/${books.iSBN}`} className="btn btn-outline-dark">
            See More
          </Link>
          <Link
            className="btn btn-outline-primary ml-2"
            to={`/update/${books.iSBN}`}
          >
            Edit
          </Link>
          <Link
            to={`/rate/${books.iSBN}`}
            className="btn btn-outline-success ml-2"
          >
            Rate book
          </Link>
        </div>
      </div>
    );
  }
}

export default Book;
