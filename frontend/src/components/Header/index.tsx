import React from 'react'
import logo from '../../assets/logo.svg'
import './styles.css'

function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src = {logo} alt= "" />
                <h1>DSMeta</h1>

            </div>

        </header>
    )
}

export default Header