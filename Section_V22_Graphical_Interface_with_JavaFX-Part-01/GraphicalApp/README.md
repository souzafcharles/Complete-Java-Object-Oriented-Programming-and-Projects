# Graphical User Interface with JavaFX: Part 01

## 1. Introduction:

<p align="justify">
JavaFX is a powerful framework for developing modern and visually appealing graphical user interfaces in Java. This
chapter provides a comprehensive guide to setting up JavaFX and Scene Builder, creating and configuring a project in
IntelliJ IDEA, and structuring a JavaFX application. It covers fundamental aspects such as refactoring the main class,
using FXML for UI design, handling user interactions through controllers, and implementing essential components like
alerts, text fields, labels, and combo boxes. Additionally, it introduces best practices for managing input constraints
and provides an overview of JavaFX layout containers to create flexible and structured user interfaces.
</p>

<p align="justify">
By following the guidelines outlined in this chapter, developers will gain a solid understanding of JavaFX application
development, from initial setup to interactive event handling. The content also includes practical checklists to ensure
that each implementation step is correctly followed, fostering efficiency and clarity throughout the development
process. Whether designing a simple UI or a more complex interface with structured layouts, the principles presented
will serve as a strong foundation for building JavaFX applications.
</p>

***

## 2. Installation of JavaFX and Scene Builder:

### 2.1. Install JavaFX:

- **Download JavaFX SDK**:
    - Visit the official [Gluon JavaFX website](https://gluonhq.com/products/javafx/) and download the latest JavaFX SDK
      for Windows.

- **Extract the SDK**:
    - Extract the downloaded `.zip` file to a preferred location on your system (e.g., `C:\JavaFX`).

- **Set Environment Variables**:
    - Open "System Properties" → "Advanced" → "Environment Variables";
    - Under "System Variables", locate `Path` and click "Edit";
    - Add the path to the `bin` folder of the extracted JavaFX SDK (e.g., `C:\JavaFX\lib`).

- **Configure JavaFX in IntelliJ IDEA**:
    - Open IntelliJ IDEA and navigate to "File" → "Project Structure";
    - Under "Libraries", click "Add" → "Java";
    - Select the `lib` folder inside the extracted JavaFX SDK.

- **Verify Installation**:
    - Create a simple JavaFX application and run it to confirm that JavaFX is correctly installed.

### 2.2. Install Scene Builder:

- **Download Scene Builder**:
    - Visit the official [Gluon Scene Builder website](https://gluonhq.com/products/scene-builder/) and download the
      Windows installer.

- **Run the Installer**:
    - Open the downloaded `.exe` file and follow the installation prompts to complete the setup.

- **Configure Scene Builder in IntelliJ IDEA**:
- Open IntelliJ IDEA and navigate to "File" → "Settings" → "Languages & Frameworks" → "JavaFX";
- Locate the "Scene Builder path" field and browse to the installed Scene Builder executable (e.g.,
  `C:\Program Files\SceneBuilder\SceneBuilder.exe`).

- **Test Scene Builder Integration**:
    - Create an FXML file in your project;
    - Right-click the FXML file and select "Open in Scene Builder" to ensure the integration is working correctly.

***

## 3. Creating a New Project in IntelliJ:

### 3.1. Open IntelliJ IDEA:

- On the welcome screen: Click on "New Project";
- On the main screen: Navigate to "File" > "New" > "Project".

### 3.2. Select the Project Type:

- In the "New Project" window, select "JavaFX" from the left panel.

### 3.3. Configure the Project:

- **Name:** Assign the name "GraphicalApp";
- **Location:** Choose a directory to save the project;
- **Language:** Select Java as the programming language;
- **Build system:** Choose Maven as the build system;
- **JDK:** Select JDK version 21.

### 3.4. Click "Next":

- After configuring the project, click "Next".

### 3.5. Keep the Default JavaFX Libraries.

### 3.6. Click "Create":

- Click "Create" to generate the project. IntelliJ IDEA will produce a basic JavaFX project.

### 3.7. Run the Project:

- Open the `HelloApplication.java` class;
- Click the execution icon in the side panel and select "Run 'HelloApplication.main()'";
- IntelliJ IDEA will compile and execute the JavaFX project.

***

## 4. Refactoring `HelloApplication.main()`

### 4.1. Convert the Class to `Main.java`:

- Refactor the existing class to ensure proper structure;
- Define a `start(Stage primaryStage)` method;
- Load the main scene using a `BorderPane` and apply the appropriate stylesheet;
- Ensure error handling for potential exceptions.

***

## 5. Testing FXML:

### 5.1. Checklist:

- Create a package named `gui`;
- Create an FXML file within the project:
    - Right-click on the `gui` package -> "New" -> "Other" -> "New FXML Document";
    - **Name:** Assign the name "View";
- Open the FXML file in Scene Builder:
    - Right-click -> "Open in Scene Builder";
- Examine the following tabs:
    - **Inspector > Layout:** Define width and height, then save;
    - **Library > Control:** Add interface elements (e.g., `TextField`, `Button`).
- Modify the `start` method in `Main` to load the FXML file using `FXMLLoader`.

***

## 6. Handling Events in JavaFX:

### 6.1. Checklist:

- Create a controller class for the view (e.g., `ViewController.java`);
- In the controller:
    - Define attributes for UI components and annotate them with `@FXML`;
    - Implement methods to handle user events and annotate them with `@FXML`.
- In Scene Builder:
    - Link the FXML view to the controller (`Controller` tab);
    - Assign an `fx:id` to each component (`Code` tab);
    - Associate methods with respective events (`Code` tab).
- **Tip:** After making changes in Scene Builder, use "Project" > "Clean" in IntelliJ IDEA to refresh the project.

***

## 7. Displaying Alerts:

### 7.1. Implement an Alert Utility:

- Create a utility class to manage alert pop-ups;
- Define a method to display alerts using JavaFX's `Alert` class;
- Set alert properties such as title, header, and content.

***

## 8. Using TextField and Label (Sum Calculation Application):

### 8.1. Checklist:

- Design the interface in Scene Builder, using a `Label` for the result;
- Utilise the `promptText` property for input fields;
- Implement a controller to perform calculations:
    - Handle `NumberFormatException` for invalid inputs;
- Return to Scene Builder and set up `fx:id` and event bindings.

***

## 9. Addressing TextField and Initializable Behaviour:

### 9.1. Checklist:

- Create a utility class `Constraints` to manage text field restrictions;
- Implement constraints such as:
    - Allow only integer values in a `TextField`;
    - Set a maximum character length;
    - Allow only decimal values.
- Ensure the controller implements `Initializable`.

***

## 10. Enhancements to ComboBox Implementation:

### 10.1. Checklist:

- Set the `promptText` property for user guidance;
- Use a generic type for `ComboBox` (e.g., `ComboBox<Person>`);
- Create an `ObservableList`, `ObservableSet`, or `ObservableMap`:
    - Convert lists to an observable format using `FXCollections.observableList(list)`;
- Populate `ComboBox` with observable data using `.setItems(observableList)`;
- Retrieve selected items via `comboBox.getSelectionModel().getSelectedItem()`;
- Access the collection through `comboBox.getItems()`;
- Customise item display within the `ComboBox`:
    - Implement a `CellFactory` to modify the displayed text.

***

## 11. Overview of Major Layout Containers:

### 11.1. Brief Description:

- **AnchorPane**: Provides a flexible layout where child elements can be anchored to the top, bottom, left, or right
  edges, ensuring dynamic resizing behaviour;
- **GridPane**: Organises components into a flexible grid of rows and columns, allowing precise placement and alignment
  of elements;
- **SplitPane**: Divides the screen into resizable sections, enabling users to adjust the proportions dynamically;
- **VBox & HBox**: VBox arranges components in a vertical stack, while HBox places them in a horizontal sequence,
  ensuring a structured layout;
- **BorderPane**: Arranges elements into five distinct regions—top, bottom, left, right, and centre—providing a
  structured and adaptable layout;
- **ScrollPane**: Encapsulates content within a scrollable view, enabling users to navigate through larger interfaces
  efficiently.





