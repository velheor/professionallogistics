<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
    <div>
        <h3 style="text-align: center; margin-top: 70px; margin-left: 20px ">My Loads</h3>
        <div class="col-md-12">
            <div class="col-md-5">
                <#if isCurrentUser>
                    <a class="btn btn-primary btn-sm  btn-block" data-toggle="collapse" href="#collapseExample"
                       role="button"
                       aria-expanded="false"
                       aria-controls="collapseExample" style="font-size: 20px;margin-left: 382px;">
                        <#if isDriver>Attach check<#else>Trip editor</#if>
                    </a>
                </#if>
            </div>
            <div class="col-md-6">
                <div class="collapse <#if load??>show</#if>" id="collapseExample">
                    <#include "parts/loadEdit.ftl">
                </div>
            </div>
            <#if isCustomer>
                <div class="col-md-5">
                    <a class="btn btn-primary btn-sm btn-block" href="/create"
                       style="font-size: 20px; margin-left: 382px ; margin-top: 10px">
                        Publish new load
                    </a>
                </div>
            </#if>
            <div class="col-md-7" style="margin-left: 150px">
                <#include "parts/loadList.ftl" />
            </div>

        </div>
    </div>
</@c.page>