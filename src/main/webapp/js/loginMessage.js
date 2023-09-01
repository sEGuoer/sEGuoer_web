if (document.cookie == "") {
} else {
    var select = document.getElementById("exampleCheck1")
    select.checked = true;
    var cookies1 = document.cookie.split(";");
    var cookies2 = cookies1[0].split("=")
    var cookie = cookies2[1]
    document.getElementById("exampleInputEmail1").value = cookie
}

function checkLogin() {

}
function verify() {
    var select = document.getElementById("exampleCheck1")
    if (select.checked) {
        console.log(3)
        let element = document.createElement("div");
        element.className = "text-danger"
        element.style = "display: none"
        element.setAttribute("id", "info-check")
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'SetSession', true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
        let email = document.getElementById("exampleInputEmail1").value
        let password = document.getElementById("exampleInputPassword1").value
        console.log(email, password)
        let emailAndPassword = "email=" + email + "&pwd=" + password
        xhr.send(emailAndPassword);
        xhr.onreadystatechange = function () {
            console.log(2);
            if (xhr.readyState == 4) {
                let info = xhr.getResponseHeader("info")
                if (!document.getElementById("info-check")) {
                    document.getElementById("exampleInputPassword1").after(element);
                }
                // readyState == 4说明请求已完成
                if ((xhr.status == 200 || xhr.status == 304) && xhr.getResponseHeader("isEmail-log-exist") == "kajsldjasdjsalkdjalkdla") {
                    // 从服务器获得数据
                    console.log("add");
                    document.getElementById("info-check").style = "";
                    document.getElementById("info-check").innerText = info;
                } else {
                    console.log("delete");
                    document.getElementById("info-check").style = "display: none";
                    window.location.href = "./verify?" + emailAndPassword
                }
            }

        };

    }else {
        console.log(3)
        let element = document.createElement("div");
        element.className = "text-danger"
        element.style = "display: none"
        element.setAttribute("id", "info-check")
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'verify', true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
        let email = document.getElementById("exampleInputEmail1").value
        let password = document.getElementById("exampleInputPassword1").value
        console.log(email, password)
        let emailAndPassword = "email=" + email + "&pwd=" + password
        xhr.send(emailAndPassword);
        xhr.onreadystatechange = function () {
            console.log(2);
            if (xhr.readyState == 4) {
                let info = xhr.getResponseHeader("info")
                if (!document.getElementById("info-check")) {
                    document.getElementById("exampleInputPassword1").after(element);
                }
                // readyState == 4说明请求已完成
                if ((xhr.status == 200 || xhr.status == 304) && xhr.getResponseHeader("isEmail-log-exist") == "kajsldjasdjsalkdjalkdla") {
                    // 从服务器获得数据
                    console.log("add");
                    document.getElementById("info-check").style = "";
                    document.getElementById("info-check").innerText = info;
                } else {
                    console.log("delete");
                    document.getElementById("info-check").style = "display: none";
                    window.location.href = "./SetSession"
                }
            }

        };
    }
    // datat应为'a=a1&b=b1'这种字符串格式，在jq里如果data为对象会自动将对象转成这种字符串格式
}