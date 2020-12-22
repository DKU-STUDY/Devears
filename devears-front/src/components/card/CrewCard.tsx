import React from "react";
import css from "styled-jsx/css";
import UserProfile, {UserProfileProps} from "./UserProfile";

interface ICrewCardProps {
  thumbnailUrl: string;
  title: string;
  description: string;
  writer: UserProfileProps;
}

const CrewCard: React.FC<ICrewCardProps> = ({ thumbnailUrl, title, description, writer }) => {
  return (
    <>
      <article>
        <figure className="image">
          <img src={thumbnailUrl} alt={title} />
        </figure>
        <h4>{title}</h4>
        <p>{description}</p>
        <UserProfile {...writer} />
      </article>
      <style jsx>{crewCardStyles}</style>
    </>
  );
}

const crewCardStyles = css`
`;

export default React.memo(CrewCard);