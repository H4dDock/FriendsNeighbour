<#import "parts/commonPage.ftl" as c>

<@c.page>
    <#list users as user>
        <ul>
            <li>${user.getUsername()}</li>
        </ul>
    </#list>
</@c.page>