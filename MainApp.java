
public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordCounter bst = new BST();
		bst.insert("Cat");
		bst.insert("Dimitris");
		bst.insert("Alexis");
		bst.insert("Cat");
		//bst.insert("Dimitris");
		bst.insert("Theofania");
		bst.insert("Bagg");
		bst.insert("Aa");
		bst.insert("Cb");
		//bst.insert("Dimitris");
		bst.insert("Bagg");
		bst.insert("Alexis");
		bst.insert("Aa");
		bst.insert("Sapikas");
		bst.insert("Ntolmadakia");
		bst.insert("Hlios");
		System.out.println(bst.toString());
		//System.out.println(bst.getMeanFrequency());
//		bst.search("Bagg");
//		System.out.println(bst.toString());
		//System.out.println(bst.getMaximumFrequency());
//		System.out.println(bst.getFrequency("Dimitris"));
//		System.out.println(bst.getDistinctWords());
//		System.out.println(bst.getTotalWords());
		//bst.print‘reeAlphabetically(null);
//		bst.print‘reeByFrequency(null);
		bst.addStopWord("Minas");
		bst.addStopWord("Imera");
		bst.addStopWord("Fos");
		bst.removeStopWord("Minas");
	}
}
