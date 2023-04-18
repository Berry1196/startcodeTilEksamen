import React from "react";

import { Fragment } from "react";
import Navbar from "./navbar/Navbar";

const Layout = ({ children, username, role }) => {
  return (
    <Fragment>
      <Navbar username={username} role={role} />
      <main>{children}</main>
    </Fragment>
  );
};

export default Layout;
