<!DOCTYPE html>
<html lang="en">

<head>
	<?php header('Access-Control-Allow-Origin: *'); ?>
	<?php header('Access-Control-Allow-Credentials: true'); ?>
    <title> Example </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href="<?php echo base_url() ?>vendor/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<?php echo base_url() ?>vendor/style.css">
</head>

<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="<?php echo base_url() ?>HocSinh/">Home</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="<?php echo base_url() ?>HocSinh/">Danh sach</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="<?php echo base_url() ?>HocSinh/ThemMoi">Them moi</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="<?php echo base_url() ?>HocSinh/ThemMoi2">Them moi 2</a>
		      </li>
		    </ul>
		  </div>
		</nav>

		<div class="jumbotron">
		  <h3 class="display-3">Them Hoc Sinh</h3>
		</div>
		<div class="alert alert-success noti" style="display: none">
		  <strong>Thanh cong!</strong> them moi hoc sinh thanh cong.
		</div>
		<!-- <form action="<?php echo base_url() ?>HocSinh/doAdd" method="POST"> -->
			<div class="form-group row">
			  <label for="studentName" class="col-1 col-form-label">Ten</label>
			  <div class="col-10">
			    <input class="form-control" type="text" id="studentName" name="studentName" placeholder="Nhap Ten">
			  </div>
			</div>
			<div class="form-group row">
			  <label for="studentAge" class="col-1 col-form-label">Tuoi</label>
			  <div class="col-10">
			    <input class="form-control" type="search" id="studentAge" name="studentAge" placeholder="Nhap tuoi">
			  </div>
			</div>
			<div class="form-group row">
			  <label for="studentEmail" class="col-1 col-form-label">Email</label>
			  <div class="col-10">
			    <input class="form-control" type="search" id="studentEmail" name="studentEmail" placeholder="Nhap email">
			  </div>
			</div>
			<div class="button text-center">
				<button class="btn btn-outline-primary mb-2 addStudent" type="submit">Them Hoc Sinh</button>
			</div>
		<!-- </form> -->

		</div>
		<script type="text/javascript" src="<?php echo base_url() ?>vendor/bootstrap.js"></script>
	    <script type="text/javascript" src="<?php echo base_url() ?>vendor/main.js"></script>
	    <script>
	    	$('.addStudent').click(function() {

				$.ajax({
		    		url: 'http://localhost/QuanLy/HocSinh/doAdd',
		    		type: 'POST',
		    		dataType: 'json',
		    		data: {
		    			studentName: $('#studentName').val(),
		    			studentAge: $('#studentAge').val(),
		    			studentEmail: $('#studentEmail').val()
		    		},
		    	})
		    	.always(function(res) {
		    		$('.noti').css("display", "block");
		    		$('#studentName').val('');
		    		$('#studentAge').val('');
		    		$('#studentEmail').val('');
		    		setTimeout(function() {
					    $('.noti').fadeOut('fast');
					}, 3000); // <-- time in milliseconds
					console.log(res);
		    	});
	    	})
	    	
	    	
	    	
	    </script>
</body>
	
</html>
