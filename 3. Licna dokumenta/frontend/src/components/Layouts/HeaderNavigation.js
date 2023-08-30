import React from "react";
import { NavLink } from "react-router-dom";

const HeaderNavigation = () => {
  return (
    <nav className="main-nav">
      <ul>
        <li>
          <NavLink to="/id-list">List of ids</NavLink>
        </li>
        <li>
          <NavLink to="/passport-issuing">Passport issuing</NavLink>
        </li>
        <li>
          <NavLink to="/bird">Birds</NavLink>
        </li>
        <li>
          <NavLink to="/food">Food</NavLink>
        </li>
      </ul>
    </nav>
  );
};

export default HeaderNavigation;
