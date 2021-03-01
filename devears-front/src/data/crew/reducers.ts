import {CrewAction} from "./actions";
import * as actionTypes from "./actionTypes";
import {CrewResponse} from "../../domain";

export type CrewStateKey = typeof actionTypes.GET_CREWS;
export type CrewState = Record<CrewStateKey, {
  asked: boolean;
  loading: boolean;
  failure: boolean;
  success: CrewResponse[];
}>

const initState: CrewState = {
  [actionTypes.GET_CREWS]: {
    asked: false,
    loading: false,
    failure: false,
    success: []
  },
}

/**
 * Crew Reducer 설명
 * saga에서 getCrew를 실행할 때 다음과 같은 action을 사용한다.
 * 1. 처음에 가져오기 전: GET_CREWS_LOADING
 * 2. 가져온 후: GET_CREWS_SUCCESS
 * 3. 실패할 경우: GET_CREWS_FAILURE
 *
 * 즉, loading => success or failure 가 되는 것이다.
 *
 * 결과 값은 GET_CREWS.success에 저장된다.
 *
 * GET_CREWS의 asked, loading, failure에 따라 컴포넌트에서 보여주는 형태를 다르게 해야 한다.
 */
export default function crewReducer(state: CrewState = initState, action: CrewAction) {
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
    default:
      return state;
  }
}
