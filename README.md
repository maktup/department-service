

IMPORTANTE:
----------
CONSIDERAR que los DNS, deben estar regsitrados en el archivo HOST, del S.O. 
El 'ARCHIVO DE CONFIGURACION' para el MICROSERVICIO: 'department-service', se manejara en la ruta del 'GITHUB': '/department-service.properties' 

Los LINKs [GET] son:

1. consultarDepartamentosAll: [http://capacitacion.microservicios.department/departmentservice/get/departamentos]
   http://capacitacion.microservicios.department/departmentservice/get/departamentos

2. consultarDepartamentosPorId: [http://capacitacion.microservicios.department/departmentservice/get/departamentos/{id}]  
   http://capacitacion.microservicios.department/departmentservice/get/departamentos/1
   
3. consultarDepartamentosPorOrganizacion: [http://capacitacion.microservicios.department/departmentservice/get/organizaciones/{organizationId}/departamentos]   
   http://capacitacion.microservicios.department/departmentservice/get/organizaciones/1/departamentos

4. consultarDepartamentosConEmpleadosPorOrganizacion: [http://capacitacion.microservicios.department/departmentservice/get/organizaciones/{organizationId}/departamentos/empleados]   
   http://capacitacion.microservicios.department/departmentservice/get/organizaciones/1/departamentos/empleados 


DETALLE:
-------
 
Para DETALLES del MICROSERVICIO, apoyarse en ACTUATOR ingresando a: 'http://capacitacion.microservicios.department/actuator'

 