$(function(){
	$('#logout').on('click', function(){
		
		$.post({
			url: 'logout',
			type: 'GET',
			success: function(){
				location.reload();
			}
		});
		return false;
	});
});