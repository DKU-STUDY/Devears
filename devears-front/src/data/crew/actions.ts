import {createAction} from 'redux-actions';
import * as actionTypes from "./actionTypes";

export interface GetCrewsAction {
  type: typeof actionTypes.GET_CREWS;
}

export interface GetCrewsLoadingAction {
  type: typeof actionTypes.GET_CREWS_LOADING;
}

export interface GetCrewsSuccessAction {
  type: typeof actionTypes.GET_CREWS_SUCCESS;
}

export interface GetCrewFailureAction {
  type: typeof actionTypes.GET_CREWS_FAILURE;
}

export const getCrews: () => GetCrewsAction = createAction(actionTypes.GET_CREWS);
export const getCrewsLoading: () => GetCrewsLoadingAction = createAction(actionTypes.GET_CREWS_LOADING);
export const getCrewsSuccess: () => GetCrewsSuccessAction = createAction(actionTypes.GET_CREWS_SUCCESS);
export const getCrewsFailure: () => GetCrewFailureAction = createAction(actionTypes.GET_CREWS_FAILURE);
