import { useState } from 'react';

function Mark({ selectedDay, timetable }) {
  // Removed calculation of dayName since we are using selectedDay directly
  const [attendance, setAttendance] = useState({});

  const handleAttendanceChange = (index, value) => {
    setAttendance((prevAttendance) => ({
      ...prevAttendance,
      [index]: value,
    }));
  };

  const handleSave = () => {
    const allMarked = timetable.every((_, index) => attendance[index]);

    if (!allMarked) {
      alert('Please mark the attendance for all subjects.');
    } else {
      alert('Attendance saved successfully!');
      // Add logic to save attendance here
    }
  };

  return (
    <>
      <h1>MARK ATTENDANCE</h1>
      <h2>Selected Day: {selectedDay}</h2>

      {timetable && timetable.length > 0 ? (
        <table>
          <thead>
            <tr>
              <th>Subject</th>
              <th>Timing</th>
              <th>Present</th>
              <th>Absent</th>
              <th>No Class</th>
            </tr>
          </thead>
          <tbody>
            {timetable.map((entry, index) => (
              <tr key={index}>
                <td>{entry.subject}</td>
                <td>{entry.time}</td>
                <td>
                  <input 
                    type="radio" 
                    name={`attendance-${index}`} 
                    value="Present" 
                    onChange={() => handleAttendanceChange(index, 'Present')}
                  />
                </td>
                <td>
                  <input 
                    type="radio" 
                    name={`attendance-${index}`} 
                    value="Absent" 
                    onChange={() => handleAttendanceChange(index, 'Absent')}
                  />
                </td>
                <td>
                  <input 
                    type="radio" 
                    name={`attendance-${index}`} 
                    value="No Class" 
                    onChange={() => handleAttendanceChange(index, 'No Class')}
                  />
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No classes available for the selected day.</p>
      )}
      <button className="save" onClick={handleSave}>SAVE</button>
    </>
  );
}

export default Mark;
