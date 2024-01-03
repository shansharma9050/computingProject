
 function openAddfieldSet(){
	
	$("#addFieldSet").show();
	$("#editFieldSet").hide();
}
function openEditfieldSet(){
	
	$("#addFieldSet").hide();
	$("#editFieldSet").show();
}

 function openAdd(){
	$("#addFieldSet").hide();
	
} 

function editData(element){
	
/*var	apiUrlApp= ;*/
	$.ajax({
		type:"post",
        url: apiUrl+"/myHome/get-data-for-edit?id=" + element.value,
       success:function(data){
		   $.each(res,function(a,value){
			   
			   if(a=='firstName')
			   {
				   $('#editRoleId').val(value);
			   }
			    if(a=='lastName')
			   {
				   $('#editnameId').val(value);
			   }
			    if(a=='email')
			   {
				   $('#editemailId').val(value);
			   }
			    if(a=='phNumber')
			   {
				   $('#editphoneNumberId').val(value);
			   }
			    if(a=='dob1')
			   {
				   $('#editdobId').val(value);
			   }
			    
			   
		   });
		   
	   }
	});
}
