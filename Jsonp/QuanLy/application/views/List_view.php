<!DOCTYPE html>
<html lang="en">

<head>
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
		  <h3 class="display-3">Danh sach Hoc sinh</h3>
		</div>

		<table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Ten</th>
		      <th scope="col">Tuoi</th>
		      <th scope="col">Email</th>
		      <th style="width: 110px" scope="col">Hanh dong</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<?php foreach ($list as $key => $value) { ?>
			  	<tr class="student-<?php echo $value['id'] ?>">
			      <th scope="row"><?php echo $key + 1 ?></th>
			      <td><?php echo $value['name'] ?></td>
			      <td><?php echo $value['age'] ?></td>
			      <td><?php echo $value['email'] ?></td>
			      <td>
			      	<a href="<?php echo base_url() ?>HocSinh/Edit/<?php echo $value['id'] ?>" class="btn btn-warning btn-sm"><i class="fa fa-pencil"></i></a>
			      	<button data-iddel="<?php echo $value['id'] ?>" class="btn btn-danger btn-sm" id="btnDel"><i class="fa fa-times"></i></button>
			      </td>
			    </tr>	
		  	<?php } ?>
		  </tbody>
		</table>
		<div id="result"></div>
		</div>
		<script type="text/javascript" src="<?php echo base_url() ?>vendor/bootstrap.js"></script>
	    <script type="text/javascript" src="<?php echo base_url() ?>vendor/main.js"></script>
</body>
	
</html>
<script type="text/javascript">
	$(document).ready(function(){
	    $("button#btnDel").on('click', function() {
	    	var result = confirm("Want to delete?");
	    	if(result) {
		    	$.ajax({
		    		url: 'http://localhost:8080/delete/',
		    		type: 'POST',
		    		dataType: 'jsonp',
		    		data: {id: $(this).data('iddel')},
		    		success: function(data) {
		    			$('#result').html("Ban da xoa hoc sinh co ID: " + data);
		    			$('tr.student-'+data).fadeOut();
		    		}
		    	})	
	    	}
	    		    	
	    })
	});

</script>
















