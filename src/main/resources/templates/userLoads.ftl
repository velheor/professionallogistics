<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
    <h3 style="text-align: center; margin-top: 70px;">My Loads</h3>
    <div class="row">
        <div class="col-md-12">
            <div class="col-md-6" style="margin: auto">
                <div style="text-align: center">
                    <a href="/user-loads/booked/"
                       style="color: black">
                        <#if isDriver>
                            Booked
                        <#else>
                            Active
                        </#if>
                    </a>

                    <a href="/user-loads/past/"
                       style="color: black">
                        Past
                    </a>
                </div>
                <#if isCurrentUser>
                    <a class="btn btn-primary btn-sm  btn-block" data-toggle="collapse" href="#collapseExample"
                       role="button"
                       aria-expanded="false"
                       aria-controls="collapseExample" style="font-size: 20px;">
                        <#if isDriver>Attach check<#else>Trip editor</#if>
                    </a>
                </#if>
                <#if isCustomer>
                    <div class="collapse <#if load??>show</#if>" id="collapseExample">
                        <#include "parts/loadEdit.ftl">
                    </div>
                </#if>
                <#if isDriver>
                    <div class="collapse <#if load??>show</#if>" id="collapseExample">
                        <div class="form-group" style="margin-top: 10px">
                            <div class="custom-file">
                                <input type="file" name="file" id="customFile">
                                <label class="custom-file-label" for="customFile">Choose file</label>
                            </div>
                        </div>
                    </div>
                </#if>
                <#if isCustomer>
                    <a class="btn btn-primary btn-sm btn-block" href="/create"
                       style="font-size: 20px; margin: auto; margin-top: 10px">
                        Publish new load
                    </a>
                </#if>
                <#include "parts/loadList.ftl" />
            </div>
        </div>
    </div>
</@c.page>