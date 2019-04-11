<#import "parts/commonPage.ftl" as c>
<#import "parts/authorisation.ftl" as auth>

<@c.page>
    Add new user
    <@auth.login "/registration"/>
</@c.page>