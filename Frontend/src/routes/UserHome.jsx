import React from "react";
import facade from "../ApiFacade";

const UserHome = ({ username, role }) => {
  return <div className='text-sm'>Hello {username} UserHomeComponent </div>;
};

export default UserHome;
