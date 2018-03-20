Assignment for Introduction to Data Structures, CS 401 - IIT

Requirements: Create a FullTimeEmployee class with salaray and name.

(1) Implement a comparator and comparable interfaces to sort FullTimeEmployee's
based on their names.
(2) Perform rudimentary JUnit testing.

Lab Lesson:

Java Provides two interfaces for comparing data members of a class:
(1) A comparable object compares itself with another object of the same class
    using the java.lang.Comparable interface to compare instances
    You use the designated work 'implements' in the class definition and then
    define the comparison in the compareTo() method
(2) A comparator class implements a 'compare()' method that takes two members
    of a class and compares them. Before using it you must instantiate an object
    of the comparator class you defined.

To Compile:

To compile:
(1) Type 'javac FullTimeEmployee.java'
(2) Type 'java FullTimeEmployee'
