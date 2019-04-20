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
			
			while (!userRequestedExit) {
				Scanner scanner = new Scanner(System.in);
				
				//get next line
				//switch off first word 
					//exit, kill, end, quit
					//get
					//set
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
		return null;
		
	}
	
	
	private static void serializeKeystore(String filePath, HashMap<String, String> keystore) {
		//serialize keystore to a new file located at filePath param
	}

}
