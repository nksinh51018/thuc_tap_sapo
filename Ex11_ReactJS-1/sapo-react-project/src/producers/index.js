import {combineReducers} from 'redux'
import products from './Products'
import productHeaderRight from './ProductHeaderRight'
import user from './User'
const appReducer = combineReducers({
    products,
    productHeaderRight,
    user,
})

export default appReducer;