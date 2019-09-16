//package service;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.servlet.annotation.WebServlet;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import model.dto.WatchaDTO;
//
//@WebServlet("/service")
//public class Service {
//
////	public static ArrayList<HappinessDTO> readPopFromAPI() throws SQLException, IOException, ParseException{
////		BufferedReader br = null;
////		JSONParser parser = new JSONParser();
////		
////		JSONObject obj = null;
////		
////		int start = 29;
////		int end = 53;
//////		int end = start + 998;
////		URL url = new URL("http://openapi.seoul.go.kr:8088/687566676b73756b32334968566f4e/json/octastatapi26/"+start+"/"+end+"/");
////		
////		HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
////		urlconnection.setRequestMethod("GET");
////		br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
////
////		obj = (JSONObject) ((JSONObject) parser.parse(br.readLine())).get("octastatapi26");
//////		System.out.println(obj);
////		long dataNum = (long) obj.get("list_total_count");
////		JSONArray jsonData = (JSONArray) obj.get("row");
////		
////		ArrayList<HappinessDTO> arrayList = new ArrayList<>();
////		HappinessDTO happy = null;
////		
////		for (int i = 0; i < jsonData.size(); i++) {
////			JSONObject j = (JSONObject) jsonData.get(i);
//////			System.out.println(j);
////			happy = new HappinessDTO((String)j.get("DAEBULLYU"), (String)j.get("JASINUI_GEONGANGSANGTAE"));
////			arrayList.add(happy);
////		}
////		return arrayList;
////	}
//
//	public static void readPopFromAPI() throws SQLException, IOException, ParseException {
//		BufferedReader br = null;
//		JSONParser parser = new JSONParser();
//
//		JSONObject obj = null;
//
//		int start = 29;
//		int end = 53;
////		int end = start + 998;
//		URL url = new URL("http://openapi.seoul.go.kr:8088/687566676b73756b32334968566f4e/json/octastatapi26/" + start
//				+ "/" + end + "/");
//
//		HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
//		urlconnection.setRequestMethod("GET");
//		br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
//
//		obj = (JSONObject) ((JSONObject) parser.parse(br.readLine())).get("octastatapi26");
////		System.out.println(obj);
//		long dataNum = (long) obj.get("list_total_count");
//		JSONArray jsonData = (JSONArray) obj.get("row");
//
//		ArrayList<WatchaDTO> arrayList = new ArrayList<>();
//		WatchaDTO happy = null;
//
//		for (int i = 0; i < jsonData.size(); i++) {
//			JSONObject j = (JSONObject) jsonData.get(i);
////			System.out.println(j);
//			happy = new WatchaDTO((String) j.get("DAEBULLYU"), (String) j.get("JASINUI_GEONGANGSANGTAE"));
//			arrayList.add(happy);
//		}
//		System.out.println(arrayList);
//	}
//
//	public static void main(String[] args) {
//		try {
//			readPopFromAPI();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
//}
