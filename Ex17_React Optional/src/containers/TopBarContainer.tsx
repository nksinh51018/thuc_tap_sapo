import React, { useContext } from 'react'
import TopBar from '../components/TopBar/TopBar';
import { actLogout } from '../actions/index'
import { UserContext } from '../contexts/UserContext';


const TopBarContainer = () => {

    let { users, dispatch} = useContext(UserContext);

    const onLogout = () => {
        dispatch(actLogout())
    }

    return (
        <TopBar onLogout={onLogout} users={users} />
    );
}
export default TopBarContainer;