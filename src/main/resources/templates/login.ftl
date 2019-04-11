<#import "parts/commonPage.ftl" as c>
<#import "parts/authorisation.ftl" as auth>

<@c.page>
    <@auth.login "/login"/>
    <a href="/registration">Add new user</a>
</@c.page>