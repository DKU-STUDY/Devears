import React from "react";
import {Link} from "react-router-dom";
import logo from "assets/image/logo.svg";

const Header: React.FC = () => {
  return (
    <>
      <header id="site-header">
        <Link to="/"><img src={logo} alt="devears" width="100" /></Link>
      </header>
      <style jsx></style>
    </>
  )
}

export default React.memo(Header);