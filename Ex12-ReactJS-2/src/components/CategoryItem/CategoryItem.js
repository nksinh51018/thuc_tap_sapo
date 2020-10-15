import React, { Component } from 'react'
import { NavLink } from 'react-router-dom';

class CategoryItem extends Component {

    render() {
        let { index, category,match } = this.props;
        
        return (
            <tr>
                <th scope="row">{index}</th>
                <td>{category.code}</td>
                <td>{category.name}</td>
                <td>{category.description}</td>
                <td>{category.createdAt}</td>
                <td>
                    <NavLink to={`${match.url}/${category.code}`}>
                        <button type="button" className="btn btn-info">Info</button>
                    </NavLink>
                </td>
            </tr>
        )
    }

}

export default CategoryItem;