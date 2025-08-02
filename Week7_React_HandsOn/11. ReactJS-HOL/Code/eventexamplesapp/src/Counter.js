import React, { Component } from 'react';

class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };
  }
  increment = () => {
    this.setState({ count: this.state.count + 1 });
    this.sayHello();
    this.staticMessage();
  };
  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };
  sayHello = () => {
    alert("Hello! Member1");
  };
  staticMessage = () => {
    console.log("Static message displayed.");
  };
  render() {
    return (
      <div>
        <h3>{this.state.count}</h3>
        <button onClick={this.increment}>Increment</button>
        <br /><br />
        <button onClick={this.decrement}>Decrement</button>
      </div>
    );
  }
}

export default Counter;