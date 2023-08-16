function pwdverify() {
    console.log(3)
    var Ajax = {
        get: function ( fn) {
            console.log(1)
            // XMLHttpRequest对象用于在后台与服务器交换数据
            var xhr = new XMLHttpRequest();
            xhr.open('GET', 'pwdverify', true);
            xhr.onreadystatechange = function () {
                console.log(2)
                // readyState == 4说明请求已完成
                if (xhr.readyState == 4 && xhr.status == 200 || xhr.status == 304) {
                    // 从服务器获得数据
                    fn.call(this, xhr.responseText);
                }
            };
            xhr.send();
        },
        // datat应为'a=a1&b=b1'这种字符串格式，在jq里如果data为对象会自动将对象转成这种字符串格式
    }
    console.log(Ajax)
}