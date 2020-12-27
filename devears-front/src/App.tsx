import React from 'react';
import {Switch} from "react-router-dom";
import {ConnectedRouter} from "connected-react-router";
import css from 'styled-jsx/css';
import {History} from "history";

import DefaultLayout from "./layouts/DefaultLayout";
import Main from "./views/Main";

interface AppProps {
  history: History
}

const App: React.FC<AppProps> = ({history}) => {
  return (
    <ConnectedRouter history={history}>
      <Switch>
        <DefaultLayout exact path="/" component={Main}/>
      </Switch>
      <style jsx global>{globalStyles}</style>
    </ConnectedRouter>
  );
}

const globalStyles = css.global`
  body, html, ul, li, div, p {
    margin: 0;
    padding: 0;
  }
  
  html {
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen',
    'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif;    
  }
  
  body {
    font-family: inherit;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    background: #f5f5f5;
  }
  
  input, textarea, button {
    font-family: inherit;
  }
  
  strong, h1, h2, h3, h4, h5, h6 {
    font-weight: 600;
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
