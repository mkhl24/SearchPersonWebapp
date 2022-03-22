 $(function(){
	$('#authForm').on('submit', function(){
		
		$.ajax({
			url: 'auth',
			type: 'POST',
			dataType: 'json',
			data: $('#authForm').serialize(),
			success: function(data){
				if (data.isMatch) {
					location.reload();
				} else {
					alert("Некорректное имя пользователя или пароль");
				}
			}
		});
		return false;
	});
});