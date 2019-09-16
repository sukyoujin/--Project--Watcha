package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import crawler.MovieInfoCrawler;
import exception.DuplicationException;
import exception.NotExistException;
import model.WatchaDAO;
import model.dto.WatchaDTO;
import util.Prop;

public class WatchaService {
	private static WatchaService instance = new WatchaService();
	private WatchaService() {};
	public static WatchaService getInstance() {
		return instance;
	}
	Properties web = Prop.getInstance().loadWebProp();

	public String call(String head, String tail) {
		return web.getProperty(head + "." + tail);
	}

	// 검색 포스터 크롤링
	public ArrayList<String> getPosterUrl(String url) throws IOException, SQLException {
		System.out.println("검색 성공");
		return MovieInfoCrawler.getPosterUrl(url);
		}
	
	// 영화 정보 크롤링
	public void inputMovieInfo() throws IOException, SQLException {
		ArrayList<HashMap<String, String>> mapList = MovieInfoCrawler.getMovieInfo();
		for(HashMap<String, String> map: mapList) {
			try {
//				WatchaDAO.addMovie(new WatchaDTO(map.get("name"), map.get("star"), map.get("urlImg")));
				WatchaDAO.addMovie(new WatchaDTO(map.get("name"), map.get("star")));

				Thread.sleep((long) 500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(map.get("name") + " 추가 성공");
		}
	}

	// 존재 검증
	public void existMovie(String name) throws SQLException, DuplicationException {
		WatchaDTO movie = WatchaDAO.getOneMovie(name);
		if (movie != null) {
			throw new DuplicationException("중복된 name입니다!");
		}
	}

	public void notExistMovie(String name) throws SQLException, NotExistException {
		WatchaDTO movie = WatchaDAO.getOneMovie(name);
		if (movie == null) {
			throw new NotExistException("해당 movie 점수가 없습니다!");
		}
	}

	// 모두 검색
	public ArrayList<WatchaDTO> getAllMovies() throws SQLException, NotExistException, IOException {
		return WatchaDAO.getAllMovies();
	}

	// 개별 검색
	public WatchaDTO getOneMovie(String name) throws SQLException, NotExistException {
		WatchaDTO movie = WatchaDAO.getOneMovie(name);
		if (movie == null) {
			throw new NotExistException("이 movie에 점수를 매기지 않았습니다!");
		}
		return movie;
	}

	// 신규 영화 저장
	public boolean addMovie(WatchaDTO movie) throws SQLException, DuplicationException, NotExistException {
		existMovie(movie.getName());
		System.out.println("영화 점수 매기기 성공");
		return WatchaDAO.addMovie(movie);
	}

	// 기존 영화 수정
	public boolean updateColor(String name, String star) throws SQLException, NotExistException {
		notExistMovie(name);
		System.out.println("영화 점수 변경 성공");
		return WatchaDAO.updateMovie(name, star);
	}

	// 기존 영화 삭제
	public boolean deleteColor(String name) throws SQLException, NotExistException {
		notExistMovie(name);
		System.out.println("영화 평가 삭제 성공");
		return WatchaDAO.deleteMovie(name);
	}
	
	


}
