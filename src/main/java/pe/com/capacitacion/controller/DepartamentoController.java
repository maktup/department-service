package pe.com.capacitacion.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import pe.com.capacitacion.bean.Departamento;
import pe.com.capacitacion.dto.ResponseDepMsg; 
import pe.com.capacitacion.service.DepartamentoService; 

/**
 * DepartmentoController
 * @author cguerra
 **/
 @Slf4j      //Autogenerar LOG4J.
 @RestController
 @RequestMapping( "/departmentservice" ) //NO USAR: [server.servlet.context-path], 'BOOT-ADMIN' reconocera el 'ACTUATOR'.
 @Api( value="DepartamentoController", description="'CONTRATO/API' para la gestion de 'DEPARTAMENTO'." )
 public class DepartamentoController{
 
		@Autowired
		private DepartamentoService objDepartamentoService; 
 
		
	   /**
	    * agregarDepartamento	
	    * @param  departamento
	    * @return ResponseEntity<ResponseDepMsg>
	    **/
		@PostMapping( "/post/departamentos" )
	    @ApiOperation( value="Funcionalidad para [CREAR] una ENTIDAD de tipo Departamento.", nickname="agregarDepartamento", notes="Funcionalidad para [CREAR] una ENTIDAD de tipo Empleado." )
		public ResponseEntity<ResponseDepMsg> agregarDepartamento( @RequestBody Departamento departamento ){
			   log.info( "-----> Departamento 'agregarDepartamento': {}", departamento ); 
 
			   //Ejecutar: 
			   ResponseEntity<ResponseDepMsg> objResponseMsg = this.objDepartamentoService.agregarDepartamentoService( departamento );  
			   return objResponseMsg; 
		}	
	
	   /**
	    * eliminarDepartamento	
	    * @param  id
	    * @return ResponseEntity<ResponseDepMsg>
	    **/
		@DeleteMapping( "/delete/departamentos/{id}" )
	    @ApiOperation( value="Funcionalidad para [ELIMINAR] una ENTIDAD de tipo Departamento por ID.", nickname="eliminarDepartamento", notes="Funcionalidad para [ELIMINAR] una ENTIDAD de tipo Departamento por ID." )
		public ResponseEntity<ResponseDepMsg> eliminarDepartamento( @PathVariable( "id" ) Long id ){ 
			   log.info( "-----> Departamento 'eliminarDepartamento': {}", id ); 
 
			   //Ejecutar: 
			   ResponseEntity<ResponseDepMsg> objResponseMsg = this.objDepartamentoService.eliminarDepartamentoService( id );  
			   return objResponseMsg; 
		}
		
		/**
		 * consultarDepartamentosAll	
		 * @return ResponseEntity<ResponseDepMsg>
		 **/
		@GetMapping( "/get/departamentos" )
	    @ApiOperation( value="Funcionalidad para [CONSULTAR] una ENTIDAD de tipo Departamento completa.", nickname="consultarDepartamentosAll", notes="Funcionalidad para [CONSULTAR] una ENTIDAD de tipo Departamento completa." ) 
		public ResponseEntity<ResponseDepMsg> consultarDepartamentosAll(){ 
			   log.info( "-----> Departmento 'consultarDepartamentosAll'" );
 
			   //Ejecutar: 
			   ResponseEntity<ResponseDepMsg> objResponseMsg = this.objDepartamentoService.consultarDepartamentosAllService(); 
			   return objResponseMsg; 
		}	
		
	   /**
	    * consultarDepartamentosPorId	
	    * @param  id
	    * @return ResponseEntity<ResponseDepMsg>
	    **/ 
		@GetMapping( "/get/departamentos/{id}" )
	    @ApiOperation( value="Funcionalidad para [CONSULTAR] una ENTIDAD de tipo Departamento por ID.", nickname="consultarDepartamentosPorId", notes="Funcionalidad para [CONSULTAR] una ENTIDAD de tipo Departamento por ID." )
		public ResponseEntity<ResponseDepMsg> consultarDepartamentosPorId( @PathVariable( "id" ) Long id ){ 
			   log.info( "-----> Departamento 'consultarDepartamentosPorId': id={}", id );
 
			   //Ejecutar: 
			   ResponseEntity<ResponseDepMsg> objResponseMsg = this.objDepartamentoService.consultarDepartamentosPorIdService( id ); 
			   return objResponseMsg; 
		}		
		
	   /**
	    * consultarDepartamentosPorOrganizacion	
	    * @param  idOrg
	    * @return ResponseEntity<ResponseDepMsg>
	    **/
		@GetMapping( "/get/departamentos-organizacion/{idOrg}" )
	    @ApiOperation( value="Funcionalidad para [CONSULTAR] una ENTIDAD de tipo Departamento por IDORG.", nickname="consultarDepartamentos_x_organizacion", notes="Funcionalidad para [CONSULTAR] una ENTIDAD de tipo Departamento por IDORG." )
		public ResponseEntity<ResponseDepMsg> consultarDepartamentosPorOrganizacion( @PathVariable( "idOrg" ) Long idOrg ){
			   log.info( "-----> Departamento 'consultarDepartamentosPorOrganizacion': idOrg={}", idOrg );
 
			   //Ejecutar:  
			   ResponseEntity<ResponseDepMsg> objResponseMsg = this.objDepartamentoService.consultarDepartamentosPorOrganizacionService( idOrg ); 
			   return objResponseMsg; 
		}
 
 }

 