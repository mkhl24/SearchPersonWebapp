 $(function(){
	$('#searchPerson').on('submit', function(){
		$.ajax({
			url: 'update',
			type: 'POST',
			dataType: 'json',
			data: $('#searchPerson').serialize(),
			success: function(data){
				
				if (data.isValid) {
				const tableBody = document.getElementById('tableData');
				let dataHtml = '';
				for ( let persondata of data.persons) {
					dataHtml += `<tr><td>${persondata.name}</td><td>${persondata.patronymic}</td><td>${persondata.surname}</td><td>${persondata.city}</td><td>${persondata.car}</td></tr>`;
				}
					tableBody.innerHTML = dataHtml;
				} else {
					alert("Введите данные для поиска");
				}
			}
		});
		
		return false;
	});
});