import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';

const AboutUs = () => {
    return (
        <div>
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
            </>
            <h1>About Us</h1>
            <p>We are a company that does something really cool.</p>
        </div>
    );
};

export default AboutUs;
