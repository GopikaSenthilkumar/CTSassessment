import React, { useState } from 'react';
import UserPage from './UserPage'; 
import GuestPage from './GuestPage'; 

function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}
function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}
function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserPage />;
  }
  return <GuestPage />; 
}
function LoginControl() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };
  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };
  let button;
  if (isLoggedIn) {
    button = <LogoutButton onClick={handleLogoutClick} />;
  } else {
    button = <LoginButton onClick={handleLoginClick} />;
  }
  return (
    <div>
      <Greeting isLoggedIn={isLoggedIn} />
      {button}
    </div>
  );
}

export default LoginControl;