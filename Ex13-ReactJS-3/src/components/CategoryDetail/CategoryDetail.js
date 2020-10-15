import React, { Component } from 'react'
class CategoryDetail extends Component {

    render() {

        let { category } = this.props;
        console.log(category)
        return (
            <>
                <div className="margin-top-body">

                </div>
                <div className="body-wrap">
                    <h1>Chi tiết danh mục : {category.code}</h1>
                    <form>
                        <div className="row form-signup">
                            <div className="col-lg-12 col-md-12 col-12">
                                <div className="form-group">
                                    <label className="lable"> Code: </label>
                                    <span className="require"> *</span>
                                    <input type="text"
                                        className="form-control"
                                        value={category.code}
                                        name="username"
                                        readOnly={true} />
                                </div>
                            </div>
                            <div className="col-lg-12 col-md-12 col-12">
                                <div className="form-group">
                                    <label className="lable"> Name : </label>
                                    <span className="require"> *</span>
                                    <input type="text"
                                        className="form-control"
                                        value={category.name}
                                        name="username"
                                        readOnly={true} />
                                </div>
                            </div>
                            <div className="col-lg-12 col-md-12 col-12">
                                <div className="form-group">
                                    <label className="lable"> Description : </label>
                                    <span className="require"> *</span>
                                    <input type="text"
                                        className="form-control"
                                        value={category.description}
                                        name="username" 
                                        readOnly={true}/>
                                </div>
                            </div>
                            <div className="col-lg-12 col-md-12 col-12">
                                <div className="form-group">
                                    <label className="lable"> Created At : </label>
                                    <span className="require"> *</span>
                                    <input type="date"
                                        className="form-control"
                                        value={category.createdAt}
                                        pattern="\d{4}-\d{2}-\d{2}"
                                        name="username" 
                                        readOnly={true}/>
                                </div>
                            </div>
                        </div>
                        {/* <div className="row form-signup">
                            <button type="button" className="button-signup" onClick={this.onSubmit}>Đăng nhập</button>
                        </div> */}
                    </form>
                    <div className="row section-6">
                        <img src="./image/Untitled-1.png" className="image end" alt='' />
                    </div>
                </div>
            </>
        )
    }

}

export default CategoryDetail;