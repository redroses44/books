import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

class BookDetails extends Component {
  state = {
    book: {}
  };

  componentDidMount() {
    axios
      .get(`http://localhost:8080/books/${this.props.match.params.isbn}`)
      .then(response => {
        this.setState({ book: response.data });
      });
  }

  render() {
    const { book } = this.state;
    console.log(book);
    return (
      <div className="container" style={{ height: '100vh' }}>
        <div className="row">
          <div className="card mt-5 col-6 mx-auto">
            <h2 className="card-header">{book.title}</h2>
            <div className="card-body">
              <p className="card-text lead">
                Author : {book.author ? book.author : '-'}
              </p>
              <p className="card-text lead">
                ISBN : {book.iSBN ? book.iSBN : '-'}
              </p>
              <p className="card-text lead">
                Publisher : {book.publisher ? book.publisher : '-'}
              </p>
              <p className="card-text lead">
                Publication Year :{' '}
                {book.publicationYear ? book.publicationYear : '-'}
              </p>
              <img
                src={book.smallImageURL ? book.smallImageURL : null}
                alt={book.smallImageURL}
                className="img-fluid d-block py-3"
                style={{ height: '200px', width: '200px' }}
              />
              <Link className="btn btn-outline-primary" to="/">
                Back
              </Link>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default BookDetails;
