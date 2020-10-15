
import React, { createContext, useReducer } from 'react';
import user from '../reducers/User'
export const UserContext = createContext();

const UserContextProvider = ({ children }) => {

    const [users, dispatch] = useReducer(user, {}, () => {
        let localData = localStorage.getItem('USER');
        return localData ? JSON.parse(localData) : {}
    })

    // useEffect(() => {
    //     localStorage.setItem('USER', JSON.stringify(users))
    // }, [users]);

    return (
        <UserContext.Provider value={{users, dispatch}}>
            {children}
        </UserContext.Provider>
    );
}

export default UserContextProvider;