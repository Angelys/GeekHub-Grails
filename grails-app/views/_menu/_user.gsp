<ul class="nav navbar-nav navbar-right">
	<li class="dropdown">
	
<sec:ifNotLoggedIn>

		<a class="dropdown-toggle" data-toggle="dropdown" href="#">
    		<i class="icon-user"></i>
    		<g:message code="security.signin.label"/><b class="caret"></b>
		</a>

		<ul class="dropdown-menu" role="menu">
			<li class="form-container">
				<form action="${request.contextPath}/j_spring_security_check" method="POST" accept-charset="UTF-8">
<%--				<form action="login" method="post" accept-charset="UTF-8">--%>
					<input class="form-control" style="margin-bottom: 15px;" type="text"		placeholder="Username" id="username" name="j_username">
					<input class="form-control" style="margin-bottom: 15px;" type="password"	placeholder="Password" id="password" name="j_password">
					<input style="float: left; margin-right: 10px;" type="checkbox" name="_spring_security_remember_me" id="remember_me" value="1">
					<label class="string optional" for="remember_me"> Remember me</label>
					<input class="btn btn-primary btn-block" type="submit" id="sign-in" value="Sign In">
				</form>
			</li>
			<li class="divider"></li>
			%{--<li class="button-container">
				<g:render template="/_common/modals/registerTextLink"/>
			</li>--}%
		</ul>

</sec:ifNotLoggedIn>
<sec:ifLoggedIn>

        <a class="dropdown-toggle" role="button" data-toggle="dropdown" data-target="#" href="#">
			<!-- TODO: Only show menu items based on permissions (e.g., Guest has no account page) -->
			<i class="icon-user icon-white"></i>
			${sec.loggedInUserInfo(field: 'username')}
			<b class="caret"></b>
		</a>
		<ul class="dropdown-menu" role="menu">
			<li class=""><g:link controller="logout">
				<i class="icon-off"></i>
				<g:message code="security.signoff.label"/>
            </g:link></li>
		</ul>

</sec:ifLoggedIn>

	</li>
</ul>

<noscript>
<ul class="nav pull-right">
	<li class="">
		<g:link controller="user" action="show"><g:message code="default.user.unknown.label"/></g:link>
	</li>
</ul>
</noscript>
