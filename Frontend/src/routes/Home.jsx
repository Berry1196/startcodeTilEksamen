import React from "react";
import facade from "../ApiFacade";

const Home = ({ username, role }) => {
  return <div className='text-sm'>Hello {username} </div>;
};

export default Home;
