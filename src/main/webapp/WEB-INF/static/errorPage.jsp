<%@ page isErrorPage="true" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 7/24/19
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Opps...</h1>
<p>Sorry, an error occurred.</p>
<p>Here is the exception stack trace: </p>
<pre><% exception.printStackTrace(response.getWriter()); %></pre>
</body>
</html>
