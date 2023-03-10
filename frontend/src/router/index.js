import { createBrowserRouter } from "react-router-dom";
import { CadastroScreen } from "../screens/cadastro/cadastro.screen";
import { LoginScreen } from "../screens/login/login.screen";
import { PerfilScreen } from "../screens/profile/profile.screen";
import { AlterUserScreen } from "../screens/alterar/alterar.screen";

import { PrivateRoute } from "./private-route.component";
import { NovaSenhaScreen } from "../screens/novasenha/novasenha.screen";
import { MudarSenhaScreen } from "../screens/mudarsenha/mudarsenha.screen";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <LoginScreen />,
  },
  {
    path: "/cadastro",
    element: <CadastroScreen />,
  },
  {
    path: "/novasenha",
    element: <NovaSenhaScreen />
  },
  {
    path: "/recuperar-senha",
    element: <MudarSenhaScreen />
  },
  {
    path: "/perfil",
    element: <PrivateRoute Screen={PerfilScreen} />,
  },
  {
    path: "/user/alter",
    element: <PrivateRoute Screen={AlterUserScreen} />,
  }
]);
