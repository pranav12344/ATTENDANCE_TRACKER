import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Dashboard from "./dashboard";
import Foot from "./footer";
import Button from './button.jsx';
import Timetable from './timetable.jsx';
import Perc from './attendance_percent.jsx';
import Backbut from './back_button.jsx';
import Mark from './marking_attend.jsx';

function App() {
  return (
    <Router>
      
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/timetable" element={<Timetable />} />
          <Route path="/attendance_percent" element={<Perc />} />
          <Route path="/marking_attend" element={<Mark />}/>
        </Routes>

        <Button />
        <Backbut/>
        <Foot />

      
    </Router>
  );
}

export default App;
