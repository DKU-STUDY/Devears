import { createActions } from 'redux-actions';
import * as actionTypes from "./actionTypes";

export const { getCrews } = createActions(actionTypes.GET_CREWS);
