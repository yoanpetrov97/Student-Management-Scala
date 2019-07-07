package bg.sofia.uni.fmi.scala.studentmanagement.commands

import bg.sofia.uni.fmi.scala.studentmanagement.entities.{Course, School}
import bg.sofia.uni.fmi.scala.studentmanagement.utils.CommandMessages._

import scala.util.Try

object AddNewCourseCommand extends Command {
  override def execute(school: School): Unit = {

    println(ADD_COURSE_NAME_MESSAGE)
    val name = io.StdIn.readLine.trim

    println(ADD_COURSE_HOURS_MESSAGE)
    val totalHours = Try(io.StdIn.readLine.trim.toInt).toOption

    totalHours match {
      case None => println(WRONG_FORMAT_ERROR_MESSAGE)
      case Some(hours) => school.addCourse(Course(name, hours))
                          printf(NEW_COURSE_MESSAGE_FORMAT, name)
    }

  }
}
