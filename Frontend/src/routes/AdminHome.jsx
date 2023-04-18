import React, { useEffect } from "react";
import facade from "../ApiFacade";

const AdminHome = ({ username, role, setRole }) => {
  return <div className='text-sm'>Hello {username} AdminHomeComponent </div>;
};

export default AdminHome;
