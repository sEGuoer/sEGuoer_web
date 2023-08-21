function pwdverify() {
    console.log(3)
    let element = document.createElement("div");
    element.innerText = "该邮箱已被注册";
    element.className = "text-danger"
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'RegisterVerify', true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    xhr.send("email=" + document.getElementById("exampleInputEmail1").value);
    xhr.onreadystatechange = function () {
        console.log(2)
        // readyState == 4说明请求已完成
        if (xhr.readyState == 4 && xhr.status == 200 || xhr.status == 304) {
            // 从服务器获得数据
            console.log("add");
            document.getElementById("exampleInputEmail1").after(element)
        }
    };
    // datat应为'a=a1&b=b1'这种字符串格式，在jq里如果data为对象会自动将对象转成这种字符串格式
}