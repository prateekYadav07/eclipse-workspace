
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Todo:</h1>
	<form:form method="post" modelAttribute="todo">
		<fieldset class="mb-3">
			<form:label path="description" class="form-label">Description</form:label>
			<form:input type="text" class="form-control" path="description" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>
		<fieldset class="mb-3">
			<form:label path="targetDate" class="form-label">Target Date</form:label>
			<form:input type="text" class="form-control w-25 p-3"
				path="targetDate" required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		<c:if test="${ done }">
			<fieldset class="mb-3">
				<form:label path="done">Is it Done?</form:label>
				<select path="done" name="done" class="form-select w-25 p-3"
					aria-label="Floating label select example">
					<option value="true">Yes</option>
					<option value="false" selected>No</option>
				</select>
			</fieldset>
		</c:if>
		<button type="submit" class="btn btn-success">submit</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>