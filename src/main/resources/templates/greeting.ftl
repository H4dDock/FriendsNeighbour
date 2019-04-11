<#import "parts/commonPage.ftl" as c>

<@c.page>
<p>"'Hello, ' + ${name} + '!'"</p>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>
</@c.page>