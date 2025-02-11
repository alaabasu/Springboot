# 📚 Student Management System  
A **Java-based Web Application** for managing student data in a university system. This program enables **adding, updating, searching, sorting, and validating** student information stored in an **XML file**.

---

## 🎯 Features  
✔ **Add a Student** – Input details: **ID, First Name, Last Name, GPA, Level, Address**. All fields are **mandatory**, and **ID must be unique**. Name and Address must contain only **alphabetic characters**. GPA must be between **0 and 4**. <br>
✔ **Update Student Details** – Modify specific fields **without changing the student ID**. Non-updated fields retain previous values. <br>
✔ **Search for a Student** – Search using **ID, Name, GPA, etc.** Displays the **number of matching students** and their details. <br>
✔ **Sort Students** – Sort by **ID, First Name, GPA, etc.** in **ascending or descending order**. <br>
✔ **Save Sorted Data** – Sorted student data is **saved back to the XML file**.  

---

## 📂 XML Structure  
```xml
<Student>
    <ID>1</ID>
    <FirstName>Ahmed</FirstName>
    <LastName>Mohamed</LastName>
    <Gender>Male</Gender>
    <GPA>3.17</GPA>
    <Level>4</Level>
    <Address>Giza</Address>
</Student>

✅ Validation Rules
🔹 All fields are mandatory. <br> 🔹 ID must be unique. <br> 🔹 Names and Address must contain only alphabetic characters (a-z). <br> 🔹 GPA must be between 0 and 4.

🚀 How to Use
1️⃣ Add a Student – Input student details and validate before adding. <br> 2️⃣ Update a Student – Search by ID and update specific details. <br> 3️⃣ Search for a Student – Search using any attribute (ID, Name, GPA, etc.). <br> 4️⃣ Sort Students – Sort by ID, Name, or GPA in ascending/descending order. <br> 5️⃣ Save Data – Sorted student data is saved back to the XML file.


🛠 Technologies Used
Java (Main Programming Language) | XML (Data Storage) | Spring Boot (Framework) | Maven (Build Automation)

