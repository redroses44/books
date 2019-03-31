import React, { Component } from 'react';
import axios from 'axios';

class AddBook extends Component {
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

  onChange = e => {
    this.setState({ [e.target.name]: e.target.value });
  };

  onSubmit = e => {
    e.preventDefault();
    const newBook = {
      title: this.state.title,
      author: this.state.author,
      publicationYear: this.state.publicationYear,
      publisher: this.state.publisher,
      smallImageURL: this.state.smallImageURL
    };
    axios
      .post('http://localhost:8080/book/add', newBook)
      .then(response => {
        console.log(response.data);
        this.props.history.push('/');
      })
      .catch(err => console.log(err));
  };

  render() {
    return (
      <div className="container">
        <div className="row mt-5">
          <div className="col-md-6 mx-auto mt-5 bg-light p-5">
            <h1 className="display-4 text-center mb-3">Add Book</h1>
            <form onSubmit={this.onSubmit}>
              <div className="form-group">
                <input
                  type="text"
                  className="form-control"
                  value={this.state.title}
                  placeholder="Title"
                  name="title"
                  onChange={this.onChange}
                />
              </div>
              <div className="form-group">
                <input
                  type="text"
                  className="form-control"
                  value={this.state.author}
                  placeholder="Author"
                  name="author"
                  onChange={this.onChange}
                />
              </div>
              <div className="form-group">
                <input
                  type="text"
                  className="form-control"
                  value={this.state.publicationYear}
                  placeholder="Publicaton Year"
                  name="publicationYear"
                  onChange={this.onChange}
                />
              </div>
              <div className="form-group">
                <input
                  type="text"
                  className="form-control"
                  value={this.state.publisher}
                  placeholder="Publisher"
                  name="publisher"
                  onChange={this.onChange}
                />
              </div>
              <div className="form-group">
                <input
                  type="text"
                  className="form-control"
                  value={this.state.smallImageURL}
                  name="smallImageURL"
                  placeholder="Enter Book Image URL"
                  onChange={this.onChange}
                />
              </div>
              <input
                type="submit"
                value="Submit"
                className="btn btn-outline-dark btn-block"
              />
            </form>
          </div>
        </div>
      </div>
    );
  }
}

export default AddBook;
