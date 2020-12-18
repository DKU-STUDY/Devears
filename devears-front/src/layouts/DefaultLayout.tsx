import React from "react";
import { Route, RouteProps } from "react-router-dom";
import Header from "./default/Header";

interface IDefaultProps extends RouteProps {
  component: any
}

const DefaultLayout: React.FC<IDefaultProps> = ({ component: Component, ...props }: IDefaultProps) => {
  return (
    <Route {...props} render={(matchProps) => (
      <>
        <Header />
        <Component {...matchProps} />
      </>
    )} />
  )
}

export default DefaultLayout;