import React from 'react'
import { NavLink } from 'react-router-dom';
import "./css/Breadcrumb.css"

const Breadcrumb = () => {
    return (
        <div className="breadcrumb-1">
            <NavLink to="/">Trang chủ</NavLink>
            <span>{'>'}</span>
            <NavLink className="active" to="/signIn">Đăng nhập</NavLink>
        </div>
    );
}


export default Breadcrumb;