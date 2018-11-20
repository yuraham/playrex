$(document).ready(function() {
	$("#post-search-submit").click(function() {
		var text = $("#post-search-text").val()
		if(text == "" || text == undefined || text == null) {
			alert("검색 내용을 입력해주세요.");
			return false;
		};
	});
});