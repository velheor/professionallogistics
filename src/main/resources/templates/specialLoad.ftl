<#import "parts/common.ftl" as c>

<@c.page>
    <div style="margin-top: 150px;">
        <div class="col-md-6" style="margin: auto">
            <form method="post">
                <#include "parts/loadList.ftl" />

                <button type="submit" style="background-color: #f89b2e; margin-top: 7px">
                    <a class="btn btn-primary btn-lg" style="color: white">
                        <#if isCustomer>
                            Check as done
                        </#if>

                        <#if isDriver>
                            Book
                        </#if>
                    </a>
                </button>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>
        </div>
    </div>
</@c.page>
