/**
 */
$(function() {

	$("#eye").click(function() {
		// iconの切り替え		
		$(this).toggleClass("mdi-eye mdi-eye-off");

		// 入力フォームの取得
		var input = $(this).parent().prev("input");
		// type切替
		if (input.attr("type") == "password") {
			input.attr("type", "text");
		} else {
			input.attr("type", "password");
		}
	});
});