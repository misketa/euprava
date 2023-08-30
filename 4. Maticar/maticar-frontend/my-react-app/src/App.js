import "./App.css";
import ListOfUsers from "./components/ListOfUsers";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<ListOfUsers />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
