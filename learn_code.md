# TaskFlow — Learning Roadmap and Project Specification

> **Purpose:** Learn backend and full-stack development by building one project incrementally, understanding each concept, and completing small tasks yourself.
>
> **Project:** TaskFlow — Personal Task Management System  
> **Stack:** Java, Spring Boot, PostgreSQL, React.js, Docker, GitHub Actions, Postman, Git/GitHub  
> **Learning style:** Learn → small example → implement independently → test → review → extend.

---

## 1. Project overview

TaskFlow is a personal task-management web application. A user can create tasks, view and search tasks, update details, mark tasks as complete, and delete tasks. The application starts as a small Java console program and grows into a full-stack application with a REST API, database, browser interface, containers, and automated tests.

### Main learning goals

By completing TaskFlow, you should be able to:

- Explain core Java and object-oriented programming concepts.
- Organize code into sensible classes and layers.
- Build and test REST APIs with Spring Boot.
- Use PostgreSQL and SQL to persist and query data.
- Connect a React interface to a backend API.
- Validate input and return useful error responses.
- Use Git/GitHub, Docker Compose, and GitHub Actions.
- Explain your design choices and demonstrate the application in a placement interview.

### Scope rule

Build the simplest working version first. Do **not** begin with microservices, Kubernetes, AI features, payment systems, or complex authentication. Add authentication only after the core task workflow is reliable.

---

## 2. Functional requirements

Functional requirements describe **what the application must do**.

| ID | Requirement | Acceptance criteria |
|---|---|---|
| FR-01 | Create a task | A user can submit a title and optional description; a new task is created with a unique ID and `completed = false`. |
| FR-02 | List tasks | The application displays all tasks, with title, description, status, and ID. |
| FR-03 | View one task | A task can be retrieved by its ID. |
| FR-04 | Update a task | The user can change the title and description of an existing task. |
| FR-05 | Complete/reopen a task | The user can mark a task complete and, if desired, reopen it. |
| FR-06 | Delete a task | The user can delete an existing task. |
| FR-07 | Search tasks | The user can search tasks by title, case-insensitively. |
| FR-08 | Filter tasks | The user can filter tasks by completion status: all, pending, or completed. |
| FR-09 | Validate input | Blank titles and titles exceeding the configured length are rejected with a clear error. |
| FR-10 | Handle missing tasks | Requests for an unknown task ID return a suitable not-found response. |
| FR-11 | Persist tasks | Once PostgreSQL is integrated, tasks remain available after the backend restarts. |
| FR-12 | Display API errors | The React interface displays understandable error messages when requests fail. |
| FR-13 | Show request states | The React interface indicates loading, empty-list, success, and error states. |
| FR-14 | Document endpoints | API routes, request examples, response examples, and error codes are documented. |

**MVP definition:** FR-01 through FR-06. Search, filters, validation, polished UI, and infrastructure are added in later milestones.

### Initial task data model

- `id`: unique identifier. Use a Java `long` initially; use a generated primary key in PostgreSQL.
- `title`: required text, maximum 120 characters.
- `description`: optional text, maximum 1000 characters.
- `completed`: boolean, initially false.
- `createdAt`: creation timestamp; introduce when persistence is added.
- `updatedAt`: last-update timestamp; introduce when persistence is added.

The Java model and database entity may evolve as the project grows. Keep API request/response DTOs separate from the database entity once you reach the DTO milestone.

---

## 3. Non-functional requirements

Non-functional requirements describe **how well and how safely the application should operate**.

| ID | Requirement | How to verify it |
|---|---|---|
| NFR-01 | Maintainability | Keep controller, service, repository, model/entity, DTO, and configuration responsibilities separate as appropriate. |
| NFR-02 | Readability | Use meaningful names, consistent formatting, and small methods; avoid duplicated business logic. |
| NFR-03 | Reliability | Handle invalid input, missing records, database errors, and unexpected failures without returning misleading success responses. |
| NFR-04 | Data persistence | PostgreSQL stores tasks; restarting the backend must not erase data. |
| NFR-05 | Testability | Add unit tests for business logic and integration tests for important API/database behaviour. |
| NFR-06 | API consistency | Use appropriate HTTP methods and status codes, and a consistent JSON error format. |
| NFR-07 | Security baseline | Never commit secrets; use environment variables for credentials; validate input. Do not store plaintext passwords if authentication is later introduced. |
| NFR-08 | Portability | A developer can run the application using documented local setup steps and, later, Docker Compose. |
| NFR-09 | Performance baseline | List/search operations should be simple and responsive for a small personal task list. Add pagination if the dataset grows. |
| NFR-10 | Observability | Record useful application errors with a logging framework; do not log secrets. |
| NFR-11 | Usability | The interface is understandable, provides feedback, and handles loading, empty, success, and error states. |
| NFR-12 | Automated quality checks | GitHub Actions runs the backend build and tests on pushes and pull requests. |

These are learning-project targets, not claims of production-scale performance or security certification.

---

## 4. Architecture — how the parts communicate

```text
React.js browser UI
    │  HTTP requests / JSON responses
    ▼
Spring Boot REST Controller
    │
    ▼
Service layer (business rules)
    │
    ▼
Spring Data JPA Repository
    │
    ▼
PostgreSQL database

Postman ───────────────► REST API (manual API testing)

GitHub repository ────► GitHub Actions (automated build/tests)

Docker Compose ───────► Spring Boot container + PostgreSQL container
```

### Responsibilities

- **React:** displays tasks, collects user input, calls the API, and displays results/errors.
- **Controller:** maps HTTP requests to application operations and chooses response status codes.
- **Service:** enforces business rules and coordinates operations.
- **Repository:** reads/writes persisted entities.
- **Entity/model:** represents task data.
- **DTO:** defines what clients send and receive through the API.
- **PostgreSQL:** stores task records durably.
- **Postman:** manually tests endpoints independently of React.
- **Docker Compose:** starts the application services with consistent configuration.
- **GitHub Actions:** runs automated checks when code changes.

---

## 5. Roadmap and completion tasks

Work through these milestones in order. Do not move on merely because a lesson was read; move on when the completion criteria are met.

### Milestone 0 — Development environment and Git

**Learn**
- JDK and Java version basics.
- IDE setup (VS Code or IntelliJ).
- Terminal basics and project folders.
- Git: `status`, `add`, `commit`, `log`, `push`.
- GitHub repository and `.gitignore`.
- Maven basics: project configuration and build lifecycle.

**Tasks**
- [ ] Verify Java and Maven are installed.
- [ ] Create a `taskflow` project folder.
- [ ] Initialize a Git repository.
- [ ] Create a README with the project goal and current progress.
- [ ] Make the first commit.

**Done when:** the project is version-controlled and another developer could understand its purpose from the README.

### Milestone 1 — Java fundamentals through the Task model

**Learn**
- Classes and objects.
- Fields, constructors, methods.
- `private` fields and encapsulation.
- Getters/setters and validation.
- `toString`, equality basics.
- Primitive types, references, and `boolean`.

**Tasks**
- [ ] Create a `Task` class with ID, title, description, and completion status.
- [ ] Write a constructor.
- [ ] Add getters and suitable update/completion methods.
- [ ] Create several task objects in a temporary `main` method.
- [ ] Print and inspect their state.
- [ ] Explain why fields should not be public.

**Done when:** you can create and manipulate task objects without copying a finished solution.

### Milestone 2 — Collections and business logic

**Learn**
- `List`, `ArrayList`, and generics.
- Loops and enhanced `for`.
- Searching and updating objects.
- `Map`/`HashMap` and when it can help.
- `Optional` (introductory use).
- Streams and lambdas (after implementing a loop-based solution).
- Separation of concerns.

**Tasks**
- [ ] Create `TaskService`.
- [ ] Store tasks in a `List<Task>`.
- [ ] Implement create, list, find-by-ID, update, complete/reopen, and delete.
- [ ] Reject duplicate IDs in the console version.
- [ ] Search by title.
- [ ] Filter by completion status.
- [ ] Sort by title or ID.
- [ ] Test normal and edge cases manually.

**Done when:** business logic lives outside `main`, and each operation behaves correctly.

### Milestone 3 — Exceptions, validation, and file I/O (Java practice)

**Learn**
- Checked vs unchecked exceptions.
- `try/catch/finally` and try-with-resources.
- Input validation.
- Reading and writing text files.
- Parsing strings and handling malformed records.
- Unit testing fundamentals (JUnit introduction).

**Tasks**
- [ ] Handle invalid menu choices and malformed input.
- [ ] Reject blank/overlong titles.
- [ ] Save tasks to a file.
- [ ] Load tasks when the program starts.
- [ ] Handle missing or corrupted files without crashing unexpectedly.
- [ ] Add tests for service operations and invalid inputs.

**Done when:** the console version can save/reload tasks and recover sensibly from common input errors.

**Design note:** file persistence is a learning exercise. It will later be replaced by PostgreSQL; do not keep both persistence mechanisms unnecessarily in the final application.

### Milestone 4 — Spring Boot and REST basics

**Learn**
- What Spring and Spring Boot provide.
- Dependency Injection and IoC.
- Beans and component scanning.
- Maven dependencies and application configuration.
- Layered architecture.
- HTTP, REST, JSON, request bodies, and path variables.
- `@RestController`, mapping annotations, and response status codes.
- CORS basics for a separate frontend.

**Tasks**
- [ ] Create a Spring Boot project with Spring Web and validation dependencies.
- [ ] Start the application and inspect its logs.
- [ ] Create a controller for `/api/tasks`.
- [ ] Implement an initial in-memory API using the service layer.
- [ ] Implement `GET /api/tasks` and `GET /api/tasks/{id}`.
- [ ] Implement `POST /api/tasks`.
- [ ] Implement `PUT /api/tasks/{id}` or a suitable partial-update route.
- [ ] Implement `PATCH /api/tasks/{id}/completion`.
- [ ] Implement `DELETE /api/tasks/{id}`.
- [ ] Return appropriate success and not-found status codes.
- [ ] Test every endpoint in Postman.

**Done when:** the API works without React and you can explain the controller → service flow.

**Important:** in-memory data disappears when the application restarts. That is expected at this stage.

### Milestone 5 — SQL and PostgreSQL

**Learn**
- Database, table, row, and column.
- Primary keys, constraints, and data types.
- `SELECT`, `INSERT`, `UPDATE`, `DELETE`.
- `WHERE`, `ORDER BY`, `LIKE`, and `ILIKE`.
- Aggregate functions and `GROUP BY`.
- Joins and foreign keys (practise even though the first version has one main table).
- Transactions and indexes at an introductory level.
- Database credentials and connection configuration.

**Tasks**
- [ ] Install/use PostgreSQL locally.
- [ ] Create a database for TaskFlow.
- [ ] Create and inspect a tasks table.
- [ ] Insert, query, update, and delete test records with SQL.
- [ ] Practise searching and filtering directly in SQL.
- [ ] Configure Spring Boot to connect to PostgreSQL.
- [ ] Keep credentials outside committed source code.

**Done when:** the application can connect to the database and execute database operations.

### Milestone 6 — Spring Data JPA and persistence

**Learn**
- ORM, JPA, and Hibernate roles.
- `@Entity`, `@Id`, and generated IDs.
- Repository interfaces and derived queries.
- Entity lifecycle and transactions.
- Database schema configuration.
- Mapping application operations to persistence operations.

**Tasks**
- [ ] Create a task entity.
- [ ] Create a Spring Data JPA repository.
- [ ] Replace the in-memory store with repository-backed persistence.
- [ ] Implement CRUD operations through the service.
- [ ] Test behaviour after a backend restart.
- [ ] Implement title search and status filtering.
- [ ] Learn why production schema changes should use migrations rather than relying on automatic schema creation.

**Done when:** the REST API uses PostgreSQL as its source of truth and data survives restart.

### Milestone 7 — API quality and automated testing

**Learn**
- DTOs and why entities should not always be returned directly.
- Bean Validation: `@NotBlank`, `@Size`, and `@Valid`.
- Global exception handling with `@ControllerAdvice`.
- Consistent error responses.
- Logging with SLF4J.
- Unit vs integration tests.
- Pagination and sorting with Spring Data.

**Tasks**
- [ ] Create request and response DTOs.
- [ ] Validate titles and descriptions.
- [ ] Return a clear `400 Bad Request` for invalid input.
- [ ] Return `404 Not Found` for unknown task IDs.
- [ ] Handle unexpected errors without exposing internal details.
- [ ] Add unit tests for service logic.
- [ ] Add controller/API tests and appropriate persistence tests.
- [ ] Add pagination and sorting to the task list.
- [ ] Document the API using OpenAPI/Swagger.
- [ ] Keep a Postman collection in the repository.

**Done when:** the API handles normal and invalid requests predictably, and the main behaviours have automated tests.

### Milestone 8 — React.js interface

**Learn**
- Node.js/npm basics and React project structure.
- Components, JSX, props, and state.
- Event handling and controlled forms.
- Rendering arrays and using stable keys.
- `useEffect` for loading data.
- Fetch or Axios for HTTP calls.
- Loading, empty, success, and error states.
- Basic CSS and accessible form labels.

**Tasks**
- [ ] Create a React frontend.
- [ ] Build a task list component.
- [ ] Build a create-task form.
- [ ] Connect the UI to the Spring Boot API.
- [ ] Implement edit, delete, and completion actions.
- [ ] Add search and status filters.
- [ ] Show loading, empty-list, and error states.
- [ ] Configure backend CORS for the frontend development origin.
- [ ] Test the full workflow in a browser.

**Done when:** you can manage tasks from the UI and verify that changes are persisted in PostgreSQL.

### Milestone 9 — Docker and Docker Compose

**Learn**
- Image vs container.
- Dockerfile, build context, ports, and environment variables.
- Container networking and service names.
- Persistent volumes.
- Compose services, dependencies, and health checks.
- Why `localhost` means something different inside a container.

**Tasks**
- [ ] Write a Dockerfile for the backend.
- [ ] Create Compose configuration for PostgreSQL and the backend.
- [ ] Configure database connection details through environment variables.
- [ ] Add a persistent database volume.
- [ ] Add an appropriate database health check and startup dependency.
- [ ] Verify the backend can reach PostgreSQL by its Compose service name.
- [ ] Run the application using Compose.
- [ ] Stop and restart services; verify database data remains.

**Done when:** the backend and database can be started reproducibly with documented commands.

**Note:** the React development server can run locally at first. Containerize or serve the frontend as a later improvement if time permits.

### Milestone 10 — GitHub Actions and delivery readiness

**Learn**
- Workflow YAML.
- Triggers: push and pull request.
- Jobs, steps, and actions.
- Java setup, Maven build, and test execution.
- Environment variables and secrets.
- CI vs deployment/CD.
- README writing and release/demo preparation.

**Tasks**
- [ ] Push the project to GitHub.
- [ ] Create a GitHub Actions workflow.
- [ ] Run Maven tests on pushes and pull requests.
- [ ] Configure a PostgreSQL service container for integration tests if needed.
- [ ] Fix failing tests and ensure CI passes.
- [ ] Document local and Docker-based setup.
- [ ] Add architecture, endpoint list, screenshots, and example requests to README.
- [ ] Record known limitations and future improvements.

**Done when:** a fresh code change triggers automated checks and the repository explains how to run and test the application.

### Milestone 11 — Optional security and extension work

Only start this after the previous milestones are working.

**Learn**
- Spring Security fundamentals.
- Password hashing with BCrypt.
- Authentication vs authorization.
- JWT or session-based authentication and their trade-offs.
- Ownership checks and protecting user-specific task data.

**Tasks**
- [ ] Add registration and login only if time allows.
- [ ] Hash passwords; never store plaintext passwords.
- [ ] Protect endpoints appropriately.
- [ ] Ensure a user can access only their own tasks.
- [ ] Test unauthorized and forbidden requests.
- [ ] Keep secrets out of Git and document configuration.

**Done when:** authentication and authorization are tested rather than merely appearing to work in the UI.

Other optional extensions: task due dates, priorities, categories, reminders, deployment, and monitoring. Choose one or two; avoid feature creep.

---

## 6. Suggested API contract

Use `/api/tasks` as the base route. Keep the contract consistent as the implementation evolves.

| Method | Endpoint | Purpose | Typical response |
|---|---|---|---|
| `POST` | `/api/tasks` | Create a task | `201 Created` |
| `GET` | `/api/tasks` | List tasks | `200 OK` |
| `GET` | `/api/tasks/{id}` | Fetch one task | `200 OK` or `404 Not Found` |
| `PUT` | `/api/tasks/{id}` | Replace editable task details | `200 OK`, `400`, or `404` |
| `PATCH` | `/api/tasks/{id}/completion` | Change completion status | `200 OK` or `404` |
| `DELETE` | `/api/tasks/{id}` | Delete a task | `204 No Content` or `404` |
| `GET` | `/api/tasks?status=pending` | Filter tasks | `200 OK` |
| `GET` | `/api/tasks?search=report` | Search titles | `200 OK` |

Exact request and response DTOs will be designed when you reach the API milestone. Use consistent validation and error responses.

---

## 7. Testing checklist

Test both expected behaviour and failure cases.

### Functional cases
- [ ] Create a valid task.
- [ ] List tasks.
- [ ] Fetch an existing task.
- [ ] Update task details.
- [ ] Mark a task complete and reopen it.
- [ ] Delete a task.
- [ ] Search and filter tasks.
- [ ] Restart the backend and confirm data persists.

### Negative and edge cases
- [ ] Blank or whitespace-only title.
- [ ] Title exceeds the maximum length.
- [ ] Description exceeds the maximum length.
- [ ] Unknown task ID.
- [ ] Malformed JSON or invalid field types.
- [ ] Empty task list.
- [ ] Database unavailable.
- [ ] Frontend API request fails.
- [ ] Repeated delete or update for a missing task.
- [ ] Data remains after container restart.

Record the expected result and actual result in your test notes. Use Postman for manual API tests and automated tests for repeatable checks.

---

## 8. Repository structure (target, not day one)

```text
taskflow/
├── backend/
│   ├── src/main/java/.../
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── entity/
│   │   ├── dto/
│   │   ├── exception/
│   │   └── config/
│   ├── src/test/java/...
│   └── pom.xml
├── frontend/
│   ├── src/
│   └── package.json
├── postman/
│   └── TaskFlow.postman_collection.json
├── .github/workflows/
│   └── ci.yml
├── compose.yaml
├── .env.example
├── .gitignore
└── README.md
```

The initial Java console version can be in a temporary `phase-1-console/` folder or a separate branch. Do not force console-specific code into the final Spring Boot architecture if it no longer serves a purpose.

---

## 9. Completion and resume readiness

You are ready to present TaskFlow as a project when you can:

1. Run it from documented instructions.
2. Demonstrate create, read, update, and delete flows.
3. Explain the React → Controller → Service → Repository → PostgreSQL flow.
4. Explain dependency injection and why the layers are separated.
5. Demonstrate validation and not-found/error handling.
6. Show meaningful tests and a passing GitHub Actions workflow.
7. Explain how Docker Compose starts the services and persists database data.
8. Discuss at least one bug you encountered and how you fixed it.

### Resume entry template — use only after implementing the relevant items

**TaskFlow — Personal Task Management System**  
*Java, Spring Boot, PostgreSQL, Spring Data JPA, React, Docker, GitHub Actions, Postman*

- Built a full-stack task management application with REST APIs for task creation, retrieval, updating, deletion, search, and status filtering.
- Persisted task data in PostgreSQL using Spring Data JPA and implemented input validation and consistent API error handling.
- Developed a React interface to interact with the backend and testable API workflows.
- Containerized services with Docker Compose and configured GitHub Actions to build and test changes automatically.

Remove or revise any bullet for a feature you have not actually implemented. Do not describe the project as production-ready unless it has been appropriately secured, tested, deployed, and operated.

---

## 10. How to use this roadmap

- Complete one milestone at a time.
- Write the code yourself before looking at a complete solution.
- Commit working increments to Git.
- Keep notes on what you learned and what failed.
- Ask for help with the smallest failing part: your code, the error, and what you expected.
- Move forward when you can explain the concept and demonstrate the task.

**First action:** Complete Milestone 0, then Milestone 1. Create the `Task` class and test it before introducing collections or Spring Boot.
