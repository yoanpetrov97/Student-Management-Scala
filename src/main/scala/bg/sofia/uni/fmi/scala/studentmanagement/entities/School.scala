package bg.sofia.uni.fmi.scala.studentmanagement.entities

case class School() {
  private var teachers: Map[String, Teacher] = Map.empty
  private var students: Map[String, Student] = Map.empty
  private var courses: Map[String, Course] = Map.empty


  def getTeachers: Map[String, Teacher] = teachers
  def getStudents: Map[String, Student] = students
  def getCourses: Map[String, Course] = courses

  /**
    * Adds a new course to the school
    */
  def addCourse(course: Course): Unit = {
    if (course != null) this.courses += course.getName -> course
  }

  /**
    * Adds a new student to the school
    */
  def addStudent(student: Student): Unit = {
    if (student != null) this.students += student.getName -> student
  }

  /**
    * Adds a new teacher to the school
    */
  def addTeacher(teacher: Teacher): Unit = {
    if (teacher != null) this.teachers += teacher.getName -> teacher
  }

  /**
    * Adds a teacher to a specific course (max 1)
    */
  def addTeacherToCourse(teacher: Teacher, course: Course): Unit = {
    if (teacher != null && course != null) course.setTeacher(teacher)
  }

  /**
    * Adds a student to a specific course
    */
  def addStudentToCourse(student: Student, course: Course): Unit = {
    if (student != null && course != null) course.addStudent(student)
  }

  /**
    * Adds a grade for student in a specific course. (grade 2.0-6.0)
    */
  def addGradeForStudentInCourse(grade: Double, student: Student, course: Course): Unit = {
    val minPossibleGrade: Int = 2
    val maxPossibleGrade: Int = 6
    if (grade >= minPossibleGrade && grade <= maxPossibleGrade && student != null && course != null && course.getStudents.contains(student))
      course.addGradeForStudent(grade, student)
  }

  /**
    * Shows all students grouped by course (alphabetically) and then by their average grade for the course
    * (ascending).
    */
  def showAllStudents(): Unit = {
    courses.values.toSeq.sortBy(courses => courses.getName)
      .foreach((course: Course) => course.getStudents
        .sortBy(course.getStudentAverageGrade)
        .foreach((student: Student) => printStudentCourseAndAverageGrade(course, student)))
  }

  private def printStudentCourseAndAverageGrade(course: Course, student: Student): Unit = {
    printf("Student: %s, Course: %s, Average grade: %f\n", student.getName, course.getName, course.getStudentAverageGrade(student))
  }

  /**
    * Shows all courses and their teachers and students (without grades)
    */
  def showAllCoursesAndTheirTeachersAndStudents(): Unit = {
    courses.values.foreach(this.printTeacherAndStudents)
  }

  private def printTeacherAndStudents(course: Course): Unit = {
    val teacher: String = if (course.getTeacher == null) "N\\A"
    else course.getTeacher.getName
    printf("Course: %s, Teacher: %s, Students: %s\n", course.getName, teacher, course.getStudents)
  }

  /**
    * Shows the average grade for all students in a specific course
    */
  def showAverageGradeForAllStudentsInCourse(course: Course): Unit = {
    println(course.getAverageGradeForAllStudents)
  }

  /**
    * Shows a total average grade for student (between all of his courses).
    */
  def showAverageGradeForAllCourses(student: Student): Unit = {
    println(getAverageGradeForAllCourses(student))
  }

  private def getAverageGradeForAllCourses(student: Student): Double = {
    val allGrades = this.courses.values.flatMap((course: Course) => course.getAllGradesOfStudent(student))
    allGrades.sum / allGrades.size
  }
}