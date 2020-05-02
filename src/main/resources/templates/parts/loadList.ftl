<#include "security.ftl">

<div class="card-rows">
    <#list loads as load>
        <div class="card my-3">
            <div class="m-2">
                <a href="/special-loads/${load.id}">
                    <span>${"City from: " + load.cityFrom}</span>
                    <span>${"City to: " + load.cityTo}</span>
                    <span>${"Weight: " + load.weight}</span>
                    <span>${"Price: " + load.price}</span>
                </a>
            </div>
            <div class="card-footer text-muted">
                <a href="/user-loads/${load.customer.id}">${load.customer.username}</a>
                <#if load.customer.id == сurrentUserId>
                    <a class="btn btn-primary" href="/user-loads/${load.customer.id}?load=${load.id}">
                        Edit
                    </a>
                </#if>
            </div>
        </div>
    <#else>
        No loads
    </#list>
</div>