
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TODO</title>
</head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<body>
	<div class="container px-4 text-center">
		<div class="row">
			<div class="col">
				<h1>TODOs:</h1>
			</div>
			<div class="col">
				<a class="btn btn-success" href="add-todos" role="button">Add Todo</a>
			</div>
		</div>
		<div class="row">
			<div class="col">

				<table class="table table-hover table-success table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Description</th>
							<th scope="col">Target Date</th>
							<th scope="col">Is Done?</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ todos }" var="todo">
							<tr>
								<th scope="row">${ todo.id }</th>
								<td>${ todo.description}</td>
								<td>${ todo.targetDate }</td>
								<td>${ todo.done }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>