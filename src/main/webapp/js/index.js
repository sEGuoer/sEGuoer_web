

function pwdverifyOnblur() {
    console.log(3)
    let element = document.createElement("div");
    element.innerText = "该邮箱已被注册";
    element.className = "text-danger"
    element.style = "display: none"
    element.setAttribute("id", "email-check")
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'RegisterVerify', true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    let email = document.getElementById("exampleInputEmail1").value
    xhr.send("email=" + email );
    let accounts = email.split("@");
    console.log(accounts[0])
    if (!document.getElementById("email-check")) {
        document.getElementById("exampleInputEmail1").after(element);
    }
    xhr.onreadystatechange = function () {
        console.log(2);
        // readyState == 4说明请求已完成
        if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 304) && (xhr.getResponseHeader("isEmail-exist") == "kajsldjasdjsalkdjalkdla"|| xhr.getResponseHeader("isEmail-exist") == "3")) {
            // 从服务器获得数据
            console.log("add");
            document.getElementById("email-check").style = "";
        } else if (xhr.readyState == 4) {
            console.log("delete");
            document.getElementById("email-check").style = "display: none";
            document.getElementById("account").value = accounts[0];
        }
    };
    // datat应为'a=a1&b=b1'这种字符串格式，在jq里如果data为对象会自动将对象转成这种字符串格式
}