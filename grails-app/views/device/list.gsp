<%--
  Created by IntelliJ IDEA.
  User: angelys
  Date: 1/2/14
  Time: 5:40 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Devices</title>
    <meta name="layout" content="kickstart" />
</head>

<body>
<h1>Tokens (${devices.size()})</h1>
    <ul>
        <g:each in="${devices}">
            <li>
                <p>${it.token}</p>
            </li>
        </g:each>
    </ul>
</body>
</html>