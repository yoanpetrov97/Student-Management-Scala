package bg.sofia.uni.fmi.scala.studentmanagement.commands

import bg.sofia.uni.fmi.scala.studentmanagement.entities.{School, Student}
import bg.sofia.uni.fmi.scala.studentmanagement.utils.CommandMessages._

import scala.util.Try

object AddNewStudentCommand extends Command {
  override def execute(school: School): Unit = {

    println(ADD_STUDENT_NAME_MESSAGE)
    val name = io.StdIn.readLine.trim

    println(ADD_STUDENT_AGE_MESSAGE)
    val age = Try(io.StdIn.readLine.trim.toInt).toOption

    age match {
      case None => println(WRONG_FORMAT_ERROR_MESSAGE)
      case Some(a) => school.addStudent(Student(name, a))
                      printf(NEW_STUDENT_MESSAGE_FORMAT, name)
    }

  }
}