package com.example.finalprojectparttwo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Advisor_Tester {
    //This will be our tester,Advisor_Tester file
    public static void main(String[] Args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        String name, acad_ID;
        int month, day, year;
        ArrayList<Advisor> advisors = new ArrayList<>();

        //Creating test advisors
        Advisor michael = new Advisor("Michael " + "R " + "Yautaro", "mry2093");
        michael.setPhoneNum(0);
        michael.setEmail("mry2093@psu.edu");
        michael.setAddress(new Address(25, "Yearsley Mills", "Media", "PA", 19380));
        ArrayList<Advisee> student_list = new ArrayList<>(0); //Array List for advisor michael.
        michael.setAdvisees(student_list);
        michael.setHiredDate(new Date(2006, 2, 20));
        michael.setTitle("Professor");
        michael.setAnnualSalary(0);
        advisors.add(michael);

        Advisor ben = new Advisor("Ben " + "J " + "Stevens", "bjs1963");
        ben.setPhoneNum(0);
        ben.setEmail("bjs1963@psu.edu");
        ben.setAddress(new Address(146, "Jeremy Lane", "Reading", "PA", 19380));
        ArrayList<Advisee> student_list2 = new ArrayList<>(0); //Array List for advisor ben.
        ben.setAdvisees(student_list2);
        ben.setHiredDate(new Date(1997, 9, 10));
        ben.setTitle("TA");
        ben.setAnnualSalary(0);
        advisors.add(ben);

        Advisee aravind = new Advisee("Aravind " + "H " + "Alwar", "aha5495");
        michael.getAdvisees().add(aravind);

        int input;

        System.out.println("Welcome to the Advisor Data System. You enter in an advisor info, we will do the work to manage the system.");
        while (!exit) {
            System.out.println("Choose a valid option from the following values");
            System.out.println("1.Add an advisor to the System.\n2.Edit an advisor in the system.\n3.Add a student to an advisor.\n4.Add a course to a student.\n5.Delete an advisor in the system.\n6.Display an advisor’s basic information and the advisees in the system.\n7.Exit the application.");
            input = scanner.nextInt();
            if (input == 1) { //Add An Advisor
                boolean adding_advisors = true;
                while (adding_advisors) {
                    System.out.println("You will now add an advisor to the array of advisors");
                    System.out.println("Enter Advisor's full name:");
                    name = scanner.next();
                    System.out.println("Enter Advisor's ID:");
                    acad_ID = scanner.next();
                    Advisor a = new Advisor(name, acad_ID);

                    System.out.println("Enter Advisor's Phone Number:");
                    a.setPhoneNum(scanner.nextLong());
                    a.setEmail(acad_ID + "@psu.edu");

                    System.out.println("You will now enter the advisor's address");
                    a.setAddress(new Address());
                    System.out.println("Enter Advisor's House Num:");
                    a.getAddress().setHouse_number(scanner.nextInt());
                    System.out.println("Enter Advisor's Street:");
                    a.getAddress().setStreet(scanner.next());
                    System.out.println("Enter Advisor's City:");
                    a.getAddress().setTown(scanner.next());
                    System.out.println("Enter Advisor's State:");
                    a.getAddress().setState(scanner.next());
                    System.out.println("Enter Advisor's Zip:");
                    a.getAddress().setZip_code(scanner.nextInt());
                    System.out.println("Enter Advisor's Title:");
                    a.setTitle(scanner.next());

                    System.out.println("Enter Advisor's Annual Salary:");
                    a.setAnnualSalary(scanner.nextDouble());

                    System.out.println("Enter Advisor's Hiring Month:");
                    month = scanner.nextInt();
                    while (month < 1 || month > 12) {
                        System.out.println("Not a valid hiring month.");
                        System.out.println("Enter Advisor's Hiring Month:");
                        month = scanner.nextInt();
                    }
                    System.out.println("Enter Advisor's Hiring Day:");
                    day = scanner.nextInt();
                    while (day < 1 || day > 31) {
                        System.out.println("Not a valid hiring Day.");
                        System.out.println("Enter Advisor's Hiring day:");
                        day = scanner.nextInt();
                    }
                    System.out.println("Enter Advisor's Hiring Year:");
                    year = scanner.nextInt();
                    while (year < 1970) {
                        System.out.println("Not a valid hiring Year.");
                        System.out.println("Enter Advisor's Hiring Year:");
                        year = scanner.nextInt();
                    }
                    a.setHiredDate(new Date(month, day, year));

                    advisors.add(a);

                    System.out.println("Advisor has been successfully added! Want to add another Advisor? Enter 0 for no:");
                    input = scanner.nextInt();
                    adding_advisors = (input != 0);
                }
            } else if (input == 2) { //Edit an Advisor
                boolean editing_advisor = true;
                boolean editing_student = false; //Still not true for now
                Advisor a = searchAdvisor(scanner, advisors);
                while (editing_advisor) {
                    System.out.println("Please select a following field to edit");
                    System.out.println("1.Edit Advisor's Name:");
                    System.out.println("2.Edit Advisor's Academic_ID:");
                    System.out.println("3.Edit Advisor's Phone number:");
                    System.out.println("4.Edit Advisor's Address:");
                    System.out.println("5.Edit Advisor's Title:");
                    System.out.println("6.Edit Advisor's Hiring Month:");
                    System.out.println("7.Edit Advisor's Hiring Day:");
                    System.out.println("8.Edit Advisor's Year:");
                    System.out.println("9.Edit Student List:");
                    System.out.println("10.Return to the main menu:");
                    input = scanner.nextInt();
                    if (input == 1) {
                        System.out.println("Type in the new name:");
                        a.setName(scanner.next());
                        System.out.println("Updated Name Successfully!");
                    } else if (input == 2) {
                        System.out.println("Type in the new Advisor ID:");
                        a.setID(scanner.next());
                        System.out.println("Updated Advisor ID Successfully!");
                    } else if (input == 3) {
                        System.out.println("Type in the new Advisor Phone Number:");
                        a.setPhoneNum(scanner.nextLong());
                        System.out.println("Updated Advisor Phone Number Successfully!");
                    } else if (input == 4) {
                        System.out.println("Choose which part to edit:");
                        System.out.println("1.House Number");
                        System.out.println("2.Street Name");
                        System.out.println("3.City");
                        System.out.println("4.State");
                        System.out.println("5.ZIPCODE");
                        input = scanner.nextInt();

                        if (input == 1) {
                            System.out.println("Enter Advisor's new House Number:");
                            a.getAddress().setHouse_number(scanner.nextInt());
                            System.out.println("House Number updated successfully!");
                        } else if (input == 2) {
                            System.out.println("Enter Advisor's new Street Name:");
                            a.getAddress().setStreet(scanner.next());
                            System.out.println("Street Number updated successfully!");
                        } else if (input == 3) {
                            System.out.println("Enter Advisor's new City:");
                            a.getAddress().setTown(scanner.next());
                            System.out.println("City name updated successfully!");
                        } else if (input == 4) {
                            System.out.println("Enter Advisor's new State:");
                            a.getAddress().setState(scanner.next());
                            System.out.println("State updated successfully!");
                        } else if (input == 5) {
                            System.out.println("Enter Advisor's new ZIPCODE:");
                            a.getAddress().setZip_code(scanner.nextInt());
                            System.out.println("Zipcode updated successfully!");
                        }
                    } else if (input == 5) {
                        System.out.println("Enter Advisor's new Title.");
                        a.setTitle(scanner.next());
                        System.out.println("Title Updated Successfully.");
                    } else if (input == 6) {
                        System.out.println("Enter Advisor's updated Hiring Month:");
                        month = scanner.nextInt();
                        while (month < 1 || month > 12) {
                            System.out.println("Not a valid hiring month.");
                            System.out.println("Enter Advisor's updated Hiring Month:");
                            month = scanner.nextInt();
                        }
                        a.getHiredDate().setMonth(month);
                    } else if (input == 7) {
                        System.out.println("Enter Advisor's updated Hiring Day:");
                        day = scanner.nextInt();
                        while (day < 1 || day > 31) {
                            System.out.println("Not a valid hiring Day.");
                            System.out.println("Enter Advisor's updated Hiring day:");
                            day = scanner.nextInt();
                        }
                        a.getHiredDate().setDate(day);
                    } else if (input == 8) {
                        System.out.println("Enter Advisor's updated Hiring Year:");
                        year = scanner.nextInt();
                        while (year < 1970) {
                            System.out.println("Not a valid hiring Year.");
                            System.out.println("Enter Advisor's Hiring Year:");
                            year = scanner.nextInt();
                        }
                        a.getHiredDate().setYear(year);
                    } else if (input == 9) {
                        editing_student = true;
                        Advisee s = searchStudent(scanner, a.getAdvisees());
                        while (editing_student) { //Going to add a student to the list of advisees.
                            System.out.println("Please select a following field to edit");
                            System.out.println("1.Edit Student's name:");
                            System.out.println("2.Edit Student's Academic_ID:");
                            System.out.println("3.Edit Student's Phone number:");
                            System.out.println("4.Edit Student's Address:");
                            System.out.println("5.Edit Student's Title:");
                            System.out.println("6.Edit Student's Admission Month:");
                            System.out.println("7.Edit Student's Admission Day:");
                            System.out.println("8.Edit Student's Admission:");
                            System.out.println("9.Return to the main menu:");
                            input = scanner.nextInt();
                            if (input == 1) {
                                System.out.println("Type in the new name:");
                                s.setName(scanner.next());
                                System.out.println("Updated Last name Successfully!");
                            } else if (input == 2) {
                                System.out.println("Type in the new Student ID:");
                                s.setID(scanner.next());
                                System.out.println("Updated Advisor ID Successfully!");
                            } else if (input == 3) {
                                System.out.println("Type in the new Student Phone Number:");
                                s.setPhoneNum(scanner.nextLong());
                                System.out.println("Updated Student Phone Number Successfully!");
                            } else if (input == 4) {
                                System.out.println("Choose which part to edit:");
                                System.out.println("1.House Number");
                                System.out.println("2.Street Name");
                                System.out.println("3.City");
                                System.out.println("4.State");
                                System.out.println("5.ZIPCODE");
                                input = scanner.nextInt();

                                if (input == 1) {
                                    System.out.println("Enter Student's new House number :");
                                    s.getAddress().setHouse_number(scanner.nextInt());
                                    System.out.println("House Number updated successfully!");
                                } else if (input == 2) {
                                    System.out.println("Enter Student's new Street name :");
                                    s.getAddress().setStreet(scanner.next());
                                    System.out.println("Street name updated successfully!");
                                } else if (input == 3) {
                                    System.out.println("Enter Student's new City:");
                                    s.getAddress().setTown(scanner.next());
                                    System.out.println("City name updated successfully!");
                                } else if (input == 4) {
                                    System.out.println("Enter Student's new State:");
                                    s.getAddress().setState(scanner.next());
                                    System.out.println("State updated successfully!");
                                } else if (input == 5) {
                                    System.out.println("Enter Student's new ZIPCODE:");
                                    s.getAddress().setZip_code(scanner.nextInt());
                                    System.out.println("Zipcode updated successfully!");
                                } else if (input == 0) {
                                    System.out.println("Bye Bye.");
                                }
                            } else if (input == 5) {
                                System.out.println("Enter Student's Major:");
                                s.setMajor(scanner.next());
                                System.out.println("Updated major successfully!");
                            } else if (input == 6) {
                                System.out.println("Enter Student's Admission Month:");
                                month = scanner.nextInt();
                                while (month < 1 || month > 12) {
                                    System.out.println("Not a valid admission month.");
                                    System.out.println("Enter Student's Admission Month:");
                                    month = scanner.nextInt();
                                }
                                s.getAdmittedDate().setMonth(month);
                                System.out.println("Updated the Month successfully.");
                            } else if (input == 7) {
                                System.out.println("Enter Student's Admission Day:");
                                day = scanner.nextInt();
                                while (day < 1 || day > 31) {
                                    System.out.println("Not a valid admission Day.");
                                    System.out.println("Enter Student's Admission Day:");
                                    day = scanner.nextInt();
                                }
                                s.getAdmittedDate().setDate(day);
                                System.out.println("Updated the Month successfully.");
                            } else if (input == 8) {
                                System.out.println("Enter Student's Admission Year:");
                                year = scanner.nextInt();
                                while (year < 1) {
                                    System.out.println("Not a valid hiring Year.");
                                    System.out.println("Enter Student's Admission Year:");
                                    year = scanner.nextInt();
                                }
                                s.getAdmittedDate().setYear(year);
                                System.out.println("Updated the Month successfully.");
                            } else if (input == 9) {
                                System.out.println("Updated info successfully,bye bye."); //Ending the program editing
                                editing_student = false;
                            }
                        }
                    } else if (input == 10) {
                        editing_advisor = false;
                    } else {
                        System.out.println("Invalid option");
                    }
                }
            } else if (input == 3) {
                boolean adding_students = true;
                boolean adding_students_for_one_advisor = true;
                //Search for an advisor to further add the advisees
                while (adding_students) { //Going to add a student to the list of advisees.
                    Advisor a = searchAdvisor(scanner, advisors);
                    while (adding_students_for_one_advisor) {
                        if (a != null) {
                            System.out.println("Enter Student's name:");
                            name = scanner.next();
                            System.out.println("Enter Student's ID:");
                            acad_ID = scanner.next();
                            Advisee s = new Advisee(name, acad_ID);

                            System.out.println("Enter Student's Phone Number:");
                            s.setPhoneNum(scanner.nextLong());
                            s.setEmail(acad_ID + "@psu.edu");

                            System.out.println("Now you will enter the student's address");
                            s.setAddress(new Address());
                            System.out.println("Enter Student's Street Num:");
                            s.getAddress().setHouse_number(scanner.nextInt());
                            System.out.println("Enter Student's Street Name:");
                            s.getAddress().setStreet(scanner.next());
                            System.out.println("Enter Student's City:");
                            s.getAddress().setTown(scanner.next());
                            System.out.println("Enter Student's State:");
                            s.getAddress().setState(scanner.next());
                            System.out.println("Enter Student's Zip:");
                            s.getAddress().setZip_code(scanner.nextInt());

                            System.out.println("Enter Student's Major:");
                            s.setMajor(scanner.next());

                            System.out.println("Enter Student's Admission Month:");
                            month = scanner.nextInt();
                            while (month < 1 || month > 12) {
                                System.out.println("Not a valid hiring month.");
                                System.out.println("Enter Student's Admission Month:");
                                month = scanner.nextInt();
                            }
                            System.out.println("Enter Student's Admission Day:");
                            day = scanner.nextInt();
                            while (day < 1 || day > 31) {
                                System.out.println("Not a valid hiring day.");
                                System.out.println("Enter Student's Admission Day:");
                                day = scanner.nextInt();
                            }
                            System.out.println("Enter Student's Admission Year:");
                            year = scanner.nextInt();
                            while (year < 1) {
                                System.out.println("Not a valid hiring Year.");
                                System.out.println("Enter Student's Admission Year:");
                                year = scanner.nextInt();
                            }
                            s.setAdmittedDate(new Date(month, day, year));

                            a.getAdvisees().add(s);

                            System.out.println("Want to add in another Student? Enter 0 for no:");
                            input = scanner.nextInt();
                            adding_students_for_one_advisor = (input != 0);
                        } else {
                            System.out.println("Advisor was not found");
                        }
                    }

                    System.out.println("Add students for another advisor? Enter 0 for no:");
                    input = scanner.nextInt();
                    adding_students = (input != 0);
                }
            } else if (input == 4) {
                Advisee s = searchStudent(scanner, searchAdvisor(scanner, advisors).getAdvisees());
                boolean adding_courses = true;
                while (adding_courses) { //Adding classes
                    Course c = new Course();
                    System.out.println("Type in the course name:");
                    c.setCourseName(scanner.next());
                    System.out.println("Number of credits for the course:");
                    int course_Credits = scanner.nextInt();
                    while (course_Credits < 0) {
                        System.out.println("Invalid value of credits,try again please");
                        course_Credits = scanner.nextInt();
                    }
                    c.setNumOfCredits(course_Credits);
                    System.out.println("Price per credit for the course:");
                    double price = scanner.nextDouble();
                    while (price < 0) {
                        System.out.println("Invalid value of price per credit,try again please");
                        price = scanner.nextDouble();
                    }
                    c.setPrice(price);

                    s.getCourses().add(c);

                    System.out.println("Add another Course? Enter 0 for no:");
                    input = scanner.nextInt();
                    adding_courses = (input != 0);
                }
            } else if (input == 5) {
                boolean deleting_advisors = true;
                while (deleting_advisors) {
                    Advisor deletedAdvisor = searchAdvisor(scanner, advisors);
                    if (!advisors.remove(deletedAdvisor)) {
                        System.out.println("Advisor was not found");
                    } else {
                        System.out.println("Advisor was successfully deleted");
                    }

                    System.out.println("Delete for another advisor? Enter 0 for no:");
                    input = scanner.nextInt();
                    deleting_advisors = (input != 0);
                }
            } else if (input == 6) {
                boolean displaying_advisors = true;
                while (displaying_advisors) {
                    Advisor a = null;
                    try {
                        a = searchAdvisor(scanner, advisors);
                        a.Display();
                    } catch (NullPointerException e) {
                        System.out.println("Advisor was not found");
                    }

                    System.out.println("Search for another advisor? Enter 0 for no: ");
                    input = scanner.nextInt();
                    displaying_advisors = (input != 0);
                }
            } else if (input == 7) {
                System.out.print("Thanks for using this app. Bye-bye.");
                exit = true;
            }
        }
    }


    private static Advisor searchAdvisor(Scanner scanner, ArrayList<Advisor> heads) {
        String acad_ID;
        System.out.println("Enter the ID for the Advisor:");
        acad_ID = scanner.next();
        Advisor a = null;

        //We now loop through the list of Advisors,Heads;
        for (Advisor n : heads) {
            if (n.getID().equals(acad_ID)) {
                a = n;
                break;
            }
        }

        return a;
    }

    private static Advisee searchStudent(Scanner scanner, ArrayList<Advisee> students) {
        String acad_ID;
        System.out.println("Enter the ID for the Student:");
        acad_ID = scanner.next();
        Advisee s = null;

        //We now loop through the list of Advisors,Heads;
        for (Advisee curr : students) {
            if (curr.getID().equals(acad_ID)) {
                s = curr;
                break;
            }
        }

        return s;
    }
}
/*
Welcome to the Advisor Data System. You enter in an advisor info,we will do the work to manage the system.
Choose a valid option from the following values
1.Add an Advisor to the System.
2.Edit an advisor in the advisor array.
3.Add A student to an advisor.
4.Delete an advisor in the array.
5.Display an advisor’s basic information and the advisees in the array.
6.Exit the application.
1
You will now add an advisor to the array of advisors
Enter Advisor's first name:
Michael
Enter Advisor's middle name:
R
Enter Advisor's last name:
Yautaro
Enter Advisor's ID:
mry2093
Enter Advisor's Phone Number:
484938493
Enter Advisor's House Num:
25
Enter Advisor's Street:
YearsleyMills
Enter Advisor's City:
Media
Enter Advisor's State:
PA
Enter Advisor's Zip:
19380
Enter Advisor's Title:
Professor
Enter Advisor's Annual Salary:
2500.50
Enter Advisor's Hiring Month:
2
Enter Advisor's Hiring Day:
20
Enter Advisor's Hiring Year:
2006
Advisor has been successfully added!Want to add another Advisor:
1
You will now add an advisor to the array of advisors
Enter Advisor's first name:
Ben
Enter Advisor's middle name:
J
Enter Advisor's last name:
Stevens
Enter Advisor's ID:
bjs1963
Enter Advisor's Phone Number:
484938494
Enter Advisor's House Num:
146
Enter Advisor's Street:
JeremyLane
Enter Advisor's City:
Reading
Enter Advisor's State:
PA
Enter Advisor's Zip:
19380
Enter Advisor's Title:
Assistant
Enter Advisor's Annual Salary:
1950.60
Enter Advisor's Hiring Month:
9
Enter Advisor's Hiring Day:
10
Enter Advisor's Hiring Year:
1997
Advisor has been successfully added!Want to add another Advisor:
0
Choose a valid option from the following values
1.Add an Advisor to the System.
2.Edit an advisor in the advisor array.
3.Add A student to an advisor.
4.Delete an advisor in the array.
5.Display an advisor’s basic information and the advisees in the array.
6.Exit the application.
3
Enter the ID for the Advisor:
bjs1963
Assistant BenJStevens
bjs1963
bjs1963@psu.edu
146 JeremyLane
Reading, PA
19380
Advisees
Enter Student's first name:
Aravind
Enter Student's middle name:
H
Enter Student's last name:
Alwar
Enter Student's ID:
aha5495
Enter Student's Phone Number:
48488675
Enter Student's Street Num:
346
Enter Student's Street Name:
GalwayDrive
Enter Student's City:
WC
Enter Student's State:
PA
Enter Student's Zip:
19380
Enter Student's Major:
CompSci
Enter Student's Admission Month:
5
Enter Student's Admission Day:
14
Enter Student's Admission Year:
2022
Type in the course name:
CmpSci131
Credits for the course:
3
Add another Course:
1
Type in the course name:
Math141H
Credits for the course:
4
Add another Course:
1
Type in the course name:
Eng30H
Credits for the course:
3
Add another Course:
0
Want to add in another Student:
0
Search for another advisor? :
0
Choose a valid option from the following values
1.Add an Advisor to the System.
2.Edit an advisor in the advisor array.
3.Add A student to an advisor.
4.Delete an advisor in the array.
5.Display an advisor’s basic information and the advisees in the array.
6.Exit the application.
5
Enter the ID for the Advisor:
bjs1963
Assistant BenJStevens
bjs1963
bjs1963@psu.edu
146 JeremyLane
Reading, PA
19380
Advisees
Aravind H Alwar
aha5495
aha5495@psu.edu
346 GalwayDrive
WC, PA
19380
Major: CompSci
Search for another advisor? :
0
Choose a valid option from the following values
1.Add an Advisor to the System.
2.Edit an advisor in the advisor array.
3.Add A student to an advisor.
4.Delete an advisor in the array.
5.Display an advisor’s basic information and the advisees in the array.
6.Exit the application.
--Did not Include a trial with 2 students,but it worked well enough.Printed both students out
Welcome to the Advisor Data System. You enter in an advisor info,we will do the work to manage the system.
Choose a valid option from the following values
1.Add an Advisor to the System.
2.Edit an advisor in the advisor array.
3.Add A student to an advisor.
4.Delete an advisor in the array.
5.Display an advisor’s basic information and the advisees in the array.
6.Exit the application.
3
Enter the ID for the Advisor:
mry2093
Advisor was not found //Correctly printed out not found advisor
Search for another advisor? :
0
Choose a valid option from the following values
1.Add an Advisor to the System.
2.Edit an advisor in the advisor array.
3.Add A student to an advisor.
4.Delete an advisor in the array.
5.Display an advisor’s basic information and the advisees in the array.
6.Exit the application.
6
Thanks for using this app. Bye-bye.
Welcome to the Advisor Data System. You enter in an advisor info,we will do the work to manage the system.
Choose a valid option from the following values
1.Add an Advisor to the System.
2.Edit an advisor in the advisor array.
3.Add A student to an advisor.
4.Delete an advisor in the array.
5.Display an advisor’s basic information and the advisees in the array.
6.Exit the application.
1
You will now add an advisor to the array of advisors
Enter Advisor's first name:
Michael
Enter Advisor's middle name:
R
Enter Advisor's last name:
Yautaro
Enter Advisor's ID:
mry2093
Enter Advisor's Phone Number:
484885923
Enter Advisor's House Num:
25
Enter Advisor's Street:
YearsleyMills
Enter Advisor's City:
Media
Enter Advisor's State:
PA
Enter Advisor's Zip:
19380
Enter Advisor's Title:
Professor
Enter Advisor's Annual Salary:
4500.900
Enter Advisor's Hiring Month:
2
Enter Advisor's Hiring Day:
20
Enter Advisor's Hiring Year:
2006
Advisor has been successfully added!Want to add another Advisor:
0
Choose a valid option from the following values
1.Add an Advisor to the System.
2.Edit an advisor in the advisor array.
3.Add A student to an advisor.
4.Delete an advisor in the array.
5.Display an advisor’s basic information and the advisees in the array.
6.Exit the application.
1
You will now add an advisor to the array of advisors
Enter Advisor's first name:
Ben
Enter Advisor's middle name:
J
Enter Advisor's last name:
Stevens
Enter Advisor's ID:
bjs1963
Enter Advisor's Phone Number:
484889482
Enter Advisor's House Num:
146
Enter Advisor's Street:
GalwayDrive
Enter Advisor's City:
Reading
Enter Advisor's State:
PA
Enter Advisor's Zip:
19380
Enter Advisor's Title:
Assistant
Enter Advisor's Annual Salary:
1500.00
Enter Advisor's Hiring Month:
9
Enter Advisor's Hiring Day:
10
Enter Advisor's Hiring Year:
1997
Advisor has been successfully added!Want to add another Advisor:
0
Choose a valid option from the following values
1.Add an Advisor to the System.
2.Edit an advisor in the advisor array.
3.Add A student to an advisor.
4.Delete an advisor in the array.
5.Display an advisor’s basic information and the advisees in the array.
6.Exit the application.
4
Enter the ID for the Advisor:
bjs1963 //Deleted both advisors
Advisor was deleted.
Search for another advisor? :
1
Enter the ID for the Advisor:
mry2093 //Deleted both advisors
Advisor was deleted.
Search for another advisor? :
0
Choose a valid option from the following values
1.Add an Advisor to the System.
2.Edit an advisor in the advisor array.
3.Add A student to an advisor.
4.Delete an advisor in the array.
5.Display an advisor’s basic information and the advisees in the array.
6.Exit the application.
5
Enter the ID for the Advisor:
mry2093
Advisor was not found
Search for another advisor? :
 */