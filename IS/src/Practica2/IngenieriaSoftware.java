package Practica2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class IngenieriaSoftware {
	
	private static IngenieriaSoftware mIngenieriaSoftware;
	private List<Alumno> lMatriculados = new ArrayList<Alumno>();
	
	private IngenieriaSoftware(){}
	
	public static IngenieriaSoftware getIngenieriaSoftware()
	{
		if(mIngenieriaSoftware==null)
		{
			mIngenieriaSoftware = new IngenieriaSoftware();
		}
		return mIngenieriaSoftware;
	}
	
	public void addAlumno(Alumno pAl)
	{
		lMatriculados.add(pAl);
	}	
	
	////////////////////////////JAVA7////////////////////////////////
	private Iterator<Alumno> obtIterador()
	{
		return lMatriculados.iterator();
	}	
	
	public void mostrarNotasTotales()
	{
		lMatriculados.stream()
		.mapToDouble(Alumno::calcularNotaFinal)
		.forEach(System.out::println);
	}
	
	public List<Alumno> obtenerAlumnosSuspendidos()
	{
		return lMatriculados.stream()
		.filter(Alumno::haSuspendido)
		.toList();
	}	
	
	public List<Alumno> obtenerAlumnosAprobadosPorNombre()
	{
		return lMatriculados.stream()
		.filter(Alumno::haAprobado)
		.sorted(Comparator.comparing(Alumno::getNombre))
		.toList();
	}

	public List<Alumno> obtenerAlumnosAprobadosPorNombreYApellido()
	{
		return lMatriculados.stream()
		.filter(Alumno::haAprobado)
		.sorted(Comparator.comparing(Alumno::getNombre).thenComparing(Alumno::getApellido))
		.toList();
	}
	
	public double obtenerPorcentajeAprobados()
	{
		double todos=lMatriculados.stream().count();
		double aprobados=lMatriculados.stream().filter(Alumno::haAprobado).count();
		
		return (aprobados/todos)*100;
		
	}
	
	public List<String> obtenerPaisesRepresentados()
	{
		return lMatriculados.stream().map(Alumno::getPais).distinct().toList();
	}
	
	public List<Alumno> obtenerAlumnosTodosEntregablesAprobados()
	{
		return lMatriculados.stream().filter(Alumno::haAprobadoTodosLosEntregables).toList();
	}
	
	public List<Alumno> obtenerAlumnosQueSuperanNotaEnEntregable(int pNota) 
	{
		return lMatriculados.stream().filter(Alumno -> Alumno.superaNotaEnEntregable(pNota)).toList();
	}
	
	public Map<Boolean,List<Alumno>> obtenerAprobadosSuspendidos()
	{
		return lMatriculados.stream().collect(Collectors.partitioningBy(Alumno::haAprobado));
	}
	
	public Map<String,Double> obtenerNotaMediaPorPaises()
	{
		return lMatriculados.stream().collect(Collectors.groupingBy(Alumno::getPais,Collectors.averagingDouble(Alumno::calcularNotaFinal)));
	}
	
	public void imprimirEstadisticasAlumnos()
	{
		DoubleSummaryStatistics estadisticas=lMatriculados.stream().mapToDouble(Alumno::calcularNotaFinal).summaryStatistics();
		System.out.print("Nota max: "+estadisticas.getMax());
		System.out.print("\nNota min: "+estadisticas.getMin());
		System.out.print("\nNota media: "+estadisticas.getAverage());
	}
	
	public Map<String,List<Alumno>> obtenerAlumnosPorPais()
	{
		return lMatriculados.stream().collect(Collectors.groupingBy(Alumno::getPais));
	}
	
	public Map<String,Double> obtenerNotasEntrMediasPorPais ()
	{
		return lMatriculados.stream().collect(Collectors.groupingBy(Alumno::getPais,Collectors.averagingDouble(Alumno::calcularNotaEntregables)));
	}
	
	public Map<String,Alumno> obtenerAlumnoConNotaMaxPorPais()
	{
		return lMatriculados.stream()
			    .collect(Collectors.collectingAndThen(
			        Collectors.groupingBy(Alumno::getPais),
			        mapa -> mapa.entrySet().stream()
			                    .collect(Collectors.toMap(
			                        Map.Entry::getKey,
			                        entry -> entry.getValue().stream()
			                                    .max(Comparator.comparingDouble(Alumno::calcularNotaFinal))
			                                    .orElse(null)
			                    ))
			    ));

	}
	
	public Map<String,Double> obtenerNotaMaxPorPais()
	{
		return lMatriculados.stream()
			    .collect(Collectors.collectingAndThen(
			        Collectors.groupingBy(Alumno::getPais),
			        mapa -> mapa.entrySet().stream()
			                    .collect(Collectors.toMap(
			                        Map.Entry::getKey,
			                        entry -> entry.getValue().stream()
			                                    .mapToDouble(Alumno::calcularNotaFinal)
			                                    .max()
			                                    .orElse(Double.NaN)
			                    ))
			    ));

	}
	
}
