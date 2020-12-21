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
          <nav>
            <ul>
              <li><a href="#!">Login</a></li>
            </ul>
          </nav>
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
    background: #fff;
    position: relative;
    z-index: 10;
  }
  
  .container {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  nav {
    
  }
`;

export default React.memo(Header);