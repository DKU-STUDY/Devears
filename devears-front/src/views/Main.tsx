import React, {useEffect} from "react";
import {useDispatch, useSelector} from "react-redux";
import css from "styled-jsx/css";

import selectors from "../data/rootSelectors";
import actions from "../data/rootActions";
import CrewCard from "../components/card/CrewCard";
import { useTranslation } from "react-i18next";

const Main: React.FC = () => {
  const { t } = useTranslation();
  const dispatch = useDispatch();
  const crews = useSelector(selectors.crew.getCrews);

  useEffect(() => {
    dispatch(actions.crew.getCrews());
  }, [dispatch]);

  return (
    <main>
      <div className="container">
        <section>
          <h2 className="title">{ t('study:study') } <strong>{ t('common:group') }</strong></h2>
          <div className="articles">
            {crews.map((crew, key) => <CrewCard key={key} {...crew} />)}
          </div>
        </section>
        <section>
          <h2 className="title">참여 중인 <strong>스터디</strong></h2>
        </section>
        <section>
          <h2 className="title">모집 중인 <strong>스터디</strong></h2>
        </section>
        <section>
          <h2 className="title">진행 중인 <strong>스터디</strong></h2>
        </section>
        <section>
          <h2 className="title">종료 된 <strong>스터디</strong></h2>
        </section>
      </div>
      <style jsx>{mainStyles}</style>
    </main>
  )
}

const mainStyles = css`
  main {
    margin: 20px 0;
  }
  .container {
    box-sizing: border-box;
    padding: 40px;
    background: #fff;
    border: 1px solid #ddd;
    border-radius :3px;
  }

  section + section {
    margin-top: 40px;
  }
  
  .title {
    font-weight: 400;
    font-size: 21px;
    margin: 0 0 20px;
    
    strong {
      color: #00529c;
      font-weight: 400;
    }
  }
  
  .articles {
    display: flex;
    flex-flow: nowrap;
  }
`;

export default React.memo(Main);
