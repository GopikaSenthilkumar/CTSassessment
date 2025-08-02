import React from 'react';

const OfficeList = () => {
  const office1 = {
    name: "DBS",
    rent: 50000,
    address: "Chennai",
    image: "https://images.unsplash.com/photo-1504384308090-c894fdcc538d?auto=format&fit=crop&w=800&q=80" 
  };
  const rentStyle = {
    color: office1.rent < 60000 ? 'red' : 'green',
    fontWeight: 'bold'
  };
  return (
    <div style={{ textAlign: 'center', padding: '40px', fontFamily: 'Arial' }}>
      {}
      <h1 style={{ fontWeight: 'bold' }}>Office Space , at Affordable Range</h1>
      {}
      <img
        src={office1.image}
        alt="Office Space"
        width="400"
        height="250"
        style={{ marginTop: '20px', borderRadius: '5px' }}
      />
      {}
      <div
        style={{
          marginTop: '20px',
          fontSize: '18px',
          lineHeight: '2',
        }}
      >
        <div><strong>Name:</strong> {office1.name}</div>
        <div style={rentStyle}>Rent: Rs. {office1.rent}</div>
        <div><strong>Address:</strong> {office1.address}</div>
      </div>
    </div>
  );
};

export default OfficeList;