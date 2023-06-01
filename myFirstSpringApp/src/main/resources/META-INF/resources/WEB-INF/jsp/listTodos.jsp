
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container px-4">
	<div class="row">
		<div class="col">
			<h1>Todos:</h1>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<table class="table table-responsive table-hover table-striped">
				<thead>
					<tr class="table-dark">
						<th scope="col">Description</th>
						<th scope="col">Target Date</th>
						<th scope="col">Is Done?</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ todos.size() > 0 }">
							<c:forEach items="${ todos }" var="todo">
								<tr class="table-info">
									<td>${ todo.description}</td>
									<td>${ todo.targetDate }</td>
									<c:choose>
										<c:when test="${ todo.done }">
											<td>Yes</td>
										</c:when>
										<c:otherwise>
											<td>No</td>
										</c:otherwise>
									</c:choose>
									<td><a href="edit-todo?id=${ todo.id }"
										title="edit ${ todo.description}" class="btn btn-success">Update</a>
										<a href="delete-todo?id=${ todo.id }"
										title="delete ${ todo.description}" class="btn btn-warning">Delete
									</a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr class="table-info">
								<td colspan="4" class="text-center">There is no matching
									data available</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<a class="btn btn-success" href="add-todos" role="button">Add
				Todo</a>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>