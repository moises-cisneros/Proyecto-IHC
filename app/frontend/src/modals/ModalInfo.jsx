export default function ModalInfo({ vendedor, onClose }) {
  return (
    
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal" onClick={(e) => e.stopPropagation()}>
        <div className="modal-header">
          <h2>{vendedor.nombreCompleto}</h2>
          <button type="button" className="modal-cerrar" onClick={onClose}>×</button>
        </div>

        <div className="modal-dato">
          <span>Estado</span>
          <strong>{vendedor.estado}</strong>
        </div>
        <div className="modal-dato">
          <span>Ubicación</span>
          <strong>{vendedor.ubicacion}</strong>
        </div>
        <div className="modal-dato">
          <span>Coordenadas</span>
          <strong>{vendedor.latitud}, {vendedor.longitud}</strong>
        </div>
        <div className="modal-dato">
            <span>Última conexión</span>
            <strong>
                {vendedor.ultimaConexion
                ? new Date(vendedor.ultimaConexion).toLocaleDateString('es-BO')
                : '—'}
            </strong>
        </div>

        <div className="modal-acciones">
          <button type="button" className="btn" onClick={onClose}>Cerrar</button>
        </div>
      </div>
    </div>
  )
}