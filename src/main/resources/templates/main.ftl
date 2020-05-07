<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
    <div>
        <div class="form-row" style="margin-top: 70px">
            <#include "parts/loadList.ftl"/>
            <div class="form-group row " style="margin-left: 100px">
                <form method="get" action="/main">
                    <div class="form-group row ">
                        <div class="col-md-12">
                            <div class="col text-center">
                                <p style="font-size: 25px; font-weight: bold">Sort loads by</p>
                            </div>
                            <input type="text" name="cityFrom" class="form-control form-control-lg"
                                   value="${cityFrom!}"
                                   placeholder="Search by cityFrom" style="text-align: center">
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-md-12">
                            <input type="text" name="cityTo" class="form-control  form-control-lg"
                                   value="${cityTo!}"
                                   placeholder="Search by cityTo" style="text-align: center">
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-md-12">
                            <input type="text" name="weight" class="form-control  form-control-lg"
                                   value="${weight!}"
                                   placeholder="Search by weight" style="text-align: center">
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-md-12">
                            <input type="text" name="price" class="form-control  form-control-lg" value="${price!}"
                                   placeholder="Search by price" style="text-align: center">
                        </div>
                    </div>
                    <div class="col-md-8">
                        <button type="submit" class="btn btn-primary btn-lg btn-block" style="margin-left: 40px">
                            Search
                        </button>
                    </div>

                </form>

            </div>
        </div>
    </div>


</@c.page>