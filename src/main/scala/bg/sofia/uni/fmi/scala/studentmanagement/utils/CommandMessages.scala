package bg.sofia.uni.fmi.scala.studentmanagement.utils

object CommandMessages {
  val MENU_OPTIONS: String = "q - exit\n" +
    "1 - Add a new course\n" +
    "2 - Add a new student\n" +
    "3 - Add a new teacher\n" +
    "4 - Add a teacher to a specific course (max 1)\n" + "5 - Add a student to a specific course\n" +
    "6 - Add a grade for student in a specific course (grade 2.0-6.0)\n" +
    "7 - Show all students grouped by course (alphabetically) and then by their " + "average grade for the course (ascending)\n" +
    "8 - Show all courses and their teachers and students (without grades)\n" +
    "9 - Show the average grade for all students in a specific course\n" +
    "10 - Show a total average grade for student (between all of his courses)\n"
  val WRONG_GRADE_FORMAT_MESSAGE: String = "The grade must be a floating point number in the interval [2.0-6.0]"
  val STUDENT_COURSE_GRADE_MESSAGE_FORMAT: String = "Enter %s's grade in the course %s:\n"
  val WRONG_STUDENT_MESSAGE_FORMAT: String = "The student %s isn't added to the school.\n"
  val STUDENT_NAME_MESSAGE: String = "Enter the student's name:"
  val WRONG_COURSE_MESSAGE_FORMAT: String = "The course %s isn't added to the school.\n"
  val WRONG_TEACHER_MESSAGE_FORMAT: String = "The teacher %s isn't added to the school.\n"
  val STUDENT_NOT_IN_COURSE_MESSAGE_FORMAT: String = "The student %s isn't added to the course %s!\n"
  val COURSE_NAME_MESSAGE: String = "Enter the name of the course:"
  val TEACHER_NAME_MESSAGE: String = "Enter the teacher's name:"
  val WRONG_DEGREE_MESSAGE: String = "Enter an integer number from {1, 2, 3} or {MSc, BSc, PhD}"
  val ADD_TEACHER_DEGREE_MESSAGE: String = "Enter the teacher's degree:\n1 - MSc\n2 - BSc\n3 - PhD"
  val ADD_TEACHER_NAME_MESSAGE: String = "Enter the name of the teacher you want to add:"
  val ADD_STUDENT_AGE_MESSAGE: String = "Enter the age of the student you want to add:"
  val ADD_STUDENT_NAME_MESSAGE: String = "Enter the name of the student you want to add:"
  val ADD_COURSE_HOURS_MESSAGE: String = "Enter the total hours of the course you want to add:"
  val ADD_COURSE_NAME_MESSAGE: String = "Enter the name of the course you want to add:"
  val WRONG_MENU_OPTION_MESSAGE: String = "Wrong command! Enter an integer number from 1 to 10 or q/exit to quit."
  val WRONG_FORMAT_ERROR_MESSAGE: String = "Wrong format! Try again."
  val EXIT_MESSAGE: String = "Bye!"
  val TEACHER_TO_COURSE_MESSAGE_FORMAT: String = "Successfully added the teacher %s to the course %s!\n"
  val STUDENT_TO_COURSE_MESSAGE_FORMAT: String = "Successfully added the student %s to the course %s!\n"
  val GRADE_FOR_STUDENT_IN_COURSE_MESSAGE_FORMAT: String = "Successfully added the grade %f for the student %s in the course %s!\n"
  val NEW_COURSE_MESSAGE_FORMAT: String = "Successfully created the course %s!\n"
  val NEW_STUDENT_MESSAGE_FORMAT: String = "Successfully created the student %s!\n"
  val NEW_TEACHER_MESSAGE_FORMAT: String = "Successfully created the teacher %s!\n"
}
