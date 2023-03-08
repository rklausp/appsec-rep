import { axiosInstance } from "./axios_instance";

export async function getMyProfile() {
    const response = await axiosInstance.get("/usuarios/me");
    return response.data;
  }