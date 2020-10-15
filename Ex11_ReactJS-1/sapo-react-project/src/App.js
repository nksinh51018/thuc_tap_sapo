import React, { Component } from 'react';
import './App.css';
import Header from './components/Header/Header';
import Footer from './components/Footer/Footer';
import TopBarContainer from './containers/TopBarContainer';
import routes from './routes'
import { Route, BrowserRouter as Router, Switch } from 'react-router-dom'
class App extends Component {
  render() {
    return (
      <Router>
        <div className="App">
          <div className="container lg">
            <TopBarContainer />
            <Header />
              {this.showContent(routes)}
            <Footer />
          </div>
        </div>
      </Router>
    );
  }
  showContent = (routes) => {
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

}

export default App;
