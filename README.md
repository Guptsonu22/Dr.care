# 🏥 Dcare - Doctor Appointment Management System

[![Java](https://img.shields.io/badge/Java-8+-orange.svg)](https://www.oracle.com/java/)
[![JSP](https://img.shields.io/badge/JSP-2.3+-blue.svg)](https://www.oracle.com/technetwork/java/javaee/jsp/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-green.svg)](https://www.mysql.com/)
[![Bootstrap](https://img.shields.io/badge/Bootstrap-4.0+-purple.svg)](https://getbootstrap.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Database Setup](#database-setup)
- [Usage](#usage)
- [Screenshots](#screenshots)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

**Dcare** is a comprehensive web-based Doctor Appointment Management System designed to streamline healthcare appointment booking and management. The system provides separate interfaces for patients, doctors, and administrators, ensuring efficient healthcare service delivery.

### 🎯 Key Objectives
- **Digitalize** appointment booking process
- **Streamline** patient-doctor communication
- **Centralize** healthcare management
- **Improve** patient experience
- **Enhance** administrative efficiency

## ✨ Features

### 👤 Patient Features
- **🔐 Secure Registration & Login**
- **📅 Appointment Booking** with doctor selection
- **👤 Profile Management** with personal details
- **📋 View Appointments** and booking history
- **💬 Feedback System** for service improvement
- **🔍 Search Doctors** by specialization

### 👨‍⚕️ Doctor Features
- **🔐 Doctor Authentication** (admin-controlled registration)
- **📅 View Appointments** and patient schedule
- **👤 Profile Management** with professional details
- **📊 Appointment Management** (approve/cancel)
- **📋 Patient History** access

### 👨‍💼 Admin Features
- **🔐 Admin Dashboard** with comprehensive controls
- **👨‍⚕️ Doctor Management** (add, edit, delete doctors)
- **👥 Patient Management** with complete patient database
- **📊 Appointment Monitoring** across all doctors
- **💬 Feedback Management** and analytics
- **📈 System Analytics** and reporting

## 🛠️ Technology Stack

### Backend
- **Java 8+** - Core programming language
- **JSP (JavaServer Pages)** - Dynamic web pages
- **Servlets** - Web application framework
- **JDBC** - Database connectivity
- **MySQL** - Database management

### Frontend
- **HTML5** - Markup language
- **CSS3** - Styling and animations
- **JavaScript** - Interactive functionality
- **Bootstrap 4** - Responsive framework
- **jQuery** - JavaScript library

### Database
- **MySQL 8.0+** - Relational database
- **MySQL Connector/J 8.0.28+** - Database connectivity

### Server
- **Apache Tomcat 8.5+** - Web server
- **Eclipse/IntelliJ IDEA** - Development IDE

## 📁 Project Structure

```
Dcare/
├── src/                          # Java Source Code
│   ├── beans/                    # Data Models
│   │   ├── PatientBean.java     # Patient data structure
│   │   ├── DocBean.java         # Doctor data structure
│   │   ├── AppointmentBean.java # Appointment data structure
│   │   └── feedbackbean.java    # Feedback data structure
│   ├── control/                  # Controllers (Servlets)
│   │   ├── AdminLog.java        # Admin authentication
│   │   ├── PatientLog.java      # Patient authentication
│   │   ├── DoctorLog.java       # Doctor authentication
│   │   ├── AppointmentReg.java  # Appointment registration
│   │   └── CancelAppointment.java # Appointment cancellation
│   ├── daofiles/                 # Data Access Layer
│   │   ├── AdminDao.java        # Admin database operations
│   │   ├── PatientDao.java      # Patient database operations
│   │   ├── DoctorDao.java       # Doctor database operations
│   │   └── AppointmentDao.java  # Appointment database operations
│   └── dba/                      # Database Connection
│       └── ConnectionProvider.java # Database connection class
├── WebContent/                   # Web Resources
│   ├── JSP Files/               # Dynamic web pages
│   │   ├── Home.jsp            # Main home page
│   │   ├── PatientLogin.jsp    # Patient login page
│   │   ├── DoctorLogin.jsp     # Doctor login page
│   │   ├── AdminHome.jsp       # Admin dashboard
│   │   └── PatientRegister.jsp # Patient registration
│   ├── HTML Files/             # Static web pages
│   │   ├── index.html          # Main website
│   │   ├── about.html          # About page
│   │   └── contact.html        # Contact page
│   ├── CSS/                    # Stylesheets
│   │   ├── style.css           # Custom styles
│   │   ├── bootstrap.min.css  # Bootstrap framework
│   │   └── animate.css         # Animations
│   ├── JS/                     # JavaScript files
│   │   ├── main.js            # Main JavaScript
│   │   ├── jquery.min.js      # jQuery library
│   │   └── bootstrap.min.js  # Bootstrap JavaScript
│   ├── images/                 # Image assets
│   ├── fonts/                  # Font files
│   └── WEB-INF/                # Web configuration
│       ├── web.xml            # Web application config
│       └── lib/                # JAR libraries
├── build/                      # Compiled classes
├── database.txt               # Database schema
└── README.md                  # Project documentation
```

## 🚀 Installation

### Prerequisites
- **Java Development Kit (JDK) 8 or higher**
- **Apache Tomcat Server 8.5 or higher**
- **MySQL Database Server 8.0 or higher**
- **Eclipse IDE or IntelliJ IDEA** (recommended)
- **MySQL JDBC Driver (8.0.28 recommended)**

### Step 1: Clone the Repository
```bash
git clone https://github.com/yourusername/Dcare.git
cd Dcare
```

### Step 2: Database Setup
1. **Install MySQL Server**
2. **Create Database**:
   ```sql
   CREATE DATABASE dcare;
   USE dcare;
   ```

3. **Run Database Scripts** (from `database.txt`):
   ```sql
   -- Admin table
   CREATE TABLE adminlogin(email VARCHAR(30), password VARCHAR(30));
   
   -- Doctors table
   CREATE TABLE doctors(
       id INT NOT NULL PRIMARY KEY,
       docname VARCHAR(30) NOT NULL,
       email VARCHAR(30) NOT NULL,
       password VARCHAR(30) NOT NULL,
       specialty VARCHAR(30) NOT NULL,
       contact VARCHAR(30) NOT NULL
   );
   
   -- Patients table
   CREATE TABLE apointment(
       id INT NOT NULL PRIMARY KEY,
       name VARCHAR(30),
       dob VARCHAR(12) NOT NULL,
       address VARCHAR(50) NOT NULL,
       gender VARCHAR(10) NOT NULL,
       contact VARCHAR(15) NOT NULL,
       email VARCHAR(30) NOT NULL,
       password VARCHAR(30) NOT NULL
   );
   
   -- Appointments table
   CREATE TABLE appointment(
       apid INT NOT NULL PRIMARY KEY,
       name VARCHAR(30) NOT NULL,
       email VARCHAR(30) NOT NULL,
       contact VARCHAR(30) NOT NULL,
       age INT NOT NULL,
       day VARCHAR(30) NOT NULL,
       speciality VARCHAR(30) NOT NULL,
       description VARCHAR(100) NOT NULL,
       id INT NOT NULL
   );
   ```

4. **Insert Default Admin**:
   ```sql
   INSERT INTO adminlogin VALUES('admin@dcare.com', 'admin123');
   ```

### Step 3: IDE Setup

#### Using Eclipse IDE
1. **Open Eclipse IDE**
2. **File → Import → Existing Projects into Workspace**
3. **Browse to project folder** → Select → Finish
4. **Add MySQL Driver**:
   - Right-click project → Properties → Java Build Path → Libraries
   - Add External JARs → Select `mysql-connector-java-8.0.xx.jar`
5. **Run on Server**:
   - Right-click project → Run As → Run on Server
   - Choose Tomcat → Finish

#### Using IntelliJ IDEA
1. **Open IntelliJ IDEA**
2. **File → Open** → Select project folder
3. **Configure Tomcat**:
   - Run → Edit Configurations → + → Tomcat Server
   - Set Tomcat home directory
   - Deploy artifact: Dcare:war exploded
4. **Run Project**: Click Run button

### Step 4: Server Configuration
1. **Download Apache Tomcat**
2. **Extract to desired location**
3. **Start Tomcat Server**:
   ```bash
   # Windows
   startup.bat
   
   # Linux/Mac
   ./startup.sh
   ```

## 🗄️ Database Setup

### Database Configuration
Update database connection in `src/dba/ConnectionProvider.java` if needed:

```java
public static Connection getConnection() {
    Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/dcare",
            "root", 
            "Root@1234"
        );
    } catch (Exception e) {
        System.out.println("Error " + e);
    }
    return con;
}
```

### Database Tables
- **`adminlogin`** - Admin credentials
- **`doctors`** - Doctor information
- **`apointment`** - Patient data
- **`appointment`** - Appointment bookings
- **`feedback`** - Patient feedback

## 📱 Usage

### Access URLs
Once the application is running, access:

- **🏠 Main Website**: `http://localhost:8080/Dcare/`
- **👤 Patient Login**: `http://localhost:8080/Dcare/PatientLogin.jsp`
- **👨‍⚕️ Doctor Login**: `http://localhost:8080/Dcare/DoctorLogin.jsp`
- **👨‍💼 Admin Login**: `http://localhost:8080/Dcare/AdminLogin.jsp`

### Default Credentials
- **Admin**: 
  - Email: `admin@dcare.com`
  - Password: `admin123`

### User Workflows

#### Patient Workflow
1. **Register** → Create patient account
2. **Login** → Access patient dashboard
3. **Book Appointment** → Select doctor and time
4. **View Appointments** → Track scheduled visits
5. **Give Feedback** → Rate service experience

#### Doctor Workflow
1. **Admin Registration** → Admin adds doctor to system
2. **Doctor Login** → Access doctor dashboard
3. **View Appointments** → See scheduled patients
4. **Manage Profile** → Update professional information

#### Admin Workflow
1. **Admin Login** → Access admin dashboard
2. **Manage Doctors** → Add, edit, delete doctors
3. **Monitor Patients** → View patient information
4. **System Oversight** → Monitor appointments and feedback

## 📸 Screenshots

### Main Website
![Main Website](screenshots/main-website.png)
*Modern medical website with professional design*

### Patient Login
![Patient Login](screenshots/patient-login.png)
*Clean, user-friendly patient authentication*

### Admin Dashboard
![Admin Dashboard](screenshots/admin-dashboard.png)
*Comprehensive admin management interface*

### Doctor Management
![Doctor Management](screenshots/doctor-management.png)
*Doctor CRUD operations with data table*

## 🔧 API Documentation

### Authentication Endpoints
- **POST** `/AdminLog` - Admin login
- **POST** `/PatientLog` - Patient login
- **POST** `/DoctorLog` - Doctor login

### Appointment Endpoints
- **POST** `/AppointmentReg` - Book appointment
- **GET** `/CancelAppointment` - Cancel appointment
- **GET** `/PatientViewAppointment` - View appointments

### Management Endpoints
- **POST** `/PatientReg` - Patient registration
- **POST** `/DoctorReg` - Doctor registration
- **GET** `/DeleteDoctor` - Delete doctor

## 🤝 Contributing

We welcome contributions to improve Dcare! Please follow these steps:

1. **Fork the repository**
2. **Create a feature branch**:
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. **Commit your changes**:
   ```bash
   git commit -m 'Add some amazing feature'
   ```
4. **Push to the branch**:
   ```bash
   git push origin feature/amazing-feature
   ```
5. **Open a Pull Request**

### Development Guidelines
- Follow Java coding standards
- Write meaningful commit messages
- Add comments for complex logic
- Test all functionality before submitting
- Update documentation for new features

## 🐛 Troubleshooting

### Common Issues

#### Database Connection Error
```java
// Check ConnectionProvider.java
// Ensure MySQL is running
// Verify database credentials
// Check if 'dcare' database exists
```

#### ClassNotFoundException for MySQL Driver
```bash
# Add MySQL connector to classpath
# Copy mysql-connector-java-8.0.xx.jar to WEB-INF/lib/
```

#### 404 Error
```bash
# Check if project is deployed correctly
# Verify Tomcat is running
# Check URL path (case-sensitive)
```

#### Session Issues
```java
// Clear browser cache and cookies
// Check session management in servlets
// Verify session attributes
```

## 📊 Project Statistics

- **Total Files**: 50+
- **Java Classes**: 15+
- **JSP Pages**: 20+
- **HTML Pages**: 10+
- **CSS Files**: 15+
- **JavaScript Files**: 10+
- **Database Tables**: 5

## 🚀 Future Enhancements

- [ ] **Mobile App** development
- [ ] **Real-time Notifications** system
- [ ] **Video Consultation** feature
- [ ] **Payment Integration** for appointments
- [ ] **Multi-language Support**
- [ ] **Advanced Analytics** dashboard
- [ ] **API Documentation** with Swagger
- [ ] **Docker Containerization**

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **Your Name** - *Initial work* - [YourGitHub](https://github.com/Guptsonu22)

## 🙏 Acknowledgments

- Bootstrap framework for responsive design
- Font Awesome for icons
- jQuery for JavaScript functionality
- MySQL community for database support
- Java community for web development resources

## 📞 Support

If you have any questions or need help with the project:

- **Email**: your.email@example.com
- **GitHub Issues**: [Create an issue](https://github.com/yourusername/Dcare/issues)
- **Documentation**: [Project Wiki](https://github.com/yourusername/Dcare/wiki)

---

## ⭐ Star this Repository

If you found this project helpful, please give it a star! ⭐

---

**Made with ❤️ for Healthcare Management**
