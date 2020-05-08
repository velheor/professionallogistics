<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #000000;">
    <a class="navbar-brand" href="/">RaccoonTruck</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse " id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto ">
            <li class="nav-item ">
                <a class="nav-link " href="/" style="color: white">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main" style="color: white">Loads</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user-loads/${сurrentUserId}" style="color: white">My loads</a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user" style="color: white">User list</a>
                </li>
            </#if>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile" style="color: white">Profile</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3" style="color: white">${name}</div>
        <@l.logout />
    </div>
</nav>