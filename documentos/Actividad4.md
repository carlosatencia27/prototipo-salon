## 3.1 Procesos Futuros

1. **Iteraciones de refinamiento UX/UI**  
   - Basadas en el feedback recogido (p. ej. destacar mejor el botón de reserva, añadir texto de ayuda en el registro y mejorar contraste del calendario).  
   - Planifica pequeños sprints (1–2 semanas) para abordar cada mejora.

2. **Configuración de CI/CD**  
   - **Frontend**: GitHub Actions que lancen tests y desplieguen a Netlify en cada push a `main`.  
   - **Backend**: pipeline que ejecute pruebas unitarias/integración y despliegue a Heroku o AWS.

3. **Ampliación de funcionalidades**  
   - Pagos en línea (Stripe o PayU) para confirmar reservas automáticamente.  
   - Gestión de inventario y servicios: añadir CRUD de nuevos servicios, precios y disponibilidades.  
   - App móvil (React Native o Flutter) replicando el flujo de cliente.  
   - Panel de reportes (Google Analytics, Grafana) para KPIs: reservas diarias, tasa de cancelación, tiempo medio de reserva.

4. **Soporte y Mantenimiento**  
   - Definir un SLA (por ejemplo, 24 h para incidencias críticas).  
   - Crear un canal de atención (email o chat) para feedback de usuarios.  
   - Programar actualizaciones trimestrales de seguridad y mejora.

5. **Monitoreo post‑lanzamiento**  
   - Recoger métricas clave (NPS, tiempo medio de tarea, tasa de éxito).  
   - Revisar semanalmente y ajustar el roadmap de producto.
## 4. Conclusiones

Al cerrar la Actividad 4, hemos cubierto todo el ciclo de vida del prototipo funcional:

- **Diseño**: Partimos de requisitos claros (RF/RNF) y modelamos la solución con UML.  
- **Prototipado**: Creamos wireframes de baja fidelidad en Figma y maquetas de alta fidelidad, enlazadas en un prototipo navegable.  
- **Pruebas**: Con 5 usuarios validamos las tareas clave, alcanzando éxito del 100 % en registro, disponibilidad y cancelación, y un 80 % en reserva, con tiempos medios inferiores a 1 min.  
- **Entrega**: Documentamos todo en GitHub (diagramas, prototipos, resultados y vídeo).

**Lecciones clave**  
1. Las pruebas de usabilidad tempranas destapan problemas de interacción antes de invertir en código.  
2. Un repositorio bien estructurado acelera la colaboración y el despliegue.  
3. Ciclos cortos de diseño → pruebas → refinamiento garantizan mayor calidad.

**Próximos pasos**  
- Desarrollar full‑stack según diagrama de clases.  
- Configurar CI/CD y staging.  
- Nuevas rondas de validación post‑iteración.

## 5. Referencias

- Pressman, R. S. (2021). *Ingeniería de software*. McGraw-Hill Interamericana.  
- Sommerville, I. (2019). *Ingeniería del software*. Pearson.  
- Nielsen Norman Group. (2023). *User Interface Design Basics*. https://www.nngroup.com/articles/definition-user-interface/  
- Figma. (2025). *Collaborative Interface Design*. https://www.figma.com  