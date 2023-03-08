import { useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { logout } from "../../api/logout.api";
import useGlobalUser from "../../context/user.context";
import { useGetMyProfile } from "../../hooks/use_get_my_profile.hook";

export function PerfilScreen() {
  const { profile, loading, error } = useGetMyProfile();
  const [user, setUser] = useGlobalUser();
  const navigate = useNavigate();

  useEffect(() => {
    if (!user) {
      navigate("/");
    }
  }, []);

  async function handleClickLogout() {
    await logout();

    setUser(null);
    localStorage.removeItem("user");
  }

  function showUserProfile() {
    if (loading) {
      return <h3 className="problem">Perfil Carregando</h3>;
    }

    if (error) {
      return <h3 className="problem">Erro ao tentar acessar perfil</h3>;
    }

    return (
      <div className="profile-info">
        <img src={profile?.foto}></img>
        <p className="name">Perfil de {profile?.nome}</p>
        <p className="nickname">{profile?.telefone}</p>
        <p className="birth-date">
          {profile?.criadoEm}
        </p>
        <p className="birth-date">
          {profile?.atualizadoEm}
        </p>
        <p className="email">Email cadastrado: {profile?.email}</p>
      </div>
    );
  }

  return (
    <div>
      <p>Seu perfil</p>
      <button onClick={handleClickLogout}>LOGOUT</button>
      {showUserProfile()}

      <Link to={`/user/alter`}>
        <button className="alter">Atualizar Perfil</button>
      </Link>
    </div>
  );
}
