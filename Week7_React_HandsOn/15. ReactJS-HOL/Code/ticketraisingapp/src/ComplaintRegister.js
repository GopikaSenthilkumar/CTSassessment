import React, { useState } from 'react';

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const referenceNumber = Math.floor(100 + Math.random() * 900);
    alert(`Thanks ${employeeName}\nYour Complaint was Submitted!\nTransaction ID: ${referenceNumber}`);
    setEmployeeName('');
    setComplaint('');
  };
  return (
    <div className="form-container">
      <h2>Raise a Complaint</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Employee Name</label>
          <input
            type="text"
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label>Complaint</label>
          <textarea
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            required
          />
        </div>
        <button type="submit">Submit Complaint</button>
      </form>
    </div>
  );
}

export default ComplaintRegister;