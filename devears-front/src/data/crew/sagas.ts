import { call, put, takeEvery } from "redux-saga/effects";
import { CrewService } from "services";
import * as actions from "./actions";
import * as actionTypes from "./actionTypes";
import {CrewResponse} from "../../domain";

function* getCrews() {
  try {
    yield put(actions.getCrewsLoading());
    const data: CrewResponse[] = yield call(CrewService.getAllCrew);
    yield put(actions.getCrewsSuccess(data));
  } catch (e) {
    console.error(e);
    yield put(actions.getCrewsFailure());
  }
}

export default function* crewSagas() {
  yield takeEvery(actionTypes.GET_CREWS, getCrews);
}
