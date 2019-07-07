package bg.sofia.uni.fmi.scala.studentmanagement.commands
import bg.sofia.uni.fmi.scala.studentmanagement.entities.School
import bg.sofia.uni.fmi.scala.studentmanagement.utils.CommandMessages._

object AddStudentToCourseCommand extends Command {
  override def execute(school: School): Unit = {
    println(STUDENT_NAME_MESSAGE)
    val studentName = io.StdIn.readLine.trim

    println(COURSE_NAME_MESSAGE)
    val courseName = io.StdIn.readLine.trim

    (school.getStudents.get(studentName), school.getCourses.get(courseName)) match {
      case (None, _) => printf(WRONG_STUDENT_MESSAGE_FORMAT, studentName)
      case (_, None) => printf(WRONG_COURSE_MESSAGE_FORMAT, courseName)
      case (Some(student), Some(course)) => school.addStudentToCourse(student, course)
                                            printf(STUDENT_TO_COURSE_MESSAGE_FORMAT, studentName, courseName)
    }
  }
}
