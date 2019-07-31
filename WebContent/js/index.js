/**
 * 
 */
function getQueryString(name) {
	var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return unescape(r[2]);
	}
	return null;
}
var id =getQueryString("id");
if(typeof(id)!="undefined" && id!=null && id!="") {
	$.ajax({
		async:true,//同步，异步
		url:"Edit", //请求的服务端地址
		data:{"id":id},
		type:"get",
		dataType:"json",
		success:function(data){
			//成功之后的处理，返回的数据就是 data

			if(typeof(data)!="undefined" && data!=null && data!="") {
				$("#name").val(data.name);
				$("#specialties").val(data.specialties);
				$("#presentation").val(data.presentation);
				$("#userid").val(data.id);
			}
		},
		error:function(){
			alert('error'); //错误的处理
		}
	});
	function add() {
		var Name = $("#name").val();
		var userid = $("#userid").val();
		var Specialties = $("#specialties").val();
		var Presentation = $("#presentation").val();
		if (Name.length === 0 || Specialties.length === 0 || Presentation.length === 0) {
			alert("内容不能为空");
			return;
		}
		$.ajax({
			async: false,//同步，异步
			url: "UpdateGuest", //请求的服务端地址
			data: {"name": Name, "specialties": Specialties, "presentation": Presentation,"userid":userid},
			type: "post",
			dataType: "json",
			success: function (data) {
				//成功之后的处理，返回的数据就是 data
				alert("修改成功");
				window.location.href = "Guestbook.jsp"
			},
			error: function () {
				alert('error'); //错误的处理
			}
		});
	}
}
else {
	function add() {
		var Name = $("#name").val();
		var Specialties = $("#specialties").val();
		var Presentation = $("#presentation").val();
		if (Name.length === 0 || Specialties.length === 0 || Presentation.length === 0) {
			alert("内容不能为空");
			return;
		}
		$.ajax({
			async: false,//同步，异步
			url: "AddGuest", //请求的服务端地址
			data: {"name": Name, "specialties": Specialties, "presentation": Presentation},
			type: "post",
			dataType: "json",
			success: function (data) {
				//成功之后的处理，返回的数据就是 data
				alert("插入成功");
				window.location.href = "Guestbook.jsp"
			},
			error: function () {
				alert('error'); //错误的处理
			}
		});
	}
}