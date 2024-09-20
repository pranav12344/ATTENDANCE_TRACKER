export const fetchTimetable = async (day) => {
    try {
      const response = await fetch(`http://localhost:8080/api/attendance/timetable/${day}`);
      const data = await response.json();
      return data;
    } catch (error) {
      console.error('Error fetching timetable:', error);
      return [];
    }
  };
  
  export const saveTimetable = async (day, timetable) => {
    try {
      const response = await fetch(`http://localhost:8080/api/attendance/timetable/${day}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(timetable),
      });
  
      if (!response.ok) {
        throw new Error('Failed to save timetable');
      }
    } catch (error) {
      console.error('Error saving timetable:', error);
    }
  };
  