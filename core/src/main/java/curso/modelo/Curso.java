package curso.modelo;

import curso.exception.ExceptionCurso;

import java.time.LocalDate;

public class Curso {
   private final String id;
   private final String nombre;
   private  final LocalDate fecha_cierre_inscripcion;
   private Level nivel;

   private Curso(String id, String nombre, LocalDate fecha_cierre_inscripcion, Level nivel) {
       this.id = id;
       this.nombre = nombre;
       this.fecha_cierre_inscripcion = fecha_cierre_inscripcion;
       this.nivel = nivel;
   }

   public static Curso factory(String id, String nombre, LocalDate fecha_cierre_inscripcion, Level nivel) throws ExceptionCurso{
       if (id == null || id.isEmpty())
               throw new ExceptionCurso("id nulo");
       if (nombre==null || nombre.isEmpty())
               throw new ExceptionCurso("nombre nulo");
       if (fecha_cierre_inscripcion == null  || fecha_cierre_inscripcion.isAfter(LocalDate.now()))
               throw new ExceptionCurso("fecha_cierre_inscripcion no valida");
       if (nivel == null)
           throw new ExceptionCurso("nivel nulo ");
       return new Curso(id, nombre, fecha_cierre_inscripcion, nivel);
   }

   public String getId() {
       return id;
   }
}
