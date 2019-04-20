<#import "parts/commonPage.ftl" as c>

<@c.page>
    User editor

    <form>
        <input type="text" name="username" value="${user.username}">
        <div>
            <#list user.roles as role>${role}<#sep>, </#list>
        </div>
        <input type="hidden" value="${user.id}" name="userId">
    </form>
</@c.page>