import "./App.css";
import IDIssuing from "./components/IDIssuing";
import PassportIssuing from "./components/PassportIssuing";
import IDUpdate from "./components/IDUpdate";
import PassportUpdate from "./components/PassportUpdate";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import IDList from "./components/IDList";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<IDIssuing />} />
          <Route path="/id-list" element={<IDList />} />
          <Route path="/passport-issuing" element={<PassportIssuing />} />
          <Route path="/id-update/:id" element={<IDUpdate />} />
          <Route path="/passport-update/:id" element={<PassportUpdate />} />
        </Routes>
      </Router>
    </div>
  );
}
export default App;
