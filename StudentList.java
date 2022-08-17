import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {
		if (args.length != 1) { // Checking arguments available or not
			System.out.println(Constants.USAGE);
			return;

		} else if (args[0].equals(Constants.SHOW_ALL)) {
			System.out.println(Constants.DATA_LOADING);
			String names[] = fileToStirngArray(Constants.STUDENT_LIST);
			for (String name : names) {
				System.out.println(name.trim());
			}
			System.out.println(Constants.DATA_LOADED);

		} else if (args[0].equals(Constants.RANDOM)) {
			System.out.println(Constants.DATA_LOADING);
			String names[] = fileToStirngArray(Constants.STUDENT_LIST);
			Random random = new Random();  // random object created for random name generating
			System.out.println(names[random.nextInt(names.length)].trim());  // random name printing
			System.out.println(Constants.DATA_LOADED);

		} else if (args[0].contains(Constants.PLUS_SIGN)) {
			System.out.println(Constants.DATA_LOADING);
			try {
				BufferedWriter bufferedWriter = writeToFile(Constants.STUDENT_LIST);  // file writer object
				String student = args[0].substring(1);
				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_STRING);
				bufferedWriter.write(Constants.COMMA + " " + student + "\nList last updated on " + dateFormat.format(date));
				bufferedWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Constants.DATA_LOADED);

		} else if (args[0].contains(Constants.QUESTION_MARK)) {
			System.out.println(Constants.DATA_LOADING);
			String names[] = fileToStirngArray(Constants.STUDENT_LIST);			
			String studentName = args[0].substring(1);
			int countNames = 0;
			for (int index = 0; index < names.length; index++) {
				if (names[index].trim().equals(studentName)) {
					countNames = countNames + 1;
				}
			}
			if(countNames == 0) {
				System.out.println(Constants.NAME_NOT_FOUND_MESSAGE);
			}
			else {
				System.out.println(countNames + " data " + Constants.NAME_FOUND_MESSAGE);
			}
			System.out.println(Constants.DATA_LOADED);

		} else if (args[0].contains(Constants.SHOW_COUNT)) {
			System.out.println(Constants.DATA_LOADING);
			String words[] = fileToStirngArray(Constants.STUDENT_LIST);
			System.out.println(words.length + Constants.WORD_FOUND_MESSAGE);  // words.length returns total number of words available in the file
			System.out.println(Constants.DATA_LOADED);

		} else {
			System.out.println(Constants.INVALID_ARGUMENT_MESSAGE); // No arguments matches
			System.out.println(Constants.USAGE);
		}
	}
	private static BufferedWriter writeToFile(String fileName) throws IOException {  // returns a buffered file writer
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter(fileName, true));
		return bufferedWriter;
	}
	private static String[] fileToStirngArray(String fileName) {  // reading from file and returning as string array
		try {
			BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(fileName)));
			String temp[] = bufferedReader.readLine().split(Constants.COMMA);
			bufferedReader.close();
			return temp;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
