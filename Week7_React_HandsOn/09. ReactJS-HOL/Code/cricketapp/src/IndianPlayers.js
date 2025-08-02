import React from 'react';

const IndianPlayers = () => {
  const T20players = ["Kohli", "Rohit", "Pant", "Sky"];
  const RanjiTrophy = ["Pujara", "Iyer", "Jadeja", "Rahane"];
  const allPlayers = [...T20players, ...RanjiTrophy]; 
  const [first, second, third, fourth, fifth, sixth, seventh, eighth] = allPlayers; 
  const flag = true; 
  return (
    <div>
      {flag ? (
        <div>
          <h2>Odd Team Players</h2>
          <ul>
            <li>{first}</li>
            <li>{third}</li>
            <li>{fifth}</li>
            <li>{seventh}</li>
          </ul>
        </div>
      ) : (
        <div>
          <h2>Even Team Players</h2>
          <ul>
            <li>{second}</li>
            <li>{fourth}</li>
            <li>{sixth}</li>
            <li>{eighth}</li>
          </ul>
        </div>
      )}
    </div>
  );
};

export default IndianPlayers;