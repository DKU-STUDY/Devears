import React from 'react';
import { BrowserRouter, Switch } from "react-router-dom";
import css from 'styled-jsx/css';

import DefaultLayout from "./layouts/DefaultLayout";
import Main from "./views/Main";

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <DefaultLayout exact path="/" component={Main} />
      </Switch>
      <style jsx global>{globalStyles}</style>
    </BrowserRouter>
  );
}

const globalStyles = css.global`
  body, html, ul, li, div, p {
    margin: 0;
    padding: 0;
  }
  
  body {
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen',
      'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
  }
  
  ul, li {
    list-style: none;
  }
  
  a {
    text-decoration: none;
    color: inherit;
  }
  
  code {
    font-family: source-code-pro, Menlo, Monaco, Consolas, 'Courier New', monospace;
  }
  
  .container {
    width: 1200px;
    margin: 0 auto;
  }
`;



export default App;
