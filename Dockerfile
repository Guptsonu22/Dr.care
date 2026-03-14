# Use an official Tomcat image as the base
FROM tomcat:8.5-jdk8-openjdk-slim

# Remove default webapps to save space
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WebContent contents to the ROOT webapp directory
COPY WebContent/ /usr/local/tomcat/webapps/ROOT/

# Copy the compiled classes (if you haven't bundled them in a WAR)
COPY WebContent/WEB-INF/classes/ /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/

# Expose port 8080 (standard Tomcat port)
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
