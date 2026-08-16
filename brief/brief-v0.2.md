# Brief v0.2

## Problema revisado
>
> Los encargados de equipos de ventas pierden horas de su jornada intentando monitorear a su personal de campo mediante herramientas no escalables y descentralizadas (como WhatsApp). Estas herramientas colapsan al manejar grupos grandes y no proveen una vista centralizada, lo que facilita conductas inadecuadas como el envío de ubicaciones estáticas falsas o paradas no justificadas.

## Usuario y contexto
>
> **Usuarios:** Supervisores, Jefes de Ventas y Coordinadores de ruteo (perfiles como Carlos o Mariana).
> **Contexto:** Manejan equipos de rastrillaje que van desde 15 hasta 30+ personas. El problema ocurre durante el horario laboral en la calle, agravándose a mitad de la jornada (por agotamiento de batería de los celulares) y en zonas periféricas con señal de internet inestable.

## Evidencia
>
> * **Escalabilidad:** WhatsApp colapsa y recalienta los celulares de los supervisores al intentar seguir a 30 promotores a la vez.
> * **Batería:** Los vendedores apagan activamente su GPS bajo el argumento (válido o como excusa) de que compartir la ubicación en tiempo real drena sus baterías.
> * **Offline y Engaños:** La pérdida de conectividad en zonas periféricas congela el rastreo, permitiendo que grupos de vendedores se aglomeren en plazas y pierdan tiempo. Además, los vendedores descubrieron que enviar una "ubicación estática" les permite irse a sus casas y engañar al supervisor.

## Insight
>
> El verdadero dolor del supervisor no es solo la "falta de control", sino la enorme **carga operativa y manual** que implica cruzar ubicaciones uno a uno. Además, si la nueva solución no es radicalmente más eficiente en el **consumo de batería**, sufrirá el mismo rechazo y sabotaje por parte de los vendedores.

## Hipotesis revisada
>
> **Creemos que** los encargados de ventas con equipos de rastrillaje **necesitan** una herramienta centralizada, escalable (tipo mapa único) y optimizada para el consumo de batería **porque** el control actual mediante WhatsApp colapsa con equipos grandes, consume demasiada energía (provocando que el personal lo apague), es vulnerable a engaños (ubicaciones estáticas falsas) y no funciona en zonas periféricas sin señal, lo que les hace perder horas de gestión y facilita paradas no justificadas.

## Alcance inicial
>
> * Aplicación móvil para el vendedor: Trackeo continuo en segundo plano, altamente optimizado para el consumo de batería, y con almacenamiento *offline* de la ruta cuando no hay señal (sincronizando al recuperar internet).
> * Plataforma web para el supervisor: Un mapa centralizado ("vista de pájaro") para monitorear a decenas de usuarios simultáneamente sin colapsar.

## Fuera del alcance
>
> * Sistemas completos de CRM o gestión de inventario/ventas.
> * Cálculo de comisiones o nóminas.
> * *El enfoque actual es estrictamente la geolocalización eficiente y el control de rutas.*

## Preguntas abiertas
>
> * ¿Cuál es el porcentaje máximo de consumo de batería que un vendedor está dispuesto a tolerar en una jornada de 8 horas?
> * ¿Cómo manejamos la privacidad y apagado automático de la app para asegurar al vendedor que no es rastreado fuera de su horario laboral?
