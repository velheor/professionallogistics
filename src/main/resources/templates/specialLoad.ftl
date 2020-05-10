<#import "parts/common.ftl" as c>

<@c.page>
    <div class="col-md-7" style="margin-top: 150px; margin-left: 140px" xmlns="http://www.w3.org/1999/html">
        <form method="post">
            <#include "parts/loadList.ftl" />

            <#if isDriver>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-lg"
                            style="margin-left: 230px; margin-top:-10px">
                        Book
                    </button>
                </div>
            </#if>
            <#if isCustomer>
                <button type="submit">
                    <a class="btn btn-primary btn-lg"
                       href="/user-loads/${сurrentUserId}"
                       style="margin-left: 230px; margin-top:-10px">
                        Check as done
                    </a>
                </button>
            </#if>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </form>
    </div>

</@c.page>
