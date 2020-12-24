import {applyMiddleware, createStore} from "redux";
import createSagaMiddleware from 'redux-saga';
import { createBrowserHistory } from 'history'
import { routerMiddleware } from 'connected-react-router'
import { createRootReducer } from "./rootReducer";
import rootSaga from "./rootSaga";

const history = createBrowserHistory();
const sagaMiddleware = createSagaMiddleware();
const rootReducer = createRootReducer(history);

export default function configureStore() {
  const store = createStore(
    rootReducer,
    applyMiddleware(
      sagaMiddleware,
      routerMiddleware(history)
    ),
  );

  sagaMiddleware.run(rootSaga);

  return {
    store,
    history
  }
}