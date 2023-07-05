import "./App.css";
import IDIssuing from "./components/IDIssuing";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import IDList from "./components/IDList";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<IDIssuing />} />
          <Route path="/id-list" element={<IDList />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
