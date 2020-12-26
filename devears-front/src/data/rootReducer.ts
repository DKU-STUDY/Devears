import { connectRouter } from 'connected-react-router';
import { combineReducers } from 'redux';
import { History } from 'history';
import crew from "./crew/reducers";

const createRootReducer = (history: History) => combineReducers({
  router: connectRouter(history),
  crew,
});

export {
  createRootReducer,
}
