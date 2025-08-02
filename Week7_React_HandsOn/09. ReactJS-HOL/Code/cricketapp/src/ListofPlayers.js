import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: "Virat", score: 95 },
    { name: "Rohit", score: 88 },
    { name: "Rahul", score: 45 },
    { name: "Shreyas", score: 72 },
    { name: "Pant", score: 65 },
    { name: "Jadeja", score: 80 },
    { name: "Hardik", score: 55 },
    { name: "Bumrah", score: 25 },
    { name: "Shami", score: 60 },
    { name: "Kuldeep", score: 70 },
    { name: "Ashwin", score: 90 },
  ];
  const filtered = players.filter(player => player.score < 70); 
  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>

      <h2>Players with Score Below 70</h2>
      <ul>
        {filtered.map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;