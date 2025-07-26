import React from 'react';
import { useParams } from 'react-router-dom';
import trainers from './trainersmock';
function TrainerDetails() {
  const { id } = useParams();
  const trainer = trainers.find(t => t.trainerId === id);
  if (!trainer) {
    return <p>Trainer not found</p>;
  }
  return (
    <div>
      <h2>Trainer Details</h2>
      <p>Name: {trainer.name} ({trainer.technology})</p>
      <p>Email: {trainer.email}</p>
      <p>Phone: {trainer.phone}</p>
      <p>Technology: {trainer.technology}</p>
      <p>Skills:</p>
      <ul>
        {trainer.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
}

export default TrainerDetails;