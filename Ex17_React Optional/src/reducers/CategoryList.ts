import * as ActionTypes from "../constains/ActionType";
import toastMessage from "../ulti/ToastMessage";
import history from "../history";
import Category from "../model/Category";

type State = {
  pageNumber: number;
  categories: Category[];
  total: number;
};

var initState: State = {
  pageNumber: 0,
  categories: [],
  total: 0,
};

const categoryList = (
  state = initState,
  action: {
    type?: string;
    pageNumber?: number;
    categories?: Category[];
    total?: number;
    id?: number;
    category?: Category;
  }
) => {
  switch (action.type) {
    case ActionTypes.GET_ALL_CATEGORY: {
      if (action.pageNumber && action.categories) {
        state.pageNumber = action.pageNumber;
        state.categories = action.categories;
      }
      return { ...state };
    }
    case ActionTypes.COUNT_ALL_CATEGORY: {
      if (action.total) {
        state.total = action.total;
      }
      return { ...state };
    }
    case ActionTypes.UPDATE_CATEGORY_SUCCESS: {
      toastMessage("Cập nhật thành công");
      let { category } = action;
      if (category) {
        let index = findIndex(state.categories, category.id);
        if (index >= 0) {
          state.categories[index] = category;
        }
        history.goBack();
      }
      return { ...state };
    }
    case ActionTypes.UPDATE_CATEGORY_FAILURE: {
      toastMessage("Cập nhật thất bại");
      return { ...state };
    }
    case ActionTypes.ADD_CATEGORY_SUCCESS: {
      toastMessage("Thêm thành công");
      let { category } = action;
      let date = new Date();
      if (category) {
        category["createAt"] = date;
        category["updatedAt"] = date;
        state.categories.unshift(category);
        state.categories.pop();
        state.total++;
      }
      history.goBack();
      return { ...state };
    }
    case ActionTypes.ADD_CATEGORY_FAILURE: {
      toastMessage("Thêm thất bại");
      return { ...state };
    }
    case ActionTypes.DELETE_CATEGORY_SUCCESS: {
      toastMessage("Xóa thành công");
      if (action.id) {
        let index = findIndex(state.categories, action.id);
        console.log(index);
        if (index >= 0) {
          state.categories.splice(index, 1);
        }
      }
      history.goBack();
      return { ...state };
    }
    case ActionTypes.DELETE_CATEGORY_FAILURE: {
      toastMessage("Xóa thất bại");
      return { ...state };
    }
    default:
      return { ...state };
  }
};

const findIndex = (categories: Category[], id: number) => {
  let n = categories.length;
  for (let i = 0; i < n; i++) {
    if (categories[i].id === id) {
      return i;
    }
  }
  return -1;
};

export default categoryList;
