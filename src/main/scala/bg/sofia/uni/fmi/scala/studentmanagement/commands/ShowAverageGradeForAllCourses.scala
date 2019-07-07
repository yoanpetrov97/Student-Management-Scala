package bg.sofia.uni.fmi.scala.studentmanagement.commands

import bg.sofia.uni.fmi.scala.studentmanagement.entities.School
import bg.sofia.uni.fmi.scala.studentmanagement.utils.CommandMessages._

object ShowAverageGradeForAllCourses extends Command {
  override def execute(school: School): Unit = {
    println(STUDENT_NAME_MESSAGE)
    val studentName = io.StdIn.readLine.trim

    school.getStudents.get(studentName) match {
      case None => printf(WRONG_STUDENT_MESSAGE_FORMAT, studentName)
      case Some(student) => school.showAverageGradeForAllCourses(student)
    }
  }
}
