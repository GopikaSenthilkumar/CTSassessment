import React from 'react';
import { courses } from '../data/coursedata';

const CourseDetails = () => {
  const coursedet = courses.map((course, index) => (
    <div key={index}>
      <h2>{course.name}</h2>
      <p>{course.date}</p>
    </div>
  ));
  return (
    <div className="mystyle1">
      <h1>Course Details</h1>
      {coursedet}
    </div>
  );
};

export default CourseDetails;