# 📋 Task Tracker App

A modern full-stack task management application built with **Spring Boot** and **React**. This project demonstrates a complete CRUD application with a RESTful API backend and a responsive frontend.

## 🚀 Features

- ✅ **Full CRUD Operations**: Create, Read, Update, and Delete tasks
- 🔍 **Search & Filter**: Search tasks by title and filter by status
- 📱 **Responsive Design**: Works seamlessly on desktop and mobile
- 🎨 **Modern UI**: Clean interface built with TailwindCSS
- 🔄 **Real-time Updates**: Instant UI updates after operations
- 📊 **Status Management**: Track tasks with TODO, IN_PROGRESS, and DONE states
- 🛡️ **Input Validation**: Both frontend and backend validation
- 📖 **API Documentation**: Swagger/OpenAPI integration

## 🛠️ Technology Stack

### Backend
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **H2 Database** (In-memory)
- **Maven** (Dependency Management)
- **Swagger/OpenAPI** (API Documentation)

### Frontend
- **React 18** with TypeScript
- **TailwindCSS** (Styling)
- **Functional Components** with Hooks
- **Fetch API** (HTTP Client)

## 🏗️ Project Structure

```
task-tracker-app/
├── backend/                    # Spring Boot Application
│   ├── src/main/java/com/tasktracker/
│   │   ├── controller/        # REST Controllers
│   │   ├── service/          # Business Logic
│   │   ├── repository/       # Data Access Layer
│   │   ├── entity/           # JPA Entities
│   │   ├── dto/              # Data Transfer Objects
│   │   ├── mapper/           # Entity-DTO Mappers
│   │   └── config/           # Configuration Classes
│   ├── src/main/resources/
│   │   ├── application.properties
│   │   └── data.sql          # Initial data
│   └── pom.xml
├── frontend/                  # React Application
│   ├── src/
│   │   ├── components/       # React Components
│   │   ├── services/         # API Services
│   │   ├── types/           # TypeScript Types
│   │   └── App.tsx
│   ├── public/
│   └── package.json
└── README.md
```

## 🚀 Getting Started

### Prerequisites

- **Java 17+**
- **Node.js 16+**
- **npm or yarn**

### 🔧 Backend Setup

1. **Navigate to backend directory**
   ```bash
   cd backend
   ```

2. **Run the Spring Boot application**
   ```bash
   ./mvnw spring-boot:run
   ```
   
   Or if you have Maven installed:
   ```bash
   mvn spring-boot:run
   ```

3. **Verify backend is running**
   - API: http://localhost:8080/api/tasks
   - H2 Console: http://localhost:8080/h2-console
   - Swagger UI: http://localhost:8080/swagger-ui.html

### 🔧 Frontend Setup

1. **Navigate to frontend directory**
   ```bash
   cd frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Start the development server**
   ```bash
   npm start
   ```

4. **Open your browser**
   - Frontend: http://localhost:3000

## 📡 API Endpoints

### Tasks API (`/api/tasks`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks?status=TODO` | Get tasks by status |
| GET | `/api/tasks/{id}` | Get task by ID |
| POST | `/api/tasks` | Create new task |
| PUT | `/api/tasks/{id}` | Update task |
| DELETE | `/api/tasks/{id}` | Delete task |
| GET | `/api/tasks/search?title={query}` | Search tasks by title |

### Task Status Values
- `TODO` - Task not started
- `IN_PROGRESS` - Task in progress
- `DONE` - Task completed

### Example Task JSON
```json
{
  \"id\": 1,
  \"title\": \"Learn Spring Boot\",
  \"description\": \"Complete the Spring Boot tutorial\",
  \"status\": \"TODO\"
}
```

## 🎯 Usage

### Creating a Task
1. Click the \"Add New Task\" button
2. Fill in the title (required) and description
3. Select a status
4. Click \"Create\"

### Editing a Task
1. Click \"Edit\" on any task card
2. Modify the fields
3. Click \"Update\"

### Filtering Tasks
- Use the search bar to find tasks by title/description
- Use the status dropdown to filter by task status
- Combine search and filter for precise results

### Deleting a Task
1. Click \"Delete\" on any task card
2. Confirm the deletion

## 🔧 Configuration

### Backend Configuration (`application.properties`)
```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:h2:mem:taskdb
spring.h2.console.enabled=true

# CORS Configuration
spring.web.cors.allowed-origins=http://localhost:3000
```

### Frontend Configuration
- API base URL: `http://localhost:8080/api/tasks`
- Development server: `http://localhost:3000`

## 🧪 Testing

### Backend Testing
```bash
cd backend
./mvnw test
```

### Frontend Testing
```bash
cd frontend
npm test
```

## 📦 Building for Production

### Backend
```bash
cd backend
./mvnw clean package
java -jar target/task-tracker-backend-1.0.0.jar
```

### Frontend
```bash
cd frontend
npm run build
# Serve the build folder with a static server
```

## 📸 Screenshots

### Main Dashboard
![Task List](https://via.placeholder.com/800x600?text=Task+List+View)

### Create/Edit Task
![Task Form](https://via.placeholder.com/400x500?text=Task+Form+Modal)

### API Documentation
![Swagger UI](https://via.placeholder.com/800x600?text=Swagger+API+Documentation)

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- React team for the powerful library
- TailwindCSS for the utility-first CSS framework
- H2 Database for the lightweight in-memory database

## 📧 Contact

For questions or suggestions, please open an issue in the repository.

---

**Happy Coding!** 🚀