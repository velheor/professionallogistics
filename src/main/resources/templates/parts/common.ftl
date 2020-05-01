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