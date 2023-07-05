import { Fragment } from "react";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <Fragment>
      <h1>Izdavanje ličnih karti</h1>
      <Link to="/id-list">Go to ID List</Link>
    </Fragment>
  );
};

export default Header;
