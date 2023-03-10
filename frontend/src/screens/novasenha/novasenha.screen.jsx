import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { newpassword } from "../../api/new_password";
import useGlobalUser from "../../context/user.context";
import { useToastr } from "../../hooks/use-toastr.hook";

export function NovaSenhaScreen(){

    const [formInput, setFormInput] = useState({ email: "" });
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
        const user = await newpassword({
          email: formInput.email,
        });
        setUser(user);
        showToastr("Verifique sua caixa de email!")
        navigate("/")
      } catch (error) {
        showToastr("Erro ao enviar email!");
      }
    }
  
  
    return (
      <div className="incluir-box">
        <form className="incluir-form" onSubmit={handleSubmit}>
          <div>
            <label>Email</label>
            <input
              onChange={handleChange}
              name="email"
              value={formInput.email}
              placeholder="Digite seu email"
            />
          </div>
          <button onClick={handleSubmit}>Enviar</button>
        </form>

      </div>
    );


}