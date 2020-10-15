import * as ActionTypes from '../constains/ActionType'
var initState = {

    pageNumber: 0,
    categories: [

    ],
    total: 0

    // {
    //     code: "CG_001",
    //     name: "Mây tre đan",
    //     description: 'Sản phẩm được làm bằng mây tre đan',
    //     createdAt: "2020-08-28"
    // },
    // {
    //     code: "CG_002",
    //     name: "Mây tre lá",
    //     description: 'Sản phẩm được làm bằng mây tre lá',
    //     createdAt: "2020-08-28"
    // },
    // {
    //     code: "CG_003",
    //     name: "Sản phẩm mây tre lá",
    //     description: 'Sản phẩm được làm bằng mây tre lá',
    //     createdAt: "2020-08-28"
    // },
    // {
    //     code: "CG_004",
    //     name: "Mỹ nghệ",
    //     description: 'Sản phẩm mỹ nghệ',
    //     createdAt: "2020-08-28"
    // },
}

const categoryList = (state = initState, action)=>{
    switch(action.type){
        case ActionTypes.GEt_ALL_CATEGORY:{
            state.pageNumber = action.pageNumber;
            state.categories = action.categories;
            return {...state};
        }
        case ActionTypes.COUNT_ALL_CATEGORY:{
            state.total = action.total;
            return {...state};
        }
        default:
            return {...state};
    }
}

export default categoryList;