import React, { Component } from 'react'
import "./css/BodyWrap.css"
import ProductsListContainer from '../../containers/ProductsListContainer';

class BodyWrap extends Component {
    render() {
        return (
            <div className="body-wrap">
                <div className="row mt-3 slide-show">
                    <div className="col-lg-9 col-md-9 col-sm-9 slide">
                        <img className="image" src="./image/slide.jpg" alt="slide 1" />
                    </div>
                    <div className="col-lg-3 col-md-3 col-sm-3 item-card">
                        <div className="mt-2">
                            <div className="d-flex justify-content-between">
                                <div>
                                    <i className="fa fa-external-link" aria-hidden="true"></i>
                                </div>
                                <div>
                                    <img
                                        className="nav-link cart-shopping"
                                        src="/image/cart-shopping-color.png"
                                        alt="cart-shopping"
                                    />
                                </div>
                            </div>
                            <div>
                                <img className="nav-link image" src="./image/Products/12.jpg" alt="12" />
                            </div>
                            <div className="des">
                                <div>
                                    BLACK CREPE FLORAL PRINT
                </div>
                                <div className="price">
                                    350.000 vnđ
                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="topnav">
                    <div className="active">Nổi bật</div>
                    <div>Bán chạy</div>
                    <div>Mới nhất</div>
                    <span className="menu-right">
                        <div>
                            <i className="fa fa-arrow-left arrow-gray" aria-hidden="true"></i>
                        </div>
                        <div>
                            <i className="fa fa-arrow-right arrow-active" aria-hidden="true"></i>
                        </div>
                    </span>
                </div>
                <ProductsListContainer />
                <div className="row menu2">
                    <div className="col-lg-3 col-md-3 col-sm-3">
                        <div className="menu2-left">
                            Tất cả sản phẩm
            </div>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-9">
                        <ul className="nav menu2-right">
                            <li className="nav-item active">
                                <a className="nav-link" href="#">Mây tre đan</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Mây lá tre</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Sản phẩm mây tre lá</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Mỹ nghệ</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">
                                    <div>
                                        <i
                                            className="fa fa-arrow-left arrow-gray"
                                            aria-hidden="true"
                                        ></i>
                                    </div>
                                </a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">
                                    <div>
                                        <i
                                            className="fa fa-arrow-right arrow-active"
                                            aria-hidden="true"
                                        ></i>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div className="row section-2">
                    <div className="col-lg-4 col-md-4 col-sm-4 slide-left">
                        <img src="./image/slide2.png" />
                    </div>
                    <div className="col-lg-8 col-md-8 col-sm-8">
                        <div className="row content-left">
                            <div className="col-lg-3 col-md-3 col-sm-3 item-card">
                                <div className="mt-2">
                                    <div className="d-flex justify-content-between">
                                        <div>
                                            <i className="fa fa-external-link" aria-hidden="true"></i>
                                        </div>
                                        <div>
                                            <img
                                                className="nav-link cart-shopping"
                                                src="./image/cart-shopping.png"
                                            />
                                        </div>
                                    </div>
                                    <div>
                                        <img className="nav-link image" src="./image/Products/11.jpg" />
                                    </div>
                                    <div className="des">
                                        <div>
                                            BLACK CREPE FLORAL PRINT
                    </div>
                                        <div className="price">
                                            350.000 vnđ
                    </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-3 col-md-3 col-sm-3 item-card">
                                <div className="mt-2">
                                    <div className="d-flex justify-content-between">
                                        <div>
                                            <i className="fa fa-external-link" aria-hidden="true"></i>
                                        </div>
                                        <div>
                                            <img
                                                className="nav-link cart-shopping"
                                                src="./image/cart-shopping.png"
                                            />
                                        </div>
                                    </div>
                                    <div>
                                        <img className="nav-link image" src="./image/Products/12.jpg" />
                                    </div>
                                    <div className="des">
                                        <div>
                                            BLACK CREPE FLORAL PRINT
                    </div>
                                        <div className="price">
                                            350.000 vnđ
                    </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-3 col-md-3 col-sm-3 item-card">
                                <div className="mt-2">
                                    <div className="d-flex justify-content-between">
                                        <div>
                                            <i className="fa fa-external-link" aria-hidden="true"></i>
                                        </div>
                                        <div>
                                            <img
                                                className="nav-link cart-shopping"
                                                src="./image/cart-shopping.png"
                                            />
                                        </div>
                                    </div>
                                    <div>
                                        <img className="nav-link image" src="./image/Products/13.jpg" />
                                    </div>
                                    <div className="des">
                                        <div>
                                            BLACK CREPE FLORAL PRINT
                    </div>
                                        <div className="price">
                                            350.000 vnđ
                    </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-3 col-md-3 col-sm-3 item-card">
                                <div className="mt-2">
                                    <div className="d-flex justify-content-between">
                                        <div>
                                            <i className="fa fa-external-link" aria-hidden="true"></i>
                                        </div>
                                        <div>
                                            <img
                                                className="nav-link cart-shopping"
                                                src="./image/cart-shopping.png"
                                            />
                                        </div>
                                    </div>
                                    <div>
                                        <img className="nav-link image" src="./image/Products/14.jpg" />
                                    </div>
                                    <div className="des">
                                        <div>
                                            BLACK CREPE FLORAL PRINT
                    </div>
                                        <div className="price">
                                            350.000 vnđ
                    </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="row section-2">
                    <div className="col-lg-8 col-md-8 col-sm-8">
                        <div className="row">
                            <div className="col-lg-3 col-md-3 col-sm-3 item-card">
                                <div className="mt-2">
                                    <div className="d-flex justify-content-between">
                                        <div>
                                            <i className="fa fa-external-link" aria-hidden="true"></i>
                                        </div>
                                        <div>
                                            <img
                                                className="nav-link cart-shopping"
                                                src="./image/cart-shopping.png"
                                            />
                                        </div>
                                    </div>
                                    <div>
                                        <img className="nav-link image" src="./image/Products/15.jpg" />
                                    </div>
                                    <div className="des">
                                        <div>
                                            BLACK CREPE FLORAL PRINT
                    </div>
                                        <div className="price">
                                            350.000 vnđ
                    </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-3 col-md-3 col-sm-3 item-card">
                                <div className="mt-2">
                                    <div className="d-flex justify-content-between">
                                        <div>
                                            <i className="fa fa-external-link" aria-hidden="true"></i>
                                        </div>
                                        <div>
                                            <img
                                                className="nav-link cart-shopping"
                                                src="./image/cart-shopping.png"
                                            />
                                        </div>
                                    </div>
                                    <div>
                                        <img className="nav-link image" src="./image/Products/16.jpg" />
                                    </div>
                                    <div className="des">
                                        <div>
                                            BLACK CREPE FLORAL PRINT
                    </div>
                                        <div className="price">
                                            350.000 vnđ
                    </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-3 col-md-3 col-sm-3 item-card">
                                <div className="mt-2">
                                    <div className="d-flex justify-content-between">
                                        <div>
                                            <i className="fa fa-external-link" aria-hidden="true"></i>
                                        </div>
                                        <div>
                                            <img
                                                className="nav-link cart-shopping"
                                                src="./image/cart-shopping.png"
                                            />
                                        </div>
                                    </div>
                                    <div>
                                        <img className="nav-link image" src="./image/Products/17.jpg" />
                                    </div>
                                    <div className="des">
                                        <div>
                                            BLACK CREPE FLORAL PRINT
                    </div>
                                        <div className="price">
                                            350.000 vnđ
                    </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-3 col-md-3 col-sm-3 item-card">
                                <div className="mt-2">
                                    <div className="d-flex justify-content-between">
                                        <div>
                                            <i className="fa fa-external-link" aria-hidden="true"></i>
                                        </div>
                                        <div>
                                            <img
                                                className="nav-link cart-shopping"
                                                src="./image/cart-shopping.png"
                                            />
                                        </div>
                                    </div>
                                    <div>
                                        <img className="nav-link image" src="./image/Products/3.jpg" />
                                    </div>
                                    <div className="des">
                                        <div>
                                            BLACK CREPE FLORAL PRINT
                    </div>
                                        <div className="price">
                                            350.000 vnđ
                    </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-4 col-md-4 col-sm-4 slide-right">
                        <img src="./image/banner2.png" alt="banner2" />
                    </div>
                </div>
                <div className="row menu2">
                    <div className="col-lg-3 col-md-3 col-sm-3">
                        <div className="menu2-left">
                            Tin tức
            </div>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-9">
                        <ul className="nav menu2-right">
                            <li className="nav-item">
                                <a className="nav-link" href="#">
                                    <div>
                                        <i
                                            className="fa fa-arrow-left arrow-gray"
                                            aria-hidden="true"
                                        ></i>
                                    </div>
                                </a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">
                                    <div>
                                        <i
                                            className="fa fa-arrow-right arrow-active"
                                            aria-hidden="true"
                                        ></i>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div className="row section-3">
                    <div className="col-lg-6 col-md-6 col-sm-6">
                        <div className="row">
                            <div className="col-lg-6 col-md-6 col-sm-6 image-left">
                                <img src="./image/tintuc1.png" className="image" />
                            </div>
                            <div className="col-lg-6 col-md-6 col-sm-6 content align-items-end">
                                <div className="justify-content-between item-content-1 w-100">
                                    <div>22/06/2015</div>
                                    <div>By Admin</div>
                                    <div>0 Comment</div>
                                </div>
                                <div className="item-content-2 w-100">
                                    <div>
                                        Đông trùng hạ thảo – món quà biếu đẳng cấp của bạn
                  </div>
                                </div>
                                <div className="item-content w-100">
                                    <div>
                                        Đông trùng hạ thảo từ lâu đã được xem là thảo dược quý trong
                                        Đông y...
                  </div>
                                </div>
                                <div className="item-content w-100">
                                    <u>Đọc thêm</u>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-lg-6 col-md-6 col-sm-6">
                        <div className="row">
                            <div className="col-lg-6 col-md-6 col-sm-6 image-left">
                                <img src="./image/tintuc2.png" className="image" />
                            </div>
                            <div className="col-lg-6 col-md-6 col-sm-6 content">
                                <div className="item-content-1 w-100">
                                    <div>22/06/2015</div>
                                    <div>By Admin</div>
                                    <div>0 Comment</div>
                                </div>
                                <div className="item-content-2 w-100">
                                    <div>
                                        Đông trùng hạ thảo – món quà biếu đẳng cấp của bạn
                  </div>
                                </div>
                                <div className="item-content w-100">
                                    <div>
                                        Đông trùng hạ thảo từ lâu đã được xem là thảo dược quý trong
                                        Đông y...
                  </div>
                                </div>
                                <div className="item-content w-100">
                                    <u>Đọc thêm</u>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="row section-4"></div>
                <div className="row section-5">
                    <img src="./image/text1.png" />
                    <div className="text1">
                        Đông trùng hạ thảo từ lâu đã được xem là thảo dược quý trong Đông y.
                        Đây là loại thảo dược có công dụng “thần kỳ” với sức khỏe con người.
          </div>
                    <img src="./image/bg.png" className="mt-3" />
                </div>
                <div className="row section-6">
                    <span className="text1">Vasily Nganu</span>
                    <u className="text2">https://www.bizweb.vn </u>
                    <div className="text3">
                        <span><i className="fa fa-circle" aria-hidden="true"></i></span>
                        <span><i className="far fa-circle" aria-hidden="true"></i></span>
                        <span><i className="far fa-circle" aria-hidden="true"></i></span>
                    </div>
                    <img src="./image/Untitled-1.png" className="image end" />
                </div>
            </div>

        )
    }
}

export default BodyWrap;