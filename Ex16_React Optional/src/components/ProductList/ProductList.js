import React, { Component } from 'react'
import ProductItem from '../ProductItem/ProductItem'
class ProductList extends Component {
    render() {
        return (
            <>
                <div className="row row-body">
                    {this.showProductItem(this.props.children)}
                </div>

            </>
        )
    }

    showProductItem = (products) => {
        let result = "";
        if (products.length > 0) {
            result = products.map((product, index) => {
                return <ProductItem product={product}
                    key={index}
                />
            })
        }
        return result;
    }
}


export default ProductList;