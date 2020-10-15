import * as ActionTypes from '../constains/ActionType'
import Category from '../model/Category';
var initState = {

}

const categoryItem = (state = initState,action: { type: string; category: Category; })=>{
    switch(action.type){
        case ActionTypes.GET_CATEGORY_BY_ID:{
            state = action.category;
            return {...state}
        }
        case ActionTypes.CLEAR_CATEGORY_ITEM:{
            state = {};
            return {...state}
        }
        default:{
            return {...state}
        }
    }
}


export default categoryItem