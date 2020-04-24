<#import "parts/common.ftl" as c>

<@c.page>
    <#include "parts/tripList.ftl" />
    <#if isDriver>
        <div class="btn btn-primary">
            book
        </div>
    </#if>
</@c.page>
