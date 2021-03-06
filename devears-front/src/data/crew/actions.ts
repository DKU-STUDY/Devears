import {createAction} from 'redux-actions';
import * as actionTypes from "./actionTypes";
import {CrewResponse} from "../../domain";

export const getCrews = createAction(actionTypes.GET_CREWS);
export const getCrewsLoading = createAction(actionTypes.GET_CREWS_LOADING);
export const getCrewsSuccess = createAction(actionTypes.GET_CREWS_SUCCESS, (payload: CrewResponse[]) => payload);
export const getCrewsFailure = createAction(actionTypes.GET_CREWS_FAILURE);


export type CrewAction = ReturnType<typeof getCrews> |
                         ReturnType<typeof getCrewsLoading> |
                         ReturnType<typeof getCrewsSuccess> |
                         ReturnType<typeof getCrewsFailure>;