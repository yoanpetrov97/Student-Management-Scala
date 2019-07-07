package bg.sofia.uni.fmi.scala.studentmanagement.commands
import bg.sofia.uni.fmi.scala.studentmanagement.entities.School

object ShowAllStudentsCommand extends Command {
  override def execute(school: School): Unit = school.showAllStudents()
}
