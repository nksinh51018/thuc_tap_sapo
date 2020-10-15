import React, { Component } from 'react'
import "./css/CategoryList.css"
import CategoryItem from '../CategoryItem/CategoryItem';
class CategoryList extends Component {

    render() {
        let {categoryList,match} = this.props;
        return (
            <>
                <div className="margin-top-body">

                </div>
                <div className="body-wrap">
                    <h1>Danh mục</h1>
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Code</th>
                                <th scope="col">Name</th>
                                <th scope="col">Description</th>
                                <th scope="col">Created At</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.showCategoryItem(categoryList,match)}
                        </tbody>
                    </table>
                    <div className="row section-6">
                        <img src="./image/Untitled-1.png" className="image end" alt='' />
                    </div>
                </div>
            </>
        )
    }

    showCategoryItem = (categoryList,match) => {
        let result = <></>;
        if (categoryList.length > 0) {
            result = categoryList.map((category, index) => {
                return (
                    <CategoryItem category={category}
                        index={index}
                        key={index}
                        match={match}
                    />
                )
            })
        }
        return result;
    }

}

export default CategoryList;