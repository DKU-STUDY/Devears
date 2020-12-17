import React from "react";
import { Route, RouteProps } from "react-router-dom";

interface IDefaultProps extends RouteProps {
  component: any
}

const DefaultLayout: React.FC<IDefaultProps> = ({ component: Component, ...props }: IDefaultProps) => {
  return (
    <Route {...props} render={(matchProps) => (
      <Component {...matchProps} />
    )} />
  )
}

export default DefaultLayout;