# SDP-ASSIGNMENT-1
# Software Design Patterns — Assignment 1: Builder Design Pattern

## Product Overview
This project implements the **Builder Creational Design Pattern** in Java for a **Modern Library Management System**. 

The core domain object, `LibraryResource`, represents complex library materials with required attributes (`id`, `title`, `author`) and optional attributes (`isbn`, `publisher`, `publishedDate`, `genre`, `maxborrowDays`). The Builder Pattern simplifies the construction of these complex objects through a Fluent API and leverages `LibraryResourceDirector` to encapsulate reusable preset configurations.

---

## Project Structure

The project strictly follows the Builder Pattern components:
- **`LibraryResource` (Product):** The target complex object containing library item attributes and getters.
- **`LibraryResourceBuilder` (Builder):** Handles step-by-step object construction using method chaining (Fluent API) and enforces state validation.
- **`LibraryResourceDirector` (Director):** Orchestrates preset configurations for standard books and rare archival books.
- **`Main` (Client):** Demonstrates resource creation using both direct Builder usage and Director orchestration.

---

## Clean Code Principles Applied

### 1. Meaningful and Intention-Revealing Names
Names clearly communicate their intent, making code self-documenting without needing unnecessary inline comments.
* **Bad:**
  ```java
  public LibraryResourceBuilder days(int d) {
      this.maxborrowDays = d;
      return this;
  }
Good:

Java
public LibraryResourceBuilder setMaxborrowDays(int maxborrowDays) {
    this.maxborrowDays = maxborrowDays;
    return this;
}
2. Single Responsibility Principle (Small, Focused Methods)
Each class and method has a single responsibility. Construction logic and validation are completely decoupled from the domain model and handled exclusively inside the Builder and Director.

Bad:

Java
public LibraryResource buildAndPrint() {
    LibraryResource resource = new LibraryResource(this);
    System.out.println("Created: " + resource.getId());
    return resource;
}
Good:

Java
public LibraryResource build() {
    if (id == null) {
        throw new IllegalStateException("Resource ID cannot be null.");
    }
    return new LibraryResource(this);
}
3. Validated Construction
The Builder enforces object state integrity inside the build() method, preventing the instantiation of invalid or incomplete domain objects by throwing explicit runtime exceptions.

Bad:

Java
public LibraryResource build() {
    return new LibraryResource(this); // Allows creating an object with null ID
}
Good:

Java
public LibraryResource build() {
    if (id == null) {
        throw new IllegalStateException("Resource ID cannot be null.");
    }
    return new LibraryResource(this);
}
4. Method Chaining (Fluent API) & Immutability
Setters in LibraryResourceBuilder return this to allow seamless method chaining. The LibraryResource fields are initialized exclusively through the Builder, guaranteeing object consistency once built.

Bad:

Java
LibraryResourceBuilder builder = new LibraryResourceBuilder("RES-001", "Clean Code", "Robert Martin");
builder.setIsbn("978-0132350884");
builder.setGenre("Software");
LibraryResource resource = builder.build();
Good:

Java
LibraryResource resource = new LibraryResourceBuilder("RES-001", "Clean Code", "Robert Martin")
        .setIsbn("978-0132350884")
        .setGenre("Software")
        .build();
5. Encapsulation of Preset Building Logic (Director Pattern)
Common resource presets (such as standard borrowing rules vs. rare archival rules) are encapsulated within LibraryResourceDirector, reducing duplication in client code.

Bad:

Java
// Recreating preset logic manually every time in Main
LibraryResource rareBook = new LibraryResourceBuilder("RES-999", "Ancient Manuscript", "Unknown")
        .setMaxborrowDays(0)
        .build();
Good:

Java
LibraryResourceDirector director = new LibraryResourceDirector();
LibraryResourceBuilder builder = new LibraryResourceBuilder("RES-999", "Ancient Manuscript", "Unknown");
LibraryResource rareBook = director.constructRareArchivalBook(builder);
How to Run the Project
Clone the repository:

Bash
git clone [https://github.com/serikbaynurali/SDP-ASSIGNMENT-1.git](https://github.com/serikbaynurali/SDP-ASSIGNMENT-1.git)
Navigate to the project root directory:

Bash
cd SDP-ASSIGNMENT-1
Compile the Java files:

Bash
javac -d out src/*.java
Run the application:

Bash
java -cp out Main
