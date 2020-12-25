import {CrewAction} from "./actions";
import * as actionTypes from "./actionTypes";

const initState = {
  [actionTypes.GET_CREWS]: {
    asked: false,
    loading: false,
    failure: false,
    success: []
  },
}

export default function crewReducer(state = initState, action: CrewAction) {
  switch (action.type) {
    case actionTypes.GET_CREWS_LOADING:
      return {
        ...state,
        [actionTypes.GET_CREWS]: {
          ...state[actionTypes.GET_CREWS],
          asked: true,
          loading: true,
          failure: false,
        }
      }
    case actionTypes.GET_CREWS_FAILURE:
      return {
        ...state,
        [actionTypes.GET_CREWS]: {
          ...state[actionTypes.GET_CREWS],
          asked: false,
          loading: false,
          failure: true,
        }
      }
    case actionTypes.GET_CREWS_SUCCESS:
      return {
        ...state,
        [actionTypes.GET_CREWS]: {
          asked: false,
          loading: false,
          failure: false,
          success: action.payload
        }
      }
  }
}
