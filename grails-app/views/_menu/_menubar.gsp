<div>
	<ul class="nav nav-tabs" data-role="listview" data-split-icon="gear" data-filter="true">
        <sec:ifAnyGranted roles="ROLE_ADMIN">
            <li>
                <g:link controller="pushNotification" action="index">Notifications</g:link>
            </li>
            <li>
                <g:link controller="device" action="list">Devices</g:link>
            </li>
        </sec:ifAnyGranted>
	</ul>
</div>
