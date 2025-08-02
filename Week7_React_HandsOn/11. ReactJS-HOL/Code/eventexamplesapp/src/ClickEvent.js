import React from 'react';

function ClickEvent() {
  const handleClick = (e) => {
    e.preventDefault();
    alert("I was clicked");
  };
  return (
    <div style={{ marginTop: '20px' }}>
      <button onClick={handleClick}>Click on me</button>
    </div>
  );
}

export default ClickEvent;