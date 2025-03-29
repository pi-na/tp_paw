<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h1>Hello, <c:out value="${username}" escapeXml="True" />!</h1>
</body>
</html>
