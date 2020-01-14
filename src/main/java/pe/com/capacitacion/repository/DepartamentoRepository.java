package pe.com.capacitacion.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import pe.com.capacitacion.bean.Departamento;

/**
 * DepartmentoController
 * @author cguerra
 **/
 public class DepartamentoRepository{
	
		private List<Departamento> listaDepartamentos = new ArrayList<Departamento>(); 
		
	   /**
	    * agregarDepartamento	
	    * @param  departamento 
	    **/
		public void agregarDepartamento( Departamento departamento ){ 
			   departamento.setId( (long)( this.listaDepartamentos.size() + 1 ) ); 
			   this.listaDepartamentos.add( departamento ); 
		}
		
	   /**
	    * consultarDepartamentosPorId	
	    * @param  id
	    * @return Departmento
	    **/
		public Departamento consultarDepartamentosPorId( Long id ){
		 	   Optional<Departamento> objOptional     = this.listaDepartamentos.stream().filter( a -> a.getId().equals( id ) ).findFirst(); 
		 	   Departamento           objDepartamento = null;  
		 	   
			   if( objOptional.isPresent() ){
				   objDepartamento = objOptional.get(); 
			   }
			   else{
				    objDepartamento = null;
			   }
			   
			   return objDepartamento; 
		}
		
	   /**
	    * consultarDepartamentosAll	
	    * @return List<Departmento>
	    **/
		public List<Departamento> consultarDepartamentosAll(){
			   return this.listaDepartamentos;
		}
		
	   /**
	    * consultarDepartamentosPorOrganizacion	
	    * @param  organizationId
	    * @return List<Departmento>
	    **/
		public List<Departamento> consultarDepartamentosPorOrganizacion( Long organizationId ){
			   return this.listaDepartamentos.stream().filter( a -> a.getOrganizationId().equals( organizationId ) ).collect( Collectors.toList() ); 
		}
	
 }
 
