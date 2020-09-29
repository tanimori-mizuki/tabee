$(function(){
	
	// 日付チェックボックスをチェックしたら発動
	$('input[name="date"]').change(function(){
		
		// チェックの状態を取得
		var date = $('#date').prop('checked');
		
		// もしチェック状態だったら
		if(date){
			// カレンダーを出力
			$('#departure').show();
		} else {
			$('#departure').hide();
		}
	});
	
	// 開始時刻
	$('input[name="checkTime"]').change(function(){
		
		// チェックの状態を取得
		var startTime = $('#checkTime').prop('checked');
		
		// もしチェック状態だったら
		if(startTime){
			// 開始時刻を出力
			$('#startTime').show();
		} else {
			$('#startTime').hide();
		}
	});
	
	// 終了時刻
	$('input[name="finish"]').change(function(){
		
		// チェックの状態を取得
		var finishTime = $('#finish').prop('checked');
		
		// もしチェック状態だったら
		if(finishTime){
			// 開始時刻を出力
			$('#finishTime').show();
		} else {
			$('#finishTime').hide();
		}
	});

});