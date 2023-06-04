// 6

import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
function App() {
    const [count, setCount] = useState(0);
    const [isMorning, setMorning] = useState(true);
    return (
        <div className={`box ${isMorning ? 'dayLight' : ''}`}>
            <h1>Good {isMorning ? 'Morning' : 'Night'}</h1>
            <button onClick={() => setMorning(!isMorning)}>Update Day</button>
            <h1>Value of Counter is : {count}</h1>
            <button onClick={() => setCount(count + 1)}>Increase Counter</button>
            <button onClick={() => setCount(count - 1)}>Decrease Counter</button>
        </div>
    );
}
export default App;

// ------------------------------------------------------------------------------

// // 8
// import React, { useMemo, useState } from 'react';
// function sum(a, b) {
//     console.log('Calculating sum...');
//     return a + b;
// }
// function CalculateSum({ a, b }) {
//     const result = useMemo(() => {
//         return sum(a, b);
//     }, [a, b]);
//     return <div>{result}</div>;
// }
// function App() {
//     const [num1, setNum1] = useState(0);
//     const [num2, setNum2] = useState(0);
//     function handleNum1Change(event) {
//         setNum1(Number(event.target.value));
//     }
//     function handleNum2Change(event) {
//         setNum2(Number(event.target.value));
//     }
//     return (
//         <div>
//             <label>
//                 Number 1:
//                 <input type="number" value={num1} onChange={handleNum1Change} />
//             </label>
//             <label>
//                 Number 2:
//                 <input type="number" value={num2} onChange={handleNum2Change} />
//             </label>
//             <CalculateSum a={num1} b={num2} />
//         </div>
//     );
// }
// export default App;

// ------------------------------------------------------------------------------

// // 9
// import React from 'react';
// import { BrowserRouter, Routes, Route } from "react-router-dom";
// import './App.css';
// import Home from './components/home';
// import Contact from './components/ContactUs.js';
// import About from './components/AboutUs.js';
// function App() {
//     return (
//         <>
//             <BrowserRouter>
//                 <Routes>
//                     <Route path="/" element={<Home />} />
//                     <Route path="/contact" element={<Contact />} />
//                     <Route path="/about" element={<About />} />
//                 </Routes>
//             </BrowserRouter>
//         </>
//     );
// }
// export default App;

// ------------------------------------------------------------------------------

// // 10
// import React, { useEffect, useState } from 'react';
// import 'bootstrap/dist/css/bootstrap.min.css';
// const UserTableExample = () => {
//     const [users, setUsers] = useState([]);
//     useEffect(() => {
//         const fetchUsers = async () => {
//             try {
//                 const response = await fetch('https://jsonplaceholder.typicode.com/users');
//                 const userData = await response.json();
//                 setUsers(userData);
//             } catch (error) {
//                 console.log('Error fetching users:', error);
//             }
//         };
//         fetchUsers();
//     }, []);
//     return (
//         <div>
//             <h1>User List</h1>
//             <table class="table" style={{ border: '2px solid green', borderSpacing: '10px', backgroundColor: 'grey' }}>
//                 <thead>
//                     <tr>
//                         <th>Name</th>
//                         <th>Email</th>
//                         <th>Phone</th>
//                         <th>Website</th>
//                     </tr>
//                 </thead>
//                 <tbody>
//                     {users.map(user => (
//                         <tr key={user.id}>
//                             <td>{user.name}</td>
//                             <td>{user.email}</td>
//                             <td>{user.phone}</td>
//                             <td>{user.website}</td>
//                         </tr>
//                     ))}
//                 </tbody>
//             </table>
//         </div>
//     );
// };
// export default UserTableExample;