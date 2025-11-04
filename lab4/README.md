# Lab 4: Library Management System

**Team Members:**

- Maksym Spizhovyi
- Tatsuki Sugawara

---

## 🎯 Objective

Refactor the initial `LibraryApp` (monolithic class) into a modular, object-oriented system that follows **GRASP principles**:

- Information Expert
- Creator
- Controller
- Low Coupling
- High Cohesion

---

## 🪄 Tasks / To-Dos

### 1. System Design

- Design the full object model following GRASP.
- Draw a **UML class diagram** showing all relationships (`Library`, `Book`, `Member`, `LibrarianController`, `LibraryApp`).
- Draw a **Use Case Diagram** illustrating core interactions (Add Book, Register Member, Borrow, Return, Lookup, Reject Request).
- Save both diagrams as `.png` and commit them to `/docs` folder.

### 2. Implement Classes

| Class                   | Responsibilities                                                                            | GRASP Principle                   |
| ----------------------- | ------------------------------------------------------------------------------------------- | --------------------------------- |
| **Book**                | Store title, author, availability. Handle borrow/return status.                             | Information Expert                |
| **Member**              | Manage member ID, name, and borrowed books list. Borrow / return books via methods.         | Information Expert & Low Coupling |
| **Library**             | Maintain catalog and members. Add/remove books, register members, find book/member by name. | Creator & Controller              |
| **LibrarianController** | Interface between user and system. Process borrow/return requests and delegate tasks.       | Controller                        |
| **LibraryApp**          | Contains `main()` for demo scenarios and user simulation.                                   | Driver Class                      |

### 3. Apply GRASP Principles

- **Information Expert:** Move book availability logic to `Book`; borrowed list logic to `Member`.
- **Creator:** `Library` creates and manages `Book` and `Member` objects.
- **Controller:** `LibrarianController` handles user operations like borrowing/returning books.
- **Low Coupling / High Cohesion:** Each class should focus on one task and interact via defined methods only.

### 4. Demonstrate Scenarios in `LibraryApp`

- Add members (Alice, Bob).
- Add books (Dune, 1984, Moby Dick).
- Borrow a book.
- Return a book.
- Display all books in catalog.
- Lookup book/member by name.
- Handle “Reject Request” if a book is not available.

### 5. Deliverables

- `Library Management System` Java source files.
- UML **Use Case Diagram** (`/docs/usecase.png`).
- UML **Class Diagram** (`/docs/classdiagram.png`).
- Short report: how each GRASP principle was applied.
- Public GitHub repository link.

---
