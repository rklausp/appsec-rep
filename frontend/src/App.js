import { RouterProvider } from 'react-router-dom';
import './App.css';
import { GlobalUserProvider } from './context/user.context';
import { router } from './router';

function App() {
  return (
    <div className="App">
     <GlobalUserProvider>
          <RouterProvider router={router} />
      </GlobalUserProvider>
    </div>
  );
}

export default App;
