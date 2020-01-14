package pe.com.capacitacion.service;

import java.util.ArrayList; 
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand; 
import pe.com.capacitacion.bean.Auditoria;
import pe.com.capacitacion.bean.ConfigurationData_01;
import pe.com.capacitacion.bean.Departamento;
import pe.com.capacitacion.bean.Empleado;
import pe.com.capacitacion.bean.ResponseMsg; 
import pe.com.capacitacion.exception.AuditoriaException;
import pe.com.capacitacion.repository.DepartamentoRepository;
import pe.com.capacitacion.util.Constantes;

/**
 * EmpleadoService
 * @author cguerra
 **/
 @Service
 public class DepartamentoService extends AuditoriaException{
		
		private static final Logger LOGGER = LoggerFactory.getLogger( DepartamentoService.class );
	 
		@Autowired
		private DepartamentoRepository objRepositorio;  
		
		@Autowired
		private Constantes constantes; 
		
		@Autowired
		private ConfigurationData_01 objConfigurationData01;  //ACCESO: inicia con [grupoconfig01]  		 
	  		
		@Autowired
		private RestTemplateBuilder objTemplate;  
		
		@Autowired
		private EurekaClient objClient;
		  
		@Autowired
		private AuditoriaException objAuditoriaException; 	
 
	   /**	
	    * agregarDepartamentoService	
	    * @param  departamento
	    * @return ResponseMsg
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarExceptionWS" )   //ANTE UNA FALLA LANZARPA EL MÉTODO: [lanzarExceptionWS].
		public ResponseMsg agregarDepartamentoService( @RequestBody Departamento departamento ){
			   LOGGER.info( "-----> Departamento 'agregarDepartamentoService': {}", departamento );
			   
			   ResponseMsg objResponseMsg = new ResponseMsg();
			   
			   String vNombreServicio = this.constantes.nombreServicio; 
			   String vValor_01       = this.constantes.valor01; 
			   String vNombres        = this.objConfigurationData01.getNombres();
			   String vDni            = this.objConfigurationData01.getDni(); 		
			   LOGGER.info( "vNombreServicio: [" + vNombreServicio + "], vValor_01: [" + vValor_01 + "], vNombres: [" + vNombres + "], vDni: [" + vDni + "]" ); 
			   
			   this.objRepositorio.agregarDepartamento( departamento );  
			   Auditoria objAuditoria = this.objAuditoriaException.cargarDatosAuditoria( this.constantes.IP_APP, this.constantes.nombreServicio, this.constantes.USUARIO_APP, this.constantes.MSJ_APP_OK ); 
  
			   //Agregando: 
			   objResponseMsg.setListaDepartamentos( new ArrayList<Departamento>() );
			   objResponseMsg.setAuditoria( objAuditoria );
			   
			   return objResponseMsg; 
		}
				
	   /**
		* consultarDepartamentosAllService	
		* @return List<Departamento>
		**/ 
		@HystrixCommand( fallbackMethod = "lanzarListaExceptionWS" )   //ANTE UNA FALLA LANZARPA EL MÉTODO: [lanzarListaExceptionWS].
		public ResponseMsg consultarDepartamentosAllService(){ 
			   LOGGER.info( "-----> Departmento 'consultarDepartamentosAllService'" );
			   
			   ResponseMsg objResponseMsg = new ResponseMsg(); 
			   
			   String vNombreServicio = this.constantes.nombreServicio; 
			   String vValor_01       = this.constantes.valor01; 
			   String vNombres        = this.objConfigurationData01.getNombres();
			   String vDni            = this.objConfigurationData01.getDni(); 		
			   LOGGER.info( "vNombreServicio: [" + vNombreServicio + "], vValor_01: [" + vValor_01 + "], vNombres: [" + vNombres + "], vDni: [" + vDni + "]" ); 
			   
			   List<Departamento> listaDepartamentos = this.objRepositorio.consultarDepartamentosAll(); 
			   Auditoria          objAuditoria       = this.objAuditoriaException.cargarDatosAuditoria( this.constantes.IP_APP, this.constantes.nombreServicio, this.constantes.USUARIO_APP, this.constantes.MSJ_APP_OK ); 

			   //Agregando: 
			   objResponseMsg.setListaDepartamentos( listaDepartamentos );
			   objResponseMsg.setAuditoria( objAuditoria );
			   
			   return objResponseMsg; 
		}
				
	   /**
	    * consultarDepartamentosPorIdService	
	    * @param  id
	    * @return ResponseMsg
	    **/  
		@HystrixCommand( fallbackMethod = "lanzarExceptionWS" )   //ANTE UNA FALLA LANZARPA EL MÉTODO: [lanzarExceptionWS].
		public ResponseMsg consultarDepartamentosPorIdService( Long id ){ 
			   LOGGER.info( "-----> Departamento 'consultarDepartamentosPorIdService': id={}", id );
			   
		       ResponseMsg objResponseMsg = new ResponseMsg(); 
		       
			   String vNombreServicio = this.constantes.nombreServicio; 
			   String vValor_01       = this.constantes.valor01; 
			   String vNombres        = this.objConfigurationData01.getNombres();
			   String vDni            = this.objConfigurationData01.getDni(); 		
			   LOGGER.info( "vNombreServicio: [" + vNombreServicio + "], vValor_01: [" + vValor_01 + "], vNombres: [" + vNombres + "], vDni: [" + vDni + "]" ); 
			   
			   Departamento objDepartamento = this.objRepositorio.consultarDepartamentosPorId( id );  
		       Auditoria    objAuditoria    = this.objAuditoriaException.cargarDatosAuditoria( this.constantes.IP_APP, this.constantes.nombreServicio, this.constantes.USUARIO_APP, this.constantes.MSJ_APP_OK );
						
			   List<Departamento> listaDepartamento = new ArrayList<Departamento>();
			   listaDepartamento.add( objDepartamento );
			
			   //Agregando: 
		       objResponseMsg.setListaDepartamentos( listaDepartamento ); 
		       objResponseMsg.setAuditoria( objAuditoria );
		   
		       return objResponseMsg; 
		}		
			
	   /**
	    * consultarDepartamentosPorOrganizacionService	
	    * @param  organizationId
	    * @return ResponseMsg
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarListaExceptionWS" )   //ANTE UNA FALLA LANZARPA EL MÉTODO: [lanzarListaExceptionWS].
		public ResponseMsg consultarDepartamentosPorOrganizacionService( Long organizationId ){
			   LOGGER.info( "-----> Departamento 'consultarDepartamentosPorOrganizacionService': organizationId={}", organizationId );
			   
		       ResponseMsg objResponseMsg = new ResponseMsg();
		       
			   String vNombreServicio = this.constantes.nombreServicio; 
			   String vValor_01       = this.constantes.valor01; 
			   String vNombres        = this.objConfigurationData01.getNombres();
			   String vDni            = this.objConfigurationData01.getDni(); 		
			   LOGGER.info( "vNombreServicio: [" + vNombreServicio + "], vValor_01: [" + vValor_01 + "], vNombres: [" + vNombres + "], vDni: [" + vDni + "]" ); 
			   
			   List<Departamento> listaDepartamentos = this.objRepositorio.consultarDepartamentosPorOrganizacion( organizationId ); 
			   Auditoria          objAuditoria       = this.objAuditoriaException.cargarDatosAuditoria( this.constantes.IP_APP, this.constantes.nombreServicio, this.constantes.USUARIO_APP, this.constantes.MSJ_APP_OK );
				
			   //Agregando: 
		       objResponseMsg.setListaDepartamentos( listaDepartamentos ); 
		       objResponseMsg.setAuditoria( objAuditoria );
		   
		       return objResponseMsg; 
		}
		
	   /**
	    * consultarPorOrganizacionConEmpleadosService	
	    * @param  organizationId 
	    * @return ResponseMsg
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarListaExceptionWS" )   //ANTE UNA FALLA LANZARPA EL MÉTODO: [lanzarListaExceptionWS].
		public ResponseMsg consultarPorOrganizacionConEmpleadosService( Long organizationId ){ 
			   LOGGER.info( "-----> Departamento 'consultarPorOrganizacionConEmpleados': organizationId={}", organizationId);
			   
			   String vNombreServicio = this.constantes.nombreServicio; 
			   String vValor_01       = this.constantes.valor01; 
			   String vNombres        = this.objConfigurationData01.getNombres();
			   String vDni            = this.objConfigurationData01.getDni(); 		
			   LOGGER.info( "vNombreServicio: [" + vNombreServicio + "], vValor_01: [" + vValor_01 + "], vNombres: [" + vNombres + "], vDni: [" + vDni + "]" ); 
			    
			   RestTemplate objRspTmp = this.objTemplate.build(); 
 		 
			   InstanceInfo vIdIstanciaEureka_01 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_01, false );
			   InstanceInfo vIdIstanciaEureka_02 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_02, false );			   
			   LOGGER.info( "========>: vIdIstanciaEureka_01 [" + vIdIstanciaEureka_01 + "]" );			   
			   LOGGER.info( "========>: vIdIstanciaEureka_02 [" + vIdIstanciaEureka_02 + "]" );
			   
			   String  vURLInst01  = vIdIstanciaEureka_01.getHomePageUrl(); 
			   String  vURLInst02  = vIdIstanciaEureka_02.getHomePageUrl(); 
			   LOGGER.info( "========>: vURLInst01 [" + vURLInst01 + "]" );
			   LOGGER.info( "========>: vURLInst02 [" + vURLInst02 + "]" );			   
			   
			   String vURL01 = (vURLInst01 + Constantes.SERVICE_NAME_01 + "/" + Constantes.HTTP_METHOD_01 + "/organizaciones/" + organizationId + "/departamentos"); 
			   LOGGER.info( "========>: vURL01 [" + vURL01 + "]" );
			   
			   String vCadenaJSON_01 = objRspTmp.getForObject( vURL01, String.class );
			   LOGGER.info( "========>: vCadenaJSON_01 [" + vCadenaJSON_01 + "]" ); 
			   
			   Gson objGson = new Gson();		
			   pe.com.capacitacion.bean.ResponseMsg objResponseMsg = objGson.fromJson( vCadenaJSON_01, pe.com.capacitacion.bean.ResponseMsg.class );
			   LOGGER.info( "========>: objResponseMsg: " + objResponseMsg ); 
		 
			   pe.com.capacitacion.bean.ResponseMsgEmp objResponseMsgEmp = null;
			   List<Departamento> listaDepartamento = objResponseMsg.getListaDepartamentos(); 
			   LOGGER.info( "========>: listaDepartamento TAMANIO: [" + listaDepartamento.size() + "]" ); 
			   
			   Departamento   objDepTemp = null;
			   long           vIdDepTemp = 0;		 
			   List<Empleado> listaEmpleadoTemp = null;
			   
			   for( int i=0; i<listaDepartamento.size(); i++ ){
				    objDepTemp = listaDepartamento.get( i );				    
				    vIdDepTemp = objDepTemp.getId(); 

				    String vURL02 = (vURLInst02 + Constantes.SERVICE_NAME_02 + "/" + Constantes.HTTP_METHOD_01 + "/departamentos/" + vIdDepTemp + "/empleados"); 
				    LOGGER.info( "========>: vURL02 [" + vURL02 + "]" );
				    
				    String vCadenaJSON_02 = objRspTmp.getForObject( vURL02, String.class );
				    LOGGER.info( "========>: vCadenaJSON_02 [" + vCadenaJSON_02 + "]" ); 
				    
				    objResponseMsgEmp = objGson.fromJson( vCadenaJSON_02, pe.com.capacitacion.bean.ResponseMsgEmp.class );
				    LOGGER.info( "========>: objResponseMsgEmp: " + objResponseMsgEmp );
				    
				    listaEmpleadoTemp = objResponseMsgEmp.getListaEmpleados();  
				    LOGGER.info( "========>: listaEmpleadoTemp: " + listaEmpleadoTemp.size() );
				    
				    //AGREGANDO:
				    objDepTemp.setListaEmpleados( listaEmpleadoTemp );
			   } 
		  
			   List<Departamento> listaDepartamentoTemp = new ArrayList<Departamento>(); 
			   listaDepartamentoTemp.add( objDepTemp ); 
			   Auditoria objAuditoria = this.objAuditoriaException.cargarDatosAuditoria( this.constantes.IP_APP, this.constantes.nombreServicio, this.constantes.USUARIO_APP, this.constantes.MSJ_APP_OK ); 
			   
			   //Agregando: 
			   objResponseMsg.setListaDepartamentos( listaDepartamentoTemp );
			   objResponseMsg.setAuditoria( objAuditoria );
			   			   
			   return objResponseMsg; 
		} 
		
 }
 
