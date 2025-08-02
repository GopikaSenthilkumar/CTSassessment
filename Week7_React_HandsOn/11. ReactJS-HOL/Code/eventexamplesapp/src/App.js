import React from 'react';
import Counter from './Counter';
import WelcomeButton from './WelcomeButton';
import ClickEvent from './ClickEvent';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  return (
    <div style={{ padding: '20px' }}>
      <Counter />
      <WelcomeButton />
      <ClickEvent />
      <CurrencyConvertor />
    </div>
  );
}

export default App;