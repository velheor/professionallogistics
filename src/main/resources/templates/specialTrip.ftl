<#import "parts/common.ftl" as c>

<@c.page>
    <form method="post">
        <#include "parts/tripList.ftl" />
        <#if isDriver>
            <div class="form-group">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary">Book</button>
            </div>
        </#if>
    </form>
</@c.page>
