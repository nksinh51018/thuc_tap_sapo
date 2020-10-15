import * as ActionType from "../constains/ActionType"

export const actSignIn = (username,password) =>{
    return {
        type: ActionType.SIGNIN,
        username,
        password,
    }
}

export const actLogout = () =>{
    return {
        type: ActionType.LOGOUT,
    }
}