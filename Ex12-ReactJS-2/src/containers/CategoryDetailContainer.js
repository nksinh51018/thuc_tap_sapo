import React, { Component } from 'react'
import CategoryDetail from '../components/CategoryDetail/CategoryDetail';
import _ from 'lodash';
import { connect } from 'react-redux';
class CategoryDetailContainer extends Component{

    render(){
        //_.findIndex(this.props.categoryList, ['code', this.props.match.params.code]);
        let {categoryList,match} = this.props;
        let category_id= _.findIndex(categoryList, ['code', match.params.code]);;
        return(
            <CategoryDetail category={categoryList[category_id]} />
        )
    }

}

const mapStatetoProps = (state)=>{
    return {
        categoryList: state.categoryList
    }
}

export default connect(mapStatetoProps,null)(CategoryDetailContainer);