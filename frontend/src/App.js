import { RouterProvider } from 'react-router-dom';
import './App.css';
import { Toastr } from './components/toastr.component';
import { GlobalToastrProvider } from './context/toastr.context';
import { GlobalUserProvider } from './context/user.context';
import { router } from './router';

function App() {
  return (
    <div className="App">
     <GlobalUserProvider>
      <GlobalToastrProvider>
        <Toastr />
          <RouterProvider router={router} />
          </GlobalToastrProvider>
      </GlobalUserProvider>
    </div>
  );
}

export default App;
