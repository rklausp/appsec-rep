import { createBrowserRouter } from "react-router-dom";
import { CadastroScreen } from "../screens/cadastro/cadastro.screen";
import { LoginScreen } from "../screens/login/login.screen";
import { PerfilScreen } from "../screens/profile/profile.screen";
import { AlterUserScreen } from "../screens/alterar/alterar.screen";

import { PrivateRoute } from "./private-route.component";

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
    path: "/perfil",
    element: <PrivateRoute Screen={PerfilScreen} />,
  },
  {
    path: "/user/alter",
    element: <PrivateRoute Screen={AlterUserScreen} />,
  }
]);
