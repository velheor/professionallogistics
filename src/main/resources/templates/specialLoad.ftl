<#import "parts/common.ftl" as c>

<@c.page>

    <div class="col-md-7" style="margin-top: 150px; margin-left: 140px">
        <form method="post">
            <#include "parts/loadList.ftl" />
            <#if isDriver>
                <div class="form-group">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary btn-lg" style="margin-left: 230px; margin-top:-10px">
                        Book
                    </button>
                </div>
            </#if>
        </form>
    </div>

</@c.page>
