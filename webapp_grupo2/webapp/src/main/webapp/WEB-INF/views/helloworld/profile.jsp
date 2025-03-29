<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<h2>HELLO <c:out value="${userid}" escapeXml="True" />!</h2>
</body>
</html>
