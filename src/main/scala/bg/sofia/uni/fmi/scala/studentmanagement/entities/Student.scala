package bg.sofia.uni.fmi.scala.studentmanagement.entities

case class Student(var name: String, var age: Int) {
  def getName: String = name


  override def toString = s"Student($name, $age)"
}