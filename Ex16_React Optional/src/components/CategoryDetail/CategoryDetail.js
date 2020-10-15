import React, { useState, useEffect } from 'react'

import { toast } from 'react-toastify';
import history from '../../history'

const CategoryDetail = (props) => {

    const [state, setstate] = useState({
        id: '',
        txtCode: '',
        txtName: '',
        txtDescription: '',
        txtCreatedAt: '',
    });


    useEffect(() => {
        let category = props.category
        if (category.id !== state.id) {
            return setstate({
                id: category.id,
                txtCode: category.categoryCode,
                txtName: category.categoryName,
                txtDescription: category.categoryDescription,
                txtCreatedAt: category.createAt,
            })
        }
    }, [props,state.id]);

    const onHandleChange = (e) => {
        let target = e.target;
        let name = target.name;
        let val = target.value;
        setstate({
            ...state,
            [name]: val
        })
    }

    const notifyMessage = (message) => {
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

    const onSubmitButton = () => {
        let { txtCode, txtName, txtDescription, id } = state

        if (txtCode !== null || txtName !== null || txtDescription !== null) {
            let category = {
                id: id,
                categoryCode: txtCode,
                categoryName: txtName,
                categoryDescription: txtDescription
            }
            if (checkId(id)) {
                props.onUpdateCategory(category)

            }
            else {
                props.onAddCategory(category)
            }
        }
        else {
            notifyMessage('Vui lòng nhập đủ các trường thông tin')
        }
    }

    const onGoBack = () => {
        history.goBack();
    }

    const checkId = (id) => {
        if (typeof id === 'undefined' || id === '') {
            return false;
        }
        else {
            return true;
        }
    }

    let { category } = props;
    let { txtCode, txtName, txtDescription, txtCreatedAt, id } = state
    let check = checkId(id)
    return (
        <>
            <div className="margin-top-body">

            </div>
            <div className="body-wrap">
                <h1>{check ? `Chi tiết danh mục : ${category.categoryName}` : 'Thêm danh mục'}</h1>

                <div className="row form-signup">
                    <div className="col-lg-12 col-md-12 col-12">
                        <div className="form-group">
                            <label className="lable"> Code: </label>
                            <span className="require"> *</span>
                            <input type="text"
                                className="form-control"
                                value={typeof txtCode === 'undefined' ? "" : txtCode}
                                name="txtCode"
                                onChange={onHandleChange}
                            />
                        </div>
                    </div>
                    <div className="col-lg-12 col-md-12 col-12">
                        <div className="form-group">
                            <label className="lable"> Name : </label>
                            <span className="require"> *</span>
                            <input type="text"
                                className="form-control"
                                value={typeof txtName === 'undefined' ? "" : txtName}
                                name="txtName"
                                onChange={onHandleChange}
                            />
                        </div>
                    </div>
                    <div className="col-lg-12 col-md-12 col-12">
                        <div className="form-group">
                            <label className="lable"> Description : </label>
                            <span className="require"> *</span>
                            <input type="text"
                                className="form-control"
                                value={typeof txtDescription === 'undefined' ? "" : txtDescription}
                                name="txtDescription"
                                onChange={onHandleChange}
                            />
                        </div>
                    </div>
                    {check ? <div className="col-lg-12 col-md-12 col-12">
                        <div className="form-group">
                            <label className="lable"> Created At : </label>
                            <span className="require"> *</span>
                            <input type="date"
                                className="form-control"
                                value={typeof txtCreatedAt === 'undefined' ? "" : txtCreatedAt}
                                pattern="\d{4}-\d{2}-\d{2}"
                                name="txtCreatedAt"
                                readOnly={true} />
                        </div>
                    </div> : ""}

                    <div className="col-lg-12 col-md-12 col-12">
                        <button className="btn mr-2" onClick={onGoBack} style={{ backgroundColor: "#cea37f", color: 'white' }}>Quay lại</button>
                        <button className="btn " onClick={onSubmitButton} style={{ backgroundColor: "#cea37f", color: 'white' }}>{check ? 'Lưu danh mục' : 'Thêm danh mục'}</button>
                    </div>

                </div>

                <div className="row section-6">
                    <img src="./image/Untitled-1.png" className="image end" alt='' />
                </div>
            </div>
        </>

    );
}


// class CategoryDetail extends Component {

//     constructor(props) {
//         super(props);
//         this.state = {
//             id: '',
//             txtCode: '',
//             txtName: '',
//             txtDescription: '',
//             txtCreatedAt: '',
//         }
//     }

//     static getDerivedStateFromProps(props, state) {
//         let category = props.category
//         if (category.id !== state.id) {
//             return {
//                 id: category.id,
//                 txtCode: category.categoryCode,
//                 txtName: category.categoryName,
//                 txtDescription: category.categoryDescription,
//                 txtCreatedAt: category.createAt,
//             }
//         }
//         return state
//     }

//     onHandleChange = (e) => {
//         let target = e.target;
//         let name = target.name;
//         let val = target.value;
//         this.setState({
//             ...this.state,
//             [name]: val
//         })
//     }

//     notifyMessage = (message) => {
//         toast.error(message, {
//             position: "top-center",
//             autoClose: 5000,
//             hideProgressBar: false,
//             closeOnClick: true,
//             pauseOnHover: true,
//             draggable: true,
//             progress: undefined,
//         });
//     }
//     onSubmitButton = () => {
//         let { txtCode, txtName, txtDescription, id } = this.state

//         if (txtCode !== null || txtName !== null || txtDescription !== null) {
//             let category = {
//                 id: id,
//                 categoryCode: txtCode,
//                 categoryName: txtName,
//                 categoryDescription: txtDescription
//             }
//             if (this.checkId(id)) {
//                 this.props.onUpdateCategory(category)

//             }
//             else {
//                 this.props.onAddCategory(category)
//             }
//         }
//         else {
//             this.notifyMessage('Vui lòng nhập đủ các trường thông tin')
//         }
//     }

//     onGoBack = () => {
//         history.goBack();
//     }

//     checkId = (id) => {
//         if (typeof id === 'undefined' || id === '') {
//             return false;
//         }
//         else {
//             return true;
//         }
//     }

//     render() {

//         let { category } = this.props;
//         let { txtCode, txtName, txtDescription, txtCreatedAt, id } = this.state
//         let check = this.checkId(id)
//         return (
//             <>
//                 <div className="margin-top-body">

//                 </div>
//                 <div className="body-wrap">
//                     <h1>{check ? `Chi tiết danh mục : ${category.categoryName}` : 'Thêm danh mục'}</h1>

//                     <div className="row form-signup">
//                         <div className="col-lg-12 col-md-12 col-12">
//                             <div className="form-group">
//                                 <label className="lable"> Code: </label>
//                                 <span className="require"> *</span>
//                                 <input type="text"
//                                     className="form-control"
//                                     value={typeof txtCode === 'undefined' ? "" : txtCode}
//                                     name="txtCode"
//                                     onChange={this.onHandleChange}
//                                 />
//                             </div>
//                         </div>
//                         <div className="col-lg-12 col-md-12 col-12">
//                             <div className="form-group">
//                                 <label className="lable"> Name : </label>
//                                 <span className="require"> *</span>
//                                 <input type="text"
//                                     className="form-control"
//                                     value={typeof txtName === 'undefined' ? "" : txtName}
//                                     name="txtName"
//                                     onChange={this.onHandleChange}
//                                 />
//                             </div>
//                         </div>
//                         <div className="col-lg-12 col-md-12 col-12">
//                             <div className="form-group">
//                                 <label className="lable"> Description : </label>
//                                 <span className="require"> *</span>
//                                 <input type="text"
//                                     className="form-control"
//                                     value={typeof txtDescription === 'undefined' ? "" : txtDescription}
//                                     name="txtDescription"
//                                     onChange={this.onHandleChange}
//                                 />
//                             </div>
//                         </div>
//                         {check ? <div className="col-lg-12 col-md-12 col-12">
//                             <div className="form-group">
//                                 <label className="lable"> Created At : </label>
//                                 <span className="require"> *</span>
//                                 <input type="date"
//                                     className="form-control"
//                                     value={typeof txtCreatedAt === 'undefined' ? "" : txtCreatedAt}
//                                     pattern="\d{4}-\d{2}-\d{2}"
//                                     name="txtCreatedAt"
//                                     readOnly={true} />
//                             </div>
//                         </div> : ""}

//                         <div className="col-lg-12 col-md-12 col-12">
//                             <button className="btn mr-2" onClick={this.onGoBack} style={{ backgroundColor: "#cea37f", color: 'white' }}>Quay lại</button>
//                             <button className="btn " onClick={this.onSubmitButton} style={{ backgroundColor: "#cea37f", color: 'white' }}>{check ? 'Lưu danh mục' : 'Thêm danh mục'}</button>
//                         </div>

//                     </div>

//                     <div className="row section-6">
//                         <img src="./image/Untitled-1.png" className="image end" alt='' />
//                     </div>
//                 </div>
//             </>
//         )
//     }

// }

export default CategoryDetail;