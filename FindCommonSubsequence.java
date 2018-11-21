import java.util.ArrayList;
import java.util.Scanner;

/**
 * to know the generation
 */

/**
 * @author ACER
 *
 */
public class FindCommonSubsequence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int root = scanner.nextInt();
		for (int index = 0; index < root; index++) {
			ArrayList<String> answer = new ArrayList<>();
			// data accept
			String dataOne = scanner.next();
			String dataTwo = scanner.next();

			// classify the data type
			String[] GenOne = new String[dataOne.length()];
			String[] GenTwo = new String[dataTwo.length()];
			for (int in = 0; in < dataOne.length(); in++) {
				GenOne[in] = Character.toString(dataOne.charAt(in));
			}

			for (int in = 0; in < dataTwo.length(); in++) {
				GenTwo[in] = Character.toString(dataTwo.charAt(in));
			}

			// operation
			for (int i = 0; i < GenOne.length; i++) {
				for (int j = 0; j < GenTwo.length; j++) {
					String data = "";
					if (GenOne[i].equals(GenTwo[j])) {
						data += GenOne[i];
						int tempIndex = j + 1;
						for (int l = i + 1; l < GenOne.length; l++) {
							for (int k = tempIndex; k < GenTwo.length; k++) {
								if (GenOne[l].equals(GenTwo[k])) {
									tempIndex = k + 1;
									data += GenOne[l];
									k += GenTwo.length;
								}
							}
						}
						answer.add(data);
					}
				}
			}
			int max = 0;
			for (String s : answer) {
				System.out.println(s);
				if (s.length() > max) {
					max = s.length();

				}
			}
			System.out.println(max);
		}
		if (scanner != null) {
			scanner.close();
		}
	}

}
