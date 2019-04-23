<#import "parts/commonPage.ftl" as c>

<@c.page>

    Profile of ${user.getUsername()}

    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Password:</label>
            <div class="col-sm-5">
                <input class="form-control" type="password" name="newPassword" placeholder="Type new password"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary mb-3">Save</button>
    </form>

</@c.page>