import { axiosInstance } from "./axios_instance";

export async function newpassword({ email }) {
  const response = await axiosInstance.post(
    `/senha/esqueci-senha/${email}`,
  );
  return response.data;
}