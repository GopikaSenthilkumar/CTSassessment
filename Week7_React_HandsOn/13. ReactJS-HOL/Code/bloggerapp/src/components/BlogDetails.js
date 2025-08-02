import React from 'react';
import { blogs } from '../data/blogdata';

const BlogDetails = () => {
  const content = blogs.map((blog, index) => (
    <div key={index}>
      <h2>{blog.title}</h2>
      <h4>{blog.author}</h4>
      <p>{blog.content}</p>
    </div>
  ));
  return (
    <div className="v1">
      <h1>Blog Details</h1>
      {content}
    </div>
  );
};

export default BlogDetails;