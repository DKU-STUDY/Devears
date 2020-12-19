import React from "react";
import {Link} from "react-router-dom";
import logo from "assets/image/logo.svg";
import css from "styled-jsx/css";

const Header: React.FC = () => {
  return (
    <>
      <header id="site-header">
        <div className="container">
          <Link to="/"><img src={logo} alt="devears" height="50"/></Link>
        </div>
      </header>
      <style jsx>{headerStyles}</style>
    </>
  )
}

const headerStyles = css`
  header {
    border-bottom: 1px solid #ddd;
    padding: 10px 0;
  }
`;

export default React.memo(Header);