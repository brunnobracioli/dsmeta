import React from 'react'
import './styles.css'

import { LogoImage  } from '../logoImage'

function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <LogoImage/>
                <h1>DSMeta</h1>

            </div>

        </header>
    )
}

export default Header