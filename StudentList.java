import java.io.*;
// import java.sql.SQLOutput;
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
				BufferedReader bufferReader = readFile();
				String students = bufferReader.readLine();
				String names[] = students.split(Constants.comma);

				for (String student : names) {
					System.out.println(student.trim());
				}
				bufferReader.close();
			} catch (Exception e) {

			}
			System.out.println(Constants.loadedData);
		} else if (args[0].equals(Constants.randomName)) {
			System.out.println(Constants.loadData);
			try {
				BufferedReader bufferedReader = readFile();
				String students = bufferedReader.readLine();
				String names[] = students.split(Constants.comma);
				Random random = new Random();
				int randomIndex = random.nextInt(4);
				System.out.println(names[randomIndex].trim());
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
				String dateFormatString = Constants.dateFormatString;
				DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
				String formatDate = dateFormat.format(date);
				bufferedWriter.write(Constants.comma + student + "\nList last updated on " + formatDate);
				bufferedWriter.close();
			} catch (Exception e) {

			}

			System.out.println(Constants.loadedData);
		} else if (args[0].contains(Constants.findFor)) {
			System.out.println(Constants.loadData);
			try {
				BufferedReader bufferedReader = readFile();
				String students = bufferedReader.readLine();
				String names[] = students.split(Constants.comma);
				boolean done = false;
				String studentName = args[0].substring(1);
				for (int index = 0; index < names.length && !done; index++) {
					if (names[index].trim().equals(studentName)) {
						System.out.println(Constants.found);
						done = true;
					}
				}
				bufferedReader.close();
			} catch (Exception e) {

			}
			System.out.println(Constants.loadedData);
		} else if (args[0].contains(Constants.showCount)) {
			System.out.println(Constants.loadData);
			try {
				BufferedReader bufferedReader = readFile();
				String students = bufferedReader.readLine();

				String names[] = students.split(Constants.comma);
				int countWord = names.length;
				System.out.println(countWord + " word found");
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
