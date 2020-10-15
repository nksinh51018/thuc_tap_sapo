import * as ActionType from '../constains/ActionType'
import { toast } from 'react-toastify';
let user1 = localStorage.getItem("USER");
var initState = {
    username: user1
}

const user = (state = initState, action) => {
    switch (action.type) {
        case ActionType.SIGNIN:{
            let {username,password} = action;
            console.log(username)
            if(username === 'admin' && password === 'admin'){
                state.username = username;
                localStorage.setItem("USER",username)
            }
            else{
                notifyMessage("Đăng nhập thất bại")
            }
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