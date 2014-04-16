<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="notification" />
</head>

<body>
    <h1>Notification create: Step 2</h1>

    <g:hasErrors bean="${command}">
        <div class="errors">
            <g:renderErrors bean="${command}" as="list" />
        </div>
    </g:hasErrors>

    <section>
        <g:form action="notificationBuild" method="post">
            <label for="description">Description</label>
            <input type="text" id="description" name="description" value="${notification.description}"/>

            <g:submitButton name="next" value="Next" />
            <g:submitButton name="previous" value="Previous" />
            <g:submitButton name="cancel" value="Cancel" />
        </g:form>
    </section>
</body>
</html>