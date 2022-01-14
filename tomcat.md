
Tomcat
======

In the installation folder of the tomcat server you will find this dicectory structure:

* **/bin** - Startup, shutdown, and other scripts (*.sh for Unix systems and *.bat for Windows).
* **/conf** - Configuration files and related DTDs.
  The most important file in here is *server.xml*.
  It is the main configuration file for the container.
* **/logs** - Log files are here by default.
* **/webapps** - This is where your webapps go.

Properties:

* **CATALINA_HOME**: Represents the root of your Tomcat installation, for example /home/tomcat/apache-tomcat-9.0.10 or C:\Program Files\apache-tomcat-9.0.10.
* **CATALINA_BASE**: Represents the root of a runtime configuration of a specific Tomcat instance. 

By default, CATALINA_HOME and CATALINA_BASE point to the same directory.

If you want to have multiple Tomcat instances on one machine, use the CATALINA_BASE property.
If you set the properties to different locations, the CATALINA_HOME location contains static sources, such as .jar files, or binary files. 
The CATALINA_BASE location contains configuration files, log files, deployed applications, and other runtime requirements.

Doing so provides the following benefits:

* Easier management of upgrading to a newer version of Tomcat.
  Because all instances with single CATALINA_HOME location share one set of .jar files and binary files, you can easily upgrade the files to newer version and have the change propagated to all Tomcat instances using the same CATALIA_HOME directory.
* Avoiding duplication of the same static .jar files.
* The possibility to share certain settings, for example the setenv shell or bat script file.

Users
-----

The tomcat users are defined in */conf/tomcat-users.xml*.

Deploy Spring App
-----------------

1. In your `pom.xml` change the packaging of the project to war.

```xml
<packaging>war</packaging>
```

2. Mark the `spring-boot-starter-tomcat` dependency as `provided` since all the Tomcat dependency libraries will be provided to the application by the servlet containter.
You probably expect these libraries aren’t packed inside the WAR, but the reality is different.
All the provided dependencies are included into the WAR file (so it can be run with `java -jar`), but they are placed in a location where Tomcat's classloader does not look: `/WEB-INF/lib-provided`.

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-tomcat</artifactId>
	<scope>provided</scope>
</dependency>
```

3. Extend the `SpringBootServletInitializer` abstract class and implement its required method to point out your application runner class.

```java
@SpringBootApplication
public class App extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}

}
```
4. Execute:
```
$ mvn clean package
```

5. Copy the WAR file generated in target into the server webapps folder.

Dual JAR/WAR deploy
-------------------

Set the packaging with a property placeholder that you will declare in your profiles.
```xml
<packaging>${project.packaging}</packaging>
```

Create the default dev profile with JAR packaging.
```xml
<profile>
    <id>dev</id>
    <activation>
        <activeByDefault>true</activeByDefault>
    </activation>
    <properties>
        <project.packaging>jar</project.packaging>
    </properties>
</profile>
```

Create the release profile with the WAR packaging.
```xml
<profile>
    <id>release</id>
    <properties>
        <project.packaging>war</project.packaging>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                    <groupId>org.springframework.boot</groupId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
</profile>
```




-----------


Note:

A **Document Type Definition** (DTD) defines the valid building blocks of an XML document.
It defines the document structure with a list of validated elements and attributes.
A DTD can be declared inline inside an XML document, or as an external reference.

A DTD is associated with an XML document by means of a document type declaration (DOCTYPE).

Example:
```xml
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
```

XSD (**XML Schema Definition**), a recommendation of the World Wide Web Consortium (W3C), specifies how to formally describe the elements in an Extensible Markup Language (XML) document. 
It can be used by programmers to verify each piece of item content in a document, to assure it adheres to the description of the element it is placed in.