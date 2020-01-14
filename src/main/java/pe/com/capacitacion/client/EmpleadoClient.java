package pe.com.capacitacion.client;
 
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.com.capacitacion.bean.ResponseMsg;

/**
 * EmpleadoClient
 * @author cguerra
 **/
 @FeignClient( name = "employee-service" )
 public interface EmpleadoClient{
       
	   /**
	    * consultarEmpleadosPorDepartamento 
	    * @param  departmentId
	    * @return List<Empleado>
	    **/
	    @GetMapping( "/employeeservice/get/departamentos/{id}/empleados" )
	    public ResponseMsg consultarEmpleadosPorDepartamento( @PathVariable( "id" ) Long departmentId ); 
	  
 }
