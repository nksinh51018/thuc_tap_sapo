import React, { Component } from 'react'
import { connect } from 'react-redux';
import SignIn from '../components/SignIn/SignIn'
import { actSignInRequest } from '../actions/index'
import history from '../history'
class SignInContainer extends Component {

    constructor(props) {
        super(props);
        this.state = {}
    }

    // componentWillReceiveProps(nextProps){
    //     if (nextProps.user.username !== '' && nextProps.user.username !== null) {
    //         history.push('/categories')
    //     }
    // }
    static getDerivedStateFromProps(props, state) {
        if (props.user.username !== '' && props.user.username !== null) {
            history.push('/categories')
        }
        return state
    }

    render() {
        return (
            <>
                <SignIn onSignIn={this.props.onSignIn} />
            </>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        user: state.user
    }
}

const mapDispatchToProps = (dispatch, action) => {
    return {
        onSignIn: (username, password) => {
            dispatch(actSignInRequest(username, password))
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(SignInContainer);