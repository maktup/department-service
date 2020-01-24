package pe.com.capacitacion.controller;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.capacitacion.bean.Departamento;
import pe.com.capacitacion.bean.ResponseMsg;
import pe.com.capacitacion.service.DepartamentoService;
import pe.com.capacitacion.util.UtilJeager;

/**
 * DepartmentoController
 * @author cguerra
 **/
 @RestController
 @RequestMapping( "/departmentservice" )
 public class DepartamentoController extends UtilJeager{
	
		private static final Logger LOGGER = LoggerFactory.getLogger( DepartamentoController.class );
 
		@Autowired
		private DepartamentoService objDepartamentoService; 
 
	   /**
	    * agregarDepartamento	
	    * @param  departamento
	    * @return ResponseMsg
	    **/
		@PostMapping( "/post/departamentos" )
		public ResponseMsg agregarDepartamento( @RequestBody Departamento departamento ){
			   LOGGER.info( "-----> Departamento 'agregarDepartamento': {}", departamento ); 
			   this.jaegerAlertTracer(); 
			   
			   //Ejecutar: 
			   ResponseMsg objResponseMsg = this.objDepartamentoService.agregarDepartamentoService( departamento );  
			   return objResponseMsg; 
		}	
		
		/**
		 * consultarDepartamentosAll	
		 * @return ResponseMsg
		 **/
		@GetMapping( "/get/departamentos" )
		public ResponseMsg consultarDepartamentosAll(){ 
			   LOGGER.info( "-----> Departmento 'consultarDepartamentosAll'" );
			   this.jaegerAlertTracer(); 
			   
			   //Ejecutar: 
			   ResponseMsg objResponseMsg = this.objDepartamentoService.consultarDepartamentosAllService(); 	 
			   return objResponseMsg; 
		}
		
	   /**
	    * consultarDepartamentosPorId	
	    * @param  id
	    * @return ResponseMsg
	    **/ 
		@GetMapping( "/get/departamentos/{id}" )
		public ResponseMsg consultarDepartamentosPorId( @PathVariable( "id" ) Long id ){ 
			   LOGGER.info( "-----> Departamento 'consultarDepartamentosPorId': id={}", id );
			   this.jaegerAlertTracer(); 
			   
			   //Ejecutar: 
			   ResponseMsg objResponseMsg = this.objDepartamentoService.consultarDepartamentosPorIdService( id ); 
			   return objResponseMsg; 
		}		
		
	   /**
	    * consultarDepartamentosPorOrganizacion	
	    * @param  organizationId
	    * @return ResponseMsg
	    **/
		@GetMapping( "/get/organizaciones/{organizationId}/departamentos" )
		public ResponseMsg consultarDepartamentosPorOrganizacion( @PathVariable( "organizationId" ) Long organizationId ){
			   LOGGER.info( "-----> Departamento 'consultarDepartamentosPorOrganizacion': organizationId={}", organizationId );
			   this.jaegerAlertTracer(); 
			   
			   //Ejecutar:  
			   ResponseMsg objResponseMsg = this.objDepartamentoService.consultarDepartamentosPorOrganizacionService( organizationId ); 
			   return objResponseMsg; 
		}
	   
	   /**
	    * consultarDepartamentosConEmpleadosPorOrganizacion	
	    * @param  organizationId 
	    * @return ResponseMsg
	    **/ 
		@GetMapping( "/get/organizaciones/{organizationId}/departamentos/empleados" )
		public ResponseMsg consultarDepartamentosConEmpleadosPorOrganizacion( @PathVariable( "organizationId" ) Long organizationId ){ 
			   LOGGER.info( "-----> Departamento 'consultarPorOrganizacionConEmpleados': organizationId={}", organizationId);
			   
			   //Ejecutar:  
			   ResponseMsg objResponseMsg = this.objDepartamentoService.consultarPorOrganizacionConEmpleadosService( organizationId ); 
			   return objResponseMsg; 
		}
 	
 }

 