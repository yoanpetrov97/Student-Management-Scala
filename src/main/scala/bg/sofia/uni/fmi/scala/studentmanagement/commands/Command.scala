package bg.sofia.uni.fmi.scala.studentmanagement.commands

import bg.sofia.uni.fmi.scala.studentmanagement.entities.School

trait Command {
  def execute(school: School): Unit
}
