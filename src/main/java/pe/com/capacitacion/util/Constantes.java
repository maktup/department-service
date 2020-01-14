package pe.com.capacitacion.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Constantes
 * @author cguerra
 **/
 @Component
 public class Constantes{
	    
	    @Value( "${ws.nombre.servicio}" )             //ACCESO: al valor REMOTO [ws.nombre.servicio]
	    public String nombreServicio;
	 
		@Value( "${propiedades.config.valor_01}" )    //ACCESO: [propiedades.config.valor_01:]
		public String valor01; 
	    
		public static String INSTANCIA_EUREKA_01 = "DEPARTMENT-SERVICE";  
		public static String INSTANCIA_EUREKA_02 = "EMPLOYEE-SERVICE"; 
		public static String INSTANCIA_EUREKA_03 = "ORGANIZATION-SERVICE";
		 
		public static String SERVICE_NAME_01 = "departmentservice";  
		public static String SERVICE_NAME_02 = "employeeservice"; 
		public static String SERVICE_NAME_03 = "organizationservice";
		
		public static String HTTP_METHOD_01 = "get";  
		public static String HTTP_METHOD_02 = "post";  
		
		public String IP_APP      = "1.1.1.1";
		public String USUARIO_APP = "RGUERRA";
		public String MSJ_APP_OK  = "PROCESO OK";
		
 }