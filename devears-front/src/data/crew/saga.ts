import { call, put, takeEvery } from "redux-saga/effects";
import { CrewService } from "services";
import * as actions from "./actions";
import * as actionTypes from "./actionTypes";

function* getCrews() {
  try {
    yield put(actions.getCrewsLoading());
    yield call(CrewService.getAllCrew);
    yield put(actions.getCrewsSuccess());
  } catch (e) {
    console.error(e);
    yield put(actions.getCrewsFailure());
  }
}

export default function* crewSagaRegister() {
  yield takeEvery(actionTypes.GET_CREWS, getCrews);
}
