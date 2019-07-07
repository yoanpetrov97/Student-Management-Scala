package bg.sofia.uni.fmi.scala.studentmanagement

import bg.sofia.uni.fmi.scala.studentmanagement.entities.{Course, School, Student, Teacher}
import bg.sofia.uni.fmi.scala.studentmanagement.enums.Degree
import org.scalatest.{FlatSpec, FunSuite, Matchers}

class SchoolTest extends FlatSpec with Matchers {
  "addCourse" should "create a new course" in {
    val school = School()
    school.addCourse(Course("Scala", 60))

    school.getCourses.contains("Scala") shouldBe true
  }

  it should "not create a null course" in {
    val school = School()
    school.addCourse(null)

    school.getCourses.size shouldBe 0
  }

  "addStudent" should "create a new student" in {
    val school = School()
    school.addStudent(Student("Yoan", 21))

    school.getStudents.contains("Yoan") shouldBe true
  }

  it should "not create a null student" in {
    val school = School()
    school.addStudent(null)

    school.getStudents.size shouldBe 0
  }

  "addTeacher" should "create a new teacher" in {
    val school = School()
    school.addTeacher(Teacher("Zdravko", Degree.PhD))

    school.getTeachers.contains("Zdravko") shouldBe true
  }

  it should "not create a null teacher" in {
    val school = School()
    school.addTeacher(null)

    school.getTeachers.size shouldBe 0
  }

  "addTeacherToCourse" should "add teacher to course" in {
    val school = School()

    val exampleTeacher = Teacher("Zdravko", Degree.PhD)
    val exampleCourse = Course("Scala", 60)

    school.addTeacher(exampleTeacher)
    school.addCourse(exampleCourse)
    school.addTeacherToCourse(exampleTeacher, exampleCourse)

    school.getCourses(exampleCourse.getName).getTeacher shouldBe exampleTeacher
  }

  it should "not create a null teacher" in {
    val school = School()

    val exampleTeacher = Teacher("Zdravko", Degree.PhD)
    val exampleCourse = Course("Scala", 60)
    school.addTeacher(exampleTeacher)
    school.addCourse(exampleCourse)

    school.addTeacherToCourse(null, exampleCourse)
    school.getCourses(exampleCourse.getName).getTeacher shouldBe null
  }

  "addStudentToCourse" should "add student to course" in {
    val school = School()

    val exampleStudent = Student("Yoan", 21)
    val exampleCourse = Course("Scala", 60)

    school.addStudent(exampleStudent)
    school.addCourse(exampleCourse)
    school.addStudentToCourse(exampleStudent, exampleCourse)

    school.getCourses(exampleCourse.getName).getStudents.contains(exampleStudent) shouldBe true
  }

  it should "not create a null student" in {
    val school = School()

    val exampleStudent = Student("Yoan", 21)
    val exampleCourse = Course("Scala", 60)
    school.addStudent(exampleStudent)
    school.addCourse(exampleCourse)

    school.addStudentToCourse(null, exampleCourse)
    school.getCourses(exampleCourse.getName).getStudents.size shouldBe 0
  }

  "addGradeForStudentInCourse" should "add grade for student in course if the student is added to the course" in {
    val school = School()

    val exampleStudent = Student("Yoan", 21)
    val exampleCourse = Course("Scala", 60)
    school.addStudent(exampleStudent)
    school.addCourse(exampleCourse)
    school.addStudentToCourse(exampleStudent, exampleCourse)

    school.addGradeForStudentInCourse(6.0, exampleStudent, exampleCourse)
    school.addGradeForStudentInCourse(2.0, exampleStudent, exampleCourse)
    school.addGradeForStudentInCourse(3.0, exampleStudent, exampleCourse)
    school.addGradeForStudentInCourse(4.0, exampleStudent, exampleCourse)


    school.getCourses(exampleCourse.getName).getAllGradesOfStudent(exampleStudent) shouldBe List[Double](6.0, 2.0, 3.0, 4.0)
  }

  it should "not add grade for student in course if the student isn't added to the course" in {
    val school = School()

    val exampleStudent = Student("Yoan", 21)
    val exampleCourse = Course("Scala", 60)
    school.addStudent(exampleStudent)
    school.addCourse(exampleCourse)

    school.addGradeForStudentInCourse(6.0, exampleStudent, exampleCourse)
    school.addGradeForStudentInCourse(2.0, exampleStudent, exampleCourse)
    school.addGradeForStudentInCourse(3.0, exampleStudent, exampleCourse)
    school.addGradeForStudentInCourse(4.0, exampleStudent, exampleCourse)


    school.getCourses(exampleCourse.getName).getAllGradesOfStudent(exampleStudent) shouldBe List.empty
  }
}
