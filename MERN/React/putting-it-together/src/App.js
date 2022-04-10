import logo from './logo.svg';
import './App.css';
import PersonCard from './component/PersonCard';

function App() {
  return (
    
   <div className="App">
      <PersonCard firstName="Jane" lastName="Doe" age={45} haircolor="black"/>
      <PersonCard firstName="John" lastName="Smith" age={88} haircolor="brown"/>
    </div>
    
  );
}

export default App;
