import React, {useCallback} from "react";
import {Link} from "react-router-dom";
import logo from "assets/image/logo.svg";
import css from "styled-jsx/css";

const Header: React.FC = () => {
  const handleLogin = useCallback((e) => {
    e.preventDefault();
  }, []);

  return (
    <>
      <header id="site-header">
        <div className="container">
          <Link to="/"><img src={logo} alt="devears" height="50"/></Link>
          <nav>
            <ul>
              <li>
                <a href="#!" onClick={handleLogin}>
                  로그인
                </a>
              </li>
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
   a {
     position: relative;
     display: block;
     padding: 5px 0;
     
     &::before {
       content: "";
       position: absolute;
       bottom: 0;
       left: 50%;
       right: 50%;
       height: 2px;
       background: #09F;
       transition-property: left, right;
       transition-duration: 0.3s;
     }
     
     &:hover {
       color: #09F;
       &::before {
         left: 0;
         right: 0;
       }
     }
   } 
  }
`;

export default React.memo(Header);