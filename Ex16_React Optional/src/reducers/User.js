import * as ActionType from '../constains/ActionType'
import toastMessage from '../ulti/ToastMessage'
let user1 = JSON.parse(localStorage.getItem("USER"));
var initState = user1 ? {
    token: user1.token,
    username: user1.username
} : {
    token: "",
    username: ""
}

const user = (state = initState, action) => {
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