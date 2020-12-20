import React from "react";
import { Route, RouteProps } from "react-router-dom";
import Header from "./default/Header";
import Footer from "./default/Footer";

interface IDefaultProps extends RouteProps {
  component: any
}

const DefaultLayout: React.FC<IDefaultProps> = ({ component: Component, ...props }: IDefaultProps) => {
  return (
    <Route {...props} render={(matchProps) => (
      <>
        <Header />
        <Component {...matchProps} />
        <Footer />
      </>
    )} />
  )
}

export default DefaultLayout;