<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div class="form-group">
    </div>
    ${message?ifExists}
    <@l.login "/registration" true />
</@c.page>
