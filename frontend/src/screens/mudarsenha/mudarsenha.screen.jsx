import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { changepassword } from "../../api/change_password";

import useGlobalUser from "../../context/user.context";
import { useToastr } from "../../hooks/use-toastr.hook";

export function MudarSenhaScreen(){

    const [formInput, setFormInput] = useState({ novaSenha: "", token: "" });
    const navigate = useNavigate();
    const [user, setUser] = useGlobalUser();
    const showToastr = useToastr();
  
    function handleChange(event) {
      const { name, value } = event.target;
  
      setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
    }
  
    async function handleSubmit(event) {
      event.preventDefault();
      try {
        const user = await changepassword({
          token: formInput.token,
          novaSenha: formInput.novaSenha,
        });
        setUser(user);
        showToastr("Senha modificada com sucesso")
        navigate("/")
      } catch (error) {
        showToastr("Erro ao modificar senha!");
      }
    }
  
  
  
    return (
      <div className="incluir-box">
        <form className="incluir-form" onSubmit={handleSubmit}>
          <div>
            <label>Nova senha</label>
            <input
              onChange={handleChange}
              name="novaSenha"
              value={formInput.novaSenha}
              placeholder="Digite sua nova senha"
            />
          </div>
          <div>
            <label>Token recebido</label>
            <input
              onChange={handleChange}
              name="token"
              value={formInput.token}
              placeholder="Digite sua nova senha"
            />
          </div>
          <button onClick={handleSubmit}>Mudar</button>
        </form>

      </div>
    );


}