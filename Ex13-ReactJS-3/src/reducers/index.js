import {combineReducers} from 'redux'
import products from './Products'
import productHeaderRight from './ProductHeaderRight'
import user from './User'
import categoryList from './CategoryList'
const appReducer = combineReducers({
    products,
    productHeaderRight,
    user,
    categoryList,
})

export default appReducer;