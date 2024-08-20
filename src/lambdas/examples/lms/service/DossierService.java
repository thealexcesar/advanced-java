package lambdas.examples.lms.service;

import lambdas.examples.lms.domain.Course;
import lambdas.examples.lms.domain.CourseEnrollment;
import lambdas.examples.lms.domain.Student;

public class DossierService {
    public void generateDossier(Student student) {
        System.out.println("Dossiê do estudante: "+student.getName()+"\nCursos:");

        student.getEnrollments().forEach(enrollment -> {
            Course course = enrollment.getCourse();
            System.out.println(" - "+course.getName()+" ("+course.getDescription()+" - "+course.getDurationHours()+" horas) = "+enrollment.isCompleted()); // TODO STRINGFY
        });

        boolean allCoursesPassed = student.getEnrollments().stream().allMatch(CourseEnrollment::isCompleted);
        System.out.println(allCoursesPassed);
    }
}
