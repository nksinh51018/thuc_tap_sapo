import * as ActionType from "../constains/ActionType"
import callAPI from '../ulti/APICaller'

export const actSignInSuccess = (token, username) => {
    return {
        type: ActionType.SIGNIN_SUCCESS,
        token,
        username
    }
}

export const actSignInFailure = () => {
    return {
        type: ActionType.SIGNIN_FAILURE
    }
}

export const actSignInRequest = (username, password) => {
    return (dispatch) => {
        callAPI("auth", 'POST', {
            "username": username,
            "password": password
        }).then(res => {
            dispatch(actSignInSuccess(res.headers.authorization.slice(6), username))
        })
            .catch(e => {
                console.log(e);
                dispatch(actSignInFailure())
            })
    }
}

export const actLogout = () => {
    return {
        type: ActionType.LOGOUT,
    }
}

export const actGetAllCategory = (pageNumber, categories) => {
    return {
        type: ActionType.GET_ALL_CATEGORY,
        categories,
        pageNumber
    }
}

export const actGetAllCategoryRequest = (pageNumber) => {
    return (dispatch) => {
        callAPI(`admin/categories?pageNumber=${pageNumber}`, 'GET', null).then(res => {
            dispatch(actGetAllCategory(pageNumber, res.data))
        })
    }
}

export const actCountCategories = (total) => {
    return {
        type: ActionType.COUNT_ALL_CATEGORY,
        total,
    }
}

export const actCountCategoriesRequest = () => {
    return (dispatch) => {
        callAPI(`admin/categories/total`, 'GET', null).then(res => {
            dispatch(actCountCategories(res.data))
        })
    }
}

export const actGetCategoryByIDRequest = (id) => {
    return (dispatch) => {
        callAPI(`admin/categories/${id}`, 'GET', null).then(res => {
            dispatch(actGetCategoryByID(res.data))
        })
    }
}

export const actGetCategoryByID = (category) => {
    return {
        type: ActionType.GET_CATEGORY_BY_ID,
        category,
    }
}

export const actUpdateCategorySuccess = (category) => {
    return {
        type: ActionType.UPDATE_CATEGORY_SUCCESS,
        category
    }
}

export const actUpdateCategoryFailure = () => {
    return {
        type: ActionType.UPDATE_CATEGORY_FAILURE
    }
}

export const actUpdateCategoryRequest = (category) => {
    return (dispatch) => {
        let user = JSON.parse(localStorage.getItem('USER'));
        if (user !== null) {
            callAPI(`admin/categories/${category.id}`, 'PUT', category, {
                'Authorization': "Bearer " + user.token,
            }).then(res => {
                dispatch(actUpdateCategorySuccess(res.data));
            })
                .catch(e => {
                    console.log(e)
                    dispatch(actUpdateCategoryFailure())
                })
        }
    }
}

export const actClearCategoryItem = () => {
    return {
        type: ActionType.CLEAR_CATEGORY_ITEM
    }
}

export const actAddCategoryRequest = (category) => {
    console.log(category)
    return (dispatch) => {
        let user = JSON.parse(localStorage.getItem('USER'));
        if (user !== null) {
            category['productDTOs'] = []
            callAPI(`admin/categories`, 'POST', category, {
                'Authorization': "Bearer " + user.token,
            }).then(res => {
                dispatch(actAddCategorySuccess(res.data));
            })
                .catch(e => {
                    console.log(e)
                    dispatch(actAddCategoryFailure())
                })
        }
    }
}

export const actAddCategorySuccess = (category) => {
    return {
        type: ActionType.ADD_CATEGORY_SUCCESS,
        category
    }
}

export const actAddCategoryFailure = () => {
    return {
        type: ActionType.ADD_CATEGORY_FAILURE
    }
}

export const actDeleteCategoryRequest = (id) => {
    return (dispatch) => {
        let user = JSON.parse(localStorage.getItem('USER'));
        if (user !== null) {
            callAPI(`admin/categories/${id}`, 'DELETE', null, {
                'Authorization': "Bearer " + user.token,
            }).then(res => {
                dispatch(actDeleteCategorySuccess(id));
            })
                .catch(e => {
                    console.log(e)
                    dispatch(actDeleteCategoryFailure())
                })
        }
    }
}

export const actDeleteCategorySuccess = (id) => {
    return {
        type: ActionType.DELETE_CATEGORY_SUCCESS,
        id
    }
}

export const actDeleteCategoryFailure = () => {
    return {
        type: ActionType.DELETE_CATEGORY_FAILURE
    }
}