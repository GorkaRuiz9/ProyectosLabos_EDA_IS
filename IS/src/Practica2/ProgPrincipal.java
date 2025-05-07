package Practica2;

import java.util.List;
import java.util.Map;

public class ProgPrincipal {

	public static void main(String[] args) {
				
		//Alumno1
		Entregable e11 = new Entregable("Entregable1");
		e11.setRespuestaUrl("Respuesta 1");
		e11.setNota(5.4);
		
		Entregable e12 = new Entregable("Entregable2");
		e12.setRespuestaUrl("Respuesta 2");
		e12.setNota(6.8);
		
		Entregable e13 = new Entregable("Entregable3");
		e13.setRespuestaUrl("Respuesta 3");
		e13.setNota(4.6);
		
		Alumno a1 = new Alumno("Markel", "Alberdi" , "markel@ehu.eus", "Suiza");
		a1.setNotaExamen(2.5);
		a1.addEntregable(e11);
		a1.addEntregable(e12);
		a1.addEntregable(e13);
		
		//Alumno2
		Entregable e21 = new Entregable("Entregable1");
		e21.setRespuestaUrl("Respuesta 1");
		e21.setNota(6.0);
		
		Entregable e22 = new Entregable("Entregable2");
		e22.setRespuestaUrl("Respuesta 2");
		e22.setNota(9.3);
		
		Entregable e23 = new Entregable("Entregable3");
		e23.setRespuestaUrl("Respuesta 3");
		e23.setNota(5.6);
		
		Alumno a2 = new Alumno("Maria", "Vaquero", "maria@ehu.eus", "Suiza");
		a2.setNotaExamen(5.5);
		a2.addEntregable(e21);
		a2.addEntregable(e22);
		a2.addEntregable(e23);
		
		//Alumno3
		Entregable e31 = new Entregable("Entregable1");
		e31.setRespuestaUrl("Respuesta 1");
		e31.setNota(4.0);
		
		Entregable e32 = new Entregable("Entregable2");
		e32.setRespuestaUrl("Respuesta 2");
		e32.setNota(5.3);
		
		Entregable e33 = new Entregable("Entregable3");
		e33.setRespuestaUrl("Respuesta 3");
		e33.setNota(5.6);
		
		Alumno a3 = new Alumno("Garazi", "Bikandi", "garazi@ehu.eus", "Suiza");
		a3.setNotaExamen(3.5);
		a3.addEntregable(e31);
		a3.addEntregable(e32);
		a3.addEntregable(e33);		
		
		//Alumno4
		Entregable e41 = new Entregable("Entregable1");
		e41.setRespuestaUrl("Respuesta 1");
		e41.setNota(7.0);
		
		Entregable e42 = new Entregable("Entregable2");
		e42.setRespuestaUrl("Respuesta 2");
		e42.setNota(5.3);
		
		Entregable e43 = new Entregable("Entregable3");
		e43.setRespuestaUrl("Respuesta 3");
		e43.setNota(5.6);
		
		Alumno a4 = new Alumno("Pedro", "Aragon", "pedro@ehu.eus", "Francia");
		a4.setNotaExamen(7.5);
		a4.addEntregable(e41);
		a4.addEntregable(e42);
		a4.addEntregable(e43);
		
		//Alumno5
		Entregable e51 = new Entregable("Entregable1");
		e51.setRespuestaUrl("Respuesta 1");
		e51.setNota(7.0);
		
		Entregable e52 = new Entregable("Entregable2");
		e52.setRespuestaUrl("Respuesta 2");
		e52.setNota(8.3);
		
		Entregable e53 = new Entregable("Entregable3");
		e53.setRespuestaUrl("Respuesta 3");
		e53.setNota(2.6);
		
		Alumno a5 = new Alumno("Angel", "Alonso", "angel@ehu.eus", "Portugal");
		a5.setNotaExamen(6.8);
		a5.addEntregable(e51);
		a5.addEntregable(e52);
		a5.addEntregable(e53);
		
		//Alumno6
		Entregable e61 = new Entregable("Entregable1");
		e61.setRespuestaUrl("Respuesta 1");
		e61.setNota(7.0);
		
		Entregable e62 = new Entregable("Entregable2");
		e62.setRespuestaUrl("Respuesta 2");
		e62.setNota(5.3);
		
		Entregable e63 = new Entregable("Entregable3");
		e63.setRespuestaUrl("Respuesta 3");
		e63.setNota(2.6);
		
		Alumno a6 = new Alumno("Irati", "Alberdi", "irati@ehu.eus", "Portugal");
		a6.setNotaExamen(3.7);
		a6.addEntregable(e61);
		a6.addEntregable(e62);
		a6.addEntregable(e63);
				
		IngenieriaSoftware ing = IngenieriaSoftware.getIngenieriaSoftware();
		ing.addAlumno(a1);
		ing.addAlumno(a2);
		ing.addAlumno(a3);
		ing.addAlumno(a4);
		ing.addAlumno(a5);
		ing.addAlumno(a6);
		
		IngenieriaSoftware is=null;
		
		//Ejer. 1) mostrar notas totales de los alumnos
		
			//is.getIngenieriaSoftware().mostrarNotasTotales();
		
		//Ejer. 2) obtener la lista de los alumnos suspendidos
		
			//List l=is.getIngenieriaSoftware().obtenerAlumnosSuspendidos();
			//l.stream().forEach(System.out::println);

		//Ejer. 3) obtener la lista de los alumnos que han aprobado ordenados por su nombre 

			//List l1=is.getIngenieriaSoftware().obtenerAlumnosAprobadosPorNombre();
			//l1.stream().forEach(System.out::println);
		
		//Ejer. 4) obtener la lista de los alumnos que han aprobado ordenados por su nombre y luego por su apellido
		
			//List l2=is.getIngenieriaSoftware().obtenerAlumnosAprobadosPorNombreYApellido();
			//l2.stream().forEach(System.out::println);

		
		//Ejer. 5) obtener el porcentaje de aprobados de la asignatura
		
			//System.out.print(is.getIngenieriaSoftware().obtenerPorcentajeAprobados());
		
		//Ejer. 6) obtener la lista de los paises representados en clase

			//List l3=is.getIngenieriaSoftware().obtenerPaisesRepresentados();
			//l3.stream().forEach(System.out::println);
				
		//Ejer. 7) obtener la lista de alumnos que han aprobado todos los entregables

			//List l4=is.getIngenieriaSoftware().obtenerAlumnosTodosEntregablesAprobados();
			//l4.stream().forEach(System.out::println);
		
		//Ejer. 8) obtener la lista de alumnos que hayan obtenido en algun entregable una nota superior a la nota introducida

			//List l5=is.getIngenieriaSoftware().obtenerAlumnosQueSuperanNotaEnEntregable(8);
			//l5.stream().forEach(System.out::println);
		
		//Ejer. 9) obtener un mapa con los alumnos aprobados y suspendidos
		
			//Map<Boolean,List<Alumno>> mapa=is.getIngenieriaSoftware().obtenerAprobadosSuspendidos();
			//List<Alumno> aprobados=mapa.get(true);
			//aprobados.stream().forEach(System.out::println);
			//System.out.print("\n");
			//List<Alumno> suspendidos=mapa.get(false);
			//suspendidos.stream().forEach(System.out::println);
		
		//Ejer. 10) obtener un mapa con las notas medias de los alumnos de los distintos paises
		
			//Map<String,Double> mapa2=is.getIngenieriaSoftware().obtenerNotaMediaPorPaises();
			//System.out.print(mapa2.get("Portugal"));
			//System.out.print("\n");
			//System.out.print(mapa2.get("Suiza"));
			//System.out.print("\n");
			//System.out.print(mapa2.get("Francia"));
		
		//Ejer. 11) inprimir estadisticas de la asignatura: la nota maxima, minima y media.
		
			//is.getIngenieriaSoftware().imprimirEstadisticasAlumnos();
			
		//Ejer. 12 obtener la lista de alumnos agrupados por paises en un mapa
		
		
		//Ejer. 12.1 obtener un mapa con la nota media de los alumnos de cada pais
				
				
		//Ejer. 12.2 obtener un mapa con el alumno que ha obtenido la nota mas alta de cada pais

				
		//Ejer. 12.3 obtener un mapa con la nota mas alta de cada pais
			
	}

}
