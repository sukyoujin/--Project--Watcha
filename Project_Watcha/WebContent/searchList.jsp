<%@page import="service.WatchaService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%
		WatchaService service = WatchaService.getInstance();
			pageContext.setAttribute("movieList", service.getAllMovies());
	%>
	<style>
.movie {
	width: 50px;
	height: 50px;
	margin: 5px;
	border-radius: 100%;
}
</style>
	<h3>COLORS</h3>
	<c:forEach items="${movieList}" var="movie">
		<button class="movie" title="${movie.name}">${movie.name} ${movie.star}</button>
	</c:forEach>
	