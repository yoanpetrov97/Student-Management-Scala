package bg.sofia.uni.fmi.scala.studentmanagement.commands

import bg.sofia.uni.fmi.scala.studentmanagement.entities.School
import bg.sofia.uni.fmi.scala.studentmanagement.utils.CommandMessages._

object AddTeacherToCourseCommand extends Command {
  override def execute(school: School): Unit = {
    println(TEACHER_NAME_MESSAGE)
    val teacherName = io.StdIn.readLine.trim

    println(COURSE_NAME_MESSAGE)
    val courseName = io.StdIn.readLine.trim

    (school.getTeachers.get(teacherName), school.getCourses.get(courseName)) match {
      case (None, _) => printf(WRONG_TEACHER_MESSAGE_FORMAT, teacherName)
      case (_, None) => printf(WRONG_COURSE_MESSAGE_FORMAT, courseName)
      case (Some(teacher), Some(course)) => school.addTeacherToCourse(teacher, course)
                                            printf(TEACHER_TO_COURSE_MESSAGE_FORMAT, teacherName, courseName)
    }
  }
}
