<#import "parts/common.ftl" as c>

<@c.page>
    <#if isCurrentUserId>
        <#include "parts/tripEdit.ftl">
    </#if>

    <#include "parts/tripList.ftl" />
</@c.page>