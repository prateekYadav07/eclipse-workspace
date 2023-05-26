
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
	<div class="container">
		<h1>Add a Todo:</h1>
		<form method="post">
			<div class="mb-3">
				<label for="description" class="form-label">Description</label> 
				<input type="text" class="form-control" name="description" id="description"
					aria-describedby="descriptionHelp">
			</div>
			<button type="submit" class="btn btn-success">Add</button>
		</form>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>