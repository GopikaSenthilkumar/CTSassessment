import React, { useState } from 'react';

function CurrencyConvertor() {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');
  const [converted, setConverted] = useState('');
  const handleSubmit = () => {
    const value = parseFloat(amount);
    if (!currency || isNaN(value) || value <= 0) {
      alert("Please enter valid amount and currency (INR or Euro).");
      return;
    }
    const currencyLower = currency.toLowerCase();
    let result = 0;
    if (currencyLower === 'inr') {
      result = value / 90;
      setConverted(`€${result.toFixed(2)}`);
      alert(`Converting from INR to Euro: Amount is €${result.toFixed(2)}`);
    } else if (currencyLower === 'euro') {
      result = value * 90;
      setConverted(`₹${result.toFixed(2)}`);
      alert(`Converting from Euro to INR: Amount is ₹${result.toFixed(2)}`);
    } else {
      alert("Invalid currency type! Please type either INR or Euro.");
      setConverted('');
    }
  };
  return (
    <div style={{ marginTop: '40px' }}>
      <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
      <div style={{ marginBottom: '10px' }}>
        <label>Amount: </label>
        <input
          type="number"
          placeholder="Enter amount"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
          style={{ marginLeft: '10px' }}
        />
      </div>
      <div style={{ marginBottom: '10px' }}>
        <label>Currency: </label>
        <input
          type="text"
          placeholder="Enter INR or Euro"
          value={currency}
          onChange={(e) => setCurrency(e.target.value)}
          style={{ marginLeft: '10px' }}
        />
      </div>
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}

export default CurrencyConvertor;
