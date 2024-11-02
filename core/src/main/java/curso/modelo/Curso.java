package curso.modelo;

import curso.exception.ExceptionCurso;

import java.time.LocalDate;
import java.util.UUID;

public class Curso {
   private UUID id;
   private String name;
   private LocalDate fecha_cierre_inscripcion;
   private Level nivel;

   private Curso(UUID id, String name, LocalDate fecha_cierre_inscripcion, Level nivel) {
       this.id = id;
       this.name = name;
       this.fecha_cierre_inscripcion = fecha_cierre_inscripcion;
       this.nivel = nivel;
   }

   public static Curso factory(UUID id, String name, LocalDate fecha_cierre_inscripcion, Level nivel) throws ExceptionCurso{
       if (id == null )
               throw new ExceptionCurso("id nulo");
       if (name ==null || name.isEmpty())
               throw new ExceptionCurso("nombre nulo");
       if (fecha_cierre_inscripcion == null  || fecha_cierre_inscripcion.isBefore(LocalDate.now()))
               throw new ExceptionCurso("fecha_cierre_inscripcion no valida");
       if (nivel == null)
           throw new ExceptionCurso("nivel nulo ");
       return new Curso(id, name, fecha_cierre_inscripcion, nivel);
   }

   public UUID getId() {
       return id;
   }

   public String getName() {
       return name;
   }
   public LocalDate getFecha_cierre_inscripcion() {
       return fecha_cierre_inscripcion;
   }
   public Level getNivel() {
       return nivel;
   }
}
