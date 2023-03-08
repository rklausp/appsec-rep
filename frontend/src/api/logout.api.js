import { axiosInstance } from "./axios_instance";

export async function logout() {
  await axiosInstance.post("/logout", {});
}
