import React, { useState, useEffect } from "react";

import { toast } from "react-toastify";
import history from "../../history";
import Category from "../../model/Category";

type Props = {
  category: Category;
  onUpdateCategory: (category: Category) => void;
  onAddCategory: (category: Category) => void;
};

const CategoryDetail = (props: Props) => {
  const [state, setstate] = useState({
    id: 0,
    txtCode: "",
    txtName: "",
    txtDescription: "",
    txtCreatedAt: new Date(),
  });

  useEffect(() => {
    let category = props.category;
    if (category.id !== state.id) {
      return setstate({
        id: category.id,
        txtCode: category.categoryCode,
        txtName: category.categoryName,
        txtDescription: category.categoryDescription,
        txtCreatedAt: category.createAt,
      });
    }
  }, [props, state.id]);

  const onHandleChange = (e: any) => {
    let target = e.target;
    let name = target.name;
    let val = target.value;
    setstate({
      ...state,
      [name]: val,
    });
  };

  const notifyMessage = (message: string) => {
    toast.error(message, {
      position: "top-center",
      autoClose: 5000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
    });
  };

  const onSubmitButton = () => {
    let { txtCode, txtName, txtDescription, id } = state;

    if (txtCode !== null || txtName !== null || txtDescription !== null) {
      let category = {
        id: id,
        categoryCode: txtCode,
        categoryName: txtName,
        categoryDescription: txtDescription,
        createAt: new Date(),
        updatedAt: new Date(),
        productDTOs: [],
      };
      if (checkId(id)) {
        props.onUpdateCategory(category);
      } else {
        props.onAddCategory(category);
      }
    } else {
      notifyMessage("Vui lòng nhập đủ các trường thông tin");
    }
  };

  const onGoBack = () => {
    history.goBack();
  };

  const checkId = (id: number) => {
    if (typeof id === "undefined" || id === 0) {
      return false;
    } else {
      return true;
    }
  };

  let { category } = props;
  let { txtCode, txtName, txtDescription, txtCreatedAt, id } = state;
  let check = checkId(id);
  return (
    <>
      <div className="margin-top-body"></div>
      <div className="body-wrap">
        <h1>
          {check
            ? `Chi tiết danh mục : ${category.categoryName}`
            : "Thêm danh mục"}
        </h1>

        <div className="row form-signup">
          <div className="col-lg-12 col-md-12 col-12">
            <div className="form-group">
              <label className="lable"> Code: </label>
              <span className="require"> *</span>
              <input
                type="text"
                className="form-control"
                value={typeof txtCode === "undefined" ? "" : txtCode}
                name="txtCode"
                onChange={onHandleChange}
              />
            </div>
          </div>
          <div className="col-lg-12 col-md-12 col-12">
            <div className="form-group">
              <label className="lable"> Name : </label>
              <span className="require"> *</span>
              <input
                type="text"
                className="form-control"
                value={typeof txtName === "undefined" ? "" : txtName}
                name="txtName"
                onChange={onHandleChange}
              />
            </div>
          </div>
          <div className="col-lg-12 col-md-12 col-12">
            <div className="form-group">
              <label className="lable"> Description : </label>
              <span className="require"> *</span>
              <input
                type="text"
                className="form-control"
                value={
                  typeof txtDescription === "undefined" ? "" : txtDescription
                }
                name="txtDescription"
                onChange={onHandleChange}
              />
            </div>
          </div>
          {check ? (
            <div className="col-lg-12 col-md-12 col-12">
              <div className="form-group">
                <label className="lable"> Created At : </label>
                <span className="require"> *</span>
                <input
                  type="date"
                  className="form-control"
                  value={
                    typeof txtCreatedAt === "undefined"
                      ? ""
                      : txtCreatedAt.toString()
                  }
                  pattern="\d{4}-\d{2}-\d{2}"
                  name="txtCreatedAt"
                  readOnly={true}
                />
              </div>
            </div>
          ) : (
            ""
          )}

          <div className="col-lg-12 col-md-12 col-12">
            <button
              className="btn mr-2"
              onClick={onGoBack}
              style={{ backgroundColor: "#cea37f", color: "white" }}
            >
              Quay lại
            </button>
            <button
              className="btn "
              onClick={onSubmitButton}
              style={{ backgroundColor: "#cea37f", color: "white" }}
            >
              {check ? "Lưu danh mục" : "Thêm danh mục"}
            </button>
          </div>
        </div>

        <div className="row section-6">
          <img src="./image/Untitled-1.png" className="image end" alt="" />
        </div>
      </div>
    </>
  );
};

export default CategoryDetail;
