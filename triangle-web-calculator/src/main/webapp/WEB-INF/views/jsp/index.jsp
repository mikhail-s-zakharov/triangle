<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Triangle Calculator</title>
    <!-- Material Design fonts -->
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/icon?family=Material+Icons">

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- Bootstrap Material Design -->
    <link rel="stylesheet" type="text/css" href="./static/bootstrap-material/css/bootstrap-material-design.css">
    <link rel="stylesheet" type="text/css" href="./static/bootstrap-material/css/ripples.min.css">
    <script language="javascript" type="text/javascript" src="./static/bootstrap-material/js/material.js">
    </script>
    <script language="javascript" type="text/javascript" src="./static/bootstrap-material/js/ripples.js">
    </script>
    <!-- init -->
    <script language="javascript" type="text/javascript">
        $(document).ready(function(){
            $.material.init();
        });
    </script>
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            Triangle calculation
        </div>
        <div class="row">
          <form method="POST" action="./" id="formCalc">
            <div class="label-floating">
                <label for="sideA" class="control-label">Side A</label>
                <input id="sideA" name="sideA" class="form-control" type="number" step="any" min="0" value="${triangle.getA()}">
            </div>
            <div class="label-floating">
                <label for="sideB" class="control-label">Side B</label>
                <input id="sideB" name="sideB" class="form-control" type="number" step="any" min="0" value="${triangle.getB()}">
            </div>
            <div class="label-floating">
                <label for="sideC" class="control-label">Side C</label>
                <input id="sideC" name="sideC" class="form-control" type="number" step="any" min="0" value="${triangle.getC()}">
            </div>
            <div class="label-static">
                <label for="triangleKind" class="control-label">Triangle kind</label>
                <span id="triangleKind" class="form-control">${triangle.getTriangleKind()}</span>
            </div>
            <div class="label-static">
                <label for="perimeter" class="control-label">Perimeter</label>
                <span id="perimeter" class="form-control">${triangle.getPerimeter()}</span>
            </div>
            <div class="label-static">
                <label for="angleAlpha" class="control-label">&alpha;</label>
                <span id="angleAlpha" class="form-control">${triangle.getAlpha()}</span>
            </div>
            <div class="label-static">
                <label for="angleBeta" class="control-label">&beta;</label>
                <span id="angleBeta" class="form-control">${triangle.getBeta()}</span>
            </div>
            <div class="label-static">
                <label for="angleGamma" class="control-label">&gamma;</label>
                <span id="angleGamma" class="form-control">${triangle.getGamma()}</span>
            </div>
            <div class="text-center">
                <button class="btn btn-raised btn-primary" id="buttonCalc" type="submit">Calculate</button>
            </div>
           </form>
        </div>
    </div>
</body>
</html>