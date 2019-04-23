<#import "parts/commonPage.ftl" as c>

<@c.page>
    <form action="/message" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Send to:</label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="toUser" placeholder="User name"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Message:</label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="message" placeholder="Message"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary mb-3">Send</button>
    </form>
    <h1>Messages</h1>
    <#list authors as author>
        <ul>
            <li>
                <a href="/message/${author}">${author}</a>
            </li>
        </ul>
    </#list>

</@c.page>