import React, { useEffect,useContext } from 'react'
import CategoryList from '../components/CategoryList/CategoryList'
import { connect } from 'react-redux'
import { actGetAllCategoryRequest, actCountCategoriesRequest, actDeleteCategoryRequest } from '../actions/index'
import history from '../history'
import {UserContext} from '../contexts/UserContext'
const CategoryListContainer = (props) => {

    let { users } = useContext(UserContext);
    let { categoryList, match } = props;
    useEffect(() => {
        if (users.username === '' || users.username === null || typeof users.username === 'undefined') {
            history.push('/signIn')
        }
        let { categoryList } = props;
        if (categoryList.categories.length < 1) {
            props.onGetAllCategory(1)
        }
        if (categoryList.total === 0) {
            props.onCountCategories();
        }
    }, [users,props]);

    const changePage = (pageNumber) => {
        props.onGetAllCategory(pageNumber)
    }

    return (
        <CategoryList categoryList={categoryList}
            match={match} user={users}
            changePage={(pageNumber) => { changePage(pageNumber) }}
            onDeleteCategory={props.onDeleteCategory}
        />
    );
}

const mapStateToProps = (state) => {
    return {
        categoryList: state.categoryList,
    }
}

const mapDispatchToProps = (dispatch, action) => {
    return {
        onGetAllCategory: (pageNumber) => {
            dispatch(actGetAllCategoryRequest(pageNumber))
        },
        onCountCategories: () => {
            dispatch(actCountCategoriesRequest())
        },
        onDeleteCategory: (id) => {
            dispatch(actDeleteCategoryRequest(id))
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(CategoryListContainer)