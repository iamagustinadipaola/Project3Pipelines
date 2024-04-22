import './App.css';
import { Link, Route, Routes, BrowserRouter as Router } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from './Components/Homepage/Home.jsx';
import PageForItem from './Components/Item/PageForItem.jsx';
import CreateItemPage from './Components/Item/CreateItemPage.jsx';
import BasketPage from './Components/Basket/BasketPage.jsx';
import Logo from './Business.png';
import React from 'react';
import Login from './Components/Homepage/Login.jsx';

function App() {
  return (
  <div class="p-3 mb-2 bg-warning text-dark" style={{ overflow: "auto" }}>
    <Router>
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#"></a>
        <Link to="/">
            <img src={Logo} alt='Logo Icon' className="navbar-brand" width="75px" />
          </Link>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
              <li class="nav-item">
                <Link class="nav-item nav-link active" to="/">Login</Link>
              </li>
              <li class="nav-item">
                <Link className="nav-item nav-link active" to='/home'>Home</Link>
              </li>
              <li class="nav-item">
                <Link className="nav-item nav-link active" to='/items'>Items</Link>
              </li>
              <li class="nav-item">
                <Link className="nav-item nav-link active" to='/basket'>Basket</Link>
              </li>
              <li class="nav-item ">
                <Link className="nav-item nav-link active" to='/createitems'>Add Items</Link>
              </li>
          </div>
          </div>
      </nav>
      <div >
        <Routes>
          <Route path='/' element={<Login />} />
          <Route path='/home' element={<Home />} />
          <Route path='/basket' element={<BasketPage />} />
          <Route path='/items' element={<PageForItem />} />
          <Route path='/createitems' element={<CreateItemPage/>} />
        </Routes>
      </div>

    </Router>
  </div>
  );
}

export default App;