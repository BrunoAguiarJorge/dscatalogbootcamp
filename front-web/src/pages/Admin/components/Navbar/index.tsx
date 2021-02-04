import React from 'react';
import { NavLink } from 'react-router-dom';
import './styles.scss';

const NavBar = () => (
    <nav className="admin-nav-container">
        <ul>
            <li>
                <NavLink to="/admin/products" className="admin-nav-item">
                    Meus Pedidos
                </NavLink>
            </li>
            <li>
                <NavLink to="/admin/categories" className="admin-nav-item">
                    Minhas categorias
                </NavLink>
            </li>
            <li>
                <NavLink to="/admin/users"className="admin-nav-item" >
                    Meus usuários
                </NavLink>
            </li>
        </ul>
    </nav>
);

export default NavBar;