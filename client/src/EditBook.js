import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

export class EditBook extends Component {
  constructor() {
    super();
    this.state = {
      title: '',
      author: '',
      publicationYear: '',
      publisher: '',
      smallImageURL: ''
    };
  }

  onDelete = e => {
    e.preventDefault();
    axios
      .delete(`http://localhost:8080/books/${this.props.match.params.isbn}`)
      .then(response => {
        console.log(response.data);
        this.props.history.push('/');
      })
      .catch(err => console.log(err));
  };

  componentDidMount() {
    axios
      .get(`http://localhost:8080/books/${this.props.match.params.isbn}`)
      .then(response => {
        this.setState({
          title: response.data.title,
          author: response.data.author,
          publicationYear: response.data.publicationYear,
          publisher: response.data.publisher,
          smallImageURL: response.data.smallImageURL
        });
      });
  }
  onChange = e => {
    this.setState({ [e.target.name]: e.target.value });
  };
  render() {
    const {
      title,
      author,
      publicationYear,
      publisher,
      smallImageURL
    } = this.state;
    return (
      <div className="container">
        <div className="row mt-5">
          <div className="col-md-6 mx-auto mt-5 bg-light p-5">
            <h1 className="display-4 text-center mb-3">Edit Book</h1>
            <form onSubmit={this.onSubmit}>
              <div className="form-group">
                <input
                  type="text"
                  className="form-control"
                  value={title}
                  placeholder="Title"
                  name="title"
                  onChange={this.onChange}
                />
              </div>
              <div className="form-group">
                <input
                  type="text"
                  className="form-control"
                  value={author}
                  placeholder="Author"
                  name="author"
                  onChange={this.onChange}
                />
              </div>
              <div className="form-group">
                <input
                  type="text"
                  className="form-control"
                  value={publicationYear}
                  placeholder="Publicaton Year"
                  name="publicationYear"
                  onChange={this.onChange}
                />
              </div>
              <div className="form-group">
                <input
                  type="text"
                  className="form-control"
                  value={publisher}
                  placeholder="Publisher"
                  name="publisher"
                  onChange={this.onChange}
                />
              </div>
              <div className="form-group">
                <input
                  type="text"
                  className="form-control"
                  value={smallImageURL}
                  name="smallImageURL"
                  placeholder="Enter Book Image URL"
                  onChange={this.onChange}
                />
              </div>
              <Link to="/" className="btn btn-outline-dark btn-block">
                Back
              </Link>
              <input
                type="button"
                value="Delete"
                className="btn btn-danger btn-block mt-2"
                onClick={this.onDelete}
              />
            </form>
          </div>
        </div>
      </div>
    );
  }
}

export default EditBook;
