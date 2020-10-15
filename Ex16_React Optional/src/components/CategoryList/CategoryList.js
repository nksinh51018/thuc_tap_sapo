import React from 'react'
import "./css/CategoryList.css"
import CategoryItem from '../CategoryItem/CategoryItem';

import Pagination from "react-js-pagination";
import { NavLink } from 'react-router-dom';

const CategoryList = (props) => {

    function handlePageChange(pageNumber) {
        props.changePage(pageNumber)
    }

    const showCategoryItem = (categoryList, match) => {
        let result = <></>;
        if (categoryList.length > 0) {
            result = categoryList.map((category, index) => {
                return (
                    <CategoryItem category={category}
                        index={index + 1}
                        key={index}
                        match={match}
                        onDeleteCategory={props.onDeleteCategory}
                    />
                )
            })
        }
        return result;
    }

    let { categoryList, match } = props;


    return (
        <>
            <div className="margin-top-body">
            </div>
            <div className="body-wrap">
                <h1>Danh mục</h1>
                <NavLink to="/categories/add" className="btn " style={{ backgroundColor: "#cea37f", color: 'white' }}>Thêm danh mục</NavLink>
                <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Code</th>
                            <th scope="col">Name</th>
                            <th scope="col">Description</th>
                            <th scope="col">Created At</th>
                            <th scope="col">Updated At</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {showCategoryItem(categoryList.categories, match)}
                    </tbody>
                </table>
                <div className="pagination-div">
                    <Pagination
                        activePage={categoryList.pageNumber}
                        itemsCountPerPage={10}
                        totalItemsCount={categoryList.total}
                        onChange={(pageNumber) => { handlePageChange(pageNumber) }}
                        itemClass="page-item"
                        linkClass="page-link"
                    />
                </div>
                <div className="row section-6">
                    <img src="./image/Untitled-1.png" className="image end" alt='' />
                </div>
            </div>
        </>

    );
}


// class CategoryList extends Component {


//     handlePageChange(pageNumber) {
//         this.props.changePage(pageNumber)
//     }

//     render() {
//         let { categoryList, match } = this.props;
//         return (
//             <>
//                 <div className="margin-top-body">
//                 </div>
//                 <div className="body-wrap">
//                     <h1>Danh mục</h1>
//                     <NavLink to="/categories/add" className="btn " onClick={this.onSubmitButton} style={{ backgroundColor: "#cea37f", color: 'white' }}>Thêm danh mục</NavLink>
//                     <table className="table">
//                         <thead>
//                             <tr>
//                                 <th scope="col">#</th>
//                                 <th scope="col">Code</th>
//                                 <th scope="col">Name</th>
//                                 <th scope="col">Description</th>
//                                 <th scope="col">Created At</th>
//                                 <th scope="col">Updated At</th>
//                                 <th scope="col">Action</th>
//                             </tr>
//                         </thead>
//                         <tbody>
//                             {this.showCategoryItem(categoryList.categories, match)}
//                         </tbody>
//                     </table>
//                     <div className="pagination-div">
//                         <Pagination
//                             activePage={categoryList.pageNumber}
//                             itemsCountPerPage={10}
//                             totalItemsCount={categoryList.total}
//                             onChange={(pageNumber) => { this.handlePageChange(pageNumber) }}
//                             itemClass="page-item"
//                             linkClass="page-link"
//                         />
//                     </div>
//                     <div className="row section-6">
//                         <img src="./image/Untitled-1.png" className="image end" alt='' />
//                     </div>
//                 </div>
//             </>
//         )
//     }

//     showCategoryItem = (categoryList, match) => {
//         let result = <></>;
//         if (categoryList.length > 0) {
//             result = categoryList.map((category, index) => {
//                 return (
//                     <CategoryItem category={category}
//                         index={index + 1}
//                         key={index}
//                         match={match}
//                         onDeleteCategory={this.props.onDeleteCategory}
//                     />
//                 )
//             })
//         }
//         return result;
//     }

// }


export default CategoryList;