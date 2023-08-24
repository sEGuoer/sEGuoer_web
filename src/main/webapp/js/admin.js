function inputAddUser() {
    setAddUserForm()
}

function setAddUserForm() {
    let formElement = document.createElement("form");
    formElement.method = "post"
    formElement.action = "addUser"
    let divElement1 = document.createElement("div")
    let labelElement1 = document.createElement("label")
    labelElement1.for = "exampleInputEmail1"
    labelElement1.className = "form-label"
    labelElement1.innerText = "邮箱"
    let inputElement1 = document.createElement("input")
    inputElement1.type = "email"
    inputElement1.setAttribute("onblur", "pwdverify()")
    inputElement1.id = "exampleInputEmail1"
    inputElement1.setAttribute("aria-describedby", "emailHelp")
    inputElement1.name = "email"
    divElement1.append(labelElement1)
    divElement1.append(inputElement1)
    formElement.append(divElement1)

    let divElement2 = document.createElement("div")
    let labelElement2 = document.createElement("label")
    labelElement2.for = "exampleInputAccount1"
    labelElement2.className = "form-label"
    labelElement2.innerText = "账号"
    let inputElement2 = document.createElement("input")
    inputElement2.type = "text"
    inputElement2.id = "exampleInputAccount1"
    inputElement2.setAttribute("aria-describedby", "emailHelp")
    inputElement2.name = "account"
    divElement2.append(labelElement2)
    divElement2.append(inputElement2)
    formElement.append(divElement2)

    let divElement3 = document.createElement("div")
    let labelElement3 = document.createElement("label")
    labelElement3.for = "exampleInputPassword1"
    labelElement3.className = "form-label"
    labelElement3.innerText = "密码"
    let inputElement3 = document.createElement("input")
    inputElement3.type = "text"
    inputElement3.id = "exampleInputPassword1"
    inputElement3.setAttribute("aria-describedby", "emailHelp")
    inputElement3.name = "pwd"
    divElement3.append(labelElement3)
    divElement3.append(inputElement3)
    formElement.append(divElement3)

    let divElement4 = document.createElement("div")
    divElement4.className = "text-start"
    let buttonElement = document.createElement("button")
    buttonElement.type = "submit"
    buttonElement.className = "btn btn-danger"
    buttonElement.innerText = "添加"
    divElement4.append(buttonElement)
    formElement.append(divElement4)

    let formFatherhood = document.createElement("div")
    formFatherhood.className = "card-body text-center"
    formFatherhood.append(formElement)

    let cardTitle = document.createElement("div")
    cardTitle.className = "card-header"
    let h4 = document.createElement("h4")
    h4.className = "my-0 fw-normal"
    h4.innerText = "添加账号"
    cardTitle.append(h4)

    let sumDiv = document.createElement("div")
    sumDiv.className = "card m-auto rounded-3 shadow-sm"
    sumDiv.id = "addUserForm"
    sumDiv.append(cardTitle)
    sumDiv.append(formFatherhood)
    if (!document.getElementById("addUserForm")) {
        document.getElementById("UserList").after(sumDiv)
        console.log("add")
    }
    console.log("loading")
}

function pwdverify() {
    console.log(3)
    let element = document.createElement("div");
    element.innerText = "该邮箱已被注册";
    element.className = "text-danger"
    element.style = "display: none"
    element.setAttribute("id", "email-check")
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'RegisterVerify', true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    let email = document.getElementById("exampleInputEmail1").value;
    let account = document.getElementById("exampleInputAccount1").value;
    let password = document.getElementById("exampleInputPassword1").value;
    xhr.send("email=" + email + "&account=" + account + "&pwd" + password);
    let accounts = email.split("@");
    console.log(accounts[0]);
    if (!document.getElementById("email-check")) {
        document.getElementById("exampleInputEmail1").after(element);
    }
    xhr.onreadystatechange = function () {
        console.log(2);
        // readyState == 4说明请求已完成
        if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 304) && xhr.getResponseHeader("isEmail-exist") == "kajsldjasdjsalkdjalkdla") {
            // 从服务器获得数据
            console.log("add");
            document.getElementById("email-check").style = "";
        } else if (xhr.readyState == 4) {
            console.log("delete");
            document.getElementById("email-check").style = "display: none";
            document.getElementById("exampleInputAccount1").value = accounts[0];
        }
    };
    // datat应为'a=a1&b=b1'这种字符串格式，在jq里如果data为对象会自动将对象转成这种字符串格式
}

function deleteUser() {
    let deleteEmail = event.target.parentNode.parentNode.id
    console.log(deleteEmail)
    event.target.parentNode.parentNode.remove()
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'deleteUser', true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    xhr.send("email=" + deleteEmail);
    xhr.onreadystatechange = function () {
        console.log(2);
        // readyState == 4说明请求已完成
        if (xhr.readyState == 4 && xhr.status == 200 || xhr.status == 304) {
            // 从服务器获得数据
            console.log("add");
        }
    };
}


