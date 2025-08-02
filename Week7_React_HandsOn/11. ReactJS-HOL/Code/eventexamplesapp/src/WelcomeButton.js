import React from 'react';

function WelcomeButton() {
  const sayWelcome = (msg) => {
    alert(msg);
  };
  return (
    <div style={{ marginTop: '20px' }}>
      <button onClick={() => sayWelcome("welcome")}>Say welcome</button>
    </div>
  );
}

export default WelcomeButton;