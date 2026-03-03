import { useEffect, useState} from 'react'

import './App.css'


function App() {
  const [VALUE, setVALUE]= useState([]);

  
   useEffect(() => {
    const fetchData = async() => { 
            const res=await fetch('http://localhost:3000');
            const data=await res.json();
            console.log(data);
    }
    fetchData(); // Call the fetchData function here
   }, []);
  return (
    <>
    </>
  )
}

export default App
