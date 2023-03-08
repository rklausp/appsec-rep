import { axiosInstance } from "./axios_instance";

export async function login({ username, password }) {
  const response = await axiosInstance.post(
    "/login",
    {},
    {
      auth: {
        username,
        password,
      },
    }
  );
  return response.data;
}