<div class="form-group mt-3">
    <form method="post" enctype="multipart/form-data">
        <div class="form-group">
            <input type="text" class="form-control"
                   value="<#if load??>${load.cityFrom}</#if>" name="cityFrom" placeholder="City from"/>
            <#if textError??>
                <div class="invalid-feedback">
                    ${cityFromError}
                `</div>
            </#if>
        </div>
        <div class="form-group">
            <input type="text" class="form-control"
                   value="<#if load??>${load.cityTo}</#if>" name="cityTo" placeholder="City to"/>
            <#if tagError??>
                <div class="invalid-feedback">
                    ${cityToError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="text" class="form-control"
                   value="<#if load??>${load.price}</#if>" name="price" placeholder="Price"/>
            <#if tagError??>
                <div class="invalid-feedback">
                    ${priceError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="text" class="form-control"
                   value="<#if load??>${load.weight}</#if>" name="weight" placeholder="Weight"/>
            <#if tagError??>
                <div class="invalid-feedback">
                    ${weightError}
                </div>
            </#if>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="id" value="<#if load??>${load.id}</#if>"/>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Save load</button>
        </div>
    </form>
</div>