import * as actionTypes from "./actionTypes";
import {CrewState} from "./reducers";
import {CrewResponse} from "../../domain";

export const getCrews = ({ crew }: { crew: CrewState }): CrewResponse[] =>
  crew[actionTypes.GET_CREWS].success;
