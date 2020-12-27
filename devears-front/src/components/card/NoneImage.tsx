import React from "react";
import {PictureOutlined} from "@ant-design/icons";
import css from "styled-jsx/css";

const NoneImage: React.FC = () => {
  return (
    <>
      <div className="none-image">
        <div>
          <PictureOutlined />
        </div>
      </div>
      <style jsx>{noneImageStyles}</style>
    </>
  )
};

const noneImageStyles = css`
  .none-image {
    padding-top: 60%;
    position: relative;
    background: #f5f5f5;
    
    > div {
      position: absolute;
      left: 0;
      top: 0;
      right: 0;
      bottom: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      color: #bbb;
      font-size: 19px;
    }
  }
`;

export default React.memo(NoneImage);