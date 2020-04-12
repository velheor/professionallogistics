<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div class="form-group">
        <div class="col-sm-10">
            <h5>Create account</h5>
        </div>
    </div>
    ${message?ifExists}
    <@l.login "/registration" true />
</@c.page>
