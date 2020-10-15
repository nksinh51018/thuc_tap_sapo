import React, { Component } from 'react'
import { NavLink } from 'react-router-dom';

class CategoryItem extends Component {

    render() {
        let { index, category, match } = this.props;
        let date = new Date(category.createAt); 
        let month = String(date.getMonth()).padStart(2, '0');
        let day = String(date.getDate()).padStart(2, '0');
        let year = date.getFullYear();
        let output = day+" - "+month+" - "+year

        return (
            <tr>
                <th scope="row">{index}</th>
                <td>{category.id}</td>
                <td>{category.categoryName}</td>
                <td>{category.categoryDescription}</td>
                <td>{output}</td>
                <td>
                    <NavLink to={`${match.url}/${category.id}`}>
                        <button type="button" className="btn btn-info">Info</button>
                    </NavLink>
                </td>
            </tr>
        )
    }

}

export default CategoryItem;