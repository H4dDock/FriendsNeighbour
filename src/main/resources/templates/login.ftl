<#import "parts/commonPage.ftl" as c>
<#import "parts/authorisation.ftl" as autho>

<@c.page>
    Login page
    <@autho.login "/login" false/>
</@c.page>