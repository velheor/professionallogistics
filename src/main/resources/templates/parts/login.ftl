<#macro login path isRegisterForm>
    <div class="row" style="margin-top: 40px">
        <div class="col-md-4" style="margin: auto">

            <div class="col-md-6">
                <h5><#if isRegisterForm>Create account<#else>Sign-In</#if></h5>
            </div>
            <form action="${path}" method="post">
                <div class="form-group" style="margin-top: -10px">
                    <label class="col-md-4 col-form-label">Your name</label>
                    <div class="col-md-12" style="margin-top: -7px">
                        <input type="text" name="username" value="<#if user??>${user.username}</#if>"
                               class="form-control ${(usernameError??)?string('is-invalid', '')}"
                        />
                        <#if usernameError??>
                            <div class="invalid-feedback">
                                ${usernameError}
                            </div>
                        </#if>
                    </div>
                </div>
                <div class="form-group" style="margin-top: -10px">
                    <label class="col-md-2 col-form-label">Password:</label>
                    <div class="col-md-12" style="margin-top: -7px">
                        <input type="password" name="password"
                               class="form-control ${(passwordError??)?string('is-invalid', '')}"
                        />
                        <#if passwordError??>
                            <div class="invalid-feedback">
                                ${passwordError}
                            </div>
                        </#if>
                    </div>
                </div>
                <#if isRegisterForm>
                    <div class="form-group" style="margin-top: -10px">
                        <label class="col-md-2 col-form-label">Password:</label>
                        <div class="col-md-12" style="margin-top: -7px">
                            <input type="password" name="password2"
                                   class="form-control ${(password2Error??)?string('is-invalid', '')}"
                            />
                            <#if password2Error??>
                                <div class="invalid-feedback">
                                    ${password2Error}
                                </div>
                            </#if>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: -10px">
                        <label class="col-md-2 col-form-label">Email:</label>
                        <div class="col-md-12" style="margin-top: -7px">
                            <input type="email" name="email" value="<#if user??>${user.email}</#if>"
                                   class="form-control ${(emailError??)?string('is-invalid', '')}"
                                   placeholder="some@some.com"/>
                            <#if emailError??>
                                <div class="invalid-feedback">
                                    ${emailError}
                                </div>
                            </#if>
                        </div>
                    </div>
                    <div class="form-check">
                        <div class="col-md-12">
                            <input class="form-check-input" type="radio" name="role" id="driverRoleRadio"
                                   value="DRIVER" checked >
                            <label class="form-check-label" for="driverRoleRadio">
                                <h5>Driver</h5>
                                You own your vehicle and have authority to book your own loads for you or your fleet.
                            </label>
                        </div>
                    </div>
                    <div class="form-check">
                        <div class="col-md-12" style="margin-top: 10px">
                            <input class="form-check-input" type="radio" name="role" id="shipperRoleRadio"
                                   value="CUSTOMER">
                            <label class="form-check-label" for="driverRoleRadio">
                                <h5>Shipper</h5>
                                You want to move loads with Raccoon Truck
                            </label>
                        </div>

                    </div>
                </#if>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="form-group">
                    <div class="col-md-12">
                        <button class="btn btn-primary btn-block"
                                type="submit"
                                style="margin-bottom: 10px"><#if isRegisterForm>Create<#else>Sign In</#if></button>
                        <#if !isRegisterForm><a href="/registration" class="btn btn-primary active btn-block"
                                                role="button"
                                                aria-pressed="true">Create your RaccoonTruck account</a></#if>
                    </div>
                </div>
            </form>
        </div>
    </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Sign Out</button>
    </form>
</#macro>