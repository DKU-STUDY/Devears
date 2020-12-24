import { createAction } from 'redux-actions';
import * as actionTypes from "./actionTypes";

export interface GetCrewsAction {
  type: typeof actionTypes.GET_CREWS;
}

export interface CrewsActions {
  getCrews: GetCrewsAction;
  payload: undefined
}

export const getCrews = createAction(actionTypes.GET_CREWS, () => undefined);
