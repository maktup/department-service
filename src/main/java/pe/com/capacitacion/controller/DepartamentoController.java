package pe.com.capacitacion.controller;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import pe.com.capacitacion.bean.Departamento;
import pe.com.capacitacion.bean.ResponseMsg;
import pe.com.capacitacion.service.DepartamentoService;
import pe.com.capacitacion.util.Constantes;

/**
 * DepartmentoController
 * @author cguerra
 **/
 @RestController
 @RequestMapping( "/departmentservice" )
 public class DepartamentoController{
	
		private static final Logger LOGGER = LoggerFactory.getLogger( DepartamentoController.class );
 
		@Autowired
		private DepartamentoService objDepartamentoService; 
  		
		@Autowired
		private EurekaClient objClient;
		
		@Autowired
		private RestTemplateBuilder objTemplate;
		
	   /**
	    * agregarDepartamento	
	    * @param  departamento
	    * @return ResponseMsg
	    **/
		@PostMapping( "/post/departamentos" )
		public ResponseMsg agregarDepartamento( @RequestBody Departamento departamento ){
			   LOGGER.info( "-----> Departamento 'agregarDepartamento': {}", departamento ); 
 
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
		
		
	   /**
	    * consultarEureka	
	    * @param  organizationId 
	    * @return ResponseMsg
	    **/ 
		@GetMapping( "/info/{nombre}" )
		public String consultarEureka( @PathVariable( "nombre" ) String nombre ){ 
			   LOGGER.info( "-----> Departamento 'consultarEureka': nombre={}", nombre);
			   
			   RestTemplate objRspTmp = this.objTemplate.build();
			   
			   InstanceInfo vIdIstanciaEureka_01 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_01, false );
			   InstanceInfo vIdIstanciaEureka_02 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_02, false );		
			   InstanceInfo vIdIstanciaEureka_03 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_03, false );
			   
			   LOGGER.info( "========>: vIdIstanciaEureka_01 [" + vIdIstanciaEureka_01 + "]" );			   
			   LOGGER.info( "========>: vIdIstanciaEureka_02 [" + vIdIstanciaEureka_02 + "]" );
			   LOGGER.info( "========>: vIdIstanciaEureka_03 [" + vIdIstanciaEureka_03 + "]" );
			   
			   LOGGER.info( "========>: getIPAddr [" + vIdIstanciaEureka_01.getIPAddr() + "]" );			
			   LOGGER.info( "========>: getVIPAddress [" + vIdIstanciaEureka_01.getVIPAddress() + "]" );
			   LOGGER.info( "========>: getHostName [" + vIdIstanciaEureka_01.getHostName() + "]" );
			   
			   String  vURLInst01  = vIdIstanciaEureka_01.getHomePageUrl(); 
			   String  vURLInst02  = vIdIstanciaEureka_02.getHomePageUrl(); 
			   String  vURLInst03  = vIdIstanciaEureka_03.getHomePageUrl(); 
			   LOGGER.info( "========>: vURLInst01 [" + vURLInst01 + "]" );
			   LOGGER.info( "========>: vURLInst02 [" + vURLInst02 + "]" );	
			   LOGGER.info( "========>: vURLInst02 [" + vURLInst03 + "]" );	
 
			   String vURL01 = ( vURLInst01 + Constantes.SERVICE_NAME_01 + "/get/empleados" ); 
			   String vURL02 = ( vURLInst02 + Constantes.SERVICE_NAME_02 + "/get/departamentos" ); 
			   String vURL03 = ( vURLInst03 + Constantes.SERVICE_NAME_03 + "/get/organizaciones" );
			   LOGGER.info( "========>: vURL01 [" + vURL01 + "]" );
			   LOGGER.info( "========>: vURL02 [" + vURL02 + "]" );
			   LOGGER.info( "========>: vURL03 [" + vURL03 + "]" );
			    
			   String vCadenaJSON_01 = objRspTmp.getForObject( vURL01, String.class );
			   LOGGER.info( "========>: vCadenaJSON_01 [" + vCadenaJSON_01 + "]" ); 
			   
			   String vCadenaJSON_02 = objRspTmp.getForObject( vURL02, String.class );
			   LOGGER.info( "========>: vCadenaJSON_02 [" + vCadenaJSON_02 + "]" ); 
			   
			   String vCadenaJSON_03 = objRspTmp.getForObject( vURL03, String.class );
			   LOGGER.info( "========>: vCadenaJSON_03 [" + vCadenaJSON_03 + "]" ); 
			    			   
			   return vIdIstanciaEureka_01 + " - " + vIdIstanciaEureka_02; 
		}
		
 }

 