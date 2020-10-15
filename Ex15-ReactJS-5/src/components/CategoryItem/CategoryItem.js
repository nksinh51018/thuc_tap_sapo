import React from 'react'
import { NavLink } from 'react-router-dom';

const CategoryItem = (props) => {
    const onDelete = (id) => {
        // eslint-disable-next-line no-restricted-globals
        if (confirm("Are you sure you want to delete this item?")) {
            props.onDeleteCategory(id)
        }

    }

    const formatDate = (dateStr) => {
        let date = new Date(dateStr);
        let month = String(date.getMonth() + 1).padStart(2, '0');
        let day = String(date.getDate()).padStart(2, '0');
        let year = date.getFullYear();
        return day + " - " + month + " - " + year
    }
    let { index, category, match } = props;
    return (
        <tr>
            <th scope="row">{index}</th>
            <td>{category.categoryCode}</td>
            <td>{category.categoryName}</td>
            <td>{category.categoryDescription}</td>
            <td>{formatDate(category.createAt)}</td>
            <td>{formatDate(category.updatedAt)}</td>
            <td>
                <NavLink to={`${match.url}/edit/${category.id}`}>
                    <button type="button" className="btn btn-info">Info</button>
                </NavLink>
                <button type="button" className="btn btn-danger" onClick={() => onDelete(category.id)}>Delete</button>
            </td>
        </tr>

    );
}


// class CategoryItem extends Component {

//     onDelete = (id) => {
//         // eslint-disable-next-line no-restricted-globals
//         if (confirm("Are you sure you want to delete this item?")) {
//             this.props.onDeleteCategory(id)
//         }

//     }

//     render() {
//         let { index, category, match } = this.props;

//         return (
//             <tr>
//                 <th scope="row">{index}</th>
//                 <td>{category.categoryCode}</td>
//                 <td>{category.categoryName}</td>
//                 <td>{category.categoryDescription}</td>
//                 <td>{this.formatDate(category.createAt)}</td>
//                 <td>{this.formatDate(category.updatedAt)}</td>
//                 <td>
//                     <NavLink to={`${match.url}/edit/${category.id}`}>
//                         <button type="button" className="btn btn-info">Info</button>
//                     </NavLink>
//                     <button type="button" className="btn btn-danger" onClick={() => this.onDelete(category.id)}>Delete</button>
//                 </td>
//             </tr>
//         )
//     }

//     formatDate = (dateStr) => {
//         let date = new Date(dateStr);
//         let month = String(date.getMonth() + 1).padStart(2, '0');
//         let day = String(date.getDate()).padStart(2, '0');
//         let year = date.getFullYear();
//         return day + " - " + month + " - " + year
//     }

// }

export default CategoryItem;