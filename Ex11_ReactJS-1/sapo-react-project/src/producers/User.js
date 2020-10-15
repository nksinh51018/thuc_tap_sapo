import * as ActionType from '../constains/ActionType'
import { toast } from 'react-toastify';
var initState = {
    username: null
}

const user = (state = initState, action) => {
    switch (action.type) {
        case ActionType.SIGNIN:{
            let {username,password} = action;
            console.log(username)
            if(username === 'admin' && password === 'admin'){
                state.username = username;
            }
            else{
                notifyMessage("Đăng nhập thất bại")
            }
            return {...state}
        }
        case ActionType.LOGOUT:{
            state.username = null;
            return {...state}
        }
        default:
            return { ...state }
    }
}

const notifyMessage = (message) => {
    toast.error(message, {
        position: "top-center",
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
    });
}

export default user;