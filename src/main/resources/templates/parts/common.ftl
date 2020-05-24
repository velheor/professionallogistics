<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>RaccoonTruck</title>
        <link rel="stylesheet" href="/static/style.css">

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
              integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
              crossorigin="anonymous">
        <style>
            .bootstrap-iso .form-control:focus {
                border-color: #f89b2e;
                box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(248, 155, 46, 0.6);
            }

            .asteriskField {
                color: #ff0000;
            }

            .bootstrap-iso form .input-group-addon {
                color: #cbc417;
                background-color: #8e2424;
                border-radius: 4px;
                padding-left: 12px
            }

            .btn-primary,
            .btn-primary:hover,
            .btn-primary:active,
            .btn-primary:visited,
            .btn-primary:focus {
                background-color: #f89b2e;
                border-color: #f89b2e;
            }
            .btn-grd-danger,
            .btn-grd-disabled,
            .btn-grd-info,
            .btn-grd-inverse,
            .btn-grd-primary,
            .btn-grd-success,
            .btn-grd-warning,
            .btn-grd-warning {
                background-size: 200% auto;
                -webkit-transition: 0.5s ease-in-out;
                transition: 0.5s ease-in-out;
                color: #fff;
            }
            .btn-grd-danger:hover,
            .btn-grd-disabled:hover,
            .btn-grd-info:hover,
            .btn-grd-inverse:hover,
            .btn-grd-primary:hover,
            .btn-grd-success:hover,
            .btn-grd-warning:hover,
            .btn-grd-warning:hover {
                background-position: right center;
            }
            .btn-grd-danger.hor-grd,
            .btn-grd-disabled.hor-grd,
            .btn-grd-info.hor-grd,
            .btn-grd-inverse.hor-grd,
            .btn-grd-primary.hor-grd,
            .btn-grd-success.hor-grd,
            .btn-grd-warning.hor-grd,
            .btn-grd-warning.hor-grd {
                background-size: auto 200%;
            }
            .btn-grd-danger.hor-grd:hover,
            .btn-grd-disabled.hor-grd:hover,
            .btn-grd-info.hor-grd:hover,
            .btn-grd-inverse.hor-grd:hover,
            .btn-grd-primary.hor-grd:hover,
            .btn-grd-success.hor-grd:hover,
            .btn-grd-warning.hor-grd:hover,
            .btn-grd-warning.hor-grd:hover {
                background-position: bottom center;
            }

            .btn-grd-primary {
                background-image: -webkit-gradient(linear, left top, right top, from(#77aaff), color-stop(51%, #0764ff), to(#77aaff));
                background-image: linear-gradient(to right, #77aaff 0%, #0764ff 51%, #77aaff 100%);
            }
            .btn-grd-primary.hor-grd {
                background-image: -webkit-gradient(linear, left bottom, left top, from(#77aaff), color-stop(51%, #0764ff), to(#77aaff));
                background-image: linear-gradient(to top, #77aaff 0%, #0764ff 51%, #77aaff 100%);
            }

            .btn-grd-warning {
                background-image: -webkit-gradient(linear, left top, right top, from(#f89b2e), color-stop(51%,#C36D09), to(#f89b2e));
                background-image: linear-gradient(to right,#f89b2e 0%, #C36D09 51%, #f89b2e 100%);
            }
            .btn-grd-warning.hor-grd {
                background-image: -webkit-gradient(linear, left bottom, left top, from(#ffe733), color-stop(51%, #c2ab00), to(#ffe733));
                background-image: linear-gradient(to top, #ffe733 0%, #c2ab00 51%, #ffe733 100%);
            }

            .btn-grd-danger {
                background-image: -webkit-gradient(linear, left top, right top, from(#dae0e5), color-stop(51%, #B3B8BD), to(#dae0e5));
                background-image: linear-gradient(to right, #dae0e5 0%, #B3B8BD 51%, #dae0e5 100%);
            }
            .btn-grd-danger.hor-grd {
                background-image: -webkit-gradient(linear, left bottom, left top, from(#ff8585), color-stop(51%, #ff1515), to(#ff8585));
                background-image: linear-gradient(to top, #ff8585 0%, #ff1515 51%, #ff8585 100%);
            }

            .btn-grd-success {
                background-image: -webkit-gradient(linear, left top, right top, from(#1aeb72), color-stop(51%, #0c8940), to(#1aeb72));
                background-image: linear-gradient(to right, #1aeb72 0%, #0c8940 51%, #1aeb72 100%);
            }
            .btn-grd-success.hor-grd {
                background-image: -webkit-gradient(linear, left bottom, left top, from(#1aeb72), color-stop(51%, #0c8940), to(#1aeb72));
                background-image: linear-gradient(to top, #1aeb72 0%, #0c8940 51%, #1aeb72 100%);
            }

            .btn-grd-inverse {
                background-image: -webkit-gradient(linear, left top, right top, from(#4c626d), color-stop(51%, #1e272b), to(#4c626d));
                background-image: linear-gradient(to right, #4c626d 0%, #1e272b 51%, #4c626d 100%);
            }
            .btn-grd-inverse.hor-grd {
                background-image: -webkit-gradient(linear, left bottom, left top, from(#4c626d), color-stop(51%, #1e272b), to(#4c626d));
                background-image: linear-gradient(to top, #4c626d 0%, #1e272b 51%, #4c626d 100%);
            }

            .btn-grd-info {
                background-image: -webkit-gradient(linear, left top, right top, from(#08e3ff), color-stop(51%, #008697), to(#08e3ff));
                background-image: linear-gradient(to right, #08e3ff 0%, #008697 51%, #08e3ff 100%);
            }
            .btn-grd-info.hor-grd {
                background-image: -webkit-gradient(linear, left bottom, left top, from(#08e3ff), color-stop(51%, #008697), to(#08e3ff));
                background-image: linear-gradient(to top, #08e3ff 0%, #008697 51%, #08e3ff 100%);
            }

            .btn-grd-disabled {
                background-image: -webkit-gradient(linear, left top, right top, from(#77aaff), color-stop(51%, #0764ff), to(#77aaff));
                background-image: linear-gradient(to right, #77aaff 0%, #0764ff 51%, #77aaff 100%);
            }
            .btn-grd-disabled.hor-grd {
                background-image: -webkit-gradient(linear, left bottom, left top, from(#77aaff), color-stop(51%, #0764ff), to(#77aaff));
                background-image: linear-gradient(to top, #77aaff 0%, #0764ff 51%, #77aaff 100%);
            }
        </style>
    </head>
    <body>
    <#include "navbar.ftl">
    <div class="bootstrap-iso">
        <div class="container-fluid">
            <#nested>
        </div>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
            integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
            crossorigin="anonymous"></script>
    </body>
    </html>
</#macro>