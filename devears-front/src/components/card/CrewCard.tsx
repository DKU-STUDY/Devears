import React from "react";
import css from "styled-jsx/css";
import UserProfile from "./UserProfile";
import {CrewResponse} from "../../domain";
import Conditional from "../../hocs/Conditional";

const CrewCard: React.FC<CrewResponse> = ({ thumbnailUrl, name, description, writer }: CrewResponse) => {
  return (
    <>
      <article>
        <Conditional condition={thumbnailUrl.length > 0}>
          <figure className="image">
            <img src={thumbnailUrl} alt={name} />
          </figure>
        </Conditional>
        <Conditional condition={thumbnailUrl.length === 0}>
          <div className="none-image" />
        </Conditional>
        <h4>{name}</h4>
        <p>{description}</p>
        <UserProfile
          name={writer.name}
          profileImageUrl={writer.profileImageUrl} />
      </article>
      <style jsx>{crewCardStyles}</style>
    </>
  );
}

const crewCardStyles = css`
  article {
    width: calc(25% - 30px);
    margin: 0 15px;
  }
  
  .none-image {
    padding-top: 40%;
    background: #f5f5f5;
  }
`;

export default React.memo(CrewCard);