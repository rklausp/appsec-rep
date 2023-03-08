import { axiosInstance } from "./axios_instance";

export async function createUser({
  nome,
  email,
  senha,
  telefone,
  foto
}) {
  const response = await axiosInstance.post("/usuarios", {
    nome,
    email,
    senha,
    telefone,
    foto,
    funcao: "USER",
  });
  return response.data;
}
