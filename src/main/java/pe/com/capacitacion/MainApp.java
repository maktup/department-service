package pe.com.capacitacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import pe.com.capacitacion.bean.Departamento;
import pe.com.capacitacion.repository.DepartamentoRepository;

/**
 * MainApp
 * @author cguerra
 **/
 @SpringBootApplication
 @EnableDiscoveryClient     //IMPORTANTE: 'EUREKA CLIENT' 
 @EnableHystrix             //IMPORTANTE: 'HYSTRIX' 
 @EnableFeignClients        //IMPORTANTE: 'FEIGN CLIENT'
 public class MainApp{
	
	    public static void main( String[] argumentos ){
		 	   SpringApplication.run( MainApp.class, argumentos );
	    }
	 
	   /**
	    * repository  
	    * @return DepartamentoRepository 
	    **/
	    @Bean
	    public DepartamentoRepository repository(){
			   DepartamentoRepository objRepositorio = new DepartamentoRepository();
			
			   objRepositorio.agregarDepartamento( new Departamento( 1L, "DESARROLLO"  ) );
			   objRepositorio.agregarDepartamento( new Departamento( 1L, "OPERACIONES" ) );
			   objRepositorio.agregarDepartamento( new Departamento( 2L, "DESARROLLO"  ) );
			   objRepositorio.agregarDepartamento( new Departamento( 2L, "OPERACIONES" ) );	
			
			   return objRepositorio;
	    }
	
 }

