<#import "parts/commonPage.ftl" as c>

<@c.page>
    Profile of ${user.getUsername()}

    <form action="/user" method="post">
        <input type="text" name="username" value="${user.getUsername()}">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.getRoles()?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.getUsername()}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>

</@c.page>