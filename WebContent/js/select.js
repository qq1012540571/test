$.ajax({
    async:true,//同步，异步
    url:"Guestbook", //请求的服务端地址
    type:"get",
    dataType:"json",
    success:function(data){
        //成功之后的处理，返回的数据就是 data
        var item;
        if(typeof(data)!="undefined" && data!=null && data!="") {
            $.each(data, function (i, result) {
                item =
                    "<tr><td>" + result['id'] + "</td><td>" + result['name'] + "</td><td>"+result['presentation']+"</td><td>"+result['specialties']+"</td><td> <a href='GuestEdit.jsp?id="+result['id']+"'>Edit</a></td></tr>";
                $('#messages').append(item);
            });
        }
},
    error:function(){
        alert('error'); //错误的处理
    }
});