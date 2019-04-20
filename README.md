# keystore
This program is meant to act as a simple keystore for key/value pairs that can write to a file to save data if the program is terminated.


## Compiling
To compile  "java" and "javac" (Java 8 or higher) must be available from the command line. You can verify this by using the command "java -version" to see what version you have, or if its available on the path. Once verified, you can compile the classes for executing the program and running the tests. From the "/jackcobb/src" directory, execute the following command to compile the java files into class files:

"javac Keystore.java"


## Program Execution
First, ensure you have followed the steps above for compilation so that the appropriate class files are available. To execute the program in its most basic state using the example alice.txt file (only providing file path and having the merkle root for the file returned), again cd to the src directory. Once there, execute the following command:
"java Keystore '/path/to/file/'" 

