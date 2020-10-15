import React from 'react';
import NotFound from './components/NotFound/NotFound';
import BodyWrap from './components/BodyWrap/BodyWrap';
import SignInContainer from './containers/SignInContainer';
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