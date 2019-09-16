package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import model.dto.WatchaDTO;
import util.DBUtil;
import util.Prop;

public class WatchaDAO {
	public static Properties prop = (Prop.getInstance()).loadDAOProp();
	public final static String table_name = "watcha";

	public static ArrayList<WatchaDTO> getAllMovies() throws SQLException {
		String option = "select_all";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<WatchaDTO> movieList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(prop.getProperty(table_name + "." + option));
			rset = pstmt.executeQuery();

			movieList = new ArrayList<WatchaDTO>();
			while (rset.next()) {
//				movieList.add(new WatchaDTO(rset.getString(1), rset.getString(2), rset.getString(3)));
				movieList.add(new WatchaDTO(rset.getString(1), rset.getString(2).substring(1)));

			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		System.out.println(movieList.size());
//		System.out.println(movieList);

		return movieList;
	}

	public static WatchaDTO getOneMovie(String name) throws SQLException {
		String option = "select";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		WatchaDTO movie = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(prop.getProperty(table_name + "." + option));
			pstmt.setString(1, name);
			rset = pstmt.executeQuery();
			if (rset.next()) {
//				movie = new WatchaDTO(rset.getString(1), rset.getString(2), rset.getString(3));
				movie = new WatchaDTO(rset.getString(1), rset.getString(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return movie;
	}

	public static boolean addMovie(WatchaDTO movie) throws SQLException {
		String option = "insert";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(prop.getProperty(table_name + "." + option));
			pstmt.setString(1, movie.getName());
			pstmt.setString(2, movie.getStar());
//			pstmt.setString(3, movie.getUrlImg());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean deleteMovie(String name) throws SQLException {
		String option = "delete";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(prop.getProperty(table_name + "." + option));
			pstmt.setString(1, name);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean updateMovie(String name, String star) throws SQLException {
		String option = "update";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(prop.getProperty(table_name + "." + option));
			pstmt.setString(1, name);
			pstmt.setString(2, star);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

}