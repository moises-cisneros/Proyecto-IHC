import { NavLink, useNavigate } from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'

import { logout, selectUser } from '../features/auth/authSlice'
import './Sidebar.css'

export default function Sidebar() {
  const user = useSelector(selectUser)
  const dispatch = useDispatch()
  const navigate = useNavigate()

  const cerrarSesion = () => {
    dispatch(logout())
    navigate('/login', { replace: true })
  }

  return (
    <aside className="sidebar">
      <div className="sidebar-marca">
        <span className="sidebar-logo">U</span>
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

        <NavLink
          to="/mensajes"
          className={({ isActive }) => 'sidebar-link' + (isActive ? ' activo' : '')}
        >
          Mensajes
        </NavLink>
      </nav>

      <div className="sidebar-pie">
        <div className="sidebar-usuario">
          <strong>{user?.nombre}</strong>
          <small>{user?.rol}</small>
        </div>
        <button type="button" className="sidebar-logout" onClick={cerrarSesion}>
          Cerrar sesión
        </button>
      </div>
    </aside>
  )
}