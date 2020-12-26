import * as actionTypes from "./actionTypes";
import {CrewState} from "./reducers";
import {CrewResponse} from "../../domain";

export const getCrews = (state: CrewState): CrewResponse[] =>
  state[actionTypes.GET_CREWS].success;
