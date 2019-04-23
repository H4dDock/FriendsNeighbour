<#import "parts/commonPage.ftl" as c>

<@c.page>
    <nav>
        <ul>
            <#list messages as message>
                <li><#if message.getFromUser() == user.getUsername()>${message.getFromUser()}
                    <#else >${message.getFromUser()}</#if>-----${message.getMessage()}</li>
            </#list>
        </ul>
    </nav>

    <form action="/message" method="post">
        <div class="form-group row">
            <div class="col-sm-5">
                <input class="form-control" type="hidden" name="toUser" value="${toUser}"/>
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

</@c.page>