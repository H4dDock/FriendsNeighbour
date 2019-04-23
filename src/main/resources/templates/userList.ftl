<#import "parts/commonPage.ftl" as c>

<@c.page>
    <form action="/user/viewProfile" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> User Name:</label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="username" placeholder="Find user"/>
            </div>
            <div><button type="submit" class="btn btn-primary mb-3">find</button></div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><form action="/user/viewProfile" method="post">
                    <input type="hidden" name = "username" value="${user.username}"/>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary">Profile</button>
                </form></td>
                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>