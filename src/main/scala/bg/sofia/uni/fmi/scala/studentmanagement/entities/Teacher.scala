package bg.sofia.uni.fmi.scala.studentmanagement.entities

import bg.sofia.uni.fmi.scala.studentmanagement.enums.Degree.Degree

case class Teacher(var name: String, var degree: Degree) {
  def getName: String = name
}
