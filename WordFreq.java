
public class WordFreq {
	private String word;  //key tis kaue lexhs h idia h lexh
	private int freq;	  //syxnothta poy emfanizetai ayth h lexh sto keimeno
	
	public WordFreq(String word, int freq) {	//constructor
		this.word = word;
		this.freq = freq;
		
	}
	public String key() {	//epistrefei to kleidi
		return word;
	}
	public String toString() {
		return this.word + " " + this.freq + " ";
	}
	
	public void setKey(String word) {
		this.word = word;
	}
	
	public void addFreq() {
		this.freq++;
	}
	
	public int getFreq() {
		return this.freq;
	}
}
