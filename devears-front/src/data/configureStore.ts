import {applyMiddleware, compose, createStore} from "redux";
import createSagaMiddleware from 'redux-saga';
import { createBrowserHistory } from 'history'
import { routerMiddleware } from 'connected-react-router'
import { createRootReducer } from "./rootReducer";
import rootSaga from "./rootSaga";

const history = createBrowserHistory();
const sagaMiddleware = createSagaMiddleware();
const rootReducer = createRootReducer(history);

export default function configureStore() {
  const { __REDUX_DEVTOOLS_EXTENSION__ = (f: Function) => f() } = window as any;
  const store = createStore(
    rootReducer,
    compose(
      applyMiddleware(
        sagaMiddleware,
        routerMiddleware(history)
      ),
      __REDUX_DEVTOOLS_EXTENSION__()
    )
  );

  sagaMiddleware.run(rootSaga);

  return {
    store,
    history
  }
}