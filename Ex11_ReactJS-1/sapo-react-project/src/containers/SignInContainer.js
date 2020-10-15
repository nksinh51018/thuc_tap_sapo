import React, { Component } from 'react'
import { connect } from 'react-redux';
import SignIn from '../components/SignIn/SignIn'
import { Redirect } from 'react-router';
import {actSignIn} from '../actions/index'
class SignInContainer extends Component {

    renderSignIn = (username) => {
        if (username === '' || username === null) {
            return <SignIn onSignIn = {this.props.onSignIn} />
        }
        else {
            return <Redirect to="/" />
        }
    }

    render() {
        let { username } = this.props.user;
        return (
            <>
                {this.renderSignIn(username)}
            </>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        user: state.user
    }
}

const mapDispatchToProps = (dispatch, action) =>{
    return {
        onSignIn: (username,password)=>{
            dispatch(actSignIn(username,password))
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(SignInContainer);