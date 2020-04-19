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
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    isDriver = false
    isCustomer = false
    >
</#if>