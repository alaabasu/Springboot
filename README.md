Student Management System
This Java-based Web Application allows managing student data for a university system. The program supports adding, updating, searching, sorting, and validating student information stored in an XML file.

Features
Add a Student

User can input student details such as ID, First Name, Last Name, GPA, Level, and Address.
All fields are mandatory, and the ID must be unique.
Name and address must contain only alphabetic characters.
GPA must be between 0 and 4.
Update Student Details

Users can update specific details (e.g., First Name, Last Name, GPA) without changing the student ID.
Non-updated fields retain their previous values.
Search for a Student

Search for students by any attribute (e.g., ID, Name, GPA).
Displays the number of matching students and shows their details.
Sort Students

Sort students by ID, First Name, GPA, etc., in ascending or descending order.
Save Sorted Data

The sorted student data is saved back to the XML file.
XML Structure
xml
Copy code
<University>
    <Student ID="20200134">
        <FirstName>Ahmed</FirstName>
        <LastName>Mohamed</LastName>
        <Gender>Male</Gender>
        <GPA>3.17</GPA>
        <Level>4</Level>
        <Address>Giza</Address>
    </Student>
</University>
Validation Rules
All fields are mandatory.
ID must be unique.
Names and Address must only contain alphabetic characters (a-z).
GPA must be between 0 and 4.
How to Use
Add a Student: Input student details and validate before adding.
Update Student: Search for a student by ID and update their details.
Search for a Student: Use any attribute to search for a student.
Sort Students: Sort by attributes like ID, Name, or GPA in ascending or descending order.
Save: The sorted data is saved back to the XML file.
Technologies Used
Java: The main programming language.
XML: For storing and reading student data.



 Install Maven
Maven is a build automation tool used for Java projects. If you don't have Maven installed, follow these steps:
Download Maven:
Visit Apache Maven Downloads and download the latest version.
Install Maven:
Unzip the downloaded file to a directory (e.g., C:\apache-maven).
Set Environment Variables:
Add MAVEN_HOME in your environment variables pointing to your Maven directory (C:\apache-maven).
Add Maven's bin directory to the PATH variable. For example: C:\apache-maven\bin.

Open Project Folder
Open VSCode.
Open your project folder (springproject) by going to File > Open Folder and select your springproject folder.
4. Install the Java and Maven Extensions in VSCode
Go to the Extensions view by clicking on the Extensions icon on the left sidebar (or press Ctrl + Shift + X).
Search for the following extensions and install them:
Java Extension Pack (which includes necessary tools like language support and debugging).
Maven for Java (helps in managing Maven projects).
5. Run the Maven Build Command
Open the terminal in VSCode (Terminal > New Terminal or Ctrl + ).
Navigate to your project folder (springproject), if you're not already in it:
bash
Copy code
cd path/to/springproject
Run the Maven command to compile and run your project:
bash
Copy code
mvn clean install
This command will clean any previous build and compile your project.
6. Run the Application
If your project has a main class (e.g., SpringBootApplication), you can run it by using the following Maven command:

bash
Copy code
mvn spring-boot:run



