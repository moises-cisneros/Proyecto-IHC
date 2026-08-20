import {Routes, Route, Navigate} from 'react-router-dom'

import Layout from './components/Layout'
import Login from './pages/Login'
import Dashboard from './pages/Dashboard'
import Vendedores from './pages/Vendedores'
import Mapa from './pages/Mapa'

export default function App(){
  return(
    <Routes>
      <Route path='/login' element={<Login />} />

      <Route element={<Layout />}>
        <Route path="/" element={<Dashboard />} />
        <Route path="/vendedores" element={<Vendedores />} />
        <Route path="/mapa" element={<Mapa />} />
      </Route>
    </Routes>
  )
}