import {combineReducers} from 'redux'
import products from './Products'
import user from './User'
import categoryList from './CategoryList'
import categoryItem from './CategoryItem'
const appReducer = combineReducers({
    products,
    user,
    categoryList,
    categoryItem,
})

export default appReducer;