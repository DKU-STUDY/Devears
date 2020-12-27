import React from "react";
import { Link } from "react-router-dom";
import css from "styled-jsx/css";

export interface UserProfileProps {
  id: string;
  profileImageUrl: string;
}

const UserProfile: React.FC<UserProfileProps> = ({ id, profileImageUrl }) => {
  const userPageLink = `/@${id}`;

  return (
    <Link to={userPageLink} className={wrapResolve.className}>
      <figure>
        <img src={profileImageUrl} alt={id} />
      </figure>
      <span>{id}</span>
      {wrapResolve.styles}
      <style jsx>{userProfileStyles}</style>
    </Link>
  )
}

const wrapResolve = css.resolve`
  a {
    margin-top: 10px;
    display: flex;
  }
`;

const userProfileStyles = css`
  figure {
    border-radius: 20px;
    width: 24px;
    height: 24px;
    overflow: hidden;
    margin: 0;
    padding: 0;
    
    img {
      width: 100%;
      height: 100%;
    }
  }
  
  span {
    font-size: 14px;
    margin-left: 5px;
    color: #666;
  }
`;

export default React.memo(UserProfile);
