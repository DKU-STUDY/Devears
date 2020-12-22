import React from "react";
import css from "styled-jsx/css";
import Logo from "assets/image/logo.svg";
import {MailOutlined, PhoneFilled} from "@ant-design/icons";

const Footer: React.FC = () => {
  return (
    <>
      <footer>
        <div className="container">
          <div>
            <ul className="menu">
              <li><a href="#!">이용약관</a></li>
              <li><a href="#!">개인정보 처리방침</a></li>
            </ul>
            <ul className="info">
              <li>
                <PhoneFilled />
                <span className="info-value">+82-10-5764-4483</span>
              </li>
              <li>
                <MailOutlined />
                <span className="info-value">junil.h@kakao.com</span>
              </li>
            </ul>
            <p className="copyright">
              Copyright &copy; 2021 <strong>Devears</strong> All Right Reserved.
            </p>
          </div>
          <div className="logo">
            <img src={Logo} alt="devears" height="50" />
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
    justify-content: space-between;
    font-size: 13px;
  }
  
  ul {
    
    li + li {
      margin-left: 7px;
      padding-left: 8px;
      position: relative;

      &:before {
        content: "";
        display: block;
        position: absolute;
        left: 0;
        top: 2px;
        bottom: 2px;
        width: 1px;
        background: #777;
      }
    }
  }

  .menu {
    display: flex;
    a:hover {
      color: #fff;
    }
  }

  .info {
    margin-top: 5px;
    display: flex;

    &-value {
      margin-left: 5px;
    }
  }

  .copyright {
    margin-top: 5px;
    text-transform: uppercase;
  }
  
  .logo {
    img {
      filter: grayscale(100%);
    }
  }
`;

export default React.memo(Footer);
