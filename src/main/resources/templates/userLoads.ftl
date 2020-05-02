<#import "parts/common.ftl" as c>

<@c.page>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button"
       aria-expanded="false"
       aria-controls="collapseExample">
        Trip editor
    </a>

    <div class="collapse <#if load??>show</#if>" id="collapseExample">
        <#include "parts/loadEdit.ftl">
    </div>
    <a class="btn btn-primary" href="/create">
        Publish new load
    </a>
    <#include "parts/loadList.ftl" />
</@c.page>