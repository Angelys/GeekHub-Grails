<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="notification" />
</head>

<body>
    <h1>Complete</h1>

    <g:hasErrors bean="${command}">
        <div class="errors">
            <g:renderErrors bean="${command}" as="list" />
        </div>
    </g:hasErrors>

    <section>
        <p class="title">${notification.title}</p>
        <p class="description">${notification.description}</p>
        <p class="postTime">${notification.postTime}</p>

        <g:link event="next">Next</g:link>
        <g:link event="previous" >Previous</g:link>
        <g:link event="cancel" >Cancel</g:link>
    </section>
</body>
</html>