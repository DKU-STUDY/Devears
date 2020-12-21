import React from "react";
import css from "styled-jsx/css";

const Footer: React.FC = () => {
  return (
    <>
      <footer>
        <div className="container">
          <div className="">
          </div>
          <div>
            <p className="copyright">
              Copyright &copy; 2021 Devears All Right Reserved.
            </p>
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
  
  .copyright {
    color: #bbc0c4;
    text-transform: uppercase;
  }
`;

export default React.memo(Footer);
