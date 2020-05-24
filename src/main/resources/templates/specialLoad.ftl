<#import "parts/common.ftl" as c>

<@c.page>
    <div class="col-md-6" style="margin-top: 150px;">
        <form method="post">
            <#include "parts/loadList.ftl" />

            <button type="submit">
                <a class="btn btn-primary btn-lg"
                >
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

</@c.page>
