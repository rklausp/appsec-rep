import { axiosInstance } from "./axios_instance";

export async function putAlterUser({ nome, email, senha, foto, telefone }) {
  const response = await axiosInstance.put(`/usuarios`, {
    nome: nome,
    email: email,
    senha: senha,
    foto: foto,
    telefone: telefone
  });
  return response.data;
}
