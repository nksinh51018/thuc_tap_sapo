import React from 'react'
import ProductList from '../components/ProductList/ProductList';
import { connect } from 'react-redux';
import Product from '../model/Product';

type Props = {
    products: Product[],
} 


const ProductListContainer = (props:Props) => {
    return (
        <ProductList products={props.products} />

    );
}

const mapStateToProps = (state: { products: any; }) => {
    return {
        products: state.products
    }
}

export default connect(mapStateToProps, null)(ProductListContainer);