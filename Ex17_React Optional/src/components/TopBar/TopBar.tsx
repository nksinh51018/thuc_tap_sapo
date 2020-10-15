import React from 'react'
import './css/TopBar.css'
import { NavLink } from 'react-router-dom';
import history from '../../history'

type Props = {
    onLogout: ()=> void,
    users: {username:string},
}

const TopBar = (props:Props) => {

    const onLogout = ()=>{
        props.onLogout();
        history.replace("/signIn")
    }

    const renderUsername = (user:{username:string}) => {
        let result = {} ;
        if (user.username === "" || user.username === null || typeof user.username ==='undefined') {
            result = <>
                <NavLink to="/signUp" >Đăng kí</NavLink>
                <span> | </span>
                <NavLink to="/signIn" >Đăng nhập</NavLink>
            </>
        }
        else {
            result =
                <>
                    <span>{user.username}</span>
                    <span> | </span>
                    <span onClick={onLogout}>Đăng xuất</span>
                </>
        }
        return result;
    }


    let user = props.users;

    return ( 
        <div className="topbar">
                <div className="row">
                    <div className="col-lg-7 col-md-7 col-sm-6">
                        <i className="fa fa-phone-alt"></i>
                        <span>(08) 6680 9686 - (08) 3866 6276</span>
                    </div>
                    <div className="col-lg-5 col-md-5 col-sm-6 col-xs-12 float-lg-right">
                        <div className="topbar-right">
                            {renderUsername(user)}
                        </div>
                    </div>
                </div>
            </div>
     );
}


// class TopBar extends Component {

//     render() {
//         let user = this.props.children;

//         return (
//             <div className="topbar">
//                 <div className="row">
//                     <div className="col-lg-7 col-md-7 col-sm-6">
//                         <i className="fa fa-phone-alt"></i>
//                         <span>(08) 6680 9686 - (08) 3866 6276</span>
//                     </div>
//                     <div className="col-lg-5 col-md-5 col-sm-6 col-xs-12 float-lg-right">
//                         <div className="topbar-right">
//                             {this.renderUsername(user)}
//                         </div>
//                     </div>
//                 </div>
//             </div>
//         )
//     }

//     renderUsername = (user) => {
//         let result = "";
//         if (user.username === "" || user.username === null) {
//             result = <>
//                 <NavLink to="/signUp" >Đăng kí</NavLink>
//                 <span> | </span>
//                 <NavLink to="/signIn" >Đăng nhập</NavLink>
//             </>
//         }
//         else {
//             result =
//                 <>
//                     <span>{user.username}</span>
//                     <span> | </span>
//                     <span onClick={this.onLogout}>Đăng xuất</span>
//                 </>
//         }
//         return result;
//     }

//     onLogout = ()=>{
//         this.props.onLogout();
//         history.replace("/signIn")
//     }

// }

export default TopBar;