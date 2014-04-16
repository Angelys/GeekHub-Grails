<%--
  Created by IntelliJ IDEA.
  User: angelys
  Date: 1/6/14
  Time: 10:58 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title><g:layoutTitle default="Notifications"/></title>
    </head>

    <body>

        <g:applyLayout name="kickstart">
            <content tag="submenubar">
                <g:render template="/pushNotification/menubar"/>
            </content>
            <g:layoutBody/>
        </g:applyLayout>
    </body>

</html>