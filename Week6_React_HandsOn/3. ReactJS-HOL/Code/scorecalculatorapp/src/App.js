import React from 'react';
import { CalculateScore } from './Components/CalculateScore';

function App() {
    return (
        <div>
            <CalculateScore 
                Name="Gopika" 
                School="Velammal Vidyalaya" 
                total={284} 
                goal={3} 
            />
        </div>
    );
}

export default App;