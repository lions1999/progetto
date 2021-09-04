<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Register page</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
    <style>
.card{
	margin: auto;
  	width: 30%;
  	border: 3px solid green;
  	padding: 10px;
}
 	</style>
</head>

<body>
<p></p>

<div class="card">
<article class="card-body">
	<h4 class="card-title mb-4 mt-1">Sign up</h4>
	<hr>
	<form>
	<div class="form-group">
        <input name="" class="form-control" placeholder="Nome" type="nome">
    </div> <!-- form-group// -->
    <div class="form-group">
        <input name="" class="form-control" placeholder="Cognome" type="cognome">
    </div> <!-- form-group// -->
    <div class="form-group">
        <input name="" class="form-control" placeholder="Email" type="email">
    </div> <!-- form-group// -->
    <div class="form-group">
        <input class="form-control" placeholder="Password" type="password">
    </div> <!-- form-group// -->   
    <div>
    <p>Witch role you cover in the condominium?</p>
  <div class="row">
    <div class="form-check form-check-inline">
      <input name="gruppo" type="radio" id="radio1" checked>
      <label for="radio1">Administrator</label>
    </div>
    <div class="form-check form-check-inline">
      <input name="gruppo" type="radio" id="radio2"checked>
      <label for="radio2">Apartment Resident</label>
    </div>
    <div class="form-check form-check-inline">
      <input name="gruppo" type="radio" id="radio3" checked>
      <label for="radio3">Apartment owner</label>
    </div>
  </div>
</div>  
    <div class="form-group">
        <input class="form-control" placeholder="Codice Condominio" type="codiceCondominio">
    </div> <!-- form-group// -->                                     
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block"> Login  </button>
            </div> <!-- form-group// -->
        </div>
        <div class="col-md-6 text-right">
            <button type="submit" class="btn btn-primary btn-block"> Clear  </button>
        </div>                                            
    </div> <!-- .row// -->                                                                  
</form>
</article>
</div> <!-- card.// -->
</body>
</html>
