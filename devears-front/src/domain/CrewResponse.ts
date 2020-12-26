import {UserResponse} from "./UserResponse";

export interface CrewResponse {
  idx: number;
  name: string;
  description: string;
  thumbnailUrl: string;
  writer: UserResponse;
}
