package pe.com.capacitacion.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List; 
import com.fasterxml.jackson.annotation.JsonRootName; 

/**
 * ResponseMsgEmp
 * @author cguerra
 **/  
 @JsonRootName( value = "ResponseMsgEmp" ) 
 public class ResponseMsgEmp implements Serializable{
  
	    private static final long serialVersionUID = 6401011924888715619L;
	
		private Auditoria      auditoria;
		private List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		
		public Auditoria getAuditoria() {
			return auditoria;
		}
		
		public void setAuditoria(Auditoria auditoria) {
			this.auditoria = auditoria;
		}
		
		public List<Empleado> getListaEmpleados() {
			return listaEmpleados;
		}
		
		public void setListaEmpleados(List<Empleado> listaEmpleados) {
			this.listaEmpleados = listaEmpleados;
		}
		
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "ResponseMsgEmp [auditoria=" + this.auditoria + ", listaEmpleados=" + this.listaEmpleados + "]";
		}   
		
 }

 