import {applyMiddleware, createStore} from "redux";
import createSagaMiddleware from 'redux-saga';
import { createBrowserHistory } from 'history'
import { routerMiddleware } from 'connected-react-router'
import { createRootReducer } from "./rootReducer";
import rootSaga from "./rootSaga";

const history = createBrowserHistory();
const sagaMiddleware = createSagaMiddleware();
const rootReducer = createRootReducer(history);

const logger = (store: any) => (next: any) => (action: any) => {
  console.group(action.type);
  console.info('dispatching', action);
  const result = next(action);
  console.log('next state', store.getState());
  console.groupEnd();
  return result;
}

export default function configureStore() {
  const store = createStore(
    rootReducer,
    applyMiddleware(
      sagaMiddleware,
      routerMiddleware(history),
      logger
    ),
  );

  sagaMiddleware.run(rootSaga);

  return {
    store,
    history
  }
}