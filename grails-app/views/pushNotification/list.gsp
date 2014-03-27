<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Notifications</title>
    <meta name="layout" content="notification" />
</head>
<body>
<div>
    <table class="table table-bordered">
        <tr>
            <td>Title</td>
            <td>Description</td>
            <td>Post Time</td>
        </tr>
        <g:each in="${notifications}">
            <tr>
                <td>${it.title}</td>
                <td>${it.description}</td>
                <td>${it.postTime}</td>
            </tr>
        </g:each>
    </table>
</div>
</body>
</html>