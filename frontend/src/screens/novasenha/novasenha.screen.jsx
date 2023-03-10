import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { newpassword } from "../../api/new_password";
import useGlobalUser from "../../context/user.context";

export function NovaSenhaScreen(){

    const [formInput, setFormInput] = useState({ email: "" });
    const navigate = useNavigate();
    const [user, setUser] = useGlobalUser();
  
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
      } catch (error) {
        console.log(error);
      }
    }
  
    useEffect(() => {
      if (user) {
        navigate("/login");
      }
    }, [user]);
  
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