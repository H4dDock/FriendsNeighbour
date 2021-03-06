<#include "security.ftl">
<#import "authorisation.ftl" as auth>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/mainPage">FriendsNeighbour</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/mainPage">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/profile">Profile</a>
            </li>

            <#if !isUser>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
            </#if>

            <#if isUser>
                <li class="nav-item">
                    <a class="nav-link" href="/message">Messages</a>
                </li>
            </#if>

            <#if !isUser>
            <li class="nav-item">
                <a class="nav-link" href="/registration">Registration</a>
            </li>
            </#if>

            <#if isUser>
                <li class="nav-item">
                    <a class="nav-link" href="/user/userList">Users list</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <#if isUser>
            <@auth.logout/>
        </#if>
    </div>
</nav>