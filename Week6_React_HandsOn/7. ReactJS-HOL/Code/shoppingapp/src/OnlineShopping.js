import React, { Component } from 'react';
import './OnlineShopping.css';
import Cart from './Cart';

class OnlineShopping extends Component {
  render() {
    const cartItems = [
      { itemname: 'Laptop', price: 65000 },
      { itemname: 'Headphones', price: 1500 },
      { itemname: 'Keyboard', price: 1200 },
      { itemname: 'Mouse', price: 700 },
      { itemname: 'Monitor', price: 10000 }
    ];

return (
      <div className="shopping-container">
        <h2>Items Ordered :</h2>
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            {cartItems.map((item, index) => (
              <Cart key={index} itemname={item.itemname} price={item.price} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;