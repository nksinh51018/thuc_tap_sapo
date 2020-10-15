import React, { Component } from 'react'

class Product extends Component {

    render() {
        let { product } = this.props;
        return (
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
                                alt="shopping-cart"
                            />
                        </div>
                    </div>
                    <div>
                        <img className="nav-link image" src={product.url} alt={product.name} />
                    </div>
                    <div className="des">
                        <div>
                            {product.name}
                        </div>
                        <div className="price">
                            {this.formatMoney(product.price)} vnđ
                    </div>
                    {product.pro}
                    </div>
                </div>
            </div>
        )
    }

    formatMoney = (price) => {
        let a = price.toString();
        let result = "";
        let n = a.length;
        for (let i = 0; i < n; i++) {
            if ((n - i) % 3 === 0 && i !== 0) {
                result += "." + a[i];
            }
            else {
                result += a[i];
            }
        }
        return result;
    }

}

export default Product;