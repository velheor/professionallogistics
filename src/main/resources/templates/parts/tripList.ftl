<#include "security.ftl">

<div class="card-rows">
    <#list trips as trip>
        <div class="card my-3">
            <div class="m-2">
                <span>${"City from: " + trip.cityFrom}</span>
                <span>${"City to: " + trip.cityTo}</span>
                <span>${"Weight: " + trip.weight}</span>
                <span>${"Price: " + trip.price}</span>
            </div>
            <div class="card-footer text-muted">
                <a href="/user-trips/${trip.customer.id}">${trip.customer.username}</a>
                <#if trip.customer.id == isCurrentUserId>
                    <a class="btn btn-primary" href="/user-trips/${trip.customer.id}?trip=${trip.id}">
                        Edit
                    </a>
                </#if>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">book</button>
    <#else>
        No trip
    </#list>
</div>