import React from 'react';
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';


const Home = () => {
	return (
		<>
			<nav className="navbar">
				<ul className="navbar-nav">
					<li className="nav-item">
						<Link to="/" className="nav-link">Home</Link>
					</li>
					<li className="nav-item">
						<Link to="/About" className="nav-link">About</Link>
					</li>
					<li className="nav-item">
						<Link to="/Contact" className="nav-link">Contact</Link>
					</li>
				</ul>
			</nav>
			<h1>Home</h1>
		</>
	);
};

export default Home;