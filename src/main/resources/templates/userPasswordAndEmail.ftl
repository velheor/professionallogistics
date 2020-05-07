<#import "parts/common.ftl" as c>

<@c.page>
    <div class="mx-auto" style="width: 400px; margin-top: 100px">
        <div class="col-md-6">
            <h3>${username}</h3>
            ${message!}
        </div>
        <form method="post">

            <div class="form-group" style="font-weight: bold; font-size: smaller">
                <label class="col-md-2 col-form-label">Email:</label>
                <div class="col-lg-12" style="font-size: medium">
                    <input type="email" name="email" class="form-control-lg" placeholder="some@some.com"
                           value="${email!''}" style="width: 300px"/>
                </div>
            </div>
            <div class="form-group" style="font-weight: bold; font-size: smaller">
                <label class="col-md-2 col-form-label">Password:</label>
                <div class="col-md-12">
                    <input type="password" name="password" class="form-control-lg" placeholder="Password"
                           style="width: 300px"/>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-primary btn-lg" type="submit" style="margin-left: 15px">Save</button>
        </form>
    </div>
</@c.page>