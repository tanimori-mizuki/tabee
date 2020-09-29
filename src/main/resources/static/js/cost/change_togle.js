$(function(){
	
	$('input[name="toggle"]').change(function(){
		
		var toggle = $('#toggle').prop('checked');
		
		// もしチェック状態だったら
		if(toggle){
			$('.input-money').show();
			$('.person-check').hide();
		} else {
			$('.input-money').hide();
			$('.person-check').show();
		}
		
	})
	
});