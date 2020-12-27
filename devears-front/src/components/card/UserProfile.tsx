import React from "react";
import { Link } from "react-router-dom";

export interface UserProfileProps {
  id: string;
  profileImageUrl: string;
}

const UserProfile: React.FC<UserProfileProps> = ({ id, profileImageUrl }) => {
  const userPageLink = `/@${id}`;

  return (
    <Link to={userPageLink}>
      <figure>
        <img src={profileImageUrl} alt={id} />
      </figure>
      <span>{id}</span>
    </Link>
  )
}

export default React.memo(UserProfile);
