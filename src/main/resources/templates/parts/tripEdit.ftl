<#include "security.ftl">

<#if isCustomer>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Trip editor
    </a>
</#if>

<div class="collapse <#if trip??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                       value="<#if trip??>${trip.cityFrom}</#if>" name="cityFrom" placeholder="City from"/>
                <#if textError??>
                    <div class="invalid-feedback">
                        ${cityFromError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if trip??>${trip.cityTo}</#if>" name="cityTo" placeholder="City to"/>
                <#if tagError??>
                    <div class="invalid-feedback">
                        ${cityToError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if trip??>${trip.price}</#if>" name="price" placeholder="Price"/>
                <#if tagError??>
                    <div class="invalid-feedback">
                        ${priceError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if trip??>${trip.weight}</#if>" name="weight" placeholder="Weight"/>
                <#if tagError??>
                    <div class="invalid-feedback">
                        ${weightError}
                    </div>
                </#if>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="hidden" name="id" value="<#if trip??>${trip.id}</#if>"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Save trip</button>
            </div>
        </form>
    </div>
</div>