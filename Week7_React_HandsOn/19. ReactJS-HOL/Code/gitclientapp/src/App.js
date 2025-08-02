import React, { useEffect, useState } from 'react';
import './App.css';
import GitClient from './GitClient';

function App() {
  const [repos, setRepos] = useState([]);
  useEffect(() => {
    const gitClient = new GitClient(); 
    gitClient.getRepositories('techiesyed').then(setRepos);
  }, []); 
  return (
    <div className="App">
      <h1>GitHub Repositories</h1>
      <ul>
        {repos.map((repo, index) => (
          <li key={index}>{repo}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;