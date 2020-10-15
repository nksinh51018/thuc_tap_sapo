import * as ActionType from '../constains/ActionType'
import toastMessage from '../ulti/ToastMessage'
let localData = localStorage.getItem("USER");
let user1 = JSON.parse(localData? localData : '');
var initState = user1 ? {
    token: user1.token,
    username: user1.username
} : {
    token: "",
    username: ""
}

const user = (state = initState, action: { type?: string; token?: string; username?: string; }) => {
    switch (action.type) {
        case ActionType.SIGNIN_SUCCESS:{
            let {token,username} = action;
            state.token = token;
            state.username = username
            localStorage.setItem("USER",JSON.stringify(state));
            return {...state}
        }
        case ActionType.SIGNIN_FAILURE:{
            toastMessage('Đăng nhập thất bại')
            return {...state}
        }
        case ActionType.LOGOUT:{
            state.username = null;
            localStorage.removeItem("USER")
            return {...state}
        }
        default:
            return { ...state }
    }
}


export default user;