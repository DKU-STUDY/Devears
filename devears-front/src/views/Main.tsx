import React, {useEffect} from "react";
import {Typography} from "antd";
import { CrewService } from "../services";
import {useDispatch, useSelector} from "react-redux";
import selectors from "../data/rootSelectors";
import actions from "../data/rootActions";
import CrewCard from "../components/card/CrewCard";
import css from "styled-jsx/css";

CrewService.getAllCrew().then(console.log);

const { Title } = Typography;

const Main: React.FC = () => {
  const dispatch = useDispatch();
  const crews = useSelector(selectors.crew.getCrews);

  useEffect(() => {
    dispatch(actions.crew.getCrews());
  }, [dispatch]);

  return (
    <main>
      <div className="container">
        <section>
          <Title level={2}>스터디 크루</Title>
          <div className="articles">
            {crews.map((crew, key) => <CrewCard key={key} {...crew} />)}
          </div>
        </section>
        <section>
          <Title level={2}>참여 중인 스터디</Title>
        </section>
        <section>
          <Title level={2}>모집 중인 스터디</Title>
        </section>
        <section>
          <Title level={2}>진행 중인 스터디</Title>
        </section>
        <section>
          <Title level={2}>종료 된 스터디</Title>
        </section>
      </div>
      <style jsx>{mainStyles}</style>
    </main>
  )
}

const mainStyles = css`
  .articles {
    display: flex;
    flex-flow: nowrap;
  }
`;

export default React.memo(Main);
