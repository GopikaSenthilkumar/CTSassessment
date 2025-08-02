import React from 'react';

class Getuser extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null
    };
  }
  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      const data = await response.json();
      this.setState({ user: data.results[0] });
    } catch (error) {
      console.error('Error fetching user:', error);
    }
  }
  render() {
    const { user } = this.state;
    return (
      <div>
        <h2>User Information</h2>
        {user ? (
          <div>
            <p>{user.name.title} {user.name.first}</p>
            <img src={user.picture.large} alt="User" />
          </div>
        ) : (
          <p>Loading user...</p>
        )}
      </div>
    );
  }
}

export default Getuser;