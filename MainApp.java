
public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordCounter bst = new BST();
		bst.insert("World");
		bst.insert("Dimitris");
		bst.insert("Thoefania");
		bst.insert("Thoefania");
		bst.insert("Hello");
		bst.insert("Hello");
		bst.insert("Hello");
		bst.insert("Hello");
		bst.insert("Konna");
		bst.insert("World");
		System.out.println(bst.toString());
	}

}
