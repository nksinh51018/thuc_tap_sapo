import React, { useEffect,useContext } from 'react'
import CategoryList from '../components/CategoryList/CategoryList'
import { connect } from 'react-redux'
import { actGetAllCategoryRequest, actCountCategoriesRequest, actDeleteCategoryRequest } from '../actions/index'
import history from '../history'
import {UserContext} from '../contexts/UserContext'
import Category from '../model/Category'

type Props = {
    categoryList: {
        categories: Category[],
        pageNumber: number,
        total:number
    },
    match: any,
    onGetAllCategory: (pageNumber: number) => void,
    onCountCategories: ()=> void,
    onDeleteCategory: (id:number)=> void
}
const CategoryListContainer = (props:Props) => {

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

    const changePage = (pageNumber:number) => {
        props.onGetAllCategory(pageNumber)
    }

    return (
        <CategoryList categoryList={categoryList}
            match={match}
            changePage={(pageNumber) => { changePage(pageNumber) }}
            onDeleteCategory={props.onDeleteCategory}
        />
    );
}

const mapStateToProps = (state: { categoryList: any }) => {
    return {
        categoryList: state.categoryList,
    }
}

const mapDispatchToProps = (dispatch:any) => {
    return {
        onGetAllCategory: (pageNumber: number) => {
            dispatch(actGetAllCategoryRequest(pageNumber))
        },
        onCountCategories: () => {
            dispatch(actCountCategoriesRequest())
        },
        onDeleteCategory: (id:number) => {
            dispatch(actDeleteCategoryRequest(id))
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(CategoryListContainer)