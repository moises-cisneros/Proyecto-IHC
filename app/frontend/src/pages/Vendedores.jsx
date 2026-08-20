import { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'

import { fetchVendedores } from '../features/vendedores/vendedoresSlice'
import { limpiarEstado } from '../features/mensajes/mensajesSlice'

import ModalInfo from '../modals/ModalInfo'
import ModalMensaje from '../modals/ModalMensaje'

import "./Vendedores.css"

export default function Vendedores(){
    const dispatch = useDispatch()
    const {lista, loading, error} = useSelector((state) => state.vendedores)

    //vendedores modal state
    const [modalInfo, setModalInfo] = useState(null)
    const [modalMensaje, setModalMensaje] = useState(null)

    //get vendedores
    useEffect(() => {
        dispatch(fetchVendedores())
    }, [dispatch])

    const abrirMensaje = (vendedor) => {
        dispatch(limpiarEstado())
        setModalMensaje((vendedor))
    }

    if(loading) return <p>Cargando...</p>
    if(error) return <p>{error}</p>

    return( 
        <>
            <h1>Vendedores</h1>

            <ul className='vendedores-lista'>
                {lista.map((vendedor) => (
                    <li className='vendedor-item'>
                        <span className='vendedor-nombre'>{vendedor.nombreCompleto}</span>

                        <div className='vendedor-acciones'>
                            <button type='button' className='btn' onClick={() => setModalInfo(vendedor)}>
                                Ver info
                            </button>
                            <button type='button' className='btn btn-primario' onClick={() => abrirMensaje(vendedor)}>
                                Mensaje
                            </button>
                        </div>
                    </li>
                ))}
            </ul>

            {modalInfo && <ModalInfo vendedor = {modalInfo} onClose = {() => setModalInfo(null)} />}
            {modalMensaje && <ModalMensaje vendedor = {modalMensaje} onClose = {() => setModalMensaje(null)} />}
        </>
    )
}