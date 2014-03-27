<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="notification" />
</head>

<body>
    <h1>Error on web flow</h1>

    <g:hasErrors bean="${command}">
        <div class="errors">
            <g:renderErrors bean="${command}" as="list" />
        </div>
    </g:hasErrors>
</body>
</html>