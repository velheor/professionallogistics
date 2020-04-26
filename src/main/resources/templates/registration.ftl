<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    ${trip?ifExists}
    <@l.login "/registration" true />
</@c.page>
