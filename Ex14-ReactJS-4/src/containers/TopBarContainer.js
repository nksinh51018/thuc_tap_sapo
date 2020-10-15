import React, { Component } from 'react'
import { connect } from 'react-redux';
import TopBar from '../components/TopBar/TopBar';
import {actLogout} from '../actions/index'

class TopBarContainer extends Component {
    render(){
        return(
            <TopBar onLogout= {this.props.onLogout}>
                {this.props.user}
            </TopBar>
        )
    }
}

const mapStateToProps = (state)=>{
    return{
        user: state.user
    }
}

const mapDispatchToProps = (dispatch,action) =>{
    return {
        onLogout: ()=>{
            dispatch(actLogout())
        }
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(TopBarContainer);