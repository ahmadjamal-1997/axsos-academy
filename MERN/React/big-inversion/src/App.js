import logo from './logo.svg';
import './App.css';
import PersonCard from './component/PersonCard';

function App() {
  return (
    <div className="App">
      <PersonCard firstName="Jane" lastName="Doe" age="45" haircolor="black"/>
      <PersonCard firstName="John" lastName="Smith" age="88" haircolor="brown"/>
      <PersonCard firstName="Millard" lastName="Fillmore" age="50" haircolor="brown"/>
      <PersonCard firstName="Maria" lastName="Smith" age="62" haircolor="brown"/>
    </div>
  );
}

export default App;
