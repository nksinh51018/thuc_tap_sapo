import * as ActionType from "../constains/ActionType"
import callAPI from '../ulti/APICaller'

export const actSignIn = (username,password) =>{
    return {
        type: ActionType.SIGNIN,
        username,
        password,
    }
}

export const actLogout = () =>{
    return {
        type: ActionType.LOGOUT,
    }
}

export const actGetAllCategory = (pageNumber,categories)=>{
    return {
        type: ActionType.GEt_ALL_CATEGORY,
        categories,
        pageNumber
    }
}

export const actGetAllCategoryRequest = (pageNumber)=>{
    return (dispatch)=>{
        callAPI(`admin/categories?pageNumber=${pageNumber}`,'GET',null).then(res =>{
            dispatch(actGetAllCategory(pageNumber,res.data))
        })
    }
}

export const actCountCategories = (total)=>{
    return {
        type: ActionType.COUNT_ALL_CATEGORY,
        total,
    }
}

export const actCountCategoriesRequest = ()=>{
    return (dispatch)=>{
        callAPI(`admin/categories/total`,'GET',null).then(res =>{
            dispatch(actCountCategories(res.data))
        })
    }
}