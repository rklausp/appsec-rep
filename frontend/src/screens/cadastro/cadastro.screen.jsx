import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createUser } from "../../api/create_user.api";

export function CadastroScreen() {
  const [formInput, setFormInput] = useState({
    email: "",
    senha: "",
    nome: "",
    telefone: "",
    foto: "",
  });
  const navigate = useNavigate();


  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      await createUser({
        nome: formInput.nome,
        email: formInput.email,
        senha: formInput.senha,
        telefone: formInput.telefone,
        foto: formInput.foto,
      });
    } catch (error) {
      console.log(error?.response?.data?.message);
    }
  }

  return (
    <div className="incluir-box">
      <form className="incluir-form" onSubmit={handleSubmit}>
        <h1>Cadastrar-se</h1>
        <div>
          <label>Nome Completo</label>
          <input
            onChange={handleChange}
            name="nome"
            value={formInput.nome}
            placeholder="Digite seu nome completo"
          />
        </div>
        <div>
          <label>Telefone</label>
          <input
            onChange={handleChange}
            name="telefone"
            value={formInput.telefone}
            placeholder="Digite seu telefone"
          />
        </div>
        <div>
          <label>email</label>
          <input
            onChange={handleChange}
            name="email"
            value={formInput.email}
            placeholder="Digite seu email"
          />
        </div>            
        <div>
          <label>Senha</label>
          <input
            onChange={handleChange}
            value={formInput.senha}
            name="senha"
            placeholder="Digite sua senha"
          />
        </div>
        <div>
          <label>Imagem de Perfil</label>
          <input
            onChange={handleChange}
            value={formInput.foto}
            name="foto"
            placeholder="Digite link da sua Imagem"
          />
        </div>
        <button onClick={handleSubmit}>Enviar</button>
      </form>
    </div>
  );
}
