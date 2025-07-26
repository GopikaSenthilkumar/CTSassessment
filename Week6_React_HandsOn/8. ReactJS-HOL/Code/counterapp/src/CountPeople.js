import React from 'react';

class CountPeople extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      entryCount: 0,
      exitCount: 0,
      loginClicked: false,
      exitClicked: false
    };
  }
  updateEntry = () => {
    this.setState((prevState) => ({
      entryCount: prevState.entryCount + 1,
      loginClicked: true
    }), () => {
      setTimeout(() => this.setState({ loginClicked: false }), 1000);
    });
  };
  updateExit = () => {
    this.setState((prevState) => ({
      exitCount: prevState.exitCount + 1,
      exitClicked: true
    }), () => {
      setTimeout(() => this.setState({ exitClicked: false }), 1000); 
    });
  };
  render() {
    const { entryCount, exitCount, loginClicked, exitClicked } = this.state;
    const loginButtonStyle = {
      ...styles.button,
      backgroundColor: loginClicked ? '#000' : '#4CAF50',
      color: loginClicked ? '#fff' : '#fff'
    };
    const exitButtonStyle = {
      ...styles.button,
      backgroundColor: exitClicked ? '#000' : '#f44336',
      color: exitClicked ? '#fff' : '#fff'
    };
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h1>Welcome to the Mall</h1>
        <h2>People Entered: {entryCount}</h2>
        <h2>People Exited: {exitCount}</h2>
        <button onClick={this.updateEntry} style={loginButtonStyle}>Login</button>
        <button onClick={this.updateExit} style={exitButtonStyle}>Exit</button>
      </div>
    );
  }
}
const styles = {
  button: {
    margin: '10px',
    padding: '10px 20px',
    fontSize: '16px',
    border: 'none',
    borderRadius: '8px',
    cursor: 'pointer',
    transition: 'background-color 0.3s ease'
  }
};

export default CountPeople;
