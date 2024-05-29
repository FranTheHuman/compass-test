# Duplicate Contact Identifier (COMPASS TEST) 👮‍♀️🕵️‍♂️👨‍🔬🕵️‍♀️

This project provides a solution to identify potential duplicate contacts from a list of contact information. It includes a function to identify possible matches, assign a score representing the accuracy of the match, and output the results.

## Instructions

You have been asked to take a list of contact information and identify which contacts are potentially duplicates. You need to write a function that will do the following:

1. Identify which contacts are possible matches.
2. Assign a score for each match that represents how accurate you believe the match is.
3. A contact might have multiple or no matches.
4. All processing should be done in working memory (no database).

## Programming Language

### Scala

### Why Scala?

Scala was chosen as the primary programming language for this project because of its expressiveness and readability. 
Scala code tends to be concise and understandable, making it accessible not only to experienced programmers but also to those new to programming. 
Additionally, Scala's powerful features allow for elegant solutions to complex problems, making it an ideal choice for this task.

### Why Sbt?

Sbt (Scala Build Tool) was chosen as the build tool for this project because of its simplicity and ease of use.
Sbt is widely used in the Scala community and provides a robust set of features for building, testing, and packaging Scala projects.

### Install Scala and Sbt on your machine

#### -> Linux <-

1. Open a terminal window and type the following command to install the Scala programming language:

```bash
java -version
```

2. If you don't have Java installed, you can install it by running the following command:

```bash
sudo apt-get update
sudo apt-get install default-jdk
```

3. Once you have Java installed, you can install Scala by running the following command:

```bash
sudo apt-get install scala
```

4. To verify that Scala has been installed correctly, you can run the following command:

```bash
scala -version
```

5. Now, you need to install the Scala build tool (sbt) by running the following command:

```bash
echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | sudo tee /etc/apt/sources.list.d/sbt.list
echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | sudo tee /etc/apt/sources.list.d/sbt_old.list
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add
sudo apt-get update
sudo apt-get install sbt
```

6. To verify that sbt has been installed correctly, you can run the following command:

```bash
sbt sbtVersion
```

## How to run the project

1. Execute (in the root) the following command to start the sbt shell:

```bash
sbt
```

2. Once the sbt shell is running, you can compile the project by running the following command:

```bash
compile
```

3. After compiling the project, you can run the Main by running the following command:

```bash
run
```

## How to run the tests

1. Execute (in the root) the following command to start the sbt shell:

```bash
sbt
```

2. After compiling the project, you can run the tests by running the following command:

```bash
test
```

## Project Structure

    

