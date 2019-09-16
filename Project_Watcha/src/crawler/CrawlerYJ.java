package crawler;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CrawlerYJ {
	
	public static Document getDocFromUrl(String url) throws IOException {
		return Jsoup.connect(url).get();
	}
	
	public static Document getDocFromUrl(String url, Map<String, String> inputData) throws IOException {
		return Jsoup.connect(url).data(inputData).get();
	}

	public static String getStringFromEl(Element el, String query) {
		return el.select(query).text();
	}
	
	public static String getStringFromEl(Element el, String query, String key) {
		return el.select(query).attr(key);
	}
	
	public static String getHtmlFromEl(Element el, String query) {
		return el.select(query).html();
	}
	
}
