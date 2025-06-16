/*Requirements Analysis
Create a Java program similar to the fictional emergency watch device from Liar Game manga that is used in hospitals. 
The device will either create a new patient account or use an existing one from a text file that has stored patient information.
For existing patients, there will be a prompt to enter a 4-character code to unlock their account, which will give them access to the device's main menu, mainMenu().
mainMenu() has five features: displayPatientInfo(), enter Readings(), displayCondition(), updatePatientInfo(), and saveInfo().
displayPatientInfo() holds the patient's personal information, including name, age, DOB, and reason for staying at the hospital. If the patient already exists (has a file) the systolic blood pressure, diastolic blood pressure, heart rate, temperature, and breathing rate will also be held.
enterReadings() is where the the systolic blood pressure, diastolic blood pressure, heart rate, temperature, and breathing rate are updated, based on input.
displayCondition() takes systolic blood pressure, diastolic blood pressure, heart rate, temperature, and breathing and sends "signals" determining whether a patient is in stable condition or not in the form of a print statements.
Signal A indicates condition is normal and Signal B indicates that condition is abnormal.
If the patient's condition is abnormal, the program sends signals determining what is/are the causes of the condition.
The signals are numbered 1-9, with two extremes for each variable tested except pulse and breathing, which have a third option. In the case of pulse, it's when no pulse is detected, and for breathing, it's when no breathing is detected.
updatePatientInfo() updates the patient's information, specifically their four-character code, first name, last name, age, and reason for staying at the hospital. 
saveInfo() saves the patient's information, including the inputs from enterReadings() into a text file similar in format to displatPatientInfo(). It determines whether a file should be created or an existing file should be used and the file path based on input and saves the information.
Lastly, typing 'q' in mainMenu() allows the user to exit the program. 
	
Design (Algorithm)
1. Create and initialize input variables for first name, last name, age, DOB, reason, systolic blood pressure, diastolic blood pressure, heart rate, temperature, and breathing rate.
2. Add variables for identifying saved files and a code. Set all variables to null, 0, or false depending on their data types.
3. Print a welcome statement and ask if user has existing data.
4. If the user has existing data, the user will be asked to input the data's file path and, using Scanner class, assign the values in the data to the variables initialized. Print FileNotFoundException message if file from file path is invalid.  
5. The user will be prompted to enter a 4-character code created previously before they can access the contents of the file. 
6. If the code matches the code recorded on their file, the user will be directed to mainMenu(); if not, the program will loop until the code is correct.
7. For new patients, the user will be asked to enter their first name, last name, age, DOB, and reason and input variables corresponding to them will be updated. 
8. The user will also be asked to create a 4-character code that will be used to access private information within the device and to access their information again, once they save and rerun the program.
9. In mainMenu(), the user will be asked to choose from five features of the device:
10. Inputting 'i' directs the user to displayPatientInfo()
11. 	Prompt user for code. If correct, continue otherwise, loop until correct.
12. 	Print "Patient Information"
13. 	Print "Name: " and input for last name and first name, in that order separated by a comma.
14. 	Print "Code: " and input for code variable.
15.		Print statements for age DOB and reason in a similar format to code with input from corresponding variables.
16. Redirect to mainMenu(). 
17. Inputting 'r' directs the user to enterReadings()
18. 	Ask user to input values for systolic and diastolic blood pressure, heart rate, temperature, and breathing rate.
19. Redirect to mainMenu().
20.	Inputting 'c' directs the user to displayCondition().
21. 	If the patient's values fall within the accepted ranges of variables used in enterReadings() for a person to be considered in good condition, print "Condition A Normal".
22. 	Else if the patient's values are not within the accepted ranges, print "Condition B Abnormal" and ask user for code:
23.		If code is correct, continue. Otherwise, loop until correct.
24. 		If the patient has systolic and diastolic blood pressure above the accepted range, print Signal 1: "High Blood Pressure".
25. 		If the patient has systolic and diastolic blood pressure below the accepted range, print Signal 2: "Low Blood Pressure".
26.  		If the patient has a pulse above the accepted range, print Signal 3: "Pulse Too Fast".
27. 		If the patient has a pulse below the accepted range, print Signal 4: "Pulse Too Slow".
28. 		If the patient's pulse cannot be detected, print Signal 5: "Pulse cannot be detected".
29. 		If the patient has a temperature above the accepted range, print Signal 6: "High Temperature".
30. 		If the patient has a temperature below the accepted range, print Signal 7: "Low Temperature".
31. 		If the patient's breathing per minute is above the accepted range, print Signal 8: "Breathing Too Fast".
32. 		If the patient's breathing per minute is below the accepted range, print Signal 9: "Breathing Too Slow".
33. 		If the patient is not breathing or breathing cannot be detected, print Signal 10: "Breathing cannot be detected."
34.	Redirect to mainMenu().
35. Inputting 's' directs the user to saveInfo().
36. 	Ask user if they have an existing file or are creating a new file
37.		Print "Saving..."
38.		If file exists:
39.			Ask user for file path.
40.			Print patient information, including readings values into text file with PrintWriter variable pw. Print IOException message if user input is invalid.
41.			Close pw
42.		Else if file is new:
43.			Ask user for file name and append ".txt" to input.
44.			Ask user for file path.
45.			Print patient information, including readings values into text file with PrintWriter variable pw. Print IOException message if user input is invalid.
46.			Close pw
47.		Print "Saved."
48. Redirect to mainMenu().
49. Inputting 'q' prints "Goodbye!" and exits program.
50. END

//Implementation
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class HealthMonitorSystem {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String firstName = null;
		String lastName = null;
		char gender = 0;
		int age = 0;
		String DOB = null;
		String reason = null;
		double sBloodPressure = 0.0;
		double dBloodPressure = 0.0; 
		double heartRate = 0.0; 
		double temperature = 0.0; 
		double breathingRate = 0.0;
		boolean save = false;
		String code = null;
		
		System.out.println("Welcome to your medical device used to keep track of your vitals");
		System.out.println("Do you have preexisting data?(Y/N)");
		char p = keyboard.next().charAt(0);
		p = Character.toUpperCase(p);
		if(p == 'Y') {
			save = true;
			try {
				System.out.println("Enter the file path: ");
				String filePath = keyboard.next();
				File file = new File(filePath);
				Scanner scan = new Scanner(file);
				scan.nextLine();
				scan.next();
				code = scan.next();
				scan.next();
				lastName = scan.next();
				firstName = scan.next();
				scan.next();
				gender = scan.next().charAt(0);
				scan.next();
				age = scan.nextInt();
				scan.next();
				DOB = scan.next();
				scan.next();
				scan.next();
				scan.next();
				reason = scan.nextLine().trim();
				scan.next();
				scan.next();
				scan.next();
				sBloodPressure = scan.nextDouble();
				scan.next();
				scan.next();
				scan.next();
				scan.next();
				dBloodPressure = scan.nextDouble();
				scan.next();
				scan.next();
				scan.next();
				scan.next();
				scan.next();
				heartRate = scan.nextDouble();
				scan.next();
				temperature = scan.nextDouble();
				scan.next();
				scan.next();
				scan.next();
				scan.next();
				scan.next();
				breathingRate = scan.nextDouble();
				
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
		    }
			System.out.println("Enter your code: ");
			String c = keyboard.next();
			while(!c.equals(code)) {
				System.out.println("Error! Incorrect code.");
				System.out.println("Reenter your code: ");
				c = keyboard.nextLine();
			}
			mainMenu(firstName, lastName, gender, age, DOB, reason, sBloodPressure, dBloodPressure, heartRate, temperature, breathingRate, save, code);
		}
		else {
			save = false;
			System.out.println("Enter a new code to access device. The code must be 4 characters long.");
			code = keyboard.next();
			if(code.length() > 4) {
				System.out.println("Error the code must be 4 characters long. Enter a new code:");
				code = keyboard.nextLine();
			}
			System.out.println("Enter the first name of the patient:");
			firstName = keyboard.next();
			System.out.println("Enter the last name of the patient:");
			lastName = keyboard.next();
			System.out.println("Enter patient's gender (M/F):");
			gender = keyboard.next().charAt(0);
			gender = Character.toUpperCase(gender);
			System.out.println("Enter patient's age:");
			age = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Enter patient's date of birth (MM/DD/YYYY):");
			DOB = keyboard.nextLine();
			System.out.println("Enter reason for patient staying at hospital:");
			reason = keyboard.nextLine();
			mainMenu(firstName, lastName, gender, age, DOB, reason, sBloodPressure, dBloodPressure, heartRate, temperature, breathingRate, save, code);
		}
	}	
	public static void mainMenu(String firstName, String lastName, char gender, int age, String DOB, String reason, double sBloodPressure, double dBloodPressure, double heartRate, double temperature, double breathingRate, boolean save, String code) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\nYou are currently in the Main Menu of your device");
		System.out.println("Press i to dislay your patient information");
		System.out.println("Press r to enter readings");
		System.out.println("Press c to view patient's condition");
		System.out.println("Press u to update your patient information");
		System.out.println("Press s to save your patient information");
		System.out.println("Press q to turn off device");
		
		char o = keyboard.next().charAt(0);
		o = Character.toLowerCase(o);
		if(o == 'i') {
			displayPatientInfo(firstName, lastName, gender, age, DOB, reason, sBloodPressure, dBloodPressure, heartRate, temperature, breathingRate, save, code);
		}
		if(o == 'r') {
			enterReadings(firstName, lastName, gender, age, DOB, reason, sBloodPressure, dBloodPressure, heartRate, temperature, breathingRate, save, code);
		}
		if(o == 'c') {
			displayCondition(firstName, lastName, gender, age, DOB, reason, sBloodPressure, dBloodPressure, heartRate, temperature, breathingRate, save, code);
		}
		if(o == 'u') {
			updatePatientInfo(firstName, lastName, gender, age, DOB, reason, sBloodPressure, dBloodPressure, heartRate, temperature, breathingRate, save, code);
		}
		if(o == 's') {
			saveInfo(firstName, lastName, gender, age, DOB, reason, sBloodPressure, dBloodPressure, heartRate, temperature, breathingRate, save, code);
		}
		if(o == 'q') {
			System.out.println("Goodbye!");
			System.exit(0);
		}
		
	}	
	
	public static void displayPatientInfo(String firstName, String lastName, char gender, int age, String DOB, String reason, double sBloodPressure, double dBloodPressure, double heartRate, double temperature, double breathingRate, boolean save, String code) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your code: ");
		String c = keyboard.nextLine();
		while(!c.equals(code)) {
			System.out.println("Error! Incorrect code.");
			System.out.println("Reenter your code: ");
			c = keyboard.nextLine();
		}
		if (save == false) {
			System.out.println("Patient Information");
			System.out.println("Patient Code: " + code);
			System.out.println("Name: " + lastName + ", " + firstName);
			System.out.println("Gender: " + gender);
			System.out.println("Age: " + age);
			System.out.println("DOB: " + DOB);
			System.out.println("Reason for staying: " + reason);
		}
		else {
			System.out.println("Patient Information");
			System.out.println("Patient Code: " + code);
			System.out.println("Name: " + lastName + " " + firstName);
			System.out.println("Gender: " + gender);
			System.out.println("Age: " + age);
			System.out.println("DOB: " + DOB);
			System.out.println("Reason for staying: " + reason);
			System.out.println("Systolic Blood Pressure: " + sBloodPressure  + " mmHg");
			System.out.println("Diastolic Blood Pressure: " + dBloodPressure + " mmHg");
			System.out.println("Heart Rate (per minute): " + heartRate);
			System.out.println("Temperature: " + temperature + " ºF");
			System.out.println("Breathing Rate (per minute): " + breathingRate);
		}
		mainMenu(firstName, lastName, gender, age, DOB, reason, sBloodPressure, dBloodPressure, heartRate, temperature, breathingRate, save, code);
	}
	public static void enterReadings(String firstName, String lastName, char gender, int age, String DOB, String reason, double sBloodPressure, double dBloodPressure, double heartRate, double temperature, double breathingRate, boolean save, String code) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your systolic blood pressure:");
		sBloodPressure = keyboard.nextInt();
		System.out.println("Enter your diastolic blood pressure:");
		dBloodPressure = keyboard.nextInt();
		System.out.println("Enter your heart rate:");
		heartRate = keyboard.nextInt();
		System.out.println("Enter your temperature:");
		temperature = keyboard.nextInt();
		System.out.println("Is this number in degrees F? (Y/N)");
		char d = keyboard.next().charAt(0);
		d = Character.toUpperCase(d);
		if (d == 'N') {
			temperature = (temperature * (9/5)) + 32;
		}
		System.out.println("Enter your breathing rate (per minute):");
		breathingRate = keyboard.nextInt();
		mainMenu(firstName, lastName, gender, age, DOB, reason, sBloodPressure, dBloodPressure, heartRate, temperature, breathingRate, save, code);
	}
	public static void displayCondition(String firstName, String lastName, char gender, int age, String DOB, String reason, double sBloodPressure, double dBloodPressure, double heartRate, double temperature, double breathingRate, boolean save, String code) {
		Scanner keyboard = new Scanner(System.in);
		if (sBloodPressure >= 90 && sBloodPressure <= 120 && dBloodPressure >= 60 && dBloodPressure <= 80 && heartRate >= 60 && heartRate <= 100 && temperature >= 97 && temperature <= 99 && breathingRate >= 12 && breathingRate <= 25){
			System.out.println("Condition A Normal");
		}
		else {
			System.out.println("Condition B Abnormal");
			System.out.println("Enter code: ");
			String c = keyboard.nextLine();
			boolean reenter = true;
			if(c.equals(code)) {
				if(sBloodPressure > 140 && dBloodPressure > 90) {
					System.out.println("Signal 1: High Blood Pressure");
				}
				if(sBloodPressure < 90 && dBloodPressure < 60) {
					System.out.println("Signal 2: Low Blood Pressure");
				}
				if(heartRate > 100) {
					System.out.println("Signal 3: Pulse Too Fast");
				}
				if(heartRate < 60) {
					System.out.println("Signal 4: Pulse Too Slow");
				}
				if(heartRate == 0) {
					System.out.println("Signal 5: Pulse cannot be detected");
				}
				if(temperature > 99) {
					System.out.println("Signal 6: High temperature");
				}
				if(temperature < 97) {
					System.out.println("Signal 7: Low temperature");
				}
				if(breathingRate > 25) {
					System.out.println("Signal 8: Breathing Too Fast");
				}
				if(breathingRate < 12) {
					System.out.println("Signal 9: Breathing Too Slow");
				}
				if(breathingRate == 0) {
					System.out.println("Signal 10: Breathing cannot be detected");
				}
			}
			else {
				reenter = false;
				while(reenter == false) {
					System.out.println("Error! Incorrect code.");
					System.out.println("Reenter your code: ");
					c = keyboard.nextLine();
				}
			}
		}
		mainMenu(firstName, lastName, gender, age, DOB, reason, sBloodPressure, dBloodPressure, heartRate, temperature, breathingRate, save, code);
	}
	public static void updatePatientInfo(String firstName, String lastName, char gender, int age, String DOB,
		String reason, double sBloodPressure, double dBloodPressure, double heartRate, double temperature, double breathingRate, boolean save, String code) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		boolean up = true;
		while (up == true) {
			System.out.println("Which information would you like to update?");
			System.out.println("Press 1 for code");
			System.out.println("Press 2 for first name");
			System.out.println("Press 3 for last name");
			System.out.println("Press 4 for age");
			System.out.println("Press 5 for reason");
			System.out.println("Only choose one number");
		
			int update = keyboard.nextInt();
		
			switch(update) {
				case 1:
					System.out.println("Enter a new code to access device. The code must be 4 characters long.");
					code = keyboard.nextLine();
					if(code.length() > 4) {
						System.out.println("Error the code must be 4 characters long. Enter a new code:");
						code = keyboard.nextLine();
					}
					break;
				case 2:
					System.out.println("Enter updated first name: ");
					firstName = keyboard.next();
					break;
				case 3:
					System.out.println("Enter updated last name: ");
					lastName = keyboard.next();
					break;
				case 4:
					System.out.println("Enter updated age: ");
					age = keyboard.nextInt();
					break;
				case 5:
					System.out.println("Enter updated reason: ");
					reason = keyboard.nextLine();
					break;
				default:
					break;
			}
			System.out.println("Would you like to update any other information? (Y/N)");
			char d = keyboard.next().charAt(0);
			d = Character.toUpperCase(d);
			if(d == 'Y'){
				up = true;
			}
			else {
				up = false;
			}
		}
		mainMenu(firstName, lastName, gender, age, DOB, reason, sBloodPressure, dBloodPressure, heartRate, temperature, breathingRate, save, code);
		
	}
	public static void saveInfo(String firstName, String lastName, char gender, int age, String DOB, String reason, double sBloodPressure, double dBloodPressure, double heartRate, double temperature, double breathingRate, boolean save, String code) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Are you saving an existing file or a new file? Press e for existing or n for new:");
		char choice = keyboard.next().charAt(0);
		choice = Character.toUpperCase(choice);
		System.out.println("Saving...");
		if(choice == 'E') {
			PrintWriter pw = null;
			try{
				System.out.println("Enter the file path: ");
				String filePath = keyboard.next();
				pw = new PrintWriter(new FileWriter(filePath, false));
				pw.println("Patient Information");
				pw.println("Code: " + code);
				pw.println("Name: " + lastName + " " + firstName);
				pw.println("Gender: " + gender);
				pw.println("Age: " + age);
				pw.println("DOB: " + DOB);
				pw.println("Reason for staying: " + reason);
				pw.println("Systolic Blood Pressure: " + sBloodPressure + " mmHg");
				pw.println("Diastolic Blood Pressure: " + dBloodPressure + " mmHg");
				pw.println("Heart Rate (per minute): " + heartRate);
				pw.println("Temperature: " + temperature + " ºF");
				pw.println("Breathing Rate (per minute): " + breathingRate);
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
			finally {
			    if (pw != null) {
			        pw.close();
			    }
			}
		}
		else if(choice == 'N') {
			PrintWriter pw = null;
			try{
				System.out.println("Enter a file name. File name should use _ instead of spaces.");
				String fileName = keyboard.next();
				pw = new PrintWriter(new FileWriter(fileName + ".txt", true));
				pw.println("Patient Information");
				pw.println("Code: " + code);
				pw.println("Name: " + lastName + ", " + firstName);
				pw.println("Gender: " + gender);
				pw.println("Age: " + age);
				pw.println("DOB: " + DOB);
				pw.println("Reason for staying: " + reason);
				pw.println("Systolic Blood Pressure: " + sBloodPressure);
				pw.println("Diastolic Blood Pressure: " + dBloodPressure);
				pw.println("Heart Rate: " + heartRate);
				pw.println("Temperature: " + temperature);
				pw.println("Breathing Rate (per minute): " + breathingRate);
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
			finally {
				if (pw != null) {
		        pw.close();
				}
			}
		}
		System.out.println("Saved");
		mainMenu(firstName, lastName, gender, age, DOB, reason, sBloodPressure, dBloodPressure, heartRate, temperature, breathingRate, save, code);
	}
}
