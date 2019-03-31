import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

export class RateBook extends Component {
  constructor() {
    super();
    this.state = {
      rate: '',
      isbn: ''
    };
  }
  onChange = e => {
    this.setState({ [e.target.name]: e.target.value });
  };
  componentDidMount() {
    axios
      .get(`http://localhost:8080/books/${this.props.match.params.isbn}`)
      .then(response => {
        this.setState({
          isbn: response.data.iSBN
        });
        console.log(this.state.isbn);
      });
  }
  rateBook = e => {
    const newRate = {
      bookRating: this.state.rate
    };
    e.preventDefault();
    axios
      .post(
        `http://localhost:8080/${this.props.match.params.isbn}/bookrating`,
        newRate
      )
      .then(response => {
        this.props.history.push('/');
      });
  };
  render() {
    const { isbn } = this.state;
    return (
      <div className="container">
        <div className="row mt-5">
          <div className="col-md-6 mx-auto mt-5 bg-light p-5">
            <h1 className="display-4 text-center mb-3">Rate Book</h1>
            <form onSubmit={this.onSubmit}>
              <div className="form-group">
                <input
                  type="text"
                  className="form-control"
                  placeholder="Rate (number between 1 and 10)"
                  name="rate"
                  value={this.state.rate}
                  onChange={this.onChange}
                />
              </div>

              <Link to="/" className="btn btn-outline-dark btn-block">
                Back
              </Link>
              <input
                type="button"
                value="Rate Book"
                className="btn btn-success btn-block mt-2"
                onClick={this.rateBook}
              />
            </form>
          </div>
        </div>
      </div>
    );
  }
}

export default RateBook;
