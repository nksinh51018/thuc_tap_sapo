import React from 'react'
import Product from '../../model/Product';

type Props = {
    product: Product
}

const ProductItem = (props:Props) => {

    let { product } = props;

    const formatMoney = (price:string) => {
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
                        {formatMoney(product.price)} vnđ
                    </div>
                
                </div>
            </div>
        </div>

    );
}

export default ProductItem;