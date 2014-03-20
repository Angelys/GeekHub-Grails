<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="notification" />
</head>

<body>
    <h1>Notification create: Step 1</h1>

    <g:hasErrors bean="${command}">
        <div class="errors">
            <g:renderErrors bean="${command}" as="list" />
        </div>
    </g:hasErrors>

    <section>
        <g:form action="notification" method="post">
            <label for="title">Title</label>
            <input type="text" id="title" name="title" value="${notification.title}"/>
            <button>Save & Push</button>
        </g:form>
    </section>
</body>
</html>