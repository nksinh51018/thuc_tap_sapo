import React from 'react'
import ProductItem from '../ProductItem/ProductItem'
import Product from '../../model/Product'

type Props = {
    products: Product[]
}

const ProductList = (props:Props) => {
    const showProductItem = (products:Product[]) => {
        let result: JSX.Element[] =[];
        if (products.length > 0) {
            result = products.map((product, index) => {
                return <ProductItem product={product}
                    key={index}
                />
            })
        }
        return result;
    }

    return (
        <>
            <div className="row row-body">
                {showProductItem(props.products)}
            </div>

        </>
    );
}

export default ProductList;