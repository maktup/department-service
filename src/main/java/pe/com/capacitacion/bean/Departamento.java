package pe.com.capacitacion.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
/**
 * Departmento
 * @author cguerra
 **/  
 public class Departamento implements Serializable{
  
	    private static final long serialVersionUID = -6779514596861036035L;
	
		private Long   id;
		private Long   organizationId;
		private String nombre;
		private List<Empleado> listaEmpleados = new ArrayList<Empleado>(); 
 

		public Departamento(){			
		}
	    
		public Departamento( Long organizationId, String nombre ){
			   super();
			   this.organizationId = organizationId;
			   this.nombre         = nombre;
		}
		
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
 
		public Long getId() {
			   return id;
		}

		public void setId(Long id) {
			   this.id = id;
		}

		public Long getOrganizationId() {
			   return organizationId;
		}

		public void setOrganizationId(Long organizationId) {
			   this.organizationId = organizationId;
		}

		public String getNombre() {
			   return nombre;
		}

		public void setNombre(String nombre) {
			   this.nombre = nombre;
		}

		public List<Empleado> getListaEmpleados() {
			   return listaEmpleados;
		}

		public void setListaEmpleados(List<Empleado> listaEmpleados) {
			   this.listaEmpleados = listaEmpleados;
		}
 
		@Override
		public String toString() {
			   return "Departmento [id=" + this.id + ", this.organizationId=" + this.organizationId + ", nombre=" + this.nombre + ", listaEmpleados=" + this.listaEmpleados + "]";
		}
      
 }

 