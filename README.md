# Ordenacao_Biblioteca

Designed to be a solution for ordering book lists.

## Getting Started

* This project was developed exclusively using JAVA 8.
* To make use of it, clone/download this repository
* Then configurate the file sis.config inside the config folder accordingly to the desired sorting method.
* Execute the Main class and the list inside it will be sorted.


### Prerequisites

JAVA JDK 8 must be installed beforehand.


### Installing

* The first step will be cloning or downloading this repository.

* Secondly configure the sis.config through the requested input according to this logic:
```
There are three numbers, "0 0 0", each is a column name: 'Ano de Edição' , 'Autor' , 'Título', respectively.
Each can be set with 0, 1 or 2, those being 'No filter', 'Ascending', 'Descending', respectively.

So, if you want to sort by, for example, "Edição descendente, Autor descendente, Título ascendente" the config would be: "2 2 1"
```

* Thirdly, start the program by compiling it from source or with the command:
```
java -jar OrdenacaoBiblioteca.jar
```
This .jar can be carried to whichever folder desired, the 'config' folder will be created within it's default configuration if it doesn't exists already.


## Authors

* **Getúlio Vieira Benincá**

