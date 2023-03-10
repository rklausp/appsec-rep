import { axiosInstance } from "./axios_instance";

export async function changepassword({ token, novaSenha }) {
  const response = await axiosInstance.post(
    `/senha/recuperar-senha`, {
        token: token,
        novaSenha: novaSenha,  
    }
  );
  return response.data;
}