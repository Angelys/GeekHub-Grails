<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="notification" />
</head>

<body>
    <h1>Version ${version}</h1>
    <h2>
        <g:if test="${date}">Release date ${date.format('yyyy-MM-dd HH:mm:ss')}</g:if>
        <g:if test="${!date}">No date</g:if>
    </h2>
<section>
    <g:form action="release" method="post">
        <g:datePicker name="date" default="${date}"/>
        <label for="version">Version</label>
        <input type="text" id="version" name="version" value="${version}"/>
        <button>Save & Push</button>
    </g:form>
</section>
</body>
</html>