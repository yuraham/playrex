$(document).ready(function() {
	$("#post-search-submit").click(function() {
		var post_text = $("#post-search-text").val()
		if(post_text == "" || post_text == undefined || post_text == null) {
			alert("검색 내용을 입력해주세요.");
			return false;
		};
	});
	
	$("#post-form-submit").click(function() {
        
        var met_title, met_room, met_project, met_subject, met_writer;
        met_title = $("#met_title").val();
        met_room = $("#met_room").val();
        met_project = $("#met_project").val();
        met_subject = $("#met_subject").val();
        met_writer = $("#met_writer").val();
        var partList = [];
        var text = "";
        var formPart=false;
        for (var i=1; i<9; i++) {
            text = "#part"
            text += i
            partList.push($(text).val());
        }

        if(met_title == "" && met_room == "" && met_project == "" && met_subject == "" && met_writer == "" ) {
            alert("필수 내용들을 입력해주세요.");
            return false;
        } else if(!met_title) {
            alert("제목을 입력해주세요.");
            return false;
        } else if(!met_room) {
            alert("회의실을 입력해주세요.");
            return false;
        } else if(!met_project) {
            alert("프로젝트를 입력해주세요.");
            return false;
        } else if(!met_subject) {
            alert("안건요약을 입력해주세요.");
            return false;
        } else if(!met_writer) {
            alert("작성자를 입력해주세요.");
            return false;
        } else {
            var i=0;
            while(i<partList.length) {
                if(partList[i]) {
                    return;
                }
                i++
            }
            alert("모든 참가자를 비워둘 수는 없습니다.");
            return false;
        }
    });
	
    $("#post-form2-submit").click(function() {
        var met_text = $("#met_text").val();
        if(!met_text) {
            alert("내용 및 결과를 입력해주세요.");
            return false;
        };
    });
    $("#form2-file-input").change(function() {
        var fileName = $(this).val();
        $(this).next('.my-post-file').html(fileName);
    });
});