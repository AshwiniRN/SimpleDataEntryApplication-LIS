# Simple Data Entry Application

This is a simple data entry application developed using Java and Spring Boot.

## Setup Instructions

Follow these steps to set up and run the application:

### Prerequisites

### Prerequisites

Before you begin, ensure that you have the following installed on your system:

- **Java Development Kit (JDK)**: Make sure you have JDK installed.
- **Eclipse IDE**: Download and install Eclipse IDE for Java Developers.
- **IntelliJ IDEA**: Download and install IntelliJ IDEA. (Optional)
- **Git**: If you plan to clone the repository, ensure that Git is installed on your system.

### Clone the Repository
1. Open a terminal or command prompt.
2. Navigate to the directory where you want to clone the repository.
3. Run the following command:
```bash
git clone https://github.com/AshwiniRN/SimpleDataEntryApplication-LIS
```
### Import Project in Eclipse
If you're using Eclipse, follow these steps to import the project:

1. Open Eclipse IDE.
2. Select `File` > `Import` from the menu.
3. In the Import dialog, expand the `Maven` folder and select `Existing Maven Projects`.
4. Click `Next`.
5. Browse to the directory where you cloned the repository (if applicable) or where you want to import the project.
6. Select the project folder and click `Finish`.

### Import Project in IntelliJ IDEA
1. Open IntelliJ IDEA.
2. Click on "Open or Import" and select the directory where you cloned the repository.
3. Select the "pom.xml" file and click "Open" to import the project.

### Build and Run the Application (With IDE)

Follow these steps to build and run the application:

1. In Eclipse's or IntelliJ's Project Explorer, navigate to `src/main/java/com/ashnadagoud/simpledataentryapplication`.
2. Right-click on the `SimpleDataEntryApplication.java` file.
3. Select `Run As` > `Java Application` (in Eclipse) or `Run 'SimpleDataEntryApplication'` (in IntelliJ).

The application will start, and you can access it at http://localhost:8080

### Build and Run the Application (Without IDE)

If you prefer not to use an IDE, you can build and run the application using the following steps:

1. Open a terminal or command prompt.
2. Navigate to the root directory of the project.
3. Run the following command to build the project:
```bash
mvn clean install
```
4.Once the build is successful, run the following command to start the application:
```bash
mvn spring-boot:run
```


### Usage
1. Navigate to http://localhost:8080 in your web browser.
2. Fill out the form with the required information (Name and Title).
3. Click the "Submit" button to submit the data.
4. You will be redirected to a confirmation page showing the entered data.
5. To add more data, click the "Back to Data Entry Form" link.
