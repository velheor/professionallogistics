<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
    <h3 style="text-align: center; margin-top: 70px;">My Loads</h3>
    <div class="row">
        <div class="col-md-12">
            <div class="col-md-6" style="margin: auto">
                <div style="text-align: center">
                    <a href="/user-loads/booked/${user.id}"
                       style="color: black">
                        <#if isDriver>
                            Booked
                        <#else>
                            Active
                        </#if>
                    </a>

                    <a href="/user-loads/past/${user.id}"
                       style="color: black">
                        Past
                    </a>
                </div>

                <a class="btn btn-primary btn-sm  btn-block" data-toggle="collapse" href="#collapseExample"
                   role="button"
                   aria-expanded="false"
                   aria-controls="collapseExample" style="font-size: 20px;">
                    <#if isDriver>Attach check<#else>Trip editor</#if>
                </a>

                <div class="collapse <#if load??>show</#if>" id="collapseExample">
                    <#include "parts/loadEdit.ftl">
                </div>

                <#if isCustomer>
                    <a class="btn btn-primary btn-sm btn-block" href="/create"
                       style="font-size: 20px; margin: 10px auto auto;">
                        Publish new load
                    </a>
                </#if>

                <#include "parts/loadList.ftl" />
            </div>
        </div>
    </div>
</@c.page>