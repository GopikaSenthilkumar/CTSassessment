import React from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';
import './App.css';

function App() {
  return (
    <div className="container">
      <CourseDetails />
      <BookDetails />
      <BlogDetails />
    </div>
  );
}

export default App;