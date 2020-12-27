import React from "react";
import css from "styled-jsx/css";
import UserProfile from "./UserProfile";
import {CrewResponse} from "../../domain";
import Conditional from "../../hocs/Conditional";
import NoneImage from "./NoneImage";
import { Link } from "react-router-dom";

const CrewCard: React.FC<CrewResponse> = ({ idx, thumbnailUrl, name, description, writer }: CrewResponse) => {
  return (
    <>
      <Link to={`/crew/${idx}`} className={crewWrap.className}>
        <article>
          <Conditional condition={thumbnailUrl.length > 0}>
            <figure>
              <img src={thumbnailUrl} alt={name} />
            </figure>
          </Conditional>
          <Conditional condition={thumbnailUrl.length === 0}>
            <NoneImage />
          </Conditional>
          <h4>{name}</h4>
          <p>{description}</p>
          <UserProfile
            id={writer.id}
            profileImageUrl={writer.profileImageUrl} />
        </article>
      </Link>
      {crewWrap.styles}
      <style jsx>{crewCardStyles}</style>
    </>
  );
}

const crewWrap = css.resolve`
  a {
    display: block;
    width: calc(20% - 10px);
    margin: 0 5px;
  }
`;
const crewCardStyles = css`

  figure {
    margin: 0;
    padding: 60% 0 0;
    position: relative;
    
    img {
      position: absolute;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      object-fit: cover;
    }
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
    text-overflow: ellipsis;
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 3;
    -webkit-box-orient: vertical;
    word-wrap: break-word;
  }
`;

export default React.memo(CrewCard);