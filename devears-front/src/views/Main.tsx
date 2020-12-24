import React from "react";
import {Typography} from "antd";
import { CrewService } from "../services";

CrewService.getAllCrew().then(console.log);

const { Title } = Typography;

const Main: React.FC = () => {
  return (
    <main>
      <div className="container">
        <section>
          <Title level={2}>스터디 크루</Title>
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
    </main>
  )
}

export default React.memo(Main);
