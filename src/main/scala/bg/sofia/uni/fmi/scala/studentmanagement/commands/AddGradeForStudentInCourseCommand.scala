package bg.sofia.uni.fmi.scala.studentmanagement.commands

import bg.sofia.uni.fmi.scala.studentmanagement.entities.School
import bg.sofia.uni.fmi.scala.studentmanagement.utils.CommandMessages._

import scala.util.Try

object AddGradeForStudentInCourseCommand extends Command {
  override def execute(school: School): Unit = {
    println(STUDENT_NAME_MESSAGE)
    val studentName = io.StdIn.readLine.trim

    println(COURSE_NAME_MESSAGE)
    val courseName = io.StdIn.readLine.trim

    printf(STUDENT_COURSE_GRADE_MESSAGE_FORMAT, studentName, courseName)

    val grade = Try(io.StdIn.readLine.trim.toDouble).toOption

    (school.getStudents.get(studentName), school.getCourses.get(courseName), grade) match {
      case (None, _, _) => printf(WRONG_STUDENT_MESSAGE_FORMAT, studentName)
      case (_, None, _) => printf(WRONG_COURSE_MESSAGE_FORMAT, courseName)
      case (Some(_), Some(_), None) => println(WRONG_FORMAT_ERROR_MESSAGE)
      case (Some(_), Some(_), Some(_)) if grade.get < 2.0 || grade.get > 6.0 => println(WRONG_GRADE_FORMAT_MESSAGE)
      case (Some(student), Some(course), _) =>
        if (course.getStudents.contains(student)) {
          school.addGradeForStudentInCourse(grade.get, student, course)
          printf(GRADE_FOR_STUDENT_IN_COURSE_MESSAGE_FORMAT, grade.get, studentName, courseName)
        } else printf(STUDENT_NOT_IN_COURSE_MESSAGE_FORMAT, studentName, courseName)
    }
  }
}
