<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <h5>Create account</h5>
    ${message?ifExists}
    <@l.login "/registration" true />
</@c.page>
