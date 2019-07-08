package bg.sofia.uni.fmi.scala.studentmanagement

import bg.sofia.uni.fmi.scala.studentmanagement.commands._
import bg.sofia.uni.fmi.scala.studentmanagement.entities.School
import bg.sofia.uni.fmi.scala.studentmanagement.utils.CommandMessages._

object SchoolManagementCLI {
  private val school = School()

  def run(): Unit = {

    def run(isRunning: Boolean) {

      if (isRunning) {

        printAvailableOptions()

        val userChoice: String = io.StdIn.readLine.trim.toLowerCase

        userChoice match {
          case "q" | "exit" | "quit" => println(EXIT_MESSAGE)
          case "1" => AddNewCourseCommand.execute(school)
          case "2" => AddNewStudentCommand.execute(school)
          case "3" => AddNewTeacherCommand.execute(school)
          case "4" => AddTeacherToCourseCommand.execute(school)
          case "5" => AddStudentToCourseCommand.execute(school)
          case "6" => AddGradeForStudentInCourseCommand.execute(school)
          case "7" => ShowAllStudentsCommand.execute(school)
          case "8" => ShowAllCoursesAndTheirTeachersAndStudentsCommand.execute(school)
          case "9" => ShowAverageGradeForAllStudentsInCourseCommand.execute(school)
          case "10" => ShowAverageGradeForAllCourses.execute(school)
          case _ => println(WRONG_MENU_OPTION_MESSAGE)
        }

        userChoice match {
          case "q" | "exit" => run(false)
          case _ => run(true)
        }

      }
    }

    run(true)
  }

  private def printAvailableOptions(): Unit = {
    println(MENU_OPTIONS)
  }

}
