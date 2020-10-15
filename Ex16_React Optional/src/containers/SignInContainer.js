import React, { useContext, useEffect } from 'react'
import SignIn from '../components/SignIn/SignIn'
import { actSignInRequest } from '../actions/index'
import history from '../history'
import { UserContext } from '../contexts/UserContext';

const SignInContainer = (props) => {

    let { users, dispatch } = useContext(UserContext);

    useEffect(() => {
        if (users.username !== '' && users.username !== null && typeof users.username !== 'undefined') {
            history.push('/categories')
        }
    }, [users]);

    const onSignIn = (username, password) => {
        actSignInRequest(username, password)(dispatch);
        
    }

    return (
        <SignIn onSignIn={onSignIn} />
    );
}

export default SignInContainer;

// class SignInContainer extends Component {

//     constructor(props){
//         super(props);
//         this.state = {}
//     }

//     static getDerivedStateFromProps(props, state) {
//         if (props.user.username !== '' && props.user.username !== null && typeof props.user.username !== 'undefined') {
//             history.push('/categories')
//         }
//         return state
//     }

//     render() {
//         return (
//             <>
//                 <SignIn onSignIn={this.props.onSignIn} />
//             </>
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
//         onSignIn: (username, password) => {
//             dispatch(actSignInRequest(username, password))
//         }
//     }
// }

// export default connect(mapStateToProps, mapDispatchToProps)(SignInContainer);