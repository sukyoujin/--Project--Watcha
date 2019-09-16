package crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieInfoCrawler extends CrawlerYJ {

	public static ArrayList<HashMap<String, String>> getMovieInfo() throws IOException {
		Document doc = null;
		ArrayList<HashMap<String, String>> mapList = new ArrayList<>();

		doc = getDocFromUrl("https://watcha.com/ko-KR/users/NP9vLVLeox6kl/contents/movies/ratings");
		Elements elsInfo = doc.select("section > div > div > ul > li");
		HashMap<String, String> map = null;
		for (Element el : elsInfo) {
			map = new HashMap<>();
			map.put("name", getStringFromEl(el, "a", "title"));
			map.put("star", getStringFromEl(el, "a > div > div.e3fgkal4"));
//			map.put("urlImg", getStringFromEl(el, "a", "href"));
			
			mapList.add(map);
		}
		System.out.println(mapList);
		return mapList;
	}

	public static ArrayList<String> getPosterUrl(String url) throws IOException {
		Document doc = null;
		doc = getDocFromUrl(url);
		Elements elsURL = doc.select(".ewlo9840");
		ArrayList<String> urlList = new ArrayList<>();
		for (Element el : elsURL) {
			System.out.println(getStringFromEl(el, "img", "src"));
			urlList.add(getStringFromEl(el, "img", "src"));
		}
		return urlList;
	}

//	public static ArrayList<String> getMovieName() throws IOException {
//		Document doc = null;
//		doc = getDocFromUrl("https://watcha.com/ko-KR/users/NP9vLVLeox6kl/contents/movies/ratings");
//		Elements elsName = doc.select(".e3fgkal3");
////		System.out.println(elsName);
//		ArrayList<String> nameList = new ArrayList<>();
//		for (Element el2 : elsName) {
//			System.out.println(el2.text());
//			nameList.add(el2.text());
//		}
//		return nameList;
//	}
//
//	public static ArrayList<String> getMovieRank() throws IOException {
//		Document doc = null;
//		doc = getDocFromUrl("https://watcha.com/ko-KR/users/NP9vLVLeox6kl/contents/movies/ratings");
//		Elements elsRank = doc.select(".e3fgkal4");
//		ArrayList<String> rankList = new ArrayList<>();
//
//		for (Element el3 : elsRank) {
//			System.out.println(el3.text().substring(1));
//			rankList.add(el3.text());
//		}
//		return rankList;
//	}

	public static ArrayList<String> getMovieExp() throws IOException {
		Document doc = null;
		doc = getDocFromUrl("");
		Elements elsURL = doc.select(".ewlo9840");
		ArrayList<String> expList = new ArrayList<>();
		for (Element el : elsURL) {
			expList.add(getStringFromEl(el, "img", "src"));
		}
		return expList;
	}

	public static void main(String[] args) {
		try {
			getMovieInfo();
//			getPosterUrl();
//			getMovieName();
//			getMovieRank();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
//	public static ArrayList<HashMap<String, String>> getMovieImages() throws IOException{
//		Document doc = null;
//		ArrayList<HashMap<String, String>> movies = new ArrayList<>();
//		doc = getDocFromUrl("https://watcha.com/ko-KR/users/NP9vLVLeox6kl");
////		System.out.println(doc);
//		Elements els = doc.select("#root > div > div.css-d3s16q-NavContainer.ebsyszu0 > section > div > div > div > div > section > div.css-1gkas1x-Grid.ejny11m0").select("a");
////		System.out.println(els);
//		HashMap<String, String> map = null;
//		for(Element el : els) {
//			map = new HashMap<>();
////			System.out.println(el.attr("href"));
//			map.put("url", el.attr("href"));
//			System.out.println(map);
//			/*
//			{url=/ko-KR/users/NP9vLVLeox6kl/analysis}
//			{url=/ko-KR/users/NP9vLVLeox6kl/contents/movies}
//			{url=/ko-KR/users/NP9vLVLeox6kl/contents/tv_seasons}
//			{url=/ko-KR/users/NP9vLVLeox6kl/contents/books}
//			 */
//		}
//		return movies;
//	}