import {createAction} from 'redux-actions';
import * as actionTypes from "./actionTypes";

export interface GetCrewsAction {
  type: typeof actionTypes.GET_CREWS;
}

export const getCrews: () => GetCrewsAction = createAction(actionTypes.GET_CREWS);
