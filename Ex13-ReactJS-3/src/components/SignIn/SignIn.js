import React, { Component } from 'react'
import "./css/SignIn.css"
import Breadcrumb from '../Breadcrumb/Breadcrumb';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
class SignIn extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            sucess: false
        };
    }

    handleChange = (event) => {
        let name = event.target.name;
        let val = event.target.value;
        this.setState(pre => {
            return {
                [name]: val
            }
        });
    }

    onSubmit = () => {
        let { username, password } = this.state;
        let check = false;
        if (username === "") {
            this.notifyMessage("Vui lòng nhập tên đăng nhập");
            check = true;
        }
        if (password === "") {
            this.notifyMessage("Vui lòng nhập mật khẩu");
            check = true;
        }
        if (check === false) {
            this.props.onSignIn(username,password);
        }
    }

    notifyMessage = (message) => {
        toast.error(message, {
            position: "top-center",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
        });
    }

    render() {
        let { username, password } = this.state;
        return (

            <div>
                <ToastContainer />
                <Breadcrumb />
                <div className="body-wrap">
                    <div className="row">
                        <div className="title-header">
                            <h3>ĐĂNG NHẬP</h3>
                            <span
                            >Nếu bạn chưa có tài khoản, xin vui lòng chuyển qua trang
                </span>
                            <u>đăng kí</u>
                        </div>
                    </div>
                    <form>
                        <div className="row form-signup">
                            <div className="col-lg-12 col-md-12 col-12">
                                <div className="form-group">
                                    <label className="lable"> Tên đăng nhập: </label>
                                    <span className="require"> *</span>
                                    <input type="text"
                                        value={username}
                                        className="form-control"
                                        onChange={this.handleChange}
                                        name="username" />
                                </div>
                            </div>
                            <div className="col-lg-12 col-md-12 col-12">
                                <div className="form-group">
                                    <label className="lable"> Mật khẩu: </label>
                                    <span className="require"> *</span>
                                    <input type="password"
                                        value={password}
                                        className="form-control"
                                        onChange={this.handleChange}
                                        name="password"
                                    ></input>
                                </div>
                            </div>
                        </div>
                        <div className="row form-signup">
                            <button type="button" className="button-signup" onClick={this.onSubmit}>Đăng nhập</button>
                        </div>
                    </form>
                </div>
            </div>
        );
    }
}

export default SignIn;