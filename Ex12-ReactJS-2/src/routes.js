import React from 'react';
import NotFound from './components/NotFound/NotFound';
import BodyWrap from './components/BodyWrap/BodyWrap';
import SignInContainer from './containers/SignInContainer';
import CategoryListContainer from './containers/CategoryListContainer';
import CategoryDetailContainer from './containers/CategoryDetailContainer';
const routes = [
    {
        to: '/signIn',
        exact: true,
        main: ({history}) => <SignInContainer history={history} />
    },
    {
        to: '/',
        exact: true,
        main: () => <BodyWrap />
    },
    {
        to: '/categories',
        exact: true,
        main: ({match}) => <CategoryListContainer match = {match}/>
    },
    {
        to: '/categories/:code',
        exact: true,
        main: ({match}) => <CategoryDetailContainer match = {match}/>
    },
    // {
    //     to: 'signUp',
    // },
    // {
    //     to: 'products',
    // },
    // {
    //     to: 'services',
    // },
    // {
    //     to: 'news',
    // },
    // {
    //     to: 'contacts',
    // },
    // {
    //     to: 'maps',
    // },
    {
        to: '',
        exact: true,
        main: () => <NotFound />
    }

]

export default routes;