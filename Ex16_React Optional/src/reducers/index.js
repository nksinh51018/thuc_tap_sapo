import {combineReducers} from 'redux'
import products from './Products'
import productHeaderRight from './ProductHeaderRight'
import user from './User'
import categoryList from './CategoryList'
import categoryItem from './CategoryItem'
const appReducer = combineReducers({
    products,
    productHeaderRight,
    user,
    categoryList,
    categoryItem,
})

export default appReducer;