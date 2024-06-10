import './assets/css/App.css';
import { UserProvider } from './components/UserContext';
import Router from './Router';


function App() {

  return (

    <div className="App">
      <UserProvider >
        <Router />
        </UserProvider>
        
    </div>
  );
}

export default App;
