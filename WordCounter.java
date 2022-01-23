import java.io.PrintStream;
public interface WordCounter {
	
		void insert(String w);
		WordFreq search(String w); //den
		void remove(String w);
		void load(String filename);
		int getTotalWords();
		int getDistinctWords();
		int getFrequency(String w);
		WordFreq getMaximumFrequency();
		double getMeanFrequency();
		void addStopWord(String w);
		void removeStopWord(String w);
		void print‘reeAlphabetically(PrintStream stream);
		void print‘reeByFrequency(PrintStream stream);
		
		
		//TreeNode containsNode(String string);
		void PrintStach();
	

}
