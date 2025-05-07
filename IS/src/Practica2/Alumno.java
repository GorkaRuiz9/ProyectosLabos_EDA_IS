package Practica2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Alumno {

	private String nombre;
	private String apellido;
	private String mail;
	private double notaExamen;
	private String pais;
	private List<Entregable> lEntregables = new ArrayList<Entregable>() ;

	public Alumno(String pNombre, String pApellido, String pMail,  String pPais)
	{
		nombre = pNombre;
		apellido = pApellido;
		mail = pMail;
		pais = pPais;
		
	}
	////////////////////GETTERS/////////////////////////
	public String getNombre()
	{
		return nombre;
	}
	public String getApellido()
	{
		return apellido;
	}
	
	public String getPais()
	{
		return pais;
	}
	
	//////////////////////////////////////////////
	
	public void setNotaExamen(double pNotaExamen)
	{
		notaExamen = pNotaExamen;
	}
	
	public void addEntregable(Entregable pEnt)
	{
		lEntregables.add(pEnt);
	}
	
	public boolean haSuspendido() {
		return calcularNotaFinal()<5;  
	}
	
	public boolean haAprobado() {
		return calcularNotaFinal()>=5;  
	}
	
	public String toString()
	{
		return "nombre: " + nombre + " " + apellido + ", mail:" + mail; 
	}
	
	////////////////////////////JAVA7////////////////////////////////
	private Iterator<Entregable> obtIterador()
	{
		return lEntregables.iterator();
	}
	
	//Debereis modificarlo y usar las herramientas que nos proporciona Java8
	public double calcularNotaEntregables()
	{
		return this.lEntregables.stream()
		.mapToDouble(Entregable::getNota)
		.average()
		.orElseGet(null);
	}
	
	//Debereis modificarlo y usar las herramientas que nos proporciona Java8
	public double calcularNotaFinal()
	{
		double notaFinal = 0;		
		
		notaFinal = calcularNotaEntregables()*0.6 + notaExamen*0.4;		
		
		return notaFinal;
	}	
	
	public boolean haAprobadoTodosLosEntregables()
	{
		return lEntregables.stream().allMatch(Entregable->Entregable.getNota()>5);
	}
	
	public boolean superaNotaEnEntregable(int pNota)
	{
		return lEntregables.stream().anyMatch(Entregable -> Entregable.getNota()>pNota);
	}
	
}
