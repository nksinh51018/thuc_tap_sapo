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
        <TopBar onLogout={onLogout}>
            {users}
        </TopBar>
    );
}

// class TopBarContainer extends Component {
//     render(){
//         return(
//             <TopBar onLogout= {this.props.onLogout}>
//                 {this.props.user}
//             </TopBar>
//         )
//     }
// }

// const mapStateToProps = (state) => {
//     return {
//         user: state.user
//     }
// }

// const mapDispatchToProps = (dispatch, action) => {
//     return {
//         onLogout: () => {
//             dispatch(actLogout())
//         }
//     }
// }

// export default connect(mapStateToProps, mapDispatchToProps)(TopBarContainer);
export default TopBarContainer;