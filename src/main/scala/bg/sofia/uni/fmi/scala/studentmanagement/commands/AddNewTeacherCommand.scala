package bg.sofia.uni.fmi.scala.studentmanagement.commands

import bg.sofia.uni.fmi.scala.studentmanagement.entities.{School, Teacher}
import bg.sofia.uni.fmi.scala.studentmanagement.enums.Degree
import bg.sofia.uni.fmi.scala.studentmanagement.enums.Degree.Degree
import bg.sofia.uni.fmi.scala.studentmanagement.utils.CommandMessages._

object AddNewTeacherCommand extends Command {
  override def execute(school: School): Unit = {

    println(ADD_TEACHER_NAME_MESSAGE)
    val name = io.StdIn.readLine.trim

    println(ADD_TEACHER_DEGREE_MESSAGE)
    school.addTeacher(Teacher(name, getTeachersDegree(name)))

    printf(NEW_TEACHER_MESSAGE_FORMAT, name)
  }

  private def getTeachersDegree(name: String): Degree = {
    val degree = io.StdIn.readLine.trim
    degree match {
      case "1" | "MSc" => Degree.MSc
      case "2" | "BSc" => Degree.BSc
      case "3" | "PhD" => Degree.PhD
      case _ => println(WRONG_FORMAT_ERROR_MESSAGE + WRONG_DEGREE_MESSAGE)
                getTeachersDegree(name)
    }
  }
}