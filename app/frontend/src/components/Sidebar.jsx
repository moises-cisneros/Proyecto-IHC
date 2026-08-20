import { NavLink, useNavigate } from 'react-router-dom'
import { useDispatch } from 'react-redux'

import { logout, selectUser } from '../features/auth/authSlice'
import './Sidebar.css'

export default function Sidebar() {
  const dispatch = useDispatch()
  const navigate = useNavigate()

  const cerrarSesion = () => {
    dispatch(logout())
    navigate('/login', { replace: true })
  }

  return (
    <aside className="sidebar">
      <div className="sidebar-marca">
        <span className="sidebar-titulo">UAGRM</span>
      </div>

      <nav className="sidebar-nav">
        <NavLink
          to="/dashboard"
          className={({ isActive }) => 'sidebar-link' + (isActive ? ' activo' : '')}
        >
          Dashboard
        </NavLink>

        <NavLink
          to="/vendedores"
          className={({ isActive }) => 'sidebar-link' + (isActive ? ' activo' : '')}
        >
          Vendedores
        </NavLink>

        <NavLink
          to="/mapa"
          className={({ isActive }) => 'sidebar-link' + (isActive ? ' activo' : '')}
        >
          Mapa
        </NavLink>
      </nav>

      <div className="sidebar-pie">
        <button type="button" className="sidebar-logout" onClick={cerrarSesion}>
          Cerrar sesión
        </button>
      </div>
    </aside>
  )
}