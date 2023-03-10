import { useState } from "react";
import { useNavigate  } from "react-router-dom";
import { putAlterUser } from "../../api/alter_user";
import { useToastr } from "../../hooks/use-toastr.hook";



export function AlterUserScreen() {
  const [formInput, setFormInput] = useState({
    nome: "",
    email: "",
    senha: "",
    telefone: "",
    foto: ""
  });
  const navigate = useNavigate();
  const showToastr = useToastr();

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      await putAlterUser({
        nome: formInput.nome,
        telefone: formInput.telefone,
        foto: formInput.foto,
        senha: formInput.senha,
        email: formInput.email,
      });
      showToastr("Usuario alterado com sucesso")
      navigate("/perfil")
    } catch (error) {
      showToastr("Erro ao alterar usuario")
    }
  }

  return (
    <div className="incluir-box">
      <form className="incluir-form" onSubmit={handleSubmit}>
        <h1>Cadastrar-se</h1>
        <div>
          <label>Novo Nome</label>
          <input
            onChange={handleChange}
            name="nome"
            value={formInput.nome}
            placeholder="Digite novo nome"
          />
        </div>
        <div>
          <label>Novo Telefone</label>
          <input
            onChange={handleChange}
            name="telfone"
            value={formInput.telefone}
            placeholder="Digite novo telefone"
          />
        </div>
        <div>
          <label>Nova imagem</label>
          <input
            onChange={handleChange}
            value={formInput.foto}
            name="foto"
            placeholder="Digite novo link da sua Imagem"
          />
        </div>
        <div>
          <label>Novo email</label>
          <input
            onChange={handleChange}
            value={formInput.email}
            name="email"
            placeholder="Digite novo email"
          />
        </div>
        <div>
          <label>Nova senha</label>
          <input
            onChange={handleChange}
            value={formInput.senha}
            name="senha"
            placeholder="Digite nova senha"
          />
        </div>
        <button onClick={handleSubmit}>Enviar</button>
      </form>
    </div>
  );
}
