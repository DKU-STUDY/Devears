import React from "react";
import {Link} from "react-router-dom";
import logo from "assets/image/logo.svg";
import css from "styled-jsx/css";

const Header: React.FC = () => {
  return (
    <>
      <header id="site-header">
        <Link to="/"><img src={logo} alt="devears" width="100"/></Link>
      </header>
      <style jsx>{headerStyles}</style>
    </>
  )
}

const headerStyles = css`
  header { border-bottom: 1px solid #ddd; background: #f5f5f5; }
`;

export default React.memo(Header);