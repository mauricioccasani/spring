$(function(){
	$("#idProveedor").submit(function(e) {
		e.preventDefault();
		alert("ddd");
		var frm = $("#idProveedor");
		var data = {};
		$.each(this, function(i, v){
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
		});
		saveRequestedData(frm, data, "user");
	});
	
})