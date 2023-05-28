
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
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" path="targetDate" required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success">submit</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>