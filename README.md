

IMPORTANTE:
----------
El 'ARCHIVO DE CONFIGURACION' para el MICROSERVICIO: 'department-service', se manejara en la ruta del 'GITHUB': '/department-service.properties' 

Los LINKs [GET] son:

1. consultarDepartamentosAll: [http://localhost:8091/departmentservice/get/departamentos]
   http://localhost:8091/departmentservice/get/departamentos

2. consultarDepartamentosPorId: [http://localhost:8091/departmentservice/get/departamentos/{id}]  
   http://localhost:8091/departmentservice/get/departamentos/1
   
3. consultarDepartamentosPorOrganizacion: [http://localhost:8091/departmentservice/get/organizaciones/{organizationId}/departamentos]   
   http://localhost:8091/departmentservice/get/organizaciones/1/departamentos

4. consultarDepartamentosConEmpleadosPorOrganizacion: [http://localhost:8091/departmentservice/get/organizaciones/{organizationId}/departamentos/empleados]   
   http://localhost:8091/departmentservice/get/organizaciones/1/departamentos/empleados 


DETALLE:
-------

1. FEIGN:        Permite consumir WebService REST, apuntando directamente al 'NOMBRE' del WebService & 'URI' respectivamente, por medio de una Interface.
2. EUREKACLIENT: Permite consumir WebService REST, apuntando directamente al 'ID' de EUREKA del WebService registrado en el.

 
Para DETALLES del MICROSERVICIO, apoyarse en ACTUATOR ingresando a: 'http://localhost:8091/actuator'

 