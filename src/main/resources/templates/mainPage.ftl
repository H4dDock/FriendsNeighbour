<#import "parts/commonPage.ftl" as c>
<#import "parts/authorisation.ftl" as auth>

<@c.page>
    <#list companies as company>
    <ul>
        <li> ${company.getCompanyName()} </li>
    </ul>
    </#list>
    <@auth.logout/>
</@c.page>