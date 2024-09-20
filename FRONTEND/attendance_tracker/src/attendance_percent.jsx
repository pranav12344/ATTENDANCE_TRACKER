// function Perc() {
//     return (
//       <table>
//         <thead>
//           <tr>
//             <th>Subjects</th>
//             <th>Present days</th>
//             <th>Absent days</th>
//             <th>Percentage</th>
//           </tr>
//         </thead>
//         <tbody>
//           <tr>
//             <td>Math</td>
//             <td>30</td>
//             <td>5</td>
//             <td>85%</td>
//           </tr>
//           <tr>
//             <td>Science</td>
//             <td>28</td>
//             <td>7</td>
//             <td>80%</td>
//           </tr>
//           <tr>
//             <td>English</td>
//             <td>32</td>
//             <td>3</td>
//             <td>90%</td>
//           </tr>
//         </tbody>
//       </table>
//     );
//   }
  
//   export default Perc;
  

import React, { useState, useEffect } from 'react';

function Perc() {
    const [attendanceData, setAttendanceData] = useState([]);

    useEffect(() => {
        fetch("/attendance/percentage")
            .then(response => response.json())
            .then(data => setAttendanceData(data))
            .catch(error => console.error('Error fetching attendance data:', error));
    }, []);

    return (
        <table>
            <thead>
                <tr>
                    <th>Subjects</th>
                    <th>Present days</th>
                    <th>Absent days</th>
                    <th>Percentage</th>
                </tr>
            </thead>
            <tbody>
                {attendanceData.map((attendance, index) => (
                    <tr key={index}>
                        <td>{attendance.subject}</td>
                        <td>{attendance.presentDays}</td>
                        <td>{attendance.absentDays}</td>
                        <td>{attendance.percentage.toFixed(2)}%</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}

export default Perc;
