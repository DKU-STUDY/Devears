import React from "react";
import css from "styled-jsx/css";
import UserProfile from "./UserProfile";
import {CrewResponse} from "../../domain";
import Conditional from "../../hocs/Conditional";
import NoneImage from "./NoneImage";

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
          <NoneImage />
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
    width: calc(20% - 10px);
    margin: 0 5px;
  }
`;

export default React.memo(CrewCard);