package bg.sofia.uni.fmi.scala.studentmanagement.entities


case class Course(name: String, totalHours: Int) {
  var students: List[Student] = List.empty
  var grades: Map[Student, List[Double]] = Map.empty
  var teacher: Teacher = _

  def getName: String = name

  def getTeacher: Teacher = teacher

  def setTeacher(teacher: Teacher): Unit = {
    this.teacher = teacher
  }

  def getStudents: List[Student] = students

  def addStudent(student: Student): Unit = this.students :::= List(student)

  def addGradeForStudent(grade: Double, student: Student): Unit = {
    val minGrade: Int = 2
    val maxGrade: Int = 6
    if (grade >= minGrade && grade <= maxGrade) {
      if (this.grades.get(student).isEmpty) this.grades += student -> List.empty
      this.grades += student -> (this.grades(student) ::: List(grade))
    }
  }

  def getStudentAverageGrade(student: Student): Double = {
    if (this.grades.get(student).isEmpty) 0
    else this.grades(student).sum / this.grades(student).size
  }

  def getAverageGradeForAllStudents: Double = {
    val grades = this.grades.values.flatten
    grades.sum / grades.size
  }

  def getAllGradesOfStudent(student: Student): List[Double] = grades.getOrElse(student, List.empty)
}