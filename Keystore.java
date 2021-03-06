import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
				@SuppressWarnings("resource")
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
					System.out.println(keystore.get(nextLineArgs[1]));
					break;
				case "set":
					String key = nextLineArgs[1];
					String value = nextLineArgs[2];
					System.out.println(String.format("Adding key-value pair '%s'-'%s' to keystore", key, value));
					keystore.put(key, value);
					break;
				case "print":
					System.out.println("Printing out current keystore...");
					System.out.println(keystore.toString());
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
	@SuppressWarnings("unchecked")
	private static HashMap<String, String> deserializeKeystore(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashMap<String, String> keystore = null;
	        keystore = (HashMap<String, String>) ois.readObject();
			ois.close();
	        fis.close();
	        return keystore;
		} catch ( IOException | ClassNotFoundException e) {
			System.out.println(String.format("No valid keystore found with supplied filepath '%s'. Defaulting to empty keystore", filePath));
			return new HashMap<String, String>();	
		} 

		
	}
	
	
	private static void serializeKeystore(String filePath, HashMap<String, String> keystore) {
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream (fos);
			oos.writeObject(keystore);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Exception ocurred serializing keystore to file...");
			e.printStackTrace();
		}
	}

}
