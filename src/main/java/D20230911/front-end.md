## 前端（front-end）

### (一)  html

#### 标签

##### 1. a标签
```html
 <a href="web.html" target="_blank">html basic</a> 
``` 
target上述属性为跳转到新页面


##### 2. img标签  
   <img src="../AU9$DES3K209A)FZ`GKJ.png" alt="picture">
```html
   <img src="../AU9$DES3K209A)FZ`GKJ.png" alt="picture">
``` 
alt指访问不到的时候显示picture


##### 3. br hr 以及 标题标签  
   <br&gt;为换行标签，其中&lt;br />可以省略  
   <hr&gt;为分割线 默认占满左右  
   <h1&gt;&lt;/h1>为一级标题，从h1~h6有六级标题


##### 4. list标签  
```html
<ul>
 <li>1</li>
 <li>2</li>
 <li>3</li>
</ul>
```
   ul为无序标签，ol为有序标签，可以通过


##### 5. table标签

  <table>
        <tr>
            <td>1</td>
            <td colspan="2" align="center">2</td>
        </tr>
        <tr>
            <td>2</td>
            <td>3</td>
            <td rowspan="2">4</td>
        </tr>
        <tr>
            <td colspan="2" align="center">3</td>
        </tr>
    </table>

代码为  
```html
<table>
        <tr>
            <td>1</td>
            <td colspan="2" align="center">2</td>
        </tr>
        <tr>
            <td>2</td>
            <td>3</td>
            <td rowspan="2">4</td>
        </tr>
        <tr>
            <td colspan="2" align="center">3</td>
        </tr>
    </table>
```

其中属性colspan为控制长度,rowspan为控制高度  
**tr可以替换为th，th表示表头**
##### 6. 不同字体标签  
   <i&gt;斜体</i&gt;:<i>斜体</i>  
   <del&gt;删除线</del&gt;:<del>删除线</del>   
   b为粗体:   <b>粗体</b>  
   u为下划线:   <u>下划线</u>  
   上标sup:<sup>2</sup>下标sup:<sub>1</sub>

##### 7. 更多标签  
如无语意p标签，div标签等等，更多待补充

### (二)  css 
css主要有两大属性：选择器，属性  
引入css有两种方法：如下（均是在html页面title标签后加标签）  
(1）直接在html加入style标签，然后写选择器和属性 （2）加link标签引入外部css
```css
.number{
   background: #6f42c1;
}
```
#### 1. 选择器  
上述代码中的.number为选择器中的一种，所以下面介绍一下选择器

选择器有不同筛选方法，下面是三种主要的选择器
```css
元素选择器
p{ /* 选择所有P标签元素  */}
类选择器
.cot{ /*选择标签属性class为cot的所有元素*/}
ID选择器
#isad{ /* 选择所有标签属性id为isad的所有元素 */}
```
#### 更多选择器  
##### （I）后代选择器
```css
        div > * {
    color: #000FFF;
}选择div的后一代所有元素
```
##### (II)子元素选择器
```css
 div * {
            color: #000FFF;
        }选择div元素的所有子元素
```
##### (III)相邻兄弟选择器
```css
 p + a{
            color: #FFF000;
        }选择p元素相邻的下一个同级的a元素，只选p后面的
```
##### (IIII)普通兄弟选择器
```css
p ~ a{
            color: #FFF000;
        }选择p元素相邻的下几个同级的a元素，只选p后面的
```

#### 2. 属性（以flex运用举例）
```css
#contentor{
    border: 1px ;
    height: 100%;
    width: 100%;
    display: flex;
    flex-direction: row;
    /* row-reverse从右往左  row从左往右  column从上往下  column-reverse从下往上 */
   flex-wrap: wrap-reverse;
   /* wrap按顺序换行 nowrap不换行 */
}

#item{
   margin: 20px;
   border: 1px solid;
   height: 200px;
   width:200px;
   background-color: aqua;
   display: flex;
   justify-content: center;
   /* start左对齐 end 右对齐 center居中 space-between两端对齐 space-around间隔相等*/
   align-items: center;
   /* align-items: start; 顶部对齐*/
   /* align-items: end;底部对齐 */
   /* align-items: center;中点对齐 */
   /* align-items: stretch;自动填充满 */
   background-image: url(..);
   /* 背景图片*/
}
```
```css
#contentor{
    border: 1px ;
    height: 100%;
    width: 100%;
    display: flex;
    flex-flow: row-reverse;
    /* 是flex-direction和flex-wrap属性的简写形式（默认值为row nowrap） */
}
```

更多已经设置好的css样式，可以在 <a href="https://icons.getbootstrap.com/">Bootstrap</a>中查看

动画转换<a href="https://animate.style/">animate</a>
### (三)  JavaScript(俗称JS)
#### JS BOM对象
##### 1. 系统对话框
```html
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>系统对话框</title>
</head>
<body>
<button type="button" onclick="testAlert()">消息框</button>
<button type="button" onclick="testPrompt()">输入框</button>
<button type="button" onclick="testConfirm()">确认框</button>
</body>
<script type="text/javascript">
    // 1）消息框:alert， 常用。
    function testAlert(){
        alert("原神，启动！");
        console.log("你好...");
    }

    // 2）输入框:prompt，返回提示框中的值
    function testPrompt(){
        var uname = window.prompt("请输入用户名：","");
        console.log(uname);
    }

    // 3）确认框:confirm，返回 true/false.
    function testConfirm() {
        var flag = confirm("您确认要删除该记录吗？");
        if (flag) {
            alert("删除成功！");
        } else {
            alert("没事别瞎点...");
        }
    }


</script>
</html>
```
##### 2. 打开窗口
```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>打开窗口</title>
</head>
<body>
<button type="button" id="btn1">打开窗口</button>
</body>
<!--
    打开窗口
        window.open()方法既可以导航到一个特定的URL也可以用来打开一个新的窗口
 -->
<script type="text/javascript">

  document.getElementById("btn1").onclick = function(){
    // 打开空白窗口
    // window.open();
    // 打开指定页面
    // window.open("01-系统对话框.html");
    // 打开百度
    // window.open("http://www.baidu.com");
    // 指定方式打开页面
    window.open("http://www.baidu.com","_self");
    // 打开页面
    //window.open("03-关闭窗口.html");
  }
</script>
</html>
```
##### 3. 关闭窗口
```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>关闭窗口</title>
</head>
<body>
<button type="button" onclick="test()">关闭窗口</button>
</body>
<script type="text/javascript">
  function test(){
    window.close();
  }
</script>
</html>
```
##### 4. 时间函数
```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>时间函数</title>
</head>
<body>
<button type="button" onclick="toBaidu()">3秒钟后跳转到百度</button>
<hr>
<button type="button" onclick="init()">开始</button>
<button type="button" onclick="stop()">暂停</button>
<h2 id="time"></h2>
<hr>
<button type="button" onclick="hello()">定时执行</button>
</body>
<!--
    setTimeout()
            setTimeout() : 在指定的毫秒数后调用函数或计算表达式。返回一个唯一的标识；
        也可以通过返回的标识cliearTimeout(id)： 来清除指定函数的执行。

        var id = setTimeout(function,times);
            参数1：执行的函数
            参数2：时间，单位毫秒

    setInteval()
            setInterval():可按照指定的周期（以毫秒计）来调用函数或计算表达式，也可根据返回的标识用来结束。
        该方法会不停地调用函数，直到 clearInterval() 被调用或窗口被关闭。

        var id = setInteval(function,times);
            参数1：执行的函数
            参数2：时间，单位毫秒
 -->
<script type="text/javascript">


  /* setTimeout(function(){
      console.log("3秒钟后执行的程序...");
  },3000); */

  // 3秒钟后跳转到百度
  function toBaidu() {
    setTimeout(test, 3000);
  }

  function test() {
    // 打开百度
    window.open("http://www.baidu.com");
  }

  console.log(new Date().toLocaleTimeString());

  var id;

  function init() {

    var time = new Date().toLocaleTimeString();

    // 将时间赋值给h2标签
    document.getElementById("time").innerHTML = time;

    // 每一秒钟调用一下
    id = setTimeout(init, 1000);
  }

  function stop() {
    clearTimeout(id);
  }


  // 定时执行
  function hello() {
    setInterval(function () {
      console.log("你好...");
    }, 1000);
  }


</script>
</html>
```

##### 5. history对象  
   (I)
```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>history对象</title>
</head>
<body>
<h2>页面1</h2>
<a href="5-history对象-2.html">页面2</a>
<hr >
<button type="button" onclick="window.history.go(2)">前进2</button>
</body>
<!--
    history对象的属性：length，返回浏览器历史列表中的 URL 数量。

         history对象的方法：
             back()：
            加载 history 列表中的前一个 URL。
             forward()：
            加载历史列表中的下一个 URL。当页面第一次访问时，还没有下一个url。
             go(number|URL):
            URL 参数使用的是要访问的 URL。而 number 参数使用的是要访问的 URL 在 History 的 URL 列表中的相对位置。go(-1)，到上一个页面
 -->
<script type="text/javascript">
  console.log(window.history.length);

</script>
</html>
```
(III)
```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>history对象</title>
</head>
<body>
<h2>页面2</h2>
<a href="5-history对象-3.html">页面3</a>
<hr />
<button type="button" onclick="window.history.forward();">前进</button>
<button type="button" onclick="window.history.back()">后退</button>
</body>
<!--
    history对象的属性：length，返回浏览器历史列表中的 URL 数量。

         history对象的方法：
             back()：
            加载 history 列表中的前一个 URL。
             forward()：
            加载历史列表中的下一个 URL。当页面第一次访问时，还没有下一个url。
             go(number|URL):
            URL 参数使用的是要访问的 URL。而 number 参数使用的是要访问的 URL 在 History 的 URL 列表中的相对位置。go(-1)，到上一个页面
 -->
<script type="text/javascript">
  console.log(window.history.length);

</script>
</html>
```
(III)
```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>history对象</title>
</head>
<body>
<h2>页面3</h2>
<button type="button" onclick="window.history.back()">后退</button>
</body>
<!--
    history对象的属性：length，返回浏览器历史列表中的 URL 数量。

         history对象的方法：
             back()：
            加载 history 列表中的前一个 URL。
             forward()：
            加载历史列表中的下一个 URL。当页面第一次访问时，还没有下一个url。
             go(number|URL):
            URL 参数使用的是要访问的 URL。而 number 参数使用的是要访问的 URL 在 History 的 URL 列表中的相对位置。go(-1)，到上一个页面
 -->
<script type="text/javascript">
  console.log(window.history.length);

</script>
</html>
```
##### 6. location对象
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>location对象</title>
</head>
<body>
<button type="button" onclick="test()">跳转</button>
<button type="button" onclick="test1()">replace</button>
<button type="button" onclick="test2()">reload</button>
</body>
<!--
        location 对象的属性
            href：设置或返回完整的 URL

            location对象的方法
                reload()：重新加载当前文档。
                replace()：用新的文档替换当前文档。(不能后退)
 -->
<script type="text/javascript">

    // 获取当前访问的URL
    var url = window.location.href;
    console.log(url);

    function test(){
        // 设置URL  页面跳转
        // window.location.href = "01-系统对话框.html";
        window.location.href = "http://www.baidu.com";
    }

    /**
     * replace()：用新的文档替换当前文档。(不能后退)
     */
    function test1(){
        window.location.replace("01-系统对话框.html");
    }
    /**
     * reload()：重新加载当前文档。
     */
    function test2(){
        window.location.reload();
    }

</script>
</html>
```


#### JS事件
##### 1. 事件
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!--
		load加载事件：
			当页面加载完毕后执行的事件

		常用事件：
			onload：当页面加载完后立即触发
			onblur：元素失去焦点
			onfocus：元素获得焦点
			onclick：鼠标点击某个对象
			onchange：用户改变***的内容
			onmouseover：鼠标移动到某个元素上
			onmouseout：鼠标从某个元素上离开
			onkeyup：某个键盘的键被松开
			onkeydown：某个键盘的键被按下
		事件流：
			接收事件的顺序
		事件流的顺序：事件冒泡和事件捕获
		事件冒泡（从小到大）
			事件开始时由最具体的元素接受，然后逐级向上传播到较为不具体的节点（文档）
		事件捕获（从大到小）
			事件开始时由document对象接受，然后逐级向下传播到具体的节点

	 -->
<body onload="loadWindows()">

</body>
<script type="text/javascript">

    function loadWindows() {
        console.log("加载...");
    }

</script>
</html>
```

##### 2. 事件处理
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>事件处理程序</title>
</head>
<body>
<!-- 1. HTML事件处理程序 -->
<button type="button" onclick="alert('Hello')" onmouseout="test()">按钮</button>
<!-- 2. DOM 0级事件处理程序 -->
<button type="button" id="btn">DOM 0级事件处理程序</button>
<!-- 3. DOM 2级事件处理程序 -->
<button type="button" id="btn2">DOM 2级事件处理程序</button>
</body>
<!--
     事件处理程序
        响应某个事件的函数就叫做事件处理程序（或事件侦听器）。事件处理程序的名字以“on”开头
        1. HTML事件处理程序
        2. DOM 0级事件处理程序
            将一个函数赋值给一个事件处理程序属性
            只能为同一个元素的同一个事件设定一个事件程序（覆盖）
        3. DOM 2级事件处理程序
            addEventListener()  和  removeEventListener()
            有三个参数：
                参数1：事件名
                参数2：处理事件的函数
                参数3：事件冒泡（false）或捕获（true）
            可以为同一个元素的同一个事件设定多个事件程序


    document.getElementById("id属性值"); 通过id属性值获取元素对象

 -->
<script type="text/javascript">
    function test(){
        console.log('鼠标移开了...');
    }

    /**
     * 加载事件
     * 	当页面上的标签和引入的资源加载完毕后，才会执行的方法
     */
    window.onload = function(){
        // 通过id属性值获取按钮对象
        var btn = document.getElementById("btn");
        console.log(btn);
        // 给指定元素绑定点击事件
        btn.onclick = function(){
            console.log("DOM 0级事件处理程序...");
        }
        btn.onclick = function(){
            console.log("test...");
        }
    }

    // DOM 2级事件
    var btn2 = document.getElementById("btn2");
    // 给按钮绑定事件监听
    btn2.addEventListener('click',function(){
        console.log("DOM 2级事件...");
    });
    btn2.addEventListener('click',fn);
    function fn(){
        console.log("按钮被点击了...");
    }
    // 移除事件
    btn2.removeEventListener("click",fn);

</script>

</html>
```
##### 3. 常用时间
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>常用事件</title>
</head>
<body>
姓名：<input type="text" id="uname" >
<button type="button" onclick="clickBtn()">按钮</button>
<hr >
城市：<select id="city">
    <option>请选择城市</option>
    <option>上海</option>
    <option>北京</option>
</select>
<hr >
<div id="div1">
    这是一个div
</div>
</body>
<!--
    常用事件：
        onload：当页面加载完后立即触发
        onblur：元素失去焦点
        onfocus：元素获得焦点
        onclick：鼠标点击某个对象
        onchange：用户改变***的内容
        onmouseover：鼠标移动到某个元素上
        onmouseout：鼠标从某个元素上离开
        onkeyup：某个键盘的键被松开
        onkeydown：某个键盘的键被按下
 -->
<script type="text/javascript">
    // onload：当页面或图像加载完后立即触发
    window.onload = function(){
        console.log("页面加载完毕...");
    }
    var uname = document.getElementById("uname");
    // onblur：元素失去焦点
    uname.onblur = function(){
        console.log("文本框失去焦点...");
    }
    // onfocus：元素获得焦点
    uname.onfocus = function(){
        console.log("文本框获得焦点...");
    }
    // onclick：鼠标点击某个对象
    function clickBtn(){
        console.log("按钮被点击了...");
    }
    // onchange：用户改变域的内容
    document.getElementById("city").onchange = function(){
        console.log("下拉框的值改变了...");
    }

    var div1 = document.getElementById("div1");
    // onmouseover：鼠标移动到某个元素上
    div1.onmouseover = function(){
        console.log("鼠标悬停...");
    }
    // onmouseout：鼠标从某个元素上离开
    div1.onmouseout = function(){
        console.log("鼠标移开...");
    }

    // 	onkeyup：某个键盘的键被松开
    uname.onkeydown = function(){
        console.log("按键按下...");
    }
    // 	onkeydown：某个键盘的键被按下
    uname.onkeyup = function(){
        console.log("按键弹起...");
    }
</script>
</html>
```