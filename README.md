📚 Student Management System
A Java-based Web Application for managing student data in a university system. This program enables adding, updating, searching, sorting, and validating student information stored in an XML file.

🎯 Features
✔ Add a Student

Input details: ID, First Name, Last Name, GPA, Level, and Address.
All fields are mandatory, and the ID must be unique.
Name and Address must contain only alphabetic characters.
GPA must be between 0 and 4.
✔ Update Student Details

Modify specific fields without changing the student ID.
Non-updated fields retain their previous values.
✔ Search for a Student

Search by any attribute (e.g., ID, Name, GPA).
Displays the number of matching students and their details.
✔ Sort Students

Sort by ID, First Name, GPA, etc. in ascending or descending order.
Sorted data is saved back to the XML file.

✅ Validation Rules
🔹 All fields are mandatory.
🔹 ID must be unique.
🔹 Names and Address must contain only alphabetic characters (a-z).
🔹 GPA must be between 0 and 4.

🚀 How to Use
1️⃣ Add a Student

Input student details and validate before adding.
2️⃣ Update a Student

Search by ID and update specific details.
3️⃣ Search for a Student

Search using any attribute (ID, Name, GPA, etc.).
4️⃣ Sort Students

Sort by ID, Name, or GPA in ascending/descending order.
5️⃣ Save Data

Sorted student data is saved back to the XML file.
-------------------------------------------------------------------------InstallationGuide--------------------------------------------

⚙ Installation Guide
Step 1: Install Maven
🔹 Download Maven: Apache Maven Downloads
🔹 Install Maven:

Unzip the downloaded file to a directory (e.g., C:\apache-maven).
Set up Environment Variables:
Add MAVEN_HOME pointing to your Maven directory (C:\apache-maven).
Add Maven's bin directory to the PATH variable (C:\apache-maven\bin).
Step 2: Open the Project in VS Code
🔹 Open VS Code
🔹 Go to File > Open Folder
🔹 Select your springproject folder

Step 3: Install Java & Maven Extensions in VS Code
🔹 Press Ctrl + Shift + X to open Extensions
🔹 Install:

✅ Java Extension Pack (Includes language support & debugging tools)
✅ Maven for Java (For managing Maven projects)
Step 4: Run the Maven Build Command
🔹 Open the terminal in VS Code:

Terminal > New Terminal (or press Ctrl + `)
🔹 Navigate to your springproject folder:

sh
Copy
Edit
cd path/to/springproject
🔹 Run the Maven build command:

sh
Copy
Edit
mvn clean install
Step 5: Run the Application
If your project has a main class (e.g., SpringBootApplication), run:

sh
Copy
Edit
mvn spring-boot:run
