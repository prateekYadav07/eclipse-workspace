
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
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<body>
	<div class="container px-4 text-center">
		<div class="row">
			<div class="col">
				<h1>TODOs:</h1>
			</div>
			<div class="col">
				<a class="btn btn-success" href="add-todos" role="button">Add
					Todo</a>
			</div>
		</div>
		<div class="row">
			<div class="col">

				<table class="table table-hover table-success table-striped">
					<thead>
						<tr>
							<th scope="col">Description</th>
							<th scope="col">Target Date</th>
							<th scope="col">Is Done?</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ todos }" var="todo">
							<tr>
								<td>${ todo.description}</td>
								<td>${ todo.targetDate }</td>
								<td>${ todo.done }</td>
								<td><a href="edit-todo?id=${ todo.id }"
									title="edit ${ todo.description}" class="btn btn-success">Update</a>
									<a href="delete-todo?id=${ todo.id }"
									title="delete ${ todo.description}" class="btn btn-warning">Delete
								</a></td>
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