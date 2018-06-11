function login(){
    var userName=$("#userName").val();
    var password=$("#password").val();
    $.ajax({
       type : "post",
        dataType : "json",
        url: "/stud/login",
        data:$('#adminlogin').serialize(),
        success:function (result) {
            if(result.resultCode==200){
                setCookie();
            }
        }
    });
}