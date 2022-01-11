
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WebPage {
	/**
	 * To store and evaluate a web page.
	 */
	private String url;
	private WordCounter counter;
	//private WebContent webContent;
	private String name;
	private double score; // page score for sorting

	public WebPage(String url, String name, WebContent webContent) throws IOException {
		this.url = url;
		this.name = name;
		//this.webContent = new WebContent();
	}

	public void setScore(ArrayList<Keyword> keywords) throws IOException {
		score = 0;
		this.counter = new WordCounter(url);
		for (Keyword k : keywords) {
			score += k.getWeight() * counter.countKeyword(k.getName());
		}
	}

	public String getWebUrl() {
		return url;
	}

	public String getWebName() {
		return name;
	}
	
	public WordCounter getCounter() {
		return counter;
	}

	public double getWebScore() {
		return score;
	}
}
