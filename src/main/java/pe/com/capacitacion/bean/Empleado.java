package pe.com.capacitacion.bean;

import java.io.Serializable;  
import com.fasterxml.jackson.annotation.JsonRootName; 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor; 

/**
 * Empleado
 * @author cguerra
 **/  
 //@Getter            //Autogenerar GETTERs. 
 //@Setter            //Autogenerar SETTERs. 
 @NoArgsConstructor   //Autogenerar CONTRUCTOR sin parametros. 
 @AllArgsConstructor  //Autogenerar CONTRUCTOR con parametros. 
 @Builder             //Autogenerar BUILDER. 
 @Data                //Autogenerar TOSTRING/GETTERs/SETTERs & otros.
 @JsonRootName( value = "Empleado" ) 
 public class Empleado  implements Serializable{
 
        private static final long serialVersionUID = -7883259734962895249L;

		private Long   id;
		private String nombre;
		private int    edad;
		private String rol;		
		private Long   departmentId;  //REFERENCIA
 
 }

 