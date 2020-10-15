import React, { Component } from 'react'
import { connect } from 'react-redux';
import SignIn from '../components/SignIn/SignIn'
import { actSignIn } from '../actions/index'
import history from '../history'
class SignInContainer extends Component {

    render() {
        if (this.props.user.username !== '' && this.props.user.username !== null) {
            history.push('/categories')
        }
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
            dispatch(actSignIn(username, password))
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(SignInContainer);