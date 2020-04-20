<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
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
                                   placeholder="Search by weight">
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


    <#include "parts/tripEdit.ftl"/>

    <#include "parts/tripList.ftl"/>

</@c.page>