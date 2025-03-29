<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h2>Register now</h2>
<c:url var="registerUrl" value="/register" />
<form action="${registerUrl}" method="post">
    <div>
        <label>Email:
            <input type="email" id="email" name="email" required />
        </label>
    </div>
    <div>
        <label>Password:
            <input type="password" id="password" name="password" required />
        </label>
    </div>
    <div>
        <input type="submit" value="Register" />
    </div>
</form>
</body>
</html>
