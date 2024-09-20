import { useState, useEffect } from 'react';
import { fetchTimetable, saveTimetable } from './services/attendanceApi'; // Importing the API service

function Timetable() {
  const [selectedDay, setSelectedDay] = useState('Monday');
  const [timetable, setTimetable] = useState([]);
  const [subject, setSubject] = useState('');
  const [startTime, setStartTime] = useState('');
  const [endTime, setEndTime] = useState('');

  useEffect(() => {
    const loadTimetable = async () => {
      const data = await fetchTimetable(selectedDay);
      setTimetable(data);
    };

    loadTimetable();
  }, [selectedDay]);

  const handleDayChange = (event) => {
    setSelectedDay(event.target.value);
  };

  const handleSave = async () => {
    const newTimetable = [...timetable, { subject, startTime, endTime }];
    await saveTimetable(selectedDay, newTimetable);
    setTimetable(newTimetable);
    setSubject('');
    setStartTime('');
    setEndTime('');
  };

  return (
    <div>
      <h1>Timetable for {selectedDay}</h1>
      
      <label htmlFor="day-select">Select Day: </label>
      <select id="day-select" value={selectedDay} onChange={handleDayChange}>
        {['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'].map(day => (
          <option key={day} value={day}>{day}</option>
        ))}
      </select>

      <div>
        <h2>Enter New Timetable Entry</h2>
        <label>
          Subject:
          <input type="text" value={subject} onChange={(e) => setSubject(e.target.value)} />
        </label>
        <label>
          Start Time:
          <input type="time" value={startTime} onChange={(e) => setStartTime(e.target.value)} />
        </label>
        <label>
          End Time:
          <input type="time" value={endTime} onChange={(e) => setEndTime(e.target.value)} />
        </label>
        <button onClick={handleSave}>Save</button>
      </div>

      {timetable.length ? (
        <table>
          <thead>
            <tr>
              <th>Subject</th>
              <th>Timing</th>
            </tr>
          </thead>
          <tbody>
            {timetable.map((entry, index) => (
              <tr key={index}>
                <td>{entry.subject}</td>
                <td>{entry.startTime} - {entry.endTime}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No classes available</p>
      )}
    </div>
  );
}

export default Timetable;
