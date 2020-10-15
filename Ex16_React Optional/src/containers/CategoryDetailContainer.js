import React, { useEffect } from 'react'
import CategoryDetail from '../components/CategoryDetail/CategoryDetail';
import { actGetCategoryByIDRequest, actUpdateCategoryRequest, actClearCategoryItem, actAddCategoryRequest } from '../actions/index'
import { connect } from 'react-redux';

const CategoryDetailContainer = (props) => {

    useEffect(() => {
        let code = props.match.params.code;
        if (code) {
            props.onGetCategoryByID(code)
        }
        else {
            props.onClearItem()
        }
    }, [props]);

    let { categoryItem } = props

    return (
        <CategoryDetail category={categoryItem} onUpdateCategory={props.onUpdateCategory} onAddCategory={props.onAddCategory} />
    );
}

// class CategoryDetailContainer extends Component{

//     componentDidMount(){
//         let code = this.props.match.params.code;
//         if(code){
//             this.props.onGetCategoryByID(code)
//         }
//         else{
//             this.props.onClearItem()
//         }
//     }

//     render(){
//         let {categoryItem} = this.props 
//         return(
//             <CategoryDetail category={categoryItem} onUpdateCategory={this.props.onUpdateCategory} onAddCategory={this.props.onAddCategory} />
//         )
//     }

// }

const mapStatetoProps = (state) => {
    return {
        categoryItem: state.categoryItem
    }
}

const mapDispatchToProps = (dispatch, action) => {
    return {
        onGetCategoryByID: (id) => {
            dispatch(actGetCategoryByIDRequest(id))
        },
        onUpdateCategory: (category) => {
            dispatch(actUpdateCategoryRequest(category))
        },
        onClearItem: () => {
            dispatch(actClearCategoryItem())
        },
        onAddCategory: (category) => {
            dispatch(actAddCategoryRequest(category))
        }
    }
}

export default connect(mapStatetoProps, mapDispatchToProps)(CategoryDetailContainer);