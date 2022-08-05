import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if (args.length == 0 || args.length != 1) {
			System.out.println(Constants.usage);
			return;
		}
		if (args[0].equals(Constants.showAll)) {
			System.out.println(Constants.loadData);
			try {
				BufferedReader bufferedReader = readFile();
				String names[] = bufferedReader.readLine().split(Constants.comma);
				for (String name : names) {
					System.out.println(name.trim());
				}
				bufferedReader.close();
			} catch (Exception e) {

			}
			System.out.println(Constants.loadedData);
		} else if (args[0].equals(Constants.randomName)) {
			System.out.println(Constants.loadData);
			try {
				BufferedReader bufferedReader = readFile();
				String names[] = bufferedReader.readLine().split(Constants.comma);
				Random random = new Random();
				System.out.println(names[random.nextInt(4)].trim());
				bufferedReader.close();
			} catch (Exception e) {

			}
			System.out.println(Constants.loadedData);
		} else if (args[0].contains(Constants.addSomething)) {
			System.out.println(Constants.loadData);
			try {
				BufferedWriter bufferedWriter = writeFile();
				String student = args[0].substring(1);
				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat(Constants.dateFormatString);
				bufferedWriter.write(Constants.comma + " " + student + "\nList last updated on " + dateFormat.format(date));
				bufferedWriter.close();
			} catch (Exception e) {

			}

			System.out.println(Constants.loadedData);
		} else if (args[0].contains(Constants.findFor)) {
			System.out.println(Constants.loadData);
			try {
				BufferedReader bufferedReader = readFile();
				String names[] = bufferedReader.readLine().split(Constants.comma);				
				String studentName = args[0].substring(1);
				int countNames = 0;
				for (int index = 0; index < names.length; index++) {
					if (names[index].trim().equals(studentName)) {
						countNames = countNames + 1;
					}
				}
				if(countNames == 0) {
					System.out.println("Name not found!");
				}
				else {
					System.out.println(countNames + " name found!");
				}
				bufferedReader.close();
			} catch (Exception e) {

			}
			System.out.println(Constants.loadedData);
		} else if (args[0].contains(Constants.showCount)) {
			System.out.println(Constants.loadData);
			try {
				BufferedReader bufferedReader = readFile();
				String words[] = bufferedReader.readLine().split(Constants.comma);
				// names.length means total number of words which is splitted by comma.
				System.out.println(words.length + " words found!");
				bufferedReader.close();
			} catch (Exception e) {

			}
			System.out.println(Constants.loadedData);
		} else {
			System.out.println(Constants.usage);
		}
	}

	private static BufferedWriter writeFile() throws IOException {
		BufferedWriter bufferedReader = new BufferedWriter(
				new FileWriter(Constants.studentList, true));
		return bufferedReader;
	}

	private static BufferedReader readFile() throws FileNotFoundException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(Constants.studentList)));
		return bufferedReader;
	}
}
