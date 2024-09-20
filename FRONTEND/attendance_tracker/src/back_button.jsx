import { useNavigate } from 'react-router-dom';

function Backbut() {
  const navigate = useNavigate();
  
  const handleClick = () => {
    navigate('/'); 
  };
  
  return (
    <button className="backbut" onClick={handleClick}>
      BACK
    </button>
  );
}

export default Backbut;
