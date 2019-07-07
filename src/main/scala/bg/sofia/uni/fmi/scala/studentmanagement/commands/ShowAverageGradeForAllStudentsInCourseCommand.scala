package bg.sofia.uni.fmi.scala.studentmanagement.commands

import bg.sofia.uni.fmi.scala.studentmanagement.entities.School
import bg.sofia.uni.fmi.scala.studentmanagement.utils.CommandMessages._

object ShowAverageGradeForAllStudentsInCourseCommand extends Command {
  override def execute(school: School): Unit = {
    println(COURSE_NAME_MESSAGE)
    val courseName = io.StdIn.readLine.trim

    school.getCourses.get(courseName) match {
      case None => printf(WRONG_COURSE_MESSAGE_FORMAT, courseName)
      case Some(course) => school.showAverageGradeForAllStudentsInCourse(course)
    }
  }
}
