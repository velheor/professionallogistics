<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.isAdmin()
    isDriver = user.isDriver()
    isCustomer = user.isCustomer()
    isCurrentUserId = user.getId()
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    isDriver = false
    isCustomer = false
    isCurrentUserId = -1
    >
</#if>