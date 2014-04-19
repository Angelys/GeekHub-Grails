<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="notification" />
</head>

<body>
    <h1>Error on web flow</h1>

    <g:if test="${notificationMessage}">
        <div class="message">${notificationMessage}</div>
    </g:if>
    <g:form action="build">
    <div class="dialog">
        <p>Sorry, but the system has reported an unrecoverable error.</p>
    </div>
    <div class="buttons">
        <span class="button">
            <g:submitButton class="confirm" name="confirm" value="OK" />
        </span>
    </div>
</g:form>
</body>
</html>