import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class txtReader {
	public WordCounter tree = new BST();
	
	public boolean onlyDigits(String str, int n)
    {
		for (int i = 0; i < n; i++) {
			  
            // Check if the sepecified
            // character is a digit then
            // return true,
            // else return false
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

	public txtReader(String s1, LinkList ll) throws FileNotFoundException {
		File TXT = new File(s1);
		Scanner scan = new Scanner(TXT);
		// remove all numbers
		while(scan.hasNextLine()) {
		String word = scan.next().toLowerCase();
		String word2 = word.replaceAll("[\\p{Punct}&&[^']]+", " ");
		int len = word2.length();
		boolean flag = onlyDigits(word2, len);
		if (flag == false) {
//			String result = word2.replaceAll("[0-9]+","");
			Scanner sc = new Scanner(word2);
			while (sc.hasNext()) {
				String word1 = sc.next();
				if (ll.printStack(word1) == false) {
					tree.insert(word1);
				}
			}
			System.out.println(tree.toString());
			System.out.println("=========");
		}
	}
	}
}
