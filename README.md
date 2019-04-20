# keystore
This program is meant to act as a simple keystore for key/value pairs that can write to a file to save data if the program is terminated.


## Compiling
To compile, "javac" (Java 8 or higher) must be available from the command line. From the top level directory, execute the following command to compile the java files into class files:

`javac Keystore.java`


## Program Execution
First, ensure you have followed the steps above for compilation so that the appropriate class files are available. To execute the program in its most basic state using the example alice.txt file (only providing file path and having the merkle root for the file returned), again cd to the src directory. Once there, execute the following command to start the program:

`java Keystore '/path/to/file/'`

### Program Commands
- `exit'`, `'quit'`, `'end'`, or `'kill'` will terminate the program and serialize the keystore to a file for reuse later
- `set $key $value'` will set the $key $value pair into the in memory keystore 
- `get $key'` will lookup and print the $value for the $key $value pair
- `print'` will print the whole keystore 
