<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=request.getParameter("username");
	response.getWriter().print(name);
%>
    <div class="header-nav">
        <a class="header-logo" href="/">
        
        <img src="//static.21cake.com/themes/site/img/logo.png" alt="21cake logo" />        
        <!-- <img src="/themes/site/img/logo.png" alt=""> -->
        </a>
        <ul class="nav-box">
            <li><a href="//www.21cake.com/" >首页</a></li>
                            <li><a href="/gallery-index---0---1.html" target="_self">蛋糕</a></li>
                            <li><a href="/gallery-index---0---5.html" target="_self">冰淇淋</a></li>
                            <li><a href="/gallery-index---0---3.html" target="_self">咖啡下午茶</a></li>
                            <li><a href="/activity-special_goods.html" target="_self">咖啡全国送</a></li>
                            <li><a href="//b.21cake.com" target="_self">企业专区</a></li>
                    </ul>
        <div class="right-city-user">
            <a class="header-app app-download" data-id='app-list' name="app_download">APP下载</a>
            <div class="current-city" data-id='current-city'>上海<i></i></div>
            <a class="header-message"  data-id='messageList' href="/message/center.html">消息</a>
            <span class="not-login"><a href="/passport-login.do">登录</a>/<a href="/passport-sign_up.do">注册</a></span>
            <a href="/member.html" class="header-user" data-id='header-user'>
            
            <img src="//static.21cake.com/themes/site/img/user-img.png" alt="21cake user icon" />            
            <!-- <img src="/themes/site/img/user-img.png" alt=""> -->
            </a>
            <a href="/cart.do" class="header-cart" id="cart-count-icon">
                <i></i>
            </a>
            <ul class="current-city-list  header-select" id="current-city">
                            <li><a href="javascript:void(0);" class="city-id-1" data-json="{&quot;id&quot;:&quot;1&quot;,&quot;name&quot;:&quot;\u4e0a\u6d77&quot;,&quot;region_id&quot;:&quot;22&quot;}">上海</a></li>
                            <li><a href="javascript:void(0);" class="city-id-2" data-json="{&quot;id&quot;:&quot;2&quot;,&quot;name&quot;:&quot;\u5317\u4eac&quot;,&quot;region_id&quot;:&quot;2&quot;}">北京</a></li>
                            <li><a href="javascript:void(0);" class="city-id-3" data-json="{&quot;id&quot;:&quot;3&quot;,&quot;name&quot;:&quot;\u5929\u6d25&quot;,&quot;region_id&quot;:&quot;43&quot;}">天津</a></li>
                            <li><a href="javascript:void(0);" class="city-id-4" data-json="{&quot;id&quot;:&quot;4&quot;,&quot;name&quot;:&quot;\u676d\u5dde&quot;,&quot;region_id&quot;:&quot;3134&quot;}">杭州</a></li>
                            <li><a href="javascript:void(0);" class="city-id-5" data-json="{&quot;id&quot;:&quot;5&quot;,&quot;name&quot;:&quot;\u65e0\u9521&quot;,&quot;region_id&quot;:&quot;1717&quot;}">无锡</a></li>
                            <li><a href="javascript:void(0);" class="city-id-6" data-json="{&quot;id&quot;:&quot;6&quot;,&quot;name&quot;:&quot;\u82cf\u5dde&quot;,&quot;region_id&quot;:&quot;1692&quot;}">苏州</a></li>
                            <li><a href="javascript:void(0);" class="city-id-7" data-json="{&quot;id&quot;:&quot;7&quot;,&quot;name&quot;:&quot;\u5e7f\u5dde&quot;,&quot;region_id&quot;:&quot;424&quot;}">广州</a></li>
                            <li><a href="javascript:void(0);" class="city-id-8" data-json="{&quot;id&quot;:&quot;8&quot;,&quot;name&quot;:&quot;\u6df1\u5733&quot;,&quot;region_id&quot;:&quot;524&quot;}">深圳</a></li>
                        </ul>
            <ul class="header-user-list  header-select" id="header-user">
                            <li><a href="/member/orders.html" target="_blank">我的订单</a></li>
                            <li><a href="/user-coupon_index.do?back_url=L2NvdXBvbi5odG1s" target="_blank">我的优惠券</a></li>
                            <li><a href="/member/date.html" target="_blank">我的纪念日</a></li>
                            <li><a href="/passport-logout.do" target="_self">退出登录</a></li>
                        </ul>
            <ul class="message-list-header  header-select" id="messageList">
                <li><a href="/message/center.html" target="_blank">通知</a></li>
                <li><a href="/message/center.html?#delivery" target="_blank">物流</a></li>
            </ul>
            <dl class="app-list  header-select" id="app-list">
            <dt>
            
            <img src="//static.21cake.com/themes/site/img/footer-erweima.png" alt="下载APP" />            
            <!-- <img src="/themes/site/img/app.jpg" alt=""> -->
            </dt>
                <dd>下载享更多优惠</dd>
            </dl>
        </div>
    </div>
</div>
</div>
