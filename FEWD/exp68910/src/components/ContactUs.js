import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';

const ContactUs = () => {
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
            <h1>Contact Us</h1>
            <p>You can contact us at:</p>
            <ul>
                <li>Email: contact@ourcompany.com</li>
                <li>Phone: 123-456-7890</li>
            </ul>
        </div>
    );
};

export default ContactUs;
