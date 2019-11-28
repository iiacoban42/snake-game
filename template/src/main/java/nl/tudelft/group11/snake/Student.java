package nl.tudelft.group11.snake;

import java.util.Objects;

public class Student {
    private final String name;
    private final int studentNumber;

    /**
     * Create a new nl.tudelft.group11.snake.Student object.
     *
     * @param name Name of the nl.tudelft.group11.snake.Student
     * @param studentNumber nl.tudelft.group11.snake.Student number used to identify student in central administration
     */
    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    /**
     * Retrieve the name of the current student.
     *
     * @return String representation of the name
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the student number of the current student.
     * This number can be used to uniquely identify students.
     *
     * @return integer representation of the number.
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * Determine whether the current nl.tudelft.group11.snake.Student object represents the same nl.tudelft.group11.snake.Student as the passed object.
     *
     * @param other Object to compare to the current nl.tudelft.group11.snake.Student
     * @return boolean with a truthy value in case of equality
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Student)) {
            return false;
        }

        Student student = (Student) other;
        return studentNumber == student.getStudentNumber();
    }

    /**
     * Check whether the current studentNumber is a valid number (7 digits).
     *
     * @return boolean value indicating the validity of the number
     */
    public boolean isValidStudentNumber() {
        if (studentNumber >= 1000000 && studentNumber <= 9999999) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStudentNumber());
    }

    /**
     * Retrieve a String representation of this nl.tudelft.group11.snake.Student object.
     *
     * @return String representation of the current student object.
     */
    @Override
    public String toString() {
        return this.getName() + " (" + this.getStudentNumber() + ")";
    }
}
