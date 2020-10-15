import React, { Component } from 'react'
import "./css/Header.css"
import { NavLink } from 'react-router-dom';

class Header extends Component {

    constructor(props) {
        super(props);
        let width = window.innerWidth;
        if (width < 425) {
            this.state = {
                menu: false,
            }
        }
        else {
            this.state = {
                menu: true,
            }
        }

    }

    toggleMenuMobile = () => {
        this.setState({
            menu: !this.state.menu
        })
    }

    updateDimensions = () => {
        let width = window.innerWidth;
        if (width < 425) {
            this.setState({
                menu: false,
            })
        }
        else {
            this.setState({
                menu: true,
            })
        }
    };
    componentDidMount() {
        window.addEventListener('resize', this.updateDimensions);
    }
    componentWillUnmount() {
        window.removeEventListener('resize', this.updateDimensions);
    }

    render() {
        return (
            <div className="header">
                <div className="row h-100 justify-content-center align-items-center">
                    <div className="nav-button"
                        id="menu"
                        onClick={() => {
                            this.toggleMenuMobile()
                        }}>
                        <i className="fas fa-stream"></i>
                    </div>
                    <div className="col-lg-2 col-md-2 col-sm-12 logo">
                        <img src="./image/logo.png" alt="logo" />
                    </div>
                    <div className="col-lg-7 col-md-7 col-sm-12 h-100">
                        <ul
                            className={`nav justify-content-center align-items-center text-center h-100 menu-mobile ${this.state.menu ? "" : "hide"}`}
                        >
                            <li className="nav-item">
                                <NavLink className="nav-link active" to="/">Trang chủ</NavLink>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/introduction">Giới thiệu</a>
                            </li>
                            <li className="nav-item">
                                <NavLink className="nav-link" to="/categories">Sản phẩm</NavLink>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/services">Dịch vụ</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/news">Tin tức</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/contact">Liên hệ</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/maps">Bản đồ</a>
                            </li>
                        </ul>
                    </div>
                    <div className="col-lg-3 col-md-3 col-sm-3">
                        <ul
                            className="nav justify-content-center align-items-center text-center h-100"
                        >
                            <li className="nav-item">
                                <i className="fa fa-search nav-link" aria-hidden="true"></i>
                            </li>
                            <li className="nav-item">
                                <img
                                    className="nav-link cart-shopping"
                                    src="./image/cart-shopping.png"
                                    alt="cart shooping"
                                />
                            </li>
                            <li className="nav-item">
                                <div className="nav-link">0 sản phẩm</div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        )
    }

}

export default Header;