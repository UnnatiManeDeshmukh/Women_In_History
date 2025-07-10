# 🌟  Legacy of Women 🌟
# Console-Based History Management System using PostgreSQL

A Java-based console application that allows users to manage records of influential women in history. Users can insert, view, update, and delete entries including name, birth year, country, and contributions. The application is developed using Core Java, JDBC, and PostgreSQL. It demonstrates database connectivity, SQL operations, and user interaction in a simple yet effective console environment.

-----

## 🧩  Features: Legacy of Women 

-✅ Insert Records
Add new entries of historical women.
Collects: Name, Birth Year, Country, Contribution.

-📋 Display Records
View all stored records from the PostgreSQL database.
Outputs details like ID, Name, Year, Country, Contribution.

-✏️ Update Records
Update an existing record by specifying the ID.
Allows editing of name, year, country, and contribution.

-🗑️ Delete Records
Delete a specific record by ID.

-🧱 Auto Table Creation
Automatically creates the women_in_history table if it doesn't exist.

-🔐 Secure & Structured
Uses PreparedStatement to prevent SQL injection.
Organized structure using try-with-resources for proper resource management.

-⚙️ Backend: PostgreSQL + JDBC
Manages persistent storage of women’s history data using JDBC with PostgreSQL.

-💡 Interactive Console UI
Simple menu-driven console interface for ease of use.

------
## 🧰 Technologies Used – Legacy of Women Project

-💻 Core Java

-🔗 JDBC (Java Database Connectivity)

-🛢️ PostgreSQL

-📦 PostgreSQL JDBC Driver

-🔁 Functional Interface (SQLConsumer<T>)

-📥 Scanner Class (java.util.Scanner)

-🖥️ Console-based UI

-⚙️ Try-With-Resources

------
## 📦 Dependencies

The project uses the following dependencies:

- **PostgreSQL JDBC Driver**: For connecting to the PostgreSQL database.
   <dependency>

         <groupId>org.postgresql</groupId>

          <artifactId>postgresql</artifactId>

            <version>42.7.3</version> <!-- Latest as of now -->

        </dependency>
----
## ✅ Prerequisites 

-1 JDK 8 or above – To compile and run Java code.

-2 PostgreSQL – Installed and running with database Legacy_Of_Women.

-3 PostgreSQL JDBC Driver – Add via Maven or manually as a .jar.

-4 Java IDE – IntelliJ, Eclipse, or any text editor.

-5 Basic Knowledge – Java, SQL, JDBC.

-6 Internet (if using Maven) – To download dependencies.

-7 Create PostgreSQL database with the following table

  ```sql
CREATE TABLE IF NOT EXISTS women_in_history (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    birth_year INT,
    country TEXT,
    contribution TEXT NOT NULL
);
  ```
----
## Project Output
![micoutput](https://github.com/user-attachments/assets/6454c316-a8ab-4532-aaae-bfd37fd8c4ca)

----
## 📞 Contact

For any questions or feedback, feel free to reach out:

- **Your Name** : Unnati Mane Deshmukh
- **Email**: unnatimd@22gmail.com
- **GitHub**: UnnatiManeDeshmukh

---

Enjoy using the **Legacy of Women **! 🚀

---


