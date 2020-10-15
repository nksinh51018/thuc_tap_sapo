import React from 'react';
import './App.css';
import Header from './components/Header/Header';
import Footer from './components/Footer/Footer';
import TopBarContainer from './containers/TopBarContainer';
import routes from './routes'
import { Route, Router, Switch } from 'react-router-dom'
import history from './history'

import { ToastContainer } from 'react-toastify';
import UserContextProvider from './contexts/UserContext';

const App = () => {
  
  const showContent = (routes) => {
    let result = "";

    if (routes.length > 0) {
      result = routes.map((route, index) => {
        return (<Route key={index}
          path={route.to}
          exact={route.exact}
          component={route.main} />
        )
      })
    }
    return <Switch>{result}</Switch>;
  }

  return (
    < >
      <Router history={history}>
        <ToastContainer />
        <UserContextProvider>
          <div className="App">
            <div className="container lg">
              <TopBarContainer />
              <Header />
              {showContent(routes)}
              <Footer />
            </div>
          </div>
        </UserContextProvider>
      </Router>
    </>
  );
}


// class App extends Component {
//   render() {
//     return (
//       < >
//         <Router history={history}>
//           <ToastContainer />
//           <UserContextProvider>
//             <div className="App">
//               <div className="container lg">
//                 <TopBarContainer />
//                 <Header />
//                 {this.showContent(routes)}
//                 <Footer />
//               </div>
//             </div>
//           </UserContextProvider>
//         </Router>
//       </>
//     );
//   }
//   showContent = (routes) => {
//     let result = "";

//     if (routes.length > 0) {
//       result = routes.map((route, index) => {
//         return (<Route key={index}
//           path={route.to}
//           exact={route.exact}
//           component={route.main} />
//         )
//       })
//     }
//     return <Switch>{result}</Switch>;
//   }

// }

export default App;
