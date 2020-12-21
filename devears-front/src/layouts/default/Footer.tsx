import React from "react";
import css from "styled-jsx/css";
import Logo from "assets/image/logo.svg";

const Footer: React.FC = () => {
  return (
    <>
      <footer>
        <div className="container">
          <div className="logo">
            <img src={Logo} alt="devears" height="50" />
          </div>
          <div>
            <p className="copyright">
              Copyright &copy; 2021 Devears All Right Reserved.
            </p>
            <ul className="info">
              <li></li>
            </ul>
          </div>
        </div>
      </footer>
      <style jsx>{footerStyles}</style>
    </>
  )
}

const footerStyles = css`
  footer {
    background: #242729;
    color: #848d95;
    padding: 20px 0;
  }
  
  .container {
    display: flex;
    align-items: center;
  }
  
  .copyright {
    color: #bbc0c4;
    text-transform: uppercase;
  }
  
  .logo {
    img {
      filter: grayscale(100%);
    }
  }
`;

export default React.memo(Footer);
