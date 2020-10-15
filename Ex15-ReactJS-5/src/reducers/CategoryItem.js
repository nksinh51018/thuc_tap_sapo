import * as ActionTypes from '../constains/ActionType'
var initState = {

}

const categoryItem = (state = initState,action)=>{
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