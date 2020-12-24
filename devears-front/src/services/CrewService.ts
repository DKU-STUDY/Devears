import { CrewResponse } from "../domain";
import { apiClient } from "../clients";

export const getAllCrew = (): Promise<CrewResponse> =>
  apiClient.get("/crew");
