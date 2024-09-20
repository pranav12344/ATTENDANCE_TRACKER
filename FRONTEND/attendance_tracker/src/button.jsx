import { useNavigate } from 'react-router-dom';

function Button() {
  const navigate = useNavigate();

  const handleSetTimeTable = () => {
    navigate('/timetable');
  };
  const handleSetPercentage = () => {
    navigate('/attendance_percent');
  };
  const handleSetMark = () => {
    navigate('/marking_attend');th
  }

  return (
    <div className="button-container">
      <button className="button b1" onClick={handleSetTimeTable}>
        SET TIME-TABLE
      </button>
      <button className="button b1" onClick={handleSetPercentage}>
        View Percentage %
        </button>
      <button className="button b1" onClick={handleSetMark}>
        MARK ATTENDANCE
        </button>
    </div>
  );
}

export default Button;
