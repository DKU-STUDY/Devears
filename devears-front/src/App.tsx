import React from 'react';
import { BrowserRouter, Switch } from "react-router-dom";
import DefaultLayout from "./layouts/DefaultLayout";
import Main from "./views/Main";

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <DefaultLayout exact path="/" component={Main} />
      </Switch>
    </BrowserRouter>
  );
}



export default App;
