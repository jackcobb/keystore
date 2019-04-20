import java.util.HashMap;
import java.util.Scanner;

public class Keystore {

	public static void main(String[] args) {
		boolean userRequestedExit = false;
		
		if (args.length == 0 ) {
			System.out.println("Unable to begin program. No keystore filepath provided. Please review README.md");
		} else {
			String keystoreFilePath = args[0];
			HashMap<String, String> keystore = deserializeKeystore(keystoreFilePath);
			System.out.println(String.format("Loaded the below keystore into memory from '%s'", keystoreFilePath));
			System.out.println(keystore.toString());
			
			while (!userRequestedExit) {
				Scanner scanner = new Scanner(System.in);
				String[] nextLineArgs = scanner.nextLine().split(" ");
				
				switch (nextLineArgs[0]) {
				case "kill":
				case "end":
				case "exit":
				case "quit":
					System.out.println(String.format("Requested termination. Serializing keystore to file '%s'", keystoreFilePath));
					userRequestedExit = true;
					serializeKeystore(keystoreFilePath, keystore);
					break;
				case "get":
					break;
				case "set":
					break;
				default:
					System.out.println("Unrecognized command. Please refer to README.md on supported commands");
				}
					
			}
		}

	}
	
	/**
	 * This method is to instantiate a hashmap based on a keystore file path provided. If no file found, an empty hashmap will be returned.
	 * @param filePath refers to the first parameters entered with the program kickoff. 
	 * @return returns a HashMap based on the data in the keystore file
	 */
	private static HashMap<String, String> deserializeKeystore(String filePath) {
		//if file not found, return new hashmap
		//if file found, try deserialization; catch exceptions
		return new HashMap<String, String>();	
	}
	
	
	private static void serializeKeystore(String filePath, HashMap<String, String> keystore) {
		//serialize keystore to a new file located at filePath param
	}

}
