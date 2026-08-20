import { useState } from "react"
import { enviarMensaje } from "../features/mensajes/mensajesSlice"
import { useDispatch, useSelector } from "react-redux"

export default function ModalMensaje({ vendedor, onClose }) {
  const dispatch = useDispatch()
  const { loading, error, enviado } = useSelector((state) => state.mensajes)
 
  const [mensaje, setMensaje] = useState('')
  const [tipo, setTipo] = useState('RECORDATORIO')

  const onSubmit = async (e) => {
    e.preventDefault()
    const resultado = await dispatch(
      enviarMensaje({ vendedorId: vendedor.id, mensaje, tipo })
    )
    if (enviarMensaje.fulfilled.match(resultado)) {
      setMensaje('')
    }
  }

  return (
    
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal" onClick={(e) => e.stopPropagation()}>
        <div className="modal-header">
          <h2>Mensaje para {vendedor.nombreCompleto}</h2>
          <button type="button" className="modal-cerrar" onClick={onClose}>X</button>
        </div>

        <form onSubmit={onSubmit}>
            <select
                className="modal-select"
                value={tipo}
                onChange={(e) => setTipo(e.target.value)}
            >
                <option value="RECORDATORIO">Recordatorio</option>
                <option value="SEGUIMIENTO">Seguimiento</option>
                <option value="INFORMATIVO">Informativo</option>
                <option value="OTRO">Otro</option>
            </select>
          <textarea
            className="modal-textarea"
            value={mensaje}
            onChange={(e) => setMensaje(e.target.value)}
            rows={4}
            placeholder="Escribe la notificación…"
            required
          />

          {error && <p className="modal-error">{error}</p>}
          {enviado && <p className="modal-ok">Mensaje enviado</p>}

          <div className="modal-acciones">
            <button type="button" className="btn" onClick={onClose}>Cancelar</button>
            <button type="submit" className="btn btn-primario" disabled={loading}>
              {loading ? 'Enviando…' : 'Enviar'}
            </button>
          </div>
        </form>
      </div>
    </div>
  )
}