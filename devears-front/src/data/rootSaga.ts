import { all, fork } from 'redux-saga/effects';
import crewSagas from "./crew/sagas";

// import postsSagas from '@/data/posts/sagaRegister';
// import commentsSagas from '@/data/comments/sagaRegister';

export default function* rootSaga() {
  yield all([
    fork(crewSagas)
  ]);
}
