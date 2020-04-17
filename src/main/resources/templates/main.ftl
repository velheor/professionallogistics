<#import "parts/common.ftl" as c>

<@c.page>
    <div>
        <div class="form-row">
            <div class="form-group row">
                <form method="get" action="/main">
                    <div class="form-group row">
                        <div class="col-md-12">
                            <input type="text" name="cityFrom" class="form-control" value="${cityFrom!}"
                                   placeholder="Search by cityFrom">
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-md-12">
                            <input type="text" name="cityTo" class="form-control" value="${cityTo!}"
                                   placeholder="Search by cityTo">
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-md-12">
                            <input type="text" name="weight" class="form-control" value="${weight!}"
                                   placeholder="Search by weightн">
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-md-12">
                            <input type="text" name="price" class="form-control" value="${price!}"
                                   placeholder="Search by price">
                        </div>
                    </div>

                    <button type="submit" class="btn btn-primary ml-2">Search</button>
                </form>
            </div>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Add new Trip
    </a>

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
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form>
        </div>
    </div>

    <div class="card-columns">
        <#list trips as trip>
            <div class="card my-3">
                <div class="m-2">
                    <span>${"City from: " + trip.cityFrom}</span>
                    <span>${"City to: " + trip.cityTo}</span>
                    <span>${"Price: " + trip.price}</span>
                    <span>${"Weight: " + trip.weight}</span>
                </div>
                <div class="card-footer text-muted">
                    ${trip.customer.username}
                </div>
            </div>
        <#else>
            No trip
        </#list>
    </div>
</@c.page>