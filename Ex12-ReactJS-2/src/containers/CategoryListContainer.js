import React, { Component } from 'react'
import CategoryList from '../components/CategoryList/CategoryList'
import { connect } from 'react-redux'

class CategoryListContainer extends Component{
    render(){
        let {categoryList,match} = this.props;
        return(
            <CategoryList categoryList={categoryList} match={match} />
        )
    }
}

const mapStateToProps = (state)=>{
    return {
        categoryList: state.categoryList,
    }
}

export default connect(mapStateToProps,null)(CategoryListContainer)