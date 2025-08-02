import React, { useState } from 'react';
import './App.css';

function Register() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: ''
  });
  const [touched, setTouched] = useState({
    name: false,
    email: false,
    password: false
  });
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
    setTouched((prev) => ({ ...prev, [name]: false }));
  };
  const handleBlur = (e) => {
    const { name, value } = e.target;
    if (!touched[name]) {
      if (name === 'name' && value.trim().length < 5) {
        alert('Name must be at least 5 characters long');
      }
      if (name === 'email' && (!value.includes('@') || !value.includes('.'))) {
        alert('Email must contain "@" and "."');
      }
      if (name === 'password' && value.length < 8) {
        alert('Password must be at least 8 characters long');
      }
      setTouched((prev) => ({ ...prev, [name]: true }));
    }
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    const { name, email, password } = formData;
    if (name.trim().length < 5) {
      alert('Name must be at least 5 characters long');
      return;
    }
    if (!email.includes('@') || !email.includes('.')) {
      alert('Email must contain "@" and "."');
      return;
    }
    if (password.length < 8) {
      alert('Password must be at least 8 characters long');
      return;
    }
    alert(`Registered Successfully!\nName: ${name}\nEmail: ${email}`);
    setFormData({ name: '', email: '', password: '' });
    setTouched({ name: false, email: false, password: false }); // reset touched state
  };
  return (
    <div className="form-container">
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Name</label>
          <input
            name="name"
            type="text"
            value={formData.name}
            onChange={handleChange}
            onBlur={handleBlur}
            required
          />
        </div>
        <div className="form-group">
          <label>Email</label>
          <input
            name="email"
            type="email"
            value={formData.email}
            onChange={handleChange}
            onBlur={handleBlur}
            required
          />
        </div>
        <div className="form-group">
          <label>Password</label>
          <input
            name="password"
            type="password"
            value={formData.password}
            onChange={handleChange}
            onBlur={handleBlur}
            required
          />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default Register;