<#include "security.ftl">

<div class="card-rows">
    <#list loads as load>
        <div class="col-md-9" style="margin-top: 10px; margin-left: 215px">

            <div class="card border-dark mb-3">

                <div class="m-2">

                    <a href="/special-loads/${load.id}" style="color: black">
                        <span style="margin-right: 18px;">${"From: " + load.cityFrom}</span>
                        <span style="margin-right: 18px">${"To: " + load.cityTo}</span>
                        <span style="margin-right: 18px">${"Weight: " + load.weight}</span>
                        <span>${"Price: " + load.price}</span>
                    </a>

                </div>
                <div class="border-top border-dark">
                    <div class="card-footer text-muted">
                        <p>Shipper:
                            <a href="/user-loads/${load.customer.id}"
                               style="color: black">${load.customer.username}</a>

                            <#if load.customer.id == сurrentUserId>
                                <a class="btn btn-primary" href="/user-loads/${load.customer.id}?load=${load.id}"
                                   style="margin-left: 315px">
                                    Edit
                                </a>
                            </#if>
                        </p>
                    </div>
                </div>
            </div>
        </div>

    <#else>
        No loads
    </#list>
</div>

