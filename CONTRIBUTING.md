# 🤝 Contributing to Dcare

Thank you for your interest in contributing to Dcare! This document provides guidelines and information for contributors.

## 📋 Table of Contents
- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [Development Setup](#development-setup)
- [Contributing Guidelines](#contributing-guidelines)
- [Pull Request Process](#pull-request-process)
- [Issue Reporting](#issue-reporting)
- [Development Standards](#development-standards)

## 📜 Code of Conduct

This project follows a code of conduct that we expect all contributors to follow:

- **Be respectful** and inclusive
- **Be constructive** in feedback and discussions
- **Be patient** with newcomers and questions
- **Be collaborative** and help others learn
- **Be professional** in all interactions

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- MySQL 5.7 or higher
- Apache Tomcat 8.5 or higher
- Eclipse IDE or IntelliJ IDEA
- Git

### Fork and Clone
1. **Fork the repository** on GitHub
2. **Clone your fork**:
   ```bash
   git clone https://github.com/yourusername/Dcare.git
   cd Dcare
   ```
3. **Add upstream remote**:
   ```bash
   git remote add upstream https://github.com/originalusername/Dcare.git
   ```

## 🛠️ Development Setup

### 1. Database Setup
```sql
CREATE DATABASE dcare;
USE dcare;
-- Run scripts from database.txt
```

### 2. IDE Configuration
- **Eclipse**: Import as existing project
- **IntelliJ**: Open project folder
- **Add MySQL JDBC driver** to classpath

### 3. Server Configuration
- **Configure Tomcat** server
- **Deploy project** to server
- **Test basic functionality**

## 📝 Contributing Guidelines

### Types of Contributions
- **Bug fixes** - Fix existing issues
- **Feature additions** - Add new functionality
- **Documentation** - Improve documentation
- **Code optimization** - Improve performance
- **UI/UX improvements** - Enhance user experience

### Before Contributing
1. **Check existing issues** and pull requests
2. **Create an issue** for major changes
3. **Discuss changes** with maintainers
4. **Follow coding standards**

## 🔄 Pull Request Process

### 1. Create Feature Branch
```bash
git checkout -b feature/your-feature-name
# or
git checkout -b bugfix/issue-description
```

### 2. Make Changes
- **Write clean, readable code**
- **Add comments** for complex logic
- **Follow existing code style**
- **Test your changes thoroughly**

### 3. Commit Changes
```bash
git add .
git commit -m "Add: Brief description of changes"
```

**Commit Message Format:**
- `Add:` for new features
- `Fix:` for bug fixes
- `Update:` for improvements
- `Remove:` for deletions
- `Refactor:` for code restructuring

### 4. Push and Create PR
```bash
git push origin feature/your-feature-name
```

Then create a Pull Request on GitHub.

### 5. PR Template
```markdown
## Description
Brief description of changes

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Breaking change
- [ ] Documentation update

## Testing
- [ ] Tested locally
- [ ] All tests pass
- [ ] No breaking changes

## Screenshots (if applicable)
Add screenshots here

## Checklist
- [ ] Code follows project style
- [ ] Self-review completed
- [ ] Documentation updated
- [ ] No merge conflicts
```

## 🐛 Issue Reporting

### Before Creating an Issue
1. **Search existing issues** first
2. **Check if it's already reported**
3. **Verify it's a real issue**

### Issue Template
```markdown
## Bug Description
Clear description of the bug

## Steps to Reproduce
1. Go to '...'
2. Click on '....'
3. Scroll down to '....'
4. See error

## Expected Behavior
What should happen

## Actual Behavior
What actually happens

## Environment
- OS: [e.g., Windows 10]
- Java Version: [e.g., Java 8]
- Browser: [e.g., Chrome 90]
- Database: [e.g., MySQL 8.0]

## Screenshots
If applicable, add screenshots

## Additional Context
Any other context about the problem
```

## 📏 Development Standards

### Java Code Standards
```java
// Use meaningful variable names
String patientName = "John Doe";
int appointmentId = 123;

// Add comments for complex logic
/**
 * Validates patient credentials against database
 * @param email Patient email
 * @param password Patient password
 * @return true if valid, false otherwise
 */
public boolean validatePatient(String email, String password) {
    // Implementation
}

// Follow naming conventions
public class PatientBean {
    private String patientName;
    private String patientEmail;
    
    // Getters and setters
    public String getPatientName() {
        return patientName;
    }
}
```

### JSP Standards
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Page Title</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <!-- Use semantic HTML -->
    <header>
        <nav>
            <!-- Navigation content -->
        </nav>
    </header>
    
    <main>
        <!-- Main content -->
    </main>
    
    <footer>
        <!-- Footer content -->
    </footer>
</body>
</html>
```

### Database Standards
```sql
-- Use descriptive table names
CREATE TABLE patient_appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    status ENUM('scheduled', 'completed', 'cancelled') DEFAULT 'scheduled',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Add indexes for performance
CREATE INDEX idx_patient_id ON patient_appointments(patient_id);
CREATE INDEX idx_doctor_id ON patient_appointments(doctor_id);
CREATE INDEX idx_appointment_date ON patient_appointments(appointment_date);
```

## 🧪 Testing Guidelines

### Unit Testing
```java
@Test
public void testPatientRegistration() {
    // Arrange
    PatientBean patient = new PatientBean();
    patient.setName("John Doe");
    patient.setEmail("john@example.com");
    
    // Act
    int result = PatientDao.save(patient);
    
    // Assert
    assertEquals(1, result);
}
```

### Integration Testing
- **Test database connections**
- **Test servlet functionality**
- **Test JSP rendering**
- **Test user workflows**

### Manual Testing Checklist
- [ ] Patient registration works
- [ ] Patient login works
- [ ] Doctor login works
- [ ] Admin login works
- [ ] Appointment booking works
- [ ] Appointment cancellation works
- [ ] All forms validate input
- [ ] Error handling works
- [ ] Session management works

## 📚 Documentation Standards

### Code Documentation
```java
/**
 * Handles patient appointment booking
 * 
 * @author Your Name
 * @version 1.0
 * @since 2024-01-01
 */
public class AppointmentController extends HttpServlet {
    
    /**
     * Processes appointment booking request
     * 
     * @param request HTTP request containing appointment details
     * @param response HTTP response to send back
     * @throws ServletException if servlet error occurs
     * @throws IOException if I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Implementation
    }
}
```

### README Updates
- **Update installation steps** if needed
- **Add new features** to feature list
- **Update screenshots** for UI changes
- **Update API documentation** for new endpoints

## 🏷️ Release Process

### Version Numbering
- **Major version** (1.0.0): Breaking changes
- **Minor version** (1.1.0): New features
- **Patch version** (1.1.1): Bug fixes

### Release Checklist
- [ ] All tests pass
- [ ] Documentation updated
- [ ] Version number updated
- [ ] Changelog updated
- [ ] Release notes prepared

## 📞 Getting Help

### Communication Channels
- **GitHub Issues**: For bug reports and feature requests
- **GitHub Discussions**: For general questions and discussions
- **Email**: your.email@example.com

### Resources
- [Java Documentation](https://docs.oracle.com/en/java/)
- [JSP Tutorial](https://www.oracle.com/technical-resources/articles/javase/jsp.html)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Bootstrap Documentation](https://getbootstrap.com/docs/)

## 🎉 Recognition

Contributors will be recognized in:
- **README.md** contributors section
- **Release notes** for significant contributions
- **GitHub contributors** page

## 📄 License

By contributing to Dcare, you agree that your contributions will be licensed under the MIT License.

---

**Thank you for contributing to Dcare! 🚀**
