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
  
  h4 {
    font-size: 17px;
    padding: 0;
    margin: 5px 0;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  
  p {
    font-size: 14px;
    line-height: 130%;
    height: calc(14px * 1.3 * 3);
    text-overflow: ellipsis;
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 3;
    -webkit-box-orient: vertical;
    word-wrap: break-word;
  }
`;

export default React.memo(CrewCard);