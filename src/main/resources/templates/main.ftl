<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
    <div class="container">
        <div class="row" style="margin-top: 50px">
            <div class="col-md-6" style="margin-top: 10px">
                <#include "parts/loadList.ftl"/>
            </div>
            <div class="col-md-6">
                <div class="col-md-6" style="margin: auto">
                    <div class="form-group">
                        <form method="get" action="/main">
                            <p style="font-size: 25px;text-align: center; font-weight: bold">Sort loads by</p>

                            <div style="margin-bottom:20px">
                                <input type="text" name="cityFrom" class="form-control form-control-lg"
                                       value="${cityFrom!}"
                                       placeholder="Search by cityFrom" style="text-align: center">
                            </div>

                            <div style="margin-bottom:20px">
                                <input type="text" name="cityTo" class="form-control  form-control-lg"
                                       value="${cityTo!}"
                                       placeholder="Search by cityTo" style="text-align: center">
                            </div>

                            <div style="margin-bottom:20px">
                                <input type="text" name="weight" class="form-control  form-control-lg"
                                       value="${weight!}"
                                       placeholder="Search by weight" style="text-align: center">
                            </div>

                            <div style="margin-bottom:20px">
                                <input type="text" name="price" class="form-control  form-control-lg"
                                       value="${price!}"
                                       placeholder="Search by price" style="text-align: center">
                            </div>

                            <button type="submit" class="btn btn-primary btn-lg btn-block" style="margin:auto">
                                Search
                            </button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</@c.page>