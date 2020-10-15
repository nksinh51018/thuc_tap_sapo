import React, { Component } from 'react'
import CategoryList from '../components/CategoryList/CategoryList'
import { connect } from 'react-redux'
import { actGetAllCategoryRequest, actCountCategoriesRequest } from '../actions/index'
import history from '../history'
class CategoryListContainer extends Component {

    componentDidMount() {
        let { categoryList } = this.props;
        if (categoryList.categories.length < 1) {
            this.props.onGetAllCategory(1)
        }
        if(categoryList.total === 0 ){
            this.props.onCountCategories();
        }
    }

    changePage = (pageNumber) => {
        this.props.onGetAllCategory(pageNumber)
    }

    render() {
        let { categoryList, match, user } = this.props;
        if (this.props.user.username === '' || this.props.user.username === null) {
            history.push('/signIn')
        }
        return (
            <CategoryList categoryList={categoryList}
                match={match} user={user}
                changePage={(pageNumber) => { this.changePage(pageNumber) }} />
        )
    }
}

const mapStateToProps = (state) => {
    return {
        categoryList: state.categoryList,
        user: state.user,
    }
}

const mapDispatchToProps = (dispatch, action) => {
    return {
        onGetAllCategory: (pageNumber) => {
            dispatch(actGetAllCategoryRequest(pageNumber))
        },
        onCountCategories: ()=>{
            dispatch(actCountCategoriesRequest())
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(CategoryListContainer)