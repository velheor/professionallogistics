<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter!}" placeholder="Search by value">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new Trip
    </a>
    <div class="collapse <#if trip??>show</#if>" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if trip??>${trip.cityFrom}</#if>" name="cityFrom" placeholder="Город отправки"/>
                    <#if textError??>
                        <div class="invalid-feedback">
                            ${cityFromError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"
                           value="<#if trip??>${trip.cityTo}</#if>" name="cityTo" placeholder="Город прибытия"/>
                    <#if tagError??>
                        <div class="invalid-feedback">
                            ${cityToError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"
                           value="<#if trip??>${trip.price}</#if>" name="price" placeholder="Цена"/>
                    <#if tagError??>
                        <div class="invalid-feedback">
                            ${priceError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"
                           value="<#if trip??>${trip.weight}</#if>" name="weight" placeholder="Вес товара"/>
                    <#if tagError??>
                        <div class="invalid-feedback">
                            ${weightError}
                        </div>
                    </#if>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>

    <div class="card-columns">
        <#list trips as trip>
            <div class="card my-3">
                <#if trip.filename??>
                    <img src="/img/${trip.filename}" class="card-img-top">
                </#if>
                <div class="m-2">
                    <span>${trip.text}</span>
                    <i>${trip.tag}</i>
                </div>
                <div class="card-footer text-muted">
                    ${trip.authorName}
                </div>
            </div>
        <#else>
            No trip
        </#list>
    </div>
</@c.page>