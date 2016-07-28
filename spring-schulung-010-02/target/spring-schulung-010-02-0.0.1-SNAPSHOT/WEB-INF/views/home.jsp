<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/theme.jsp"></jsp:include>
<title>OlympicGames :: Home</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>Willkommen zu Olympic Games!</h1>
		<hr />
		<P>There are ${totalOpenTasks}(${totalTasks}) open tasks.</P>
	</div>
</body>
</html>
