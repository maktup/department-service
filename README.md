

IMPORTANTE:
----------
* CONSIDERAR que los DNS, deben estar registrados en el archivo HOST del S.O (Las IPs manejadas deben de ser FIJAS). 
* La 'ARCHIVO DE CONFIGURACION' para el MICROSERVICIO: 'department-service', se manejara por medio de los SCRIPTs:

  - 1_department-service_[ConfigMap-Secret].yml
  - 2_department-service_[Deployment-Service].yml
  
* Dentro del SCRIPT: 'DOCKERFILE' se estan manejando tambien 'VARIABLES DE ENTORNO' para algunos requerimientos en el MICROSERVICIO.  


SWAGGER:
--------
CREAR EL 'CONTRADO/API' ONLINE USANDO:
http://editor.swagger.io/

UNA VEZ DESPLEGADO EL 'MICROSERVICIO' ACCEDER A:  
http://capacitacion.microservicios.department/swagger-ui.html


Los LINKs del 'MICROSERVICIO' son:
---------------------------------

  1. Las 'URI' de tipo [GET] son:
     ---------------------------
  
     - consultardepartamentosAll: 
	   http://capacitacion.microservicios.department/departmentservice/get/departamentos
	
     - consultardepartamentosPorId:   
	   http://capacitacion.microservicios.department/departmentservice/get/departamentos/1
	                                                                  
     - consultardepartamentosPorDepartamento:   
	   http://capacitacion.microservicios.department/departmentservice/get/departamentos-organizacion/1
 
 
  2. Las 'URI' de tipo [POST] son:
     ----------------------------
     
     - agregarDepartamento:   
	   http://capacitacion.microservicios.department/departmentservice/post/departamentos
 
	   {    
		 "nombre": "RRHH",  
		  
	     "idOrg":  "1" 
	   }
 
 
  3. Las 'URI' de tipo [DELETE] son:
     ------------------------------
 
     - eliminarDepartamento:   
	   http://capacitacion.microservicios.department/departmentservice/delete/departamentos/1


DETALLE:
------- 
* Para INFORMACIÓN interna del MICROSERVICIO, apoyarse en ACTUATOR ingresando a: 'http://capacitacion.microservicios.department/actuator'
* Para acceder a 'PHOMETHEUS' acceder por medio de ACTUATOR asi: 'http://capacitacion.microservicios.department/actuator/prometheus'

 