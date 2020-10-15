import React, { Component } from 'react'
import ProductList from '../components/ProductList/ProductList';
import { connect } from 'react-redux';

class ProductListContainer extends Component {
    render(){
        return(
            <ProductList>
                {this.props.products}
            </ProductList>
        )
    }
}

const mapStateToProps = (state)=>{
    return{
        products: state.products
    }
}

export default connect(mapStateToProps,null)(ProductListContainer);