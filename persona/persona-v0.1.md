# Persona v0.1

- **Nombre:** Carlos
- **Situación:** Supervisor y responsable de un equipo de ventas. Actualmente usa WhatsApp para preguntar el avance de cada uno de sus agentes durante la jornada.
- **Objetivo:** Revisar el avance de su equipo de ventas (entre 10 y 20 personas) para tomar decisiones sobre la situación en la que está cada uno.
- **Dificultad:** Revisar los chats uno por uno para saber cómo va el avance es bastante moroso y no le permite tener un buen control.
- **Necesidad:** Encontrar una manera rápida y eficiente de revisar el avance de su equipo de ventas para no demorar tanto tiempo y poder tomar decisiones rápidas.

## App-map v0.1

"¿Dónde puede encontrar la persona lo que necesita?"

Login -> Inicio (Resumen) -> Listado de Vendedores -> Detalles del Vendedor (Modal) -> Enviar Recordatorio (Acción)

### Estructura de "AppMap" (Supervisor)

- **Login Page:** Autenticación de usuarios (Supervisor, Agente Vendedor).
- **Inicio (Home Screen):** Pantalla principal con un pequeño resumen del día y panel lateral (sidebar).
- **Vendedores Page (Listado):** Lista de los agentes vendedores. Por ahora se mostrará el estado o ubicación aproximada simulada (ej. "en movimiento", "zona la Villa", "zona norte").
- **Vendedor Modal:** Vista de detalles al seleccionar un agente. Muestra información básica, estado de su tarea actual y opciones de acción para enviarle un recordatorio o mensaje predefinido (ej. "¿por qué no has empezado a vender?", "felicidades, lo estás haciendo bien").

## Flujo v0.1

Flujo de pasos:

Abrir la aplicación -> Iniciar sesión (Login) -> Visualizar el resumen del día en el Inicio -> Ir al "Listado de Vendedores" -> Seleccionar un vendedor específico de la lista -> Revisar sus datos básicos y estado actual en el "Vendedor Modal" -> Tomar acción: Enviar un recordatorio o mensaje al agente.
