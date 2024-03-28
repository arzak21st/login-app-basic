# Login App (Basic) ☕

A **Java** web application that provides a basic user registration and login mechanism. </br>

## Installation 🔌

- ### Requirements

  - [Java 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html) or higher.
  - [Maven](https://maven.apache.org/download.cgi).
  - [Tomcat 8](https://tomcat.apache.org/download-80.cgi).
  - [MySQL](https://dev.mysql.com/downloads/mysql/).
  - [Git](https://git-scm.com/downloads).
  - [NetBeans 19](https://netbeans.apache.org/front/main/download/nb19/).
    > You can use any other Java IDE, just make sure it uses the mentioned **Java 11**, **Maven**, and **Tomcat 8**. </br>

- ### Steps

  - Press the **Fork** button (top right the page) to make a copy of this project on your own GitHub account.
  - Open **Git Bash** and navigate to where you want your forked project to be cloned.
  - Clone the project with the following command:
      ```
      git clone https://github.com/your-username/your-forked-project-name.git
      ```
      > Replace `your-username` with the actual username of your GitHub account, and `your-forked-project-name` with the actual name of your forked project. </br>
  - Open **MySQL Command Line Client** and try to login 
  - Execute the SQL file found within the root directory of your cloned project with the following command:
      ```
      source path/to/your-cloned-project-name/login-app-db.sql
      ```
      > Replace `path/to/` with the actual path to `your-cloned-project-name/login-app-db.sql`, and `your-cloned-project-name` with the actual name of your cloned project. </br>
  - Open **NetBeans** (or any other Java IDE) and try to import your cloned project.
  - Make sure you set the right credentials for your MySQL database within the
  [MySqlDatabase.java](https://github.com/arzak21st/login-app-basic/blob/main/src/main/java/dev/arzak21st/loginapp/databases/MySqlDatabase.java) 
  file:
      ```
      private static final String USERNAME = "root"; // Change to your MySQL username
      private static final String PASSWORD = "pass"; // Change to your MySQL password
      ```

## Additional Information 🔥

This application utilizes plain JDBC for database interaction. </br>
