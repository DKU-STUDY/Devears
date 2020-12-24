import axios, {AxiosInstance} from "axios";

const apiClient: AxiosInstance = axios.create({
  baseURL: "/api",
  timeout: 5000
});

apiClient.interceptors.response.use((response) => {
  return response.data;
}, error => {
  return Promise.reject(error);
});

export default apiClient;