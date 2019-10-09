package sphinxCommands;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;

public class voiceLauncher {
	public static void main(String [] args) throws IOException {
		 // Configuration Object
        Configuration configuration = new Configuration();
 
        // Set path to the acoustic model.
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        // Set path to the dictionary.
        configuration.setDictionaryPath("file:C:/Users/vishalsunkara/Desktop/sphinxCommands/src/0071.dic");
        // Set path to the language model.
        configuration.setLanguageModelPath("file:C:/Users/vishalsunkara/Desktop/sphinxCommands/src/0071.lm");
       
        //Recognizer Object, Pass the Configuration object
        LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
 
        //Start Recognition Process (The bool parameter clears the previous cache if true)
        recognize.startRecognition(true);
		
        //Create SpeechResult Object
        SpeechResult result;
 
        //Checking if recognizer has recognized the speech
        while ((result = recognize.getResult()) != null) {
        	//Get the recognize speech
            String command = result.getHypothesis();
            String work = null;
            Process p;
            
		//Match recognized speech with our commands
        if(command.equalsIgnoreCase("open file manager")) {
        	work = "explorer.exe";
        	System.out.println("File Manager Opened!");
        }
        else if (command.equalsIgnoreCase("close file manager")) {
        	work = "pkill explorer.exe";
            System.out.println("File Manager Closed!");
        }
        else if (command.equalsIgnoreCase("open browser")) {
        	work = "google-chrome";
            System.out.println("Browser Opened!");
        } 
        else if (command.equalsIgnoreCase("close browser")) {
            work = "pkill google-chrome";
            System.out.println("Browser Closed!");
        }
        else if (command.equalsIgnoreCase("open mail")) {
            work = "google-chrome gmail.com";
            System.out.println("Mail opened");
        }
        else if(command.equalsIgnoreCase("close mail")) {
        	work = "pkill google-chrome gmail.com";
        	System.out.println("Mail closed");
        }
        else if (command.equalsIgnoreCase("open terminal")) {
            work = "cmd.exe";
            System.out.println("Terminal opened");
        } 
        else if(command.equalsIgnoreCase("close terminal")) {
        	work = "pkill cmd.exe";
        	System.out.println("Terminal Closed");
        }
        else if(command.equalsIgnoreCase("open search")) {
            work = "google-chrome http://www.google.com";
            System.out.println("Search opened");
        }
        else if(command.equalsIgnoreCase("close search")) {
        	work = "pkill google-chrome google.com";
        	System.out.println("Search closed");
        }
        else if(command.equalsIgnoreCase("open notepad")) {
        	work = "notepad.exe";
        	System.out.println("Notepad opened");
        }
        else if(command.equalsIgnoreCase("close notepad")) {
        	work = "pkill notepad.exe";
        	System.out.println("Notepad closed");
        }
        else if(command.equalsIgnoreCase("open calculator")) {
        	work = "calc.exe";
        	System.out.println("Calculator opened");
        }
        else if(command.equals("close calculator")) {
        	work = "pkill calc.exe";
        	System.out.println("Calculator closed");
        }
      //If command is recognized, command is executed.
        if(work != null) {
            //Execute the command
            p = Runtime.getRuntime().exec(work);
        }    
        }
	}
 
}
