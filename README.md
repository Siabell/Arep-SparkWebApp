# AREP-SparkWebApp


This project has the operations to calculate the mean and standard deviation of a set of n real numbers. The project implements my own implementation of a linked list.

## Getting Started

 In order to use this project, first clone this repository or download the project.

Then access the address where the project is located and execute the following commands

```
mvn compile
mvn package
mvn install
```
In order to generate the documentation of the project use the command 

```
mvn javadoc:javadoc
```
This command will generate the documentation in the folder 
```
 /target/site/apidocs/
 ```

To see the documentation of this project, access to the following link: [documentation](https://github.com/Siabell/AREP-lab1-introduccion/blob/master/target/site/apidocs/index.html) .


Test the compiled and packaged JAR with the following command:

```
java -cp target/Proyecto-Intro-1.0-SNAPSHOT.jar edu.escuelaing.arep.CalculatorApp
```
![Drag Racing](resources/images/TestResult.PNG)

### Prerequisites

You will need maven and java installed on your machine to employ this program


## Running the tests

In order to run the automated tests for this project execute the following command.

```
mvn test
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Valentina Siabatto** - *Escuela Colombiana de Ingeniería Julio Garavito* 

See also the list of [contributors](https://github.com/Siabell/AREP-lab1-introduccion/graphs/contributors) who participated in this project.

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE.md](LICENSE.md) file for details


