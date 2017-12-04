<html ng-app="av3">
<title>
    Goiaba Serrana
</title>
<head>

        <meta name="description" content="">
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <link rel="stylesheet" href="static/app/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="static/app/assets/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="static/app/assets/css/fontAwesome.css">
        <link rel="stylesheet" href="static/app/assets/css/hero-slider.css">
        <link rel="stylesheet" href="static/app/assets/css/tooplate-style.css">

        <script src="static/app/assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>

</head>

<body ng-controller="MainController">

    <div ui-view id="wrapper"></div>



        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>
            window.jQuery || document.write('<script src="static/app/assets/js/vendor/jquery-1.11.2.min.js"><\/script>')
        </script>

        <script src="static/app/assets/js/vendor/bootstrap.min.js"></script>

        <script src="static/app/assets/js/plugins.js"></script>
        <script src="static/app/assets/js/main.js"></script>


</body>

<script src="static/node_modules/angular/angular.js"></script>
<script src="static/bower_components/angular-bootstrap/ui-bootstrap.js"></script>
<script src="static/bower_components/angular-ui-router/release/angular-ui-router.js"></script>

<script src="static/app/script/app.js"></script>
<script src="static/app/script/config/router.js"></script>

<script src="static/app/script/service/pedidoService.js"></script>
<script src="static/app/script/controller/MainController.js"></script>
<script src="static/app/script/controller/CadastroController.js"></script>

</html>