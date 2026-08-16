# Evidencias de Investigación

## Perfiles Entrevistados

Para esta investigación, contrastamos dos perfiles dentro del mismo sector (rastrillaje de ventas en terreno) pero con diferentes escalas y fricciones tecnológicas:

* **Perfil SA (Carlos - Jefe de Ventas Regional):**
  * **Demografía y Rol:** 45 años, industria de Consumo Masivo. Supervisa a un equipo mediano de 15 vendedores de calle.
  * **Contexto de la entrevista:** Su mayor dolor es la falta de transparencia. Depende de que los vendedores contesten el teléfono o mantengan el GPS encendido. Sufre constantes engaños mediante la manipulación de ubicaciones estáticas falsas y el equipo apaga activamente el GPS argumentando un excesivo consumo de batería en sus celulares personales.

* **Perfil SB (Mariana - Supervisora de Ruteo y Promotoría):**
  * **Demografía y Rol:** 28 años, industria de Telecomunicaciones. Supervisa a un equipo masivo y rotativo de 30 promotores de calle.
  * **Contexto de la entrevista:** Su problema principal es la infraestructura técnica y la escalabilidad. WhatsApp colapsa físicamente su teléfono al intentar monitorear a 30 personas simultáneamente. Pierde el rastro por completo cuando el equipo entra en zonas periféricas sin internet, lo que los vendedores aprovechan para aglomerarse y hacer paradas no justificadas sin ser detectados.

---

## 1. Ficha de Entrevista: Perfil SA (Carlos)

### 1.1 Elegir a quien escuchar

* **Persona:** Carlos, Jefe de Ventas Regional (Consumo Masivo).
* **Tarea:** Controlar la ubicación, avance y estado de su personal de campo de 15 personas durante la jornada laboral para asegurar el cumplimiento de rutas y evitar que abandonen sus zonas.

### 1.2. Preparar preguntas

1. *"Cuéntame sobre la última vez que tuviste que coordinar y verificar el avance de tu equipo en la calle. ¿Cómo fue el proceso?"*
2. *"¿Qué herramientas utilizas actualmente para saber la ubicación de tus vendedores?"*
3. *"De todas las tareas, ¿cuál te consume más tiempo o energía y por qué?"*
4. *"Describe una situación en la que el reporte de ubicación no fue preciso. ¿Qué consecuencias tuvo?"*

### 1.3. Conversar u observar

**Frases clave:**

* *"Fácilmente paso entre 2 y 3 horas de mi día mandando mensajes de '¿Dónde estás?'."*
* *"Ese tiempo debería usarlo para analizar estrategias de ventas, no para hacer de niñera."*
* *"Como la ubicación estática es fácil de manipular, me engañó."*

**Dificultades detalladas:**

* La mitad del equipo apaga la ubicación compartida a las 11 AM bajo la excusa de que el GPS les consume toda la batería del celular.
* No existe una herramienta que le diga dónde están exactamente si los vendedores no contestan el teléfono.
* Las ubicaciones estáticas compartidas por WhatsApp son manipuladas para ocultar conductas inadecuadas (ej. un vendedor se fue a su casa a descansar mientras enviaba una ubicación estática de la zona norte).

**Acciones registradas:**

* Llamar a los vendedores uno por uno para saber por qué zona iban cuando apagan el GPS.
* Llenar un Excel en la oficina para cruzar manualmente lo que vendieron con lo que dijeron que visitaron.
* Mandar mensajes constantes preguntando "*¿Dónde estás?*" o "*¿Ya llegaste a la tienda de don Juan?*".

### 1.4. Comparar con la hipótesis

* **Confirmado:** El control precario mediante WhatsApp toma más tiempo del necesario (2 a 3 horas perdidas al día de micromanagement).
* **Confirmado:** La falta de visibilidad permite y facilita conductas inadecuadas (como el vendedor descansando en su casa en horario laboral).
* **Descubrimiento clave:** El problema de la batería es una fricción principal para la adopción tecnológica en este rubro. La solución *debe* ser energéticamente eficiente o fracasará.

---

## 2. Ficha de Entrevista: Perfil SB (Mariana)

### 2.1 Elegir a quien escuchar

* **Persona:** Mariana, Supervisora de Ventas en Terreno (Telecomunicaciones).
* **Tarea:** Asignar cuadrantes, reaccionar a imprevistos y monitorear la distribución de 30 vendedores simultáneamente en zonas periféricas, evitando el solapamiento o la inactividad.

### 2.2. Preparar preguntas

1. *"Cuéntame sobre la última vez que tuviste que coordinar el avance de tu equipo. ¿Cómo fue el proceso paso a paso?"*
2. *"¿Qué herramientas usas para saber el estado de tus vendedores?"*
3. *"Describe una situación donde el reporte no fue preciso o te generó dudas. ¿Qué consecuencias tuvo?"*
4. *"¿Cómo manejas las excepciones en tiempo real y cómo reajustas la cobertura?"*

### 2.3. Conversar u observar

**Frases clave:**

* *"El teléfono se me recalentaba de intentar abrir 30 chats a la vez para ver si habían llegado a sus zonas."*
* *"No me da un mapa único donde pueda verlos a todos distribuidos para saber si se están pisando las zonas."*
* *"Lo hago todo a puro instinto, y casi siempre nos quedan cuadras sin visitar porque no tengo una vista de pájaro para reaccionar rápido."*

**Dificultades detalladas:**

* WhatsApp no soporta monitorear a 30 promotores al mismo tiempo; la aplicación se traba, no carga y el teléfono se recalienta a los 40 minutos de iniciar la jornada.
* En barrios periféricos o nuevos, los vendedores se quedan sin señal de internet, provocando que la ubicación quede "congelada" o no contesten las llamadas.
* Los vendedores aprovechan la caída de internet para agruparse y no trabajar (ej. 5 vendedores sentados tomando gaseosa en una plaza).

**Acciones registradas:**

* Empezar a llamar a los promotores uno por uno cuando la aplicación de WhatsApp se traba.
* Subirse al auto y "caer de sorpresa" físicamente a la zona asignada cuando el GPS se congela y le genera dudas.
* Abrir su propio Google Maps, revisar los chats manualmente y mandar audios para reasignar vendedores cercanos a puro instinto.

### 2.4. Comparar con la hipótesis

* **Confirmado:** La necesidad imperativa de una herramienta "centralizada". El término "vista de pájaro" o "mapa único" surge como el requisito número uno de diseño.
* **Confirmado:** Conductas inadecuadas facilitadas por la falta de visibilidad (vendedores agrupándose a tomar algo en una plaza).
* **Confirmado:** La resiliencia a la mala conectividad es vital. El diseño de la solución debe contemplar el registro de trayectorias *offline* para que los "agujeros de internet" no sirvan como excusa de inactividad.
