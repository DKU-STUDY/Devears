import React from "react";

export interface UserProfileProps {
  name: string;
  profileImageUrl: string;
}

const UserProfile: React.FC<UserProfileProps> = ({ name, profileImageUrl }) => {
  return (
    <a>
      <figure>
        <img src={profileImageUrl} alt={name} />
      </figure>
      <span>{name}</span>
    </a>
  )
}

export default React.memo(UserProfile);
