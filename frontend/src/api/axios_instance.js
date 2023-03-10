import axios from "axios";
import { API_URL } from "../constants/api-url.constant";

export const axiosInstance = axios.create({
  baseURL: API_URL,
  timeout: 40000,
  withCredentials: true,
});
