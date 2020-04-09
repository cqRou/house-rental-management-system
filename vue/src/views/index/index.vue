<template>
  <div>
    <div class="header background-header">
      <div class="w3ls-header">
        <div class="row"> 
          <div class="col-md-1">
            <div class="w3ls-header-left">
              <p><a href="#">houseing_renter_sysytem</a></p>
            </div>
          </div>
          <div class="col-md-3">
          </div>
          <div class="col-md-2">
            <form action="#" method="post" class="center">
              <input class="search2" name="Search" placeholder="请输入需求描述" required="">
              <button type="submit" class="btn btn-default" aria-label="Left Align">
                <i class="fa fa-search" aria-hidden="true"> </i>
              </button>  
            </form>      
          </div>
          <div class="col-md-6">     
            <div class="w3ls-header-right">             
              <!-- 工作室(学生) -->
              <ul v-if="this.$root.loginedRoleId =='2'">
                <li class="dropdown head-dpdn">
                  <router-link to="/modifyInfo"  style="color:white" class="dropdown-toggle"><i class="fa fa-user" aria-hidden="true"></i>
                  个人中心</router-link>
                </li> 
                <li class="dropdown head-dpdn">             
                  <router-link to="/studioManageUnrecruited"  style="color:white" class="dropdown-toggle"><i class="fa fa-percent" aria-hidden="true"></i>
                  项目管理</router-link>
                </li> 
                <li class="dropdown head-dpdn">
                  <router-link to="/classify"  style="color:white" class="dropdown-toggle"><i class="fa fa-comment" aria-hidden="true"></i>
                  查看项目列表</router-link>
                </li>
                <li class="dropdown head-dpdn">
                  <router-link to="/advertisement"  style="color:white" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                申请广告位</router-link>
                </li> 
                <li class="dropdown head-dpdn">
                  <router-link to="/help" style="color:white" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  联系我们</router-link>
                </li>
                <li class="dropdown head-dpdn">
                  <a style="color:white"  @click="loginOut" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  退出登录</a>
                </li>
              </ul>
              <!-- 企业 -->
              <ul v-if="this.$root.loginedRoleId =='3'">
                <li class="dropdown head-dpdn">
                   <router-link to="/modifyInfo"  style="color:white" class="dropdown-toggle"><i class="fa fa-user" aria-hidden="true"></i>
                  个人中心</router-link>
                </li> 
                <li class="dropdown head-dpdn">
                   <router-link to="/companyManageUnrecruited"  style="color:white" class="dropdown-toggle"><i class="fa fa-user" aria-hidden="true"></i>
                  项目管理</router-link>
                </li>
                <li class="dropdown head-dpdn">
                  <router-link to="/studioinfo"  style="color:white" class="dropdown-toggle"><i class="fa fa-comment" aria-hidden="true"></i>
                  工作室信息</router-link>
                </li>
                <li class="dropdown head-dpdn">
                  <router-link to="/demand" style="color:white" class="dropdown-toggle"><i class="fa fa-cloud-upload" aria-hidden="true"></i>
                发布需求</router-link>
                </li>  
                <li class="dropdown head-dpdn">
                  <router-link to="/advertisement" style="color:white" class="dropdown-toggle"><i class="fa fa-gift" aria-hidden="true"></i>
                  广告位申请</router-link>
                </li> 
                <li class="dropdown head-dpdn">
                  <router-link to="/help" style="color:white" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  联系我们</router-link>
                </li>
                <li class="dropdown head-dpdn">
                  <a style="color:white"  @click="loginOut" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  退出登录</a>
                </li>
              </ul>
              <!--viewer -->
              <ul v-if="this.$root.userIsLogined == false">
                <li class="dropdown head-dpdn">
                  <el-button  type="primary" icon="edit" @click="showLogin"><i class="fa fa-user" aria-hidden="true"></i>登录</el-button>
                    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible1" style="display: none;width:60%;margin:10px 300px 10px" >
                    <el-form autoComplete="on" :model="loginForm" :rules="loginRules" ref="loginForm" class="small-space" label-position="left" label-width="80px"
                            style='width: 300px; margin-left:50px;'>
                      <el-form-item prop="username" label="账号" required>
                        <el-input type="text" v-model="loginForm.username" autoComplete="on"></el-input>
                      </el-form-item>
                      <el-form-item label="密码" prop="password"  required>
                        <el-input type="password" @keyup.enter.native="handleLogin" v-model="loginForm.password" autoComplete="on"></el-input>
                      </el-form-item>
                    </el-form>
                    <div slot="footer" class="dialog-footer">
                      <el-row>
                         <el-col :span="6">
                          <div>&nbsp;
                          </div>
                         </el-col>
                         <!-- <el-col :span="12"> -->
                          <el-button type="submit" :loading="loading" @click.native.prevent="handleLogin" style="border: none;outline: none;cursor: pointer;color: #fff;background: #0280e1;
                       width: 42%;padding: 0.8em 1em;font-size: 1em;margin: -3em 12.5em 0.8em -1.5em;-webkit-transition:.5s all;-moz-transition:.5s all;
	                    -o-transition:.5s all;-ms-transition:.5s all;transition:.5s all;text-transform: uppercase;-webkit-appearance:none;">
                          登 录</el-button>
                        <!-- </el-col> -->
                        <!-- <el-col :span="6">
                          <el-button @click="dialogFormVisible1 = false" style="border: none;outline: none;cursor: pointer;color: #fff;background: #0280e1;
                          font-size: 1em;margin:-20em 24em 0.8em 0em;-webkit-transition:.5s all;-moz-transition:.5s all;
                          -o-transition:.5s all;-ms-transition:.5s all;transition:.5s all;text-transform: uppercase;-webkit-appearance:none;">
                          取消</el-button>
                        </el-col> -->
                      </el-row>
                      <el-row>
                        <el-col :span="2"><el-checkbox v-model="checked" style="margin:1em 0em -2em">记住密码</el-checkbox></el-col>
                        <el-col :span="6"><div style="margin:1em -19em -2em"><router-link to="/myWallet">忘记密码?</router-link></div></el-col>
                      </el-row>
                      <!-- <el-checkbox v-model="checked" style="right:145px;margin: 1em 15em 1em">记住密码</el-checkbox>
                      <router-link to="/myWallet" style="margin: -5em 1em -2em">忘记密码</router-link>
                      <el-button style="color:#000" @click="dialogFormVisible1 = false">取 消</el-button> -->
                    </div>
                  </el-dialog>
                </li>
                <li class="dropdown head-dpdn">
                  <el-button type="primary" icon="edit" @click="showRegister"><i class="fa fa-user" aria-hidden="true"></i>注册</el-button>
                    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible2" style="display: none;width:60%;margin:10px 300px 10px" >
                      <el-form autoComplete="on" :model="registerForm" :rules="loginRules" ref="registerForm" class="small-space" label-position="left" label-width="80px"
                              style='width: 300px; margin-left:50px;'>
                        <el-form-item prop="username" label="账号" required>
                          <el-input type="text" v-model="registerForm.username" autoComplete="on"></el-input>
                        </el-form-item>
                        <el-form-item label="密码" required>
                          <el-input type="password" placeholder="输入您的密码" v-model="registerForm.password"></el-input>
                        </el-form-item>
                        <el-form-item label="密码确认" required>
                          <el-input type="password" placeholder="再次输入您的密码" v-model="registerForm.passwordAgain"></el-input>
                        </el-form-item>
                        <el-form-item label="邮箱" required>
                          <el-input type="text" placeholder="输入您的邮箱" v-model="registerForm.email"></el-input>
                        </el-form-item>
                        <el-form-item label="所在城市" required>
                          <el-input type="text" placeholder="输入您所在的城市" v-model="registerForm.address"></el-input>
                        </el-form-item>
                        <el-form-item label="联系电话" required>
                          <el-input type="text" placeholder="输入您的联系方式" v-model="registerForm.telephone"></el-input>
                        </el-form-item>
                        <el-form-item label="单位名称" required>
                          <el-input type="text" placeholder="输入您的公司/工作室名称" v-model="registerForm.unitName"></el-input>
                        </el-form-item>
                        <el-form-item label="角色" required>
                          <el-select v-model="registerForm.roleId" placeholder="请选择">
                            <el-option
                              v-for="item in roles"
                              :key="item.value"
                              :label="item.label"
                              :value="item.value">
                            </el-option>
                          </el-select>
                        </el-form-item>
                      </el-form>
                    <div slot="footer" class="dialog-footer">
                      <el-button type="submit" @click="handleRegister" style="border: none;outline: none;cursor: pointer;color: #fff;background: #0280e1;
                       width: 70%;padding: .8em 1em;font-size: 1em;margin: -2em 4.5em 0.8em;-webkit-transition:.5s all;-moz-transition:.5s all;
	                    -o-transition:.5s all;-ms-transition:.5s all;transition:.5s all;text-transform: uppercase;-webkit-appearance:none;">注 册</el-button>
                      <el-button style="color:#000" @click="dialogFormVisible2 = false">取 消</el-button>
                    </div>
                  </el-dialog>
                </li>  
              </ul>
            </div>
          </div>
          <div class="clearfix"> </div>
        </div> 
      </div>
      <div class="header-two" style="height:520px; width:100%"><!-- header-two -->
          <div class="row">
            <div class="col-md-2">
              <div class="header-logo">              
              </div>
            </div>
            <div class="col-md-1">
            </div>
            <div class="col-md-9">	

            </div>
            <div class="clearfix"> 
            </div>
          </div>	
           <el-carousel :interval="5000" arrow="always">
            <el-carousel-item v-for="item in 4" :key="item">
              <h3>{{ item }}</h3>
            </el-carousel-item>
          </el-carousel>	
      </div><!-- //header-two -->
    </div>
    <div class="cont-wrap m-t-box">
        <div class="box search-cont p-none clearfix">
            <div class="left-tabs">
                <a href="javascript:void(0);"><span class="tab h-tab cur-tab" data-type="1">买&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;房</span></a>
                <a href="javascript:void(0);"><span class="tab h-tab" data-type="8">卖&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;房</span></a>
                <a href="javascript:void(0);"><span class="tab" data-type="3">租&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;房</span></a>
                <a href="javascript:void(0);">
                    <span class="tab" data-type="5">商铺写字楼</span>
                </a>
            </div>
            <div class="right-conts">
                <!-- 买房、租房、商业地产对应的搜索框 -->
                <form class="search search-form" method="GET" action="https://hangzhou.anjuke.com/indexsearch/?from=SearchBar" target="_self" id="indexSearch" style="display:none;">
                  <!--商业地产radios-->
                  <div style="display: none;" id="contsydc" class="contsydc">
                    <input hidefocus="true" type="radio" value="租写字楼" name="sydc_type" class="sydc-type fst-type" checked="true" data-text="租写字楼" data-type="5">&nbsp;租写字楼
                    <input hidefocus="true" type="radio" value="买写字楼" name="sydc_type" class="sydc-type" data-text="买写字楼" data-type="4">&nbsp;买写字楼
                    <input hidefocus="true" type="radio" value="买商铺" name="sydc_type" class="sydc-type" data-text="买商铺" data-type="6">&nbsp;买商铺
                    <input hidefocus="true" type="radio" value="租商铺" name="sydc_type" class="sydc-type" data-text="租商铺" data-type="7">&nbsp;租商铺
                  </div>
                  <input type="hidden" name="t" value="1" id="iptHidden" class="iptHidden">
                  <!-- 买房搜新房 -->
                  <div class="fd1 clearfix" id="searchIpt">
                    <input type="text" name="kw" class="kw" id="glb_search0" maxlength="100" autocomplete="off" placeholder="请输入房源特征、地址、小区、楼盘名或…" value="">
                    <i class="home-icon search-close" data-tracker="delete-kw" id="home_close" style="display: none;"></i><!--搜索关闭按钮-->
                    <a href="javascript:void(0);" id="xfLink"><i class="btn-icon icon-xfzf"></i><input style="" type="button" id="otherBtn" class="btn-bg-xf btn otherBtn" value="新房"></a>
                    <a href="javascript:void(0);"><i class="btn-icon" id="btnIcon"></i><input hidefocus="true" id="btnSubmit" type="submit" class="btn btnSubmit" value="二手房"></a>
                  </div>
                </form>

                <!-- 买房搜二手房启用新搜索框 -->
                <form class="search search-form" method="GET" action="https://hangzhou.anjuke.com/indexsearch/?from=SearchBar" target="_self" id="search-form">
                    <input type="hidden" name="t" value="1" id="iptHidden" class="iptHidden">
                    <div class="fd1 clearfix" id="searchIpt">
                        <input type="text" name="kw" class="kw" id="search-esf" maxlength="100" autocomplete="off" placeholder="请输入小区名称、地址…" value="">
                        <i class="home-icon search-close" data-tracker="delete-kw" id="search-close" style="display: none;"></i><!--搜索关闭按钮-->
                        <a href="javascript:void(0);"><i class="btn-icon" id="btnIcon"></i><input hidefocus="true" id="btnSubmit" type="submit" class="btn btnSubmit" value="二手房"></a>
                        <a href="javascript:void(0);" id="xfLink"><i class="btn-icon icon-xfzf"></i><input style="" type="button" id="otherBtn" class="btn-bg-xf btn otherBtn" value="新房"></a>
                        <div class="auto-wrap"></div>
                    </div>
                </form>

                <!--type 1:默认词, 2:搜索次数最多的小区词, 3:搜索过的词, 4:浏览过的房源所属小区词, 5:根据小区ID推荐的小区词, 6:用户输入后匹配到的词 -->
                <script type="text/template" id="search-tpl">
                    <ul class="search-ul esf-search-ul">
                        <%_.each(obj,function(item){%>
                            <li link="<%= item.link %>">
                                <% if(item.type==2){%>
                                    <em class="font_tag recom_tg">热门</em>
                                <% }else if(item.type==3){%>
                                    <em class="font_tag sou_tg">搜过</em>
                                <% }else if(item.type==4){%>
                                    <em class="font_tag kan_tg">看过</em>
                                <% }else if(item.type==5){%>
                                    <em class="font_tag recom_tg">推荐</em>
                                <%}%>

                                <span <% if(item.type!=6 && item.type!=7 && item.type!=1){%>class="s_kw"<%}%> ><%= item.keyword %></span>
                                <label class="gray <%if(item.type==1){%>pz<%}%>"><%= item.description %></label>
                                <% if(item.type==6 && item.isa == 0 && item.address){%>
                                    <label class="gray address">-&nbsp;<%= item.address %></label>
                                <%}%>
                                <% if(item.type == 7 && item.total) {%>
                                <label class="price">共<%= item.total %>个小区</label>
                                <% }else if(item.price){%><label class="price"><%= item.price %></label><%}%>

                            </li>
                        <%});%>
                    </ul>
                </script>
                <!-- 买房 -->
                <div class="buy-house tab-contents" id="content_Rd1">
                    <!-- 买房(二手房、新房都有)style="display: none" -->
                    <div class="clearfix">
                        <!-- 二手房 -->
                        <div class="details float_l">
                            <a title="地图找房" alt="地图找房" class="map" href="https://hangzhou.anjuke.com/map/sale/" _soj="SearchBar"><i class="home-icon"></i>地图找房</a>
                            <p>二手房</p>
                            <div class="areas">
                                <a title="余杭二手房" alt="余杭" class="hot-word" href="https://hangzhou.anjuke.com/sale/yuhang/" target="_self" _soj="SearchBar">余杭</a>
                                <a title="萧山二手房" alt="萧山" class="hot-word" href="https://hangzhou.anjuke.com/sale/xiaoshan/" target="_self" _soj="SearchBar">萧山</a>
                                <a title="江干二手房" alt="江干" class="hot-word" href="https://hangzhou.anjuke.com/sale/jianggan/" target="_self" _soj="SearchBar">江干</a>
                                <a title="西湖二手房" alt="西湖" href="https://hangzhou.anjuke.com/sale/xihu/" target="_self" _soj="SearchBar">西湖</a>
                                <a title="滨江二手房" alt="滨江" href="https://hangzhou.anjuke.com/sale/binjiangb/" target="_self" _soj="SearchBar">滨江</a>
                                <a title="拱墅二手房" alt="拱墅" href="https://hangzhou.anjuke.com/sale/gongshu/" target="_self" _soj="SearchBar">拱墅</a>
                                <a title="临安二手房" alt="临安" href="https://hangzhou.anjuke.com/sale/linanq/" target="_self" _soj="SearchBar">临安</a>
                                <a title="富阳二手房" alt="富阳" href="https://hangzhou.anjuke.com/sale/fuyang/" target="_self" _soj="SearchBar">富阳</a>
                                <a title="下城二手房" alt="下城" href="https://hangzhou.anjuke.com/sale/xiacheng/" target="_self" _soj="SearchBar">下城</a>
                                <a title="上城二手房" alt="上城" href="https://hangzhou.anjuke.com/sale/shangcheng/" target="_self" _soj="SearchBar">上城</a>
                                <a title="桐庐二手房" alt="桐庐" href="https://hangzhou.anjuke.com/sale/tonglu/" target="_self" _soj="SearchBar">桐庐</a>
                                <a title="淳安二手房" alt="淳安" href="https://hangzhou.anjuke.com/sale/chunan/" target="_self" _soj="SearchBar">淳安</a>
                                <a title="杭州周边二手房" alt="杭州周边" href="https://hangzhou.anjuke.com/sale/hangzhouzhoubian/" target="_self" _soj="SearchBar">杭州周边</a>
                                <a title="建德二手房" alt="建德" href="https://hangzhou.anjuke.com/sale/jiande/" target="_self" _soj="SearchBar">建德</a>
                            </div>
                            <div class="prices">
                              <a title="50万以下二手房" alt="50万以下" href="//hangzhou.anjuke.com/sale/m70/" target="_self" _soj="SearchBar">50万以下</a>
                              <a title="50-80万二手房" alt="50-80万" href="//hangzhou.anjuke.com/sale/m71/" target="_self" _soj="SearchBar">50-80万</a>
                              <a title="80-100万二手房" alt="80-100万" href="//hangzhou.anjuke.com/sale/m72/" target="_self" _soj="SearchBar">80-100万</a>
                              <a title="120-150万二手房" alt="120-150万" href="//hangzhou.anjuke.com/sale/m74/" target="_self" _soj="SearchBar">120-150万</a>
                              <a title="150-180万二手房" alt="150-180万" href="//hangzhou.anjuke.com/sale/m5056/" target="_self" _soj="SearchBar">150-180万</a>
                              <a title="250-300万二手房" alt="250-300万" href="//hangzhou.anjuke.com/sale/m694/" target="_self" _soj="SearchBar">250-300万</a>
                              <a title="400-500万二手房" alt="400-500万" href="//hangzhou.anjuke.com/sale/m5062/" target="_self" _soj="SearchBar">400-500万</a>
                              <a title="500-1000万二手房" alt="500-1000万" href="//hangzhou.anjuke.com/sale/m696/" target="_self" _soj="SearchBar">500-1000万</a>
                          </div>
                        </div>
                        <i class="solid-line  line-mag float_l"></i>
                        <!-- 新房 -->
                        <div class="details float_l">
                            <a title="地图找房" alt="地图找房" class="map" href="https://hz.fang.anjuke.com/map/loupan/" _soj="SearchBar"><i class="home-icon"></i>地图找房</a>
                            <p>新房</p>
                            <div class="areas">
                                <a title="余杭" alt="余杭" class="hot-word" href="https://hz.fang.anjuke.com/loupan/yuhang/" target="_self" _soj="SearchBar">余杭</a>
                                <a title="萧山" alt="萧山" class="hot-word" href="https://hz.fang.anjuke.com/loupan/xiaoshan/" target="_self" _soj="SearchBar">萧山</a>
                                <a title="江干" alt="江干" class="hot-word" href="https://hz.fang.anjuke.com/loupan/jianggan/" target="_self" _soj="SearchBar">江干</a>
                                <a title="临安" alt="临安" href="https://hz.fang.anjuke.com/loupan/linan/" target="_self" _soj="SearchBar">临安</a>
                                <a title="钱塘新区" alt="钱塘新区" href="https://hz.fang.anjuke.com/loupan/qiantangxinqu/" target="_self" _soj="SearchBar">钱塘新区</a>
                                <a title="富阳" alt="富阳" href="https://hz.fang.anjuke.com/loupan/fuyang/" target="_self" _soj="SearchBar">富阳</a>
                                <a title="杭州周边" alt="杭州周边" href="https://hz.fang.anjuke.com/loupan/hangzhouzhoubian/" target="_self" _soj="SearchBar">杭州周边</a>
                                <a title="拱墅" alt="拱墅" href="https://hz.fang.anjuke.com/loupan/gongshu/" target="_self" _soj="SearchBar">拱墅</a>
                                <a title="滨江" alt="滨江" href="https://hz.fang.anjuke.com/loupan/binjiang/" target="_self" _soj="SearchBar">滨江</a>
                                <a title="西湖" alt="西湖" href="https://hz.fang.anjuke.com/loupan/xihu/" target="_self" _soj="SearchBar">西湖</a>
                                <a title="之江" alt="之江" href="https://hz.fang.anjuke.com/loupan/zhijiang/" target="_self" _soj="SearchBar">之江</a>
                                <a title="下城" alt="下城" href="https://hz.fang.anjuke.com/loupan/xiacheng/" target="_self" _soj="SearchBar">下城</a>
                                <a title="桐庐县" alt="桐庐县" href="https://hz.fang.anjuke.com/loupan/tongluxian/" target="_self" _soj="SearchBar">桐庐县</a>
                                <a title="建德市" alt="建德市" href="https://hz.fang.anjuke.com/loupan/jiandeshi/" target="_self" _soj="SearchBar">建德市</a>
                                <a title="上城" alt="上城" href="https://hz.fang.anjuke.com/loupan/shangcheng/" target="_self" _soj="SearchBar">上城</a>
                                <a title="淳安县" alt="淳安县" href="https://hz.fang.anjuke.com/loupan/chunanxian/" target="_self" _soj="SearchBar">淳安县</a>
                            </div>
                            <div class="prices">
                                <a title="1万以下" alt="1万以下" href="https://hz.fang.anjuke.com/loupan/s?m=1&amp;p7=2758" target="_self" _soj="SearchBar">1万以下</a>
                                <a title="1-1.5万" alt="1-1.5万" href="https://hz.fang.anjuke.com/loupan/s?m=1&amp;p7=59" target="_self" _soj="SearchBar">1-1.5万</a>
                                <a title="1.5-2万" alt="1.5-2万" href="https://hz.fang.anjuke.com/loupan/s?m=1&amp;p7=60" target="_self" _soj="SearchBar">1.5-2万</a>
                                <a title="2-3万" alt="2-3万" href="https://hz.fang.anjuke.com/loupan/s?m=1&amp;p7=61" target="_self" _soj="SearchBar">2-3万</a>
                                <a title="3万-4万" alt="3万-4万" href="https://hz.fang.anjuke.com/loupan/s?m=1&amp;p7=2759" target="_self" _soj="SearchBar">3万-4万</a>
                                <a title="4万-5万" alt="4万-5万" href="https://hz.fang.anjuke.com/loupan/s?m=1&amp;p7=2760" target="_self" _soj="SearchBar">4万-5万</a>
                                <a title="5万以上" alt="5万以上" href="https://hz.fang.anjuke.com/loupan/s?m=1&amp;p7=2761" target="_self" _soj="SearchBar">5万以上</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end买房 -->

                <!-- 租房 -->
                <div style="display: none" class="tab-contents clearfix" id="content_Rd3">

                                        <a title="地图找房" alt="地图找房" class="map one-map" href="https://hz.zu.anjuke.com/ditu/" _soj="SearchBar"><i class="home-icon"></i>地图找房</a>
                                        <div class="hot-areas">
                        <p>热门区域</p>
                        <div class="areas list-height">
                                                                    <a title="余杭租房" alt="余杭" class="hot-word" href="//hz.zu.anjuke.com/fangyuan/yuhang/" target="_self" _soj="SearchBar">余杭</a>
                                                                    <a title="萧山租房" alt="萧山" class="hot-word" href="//hz.zu.anjuke.com/fangyuan/xiaoshan/" target="_self" _soj="SearchBar">萧山</a>
                                                                    <a title="江干租房" alt="江干" class="hot-word" href="//hz.zu.anjuke.com/fangyuan/jianggan/" target="_self" _soj="SearchBar">江干</a>
                                                                    <a title="西湖租房" alt="西湖" href="//hz.zu.anjuke.com/fangyuan/xihu/" target="_self" _soj="SearchBar">西湖</a>
                                                                    <a title="滨江租房" alt="滨江" href="//hz.zu.anjuke.com/fangyuan/binjiangb/" target="_self" _soj="SearchBar">滨江</a>
                                                                    <a title="钱塘新区租房" alt="钱塘新区" href="//hz.zu.anjuke.com/fangyuan/qtxq/" target="_self" _soj="SearchBar">钱塘新区</a>
                                                                    <a title="拱墅租房" alt="拱墅" href="//hz.zu.anjuke.com/fangyuan/gongshu/" target="_self" _soj="SearchBar">拱墅</a>
                                                                    <a title="下城租房" alt="下城" href="//hz.zu.anjuke.com/fangyuan/xiacheng/" target="_self" _soj="SearchBar">下城</a>
                                                                    <a title="上城租房" alt="上城" href="//hz.zu.anjuke.com/fangyuan/shangcheng/" target="_self" _soj="SearchBar">上城</a>
                                                                    <a title="富阳租房" alt="富阳" href="//hz.zu.anjuke.com/fangyuan/fuyang/" target="_self" _soj="SearchBar">富阳</a>
                                                                    <a title="临安租房" alt="临安" href="//hz.zu.anjuke.com/fangyuan/linanq/" target="_self" _soj="SearchBar">临安</a>
                                                                    <a title="桐庐租房" alt="桐庐" href="//hz.zu.anjuke.com/fangyuan/tonglu/" target="_self" _soj="SearchBar">桐庐</a>
                                                                    <a title="淳安租房" alt="淳安" href="//hz.zu.anjuke.com/fangyuan/chunan/" target="_self" _soj="SearchBar">淳安</a>
                                                                    <a title="建德租房" alt="建德" href="//hz.zu.anjuke.com/fangyuan/jiande/" target="_self" _soj="SearchBar">建德</a>
                                                                    <a title="杭州周边租房" alt="杭州周边" href="//hz.zu.anjuke.com/fangyuan/hangzhouzhoubian/" target="_self" _soj="SearchBar">杭州周边</a>
                                                        </div>
                    </div>
                    <i class="solid-line float_l"></i>
                    <div class="hot-plates">
                        <p>热门板块</p>
                        <div class="areas list-height">
                                                                    <a title="钱江世纪城租房" alt="钱江世纪城" class="hot-word" href="//hz.zu.anjuke.com/fangyuan/xiaoshan-q-qianjiangshijicheng/" target="_self" _soj="SearchBar">钱江世纪城</a>
                                                                    <a title="万达广场租房" alt="万达广场" class="hot-word" href="//hz.zu.anjuke.com/fangyuan/gongshu-q-wandaguangchang/" target="_self" _soj="SearchBar">万达广场</a>
                                                                    <a title="近江租房" alt="近江" class="hot-word" href="//hz.zu.anjuke.com/fangyuan/shangcheng-q-jinjiang/" target="_self" _soj="SearchBar">近江</a>
                                                                    <a title="拱墅三墩租房" alt="拱墅三墩" href="//hz.zu.anjuke.com/fangyuan/gongshu-q-gongshusandun/" target="_self" _soj="SearchBar">拱墅三墩</a>
                                                                    <a title="武林租房" alt="武林" href="//hz.zu.anjuke.com/fangyuan/xiacheng-q-wulin/" target="_self" _soj="SearchBar">武林</a>
                                                                    <a title="庆春租房" alt="庆春" href="//hz.zu.anjuke.com/fangyuan/xiacheng-q-qingchun/" target="_self" _soj="SearchBar">庆春</a>
                                                                    <a title="下沙物美租房" alt="下沙物美" href="//hz.zu.anjuke.com/fangyuan/qtxq-q-xiashawumei/" target="_self" _soj="SearchBar">下沙物美</a>
                                                                    <a title="仙林桥租房" alt="仙林桥" href="//hz.zu.anjuke.com/fangyuan/xiacheng-q-xianlinqiao/" target="_self" _soj="SearchBar">仙林桥</a>
                                                                    <a title="钱江湾租房" alt="钱江湾" href="//hz.zu.anjuke.com/fangyuan/binjiangb-q-qianjiangwan/" target="_self" _soj="SearchBar">钱江湾</a>
                                                                    <a title="环北丝绸城附近租房" alt="环北丝绸城附近" href="//hz.zu.anjuke.com/fangyuan/xiacheng-q-huanbeisichouchengfujin/" target="_self" _soj="SearchBar">环北丝绸城附近</a>
                                                                    <a title="北干租房" alt="北干" href="//hz.zu.anjuke.com/fangyuan/xiaoshan-q-beigan/" target="_self" _soj="SearchBar">北干</a>
                                                                    <a title="和平租房" alt="和平" href="//hz.zu.anjuke.com/fangyuan/xiacheng-q-heping/" target="_self" _soj="SearchBar">和平</a>
                                                                    <a title="富春租房" alt="富春" href="//hz.zu.anjuke.com/fangyuan/fuyang-q-fuchun/" target="_self" _soj="SearchBar">富春</a>
                                                                    <a title="东新租房" alt="东新" href="//hz.zu.anjuke.com/fangyuan/xiacheng-q-dongxin/" target="_self" _soj="SearchBar">东新</a>
                                                                    <a title="文苑租房" alt="文苑" href="//hz.zu.anjuke.com/fangyuan/xihu-q-wenyuan/" target="_self" _soj="SearchBar">文苑</a>
                                                        </div>
                    </div>
                    <i class="solid-line float_l"></i>
                    <div class="house-budget">
                        <p>租房预算</p>
                        <div class="areas list-height">
                                                                    <a title="1000元以下" alt="1000元以下" href="//hz.zu.anjuke.com/fangyuan/zj101/" target="_self" _soj="SearchBar">1000元以下</a>
                                                                    <a title="1000-1500元" alt="1000-1500元" href="//hz.zu.anjuke.com/fangyuan/zj102/" target="_self" _soj="SearchBar">1000-1500元</a>
                                                                    <a title="1500-2000元" alt="1500-2000元" href="//hz.zu.anjuke.com/fangyuan/zj103/" target="_self" _soj="SearchBar">1500-2000元</a>
                                                                    <a title="2000-2500元" alt="2000-2500元" href="//hz.zu.anjuke.com/fangyuan/zj104/" target="_self" _soj="SearchBar">2000-2500元</a>
                                                                    <a title="2500-3000元" alt="2500-3000元" href="//hz.zu.anjuke.com/fangyuan/zj105/" target="_self" _soj="SearchBar">2500-3000元</a>
                                                        </div>
                    </div>
                </div>
                <!-- end租房 -->
                
                <!-- 租写字楼"-->
                <div style="display: none" class="tab-contents clearfix" id="content_Rd5">
                    <div class="details float_l">
                        <p>热门区域</p>
                        <div class="areas">
                            <a title="滨江" alt="滨江" class="hot-word" href="https://hz.sydc.anjuke.com/xzl-zu/binjiang/" target="_self" _soj="SearchBar">滨江</a>
                            <a title="江干" alt="江干" class="hot-word" href="https://hz.sydc.anjuke.com/xzl-zu/jianggan/" target="_self" _soj="SearchBar">江干</a>
                            <a title="余杭" alt="余杭" class="hot-word" href="https://hz.sydc.anjuke.com/xzl-zu/yuhang/" target="_self" _soj="SearchBar">余杭</a>
                            <a title="西湖" alt="西湖" href="https://hz.sydc.anjuke.com/xzl-zu/xihuqu/" target="_self" _soj="SearchBar">西湖</a>
                            <a title="萧山" alt="萧山" href="https://hz.sydc.anjuke.com/xzl-zu/xiaoshan/" target="_self" _soj="SearchBar">萧山</a>
                            <a title="拱墅" alt="拱墅" href="https://hz.sydc.anjuke.com/xzl-zu/gongshu/" target="_self" _soj="SearchBar">拱墅</a>
                            <a title="下城" alt="下城" href="https://hz.sydc.anjuke.com/xzl-zu/xiacheng/" target="_self" _soj="SearchBar">下城</a>
                            <a title="钱塘新区" alt="钱塘新区" href="https://hz.sydc.anjuke.com/xzl-zu/qtxq/" target="_self" _soj="SearchBar">钱塘新区</a>
                            <a title="上城" alt="上城" href="https://hz.sydc.anjuke.com/xzl-zu/hzshangcheng/" target="_self" _soj="SearchBar">上城</a>
                            <a title="临安" alt="临安" href="https://hz.sydc.anjuke.com/xzl-zu/linanshi/" target="_self" _soj="SearchBar">临安</a>
                            <a title="富阳" alt="富阳" href="https://hz.sydc.anjuke.com/xzl-zu/fuyangshi/" target="_self" _soj="SearchBar">富阳</a>
                            <a title="桐庐" alt="桐庐" href="https://hz.sydc.anjuke.com/xzl-zu/tonglu/" target="_self" _soj="SearchBar">桐庐</a>
                            <a title="淳安" alt="淳安" href="https://hz.sydc.anjuke.com/xzl-zu/chunan/" target="_self" _soj="SearchBar">淳安</a>
                            <a title="建德" alt="建德" href="https://hz.sydc.anjuke.com/xzl-zu/jiandeshi/" target="_self" _soj="SearchBar">建德</a>
                            <a title="杭州周边" alt="杭州周边" href="https://hz.sydc.anjuke.com/xzl-zu/hangzhou/" target="_self" _soj="SearchBar">杭州周边</a>
                        </div>
                    </div>
                    <i class="solid-line line-mag float_l" style="height: 121px"></i>
                    <div class="details float_l">
                        <p>热门板块</p>
                        <div class="areas">
                          <a title="钱江新城" alt="钱江新城" class="hot-word" href="https://hz.sydc.anjuke.com/xzl-zu/jianggan-qianjiangxc/" target="_self" _soj="SearchBar">钱江新城</a>
                          <a title="钱江世纪城" alt="钱江世纪城" class="hot-word" href="https://hz.sydc.anjuke.com/xzl-zu/xiaoshan-qianjiangsjc/" target="_self" _soj="SearchBar">钱江世纪城</a>
                          <a title="西兴" alt="西兴" class="hot-word" href="https://hz.sydc.anjuke.com/xzl-zu/binjiang-xixing/" target="_self" _soj="SearchBar">西兴</a>
                          <a title="区政府" alt="区政府" href="https://hz.sydc.anjuke.com/xzl-zu/binjiang-quzhengfuhz/" target="_self" _soj="SearchBar">区政府</a>
                          <a title="未来科技城" alt="未来科技城" href="https://hz.sydc.anjuke.com/xzl-zu/yuhang-weilaikejicheng/" target="_self" _soj="SearchBar">未来科技城</a>
                          <a title="长河" alt="长河" href="https://hz.sydc.anjuke.com/xzl-zu/binjiang-hzchanghe/" target="_self" _soj="SearchBar">长河</a>
                          <a title="临平" alt="临平" href="https://hz.sydc.anjuke.com/xzl-zu/yuhang-linping/" target="_self" _soj="SearchBar">临平</a>
                          <a title="火车东站 " alt="火车东站 " href="https://hz.sydc.anjuke.com/xzl-zu/jianggan-huochedongzhan/" target="_self" _soj="SearchBar">火车东站 </a>
                          <a title="西湖三墩" alt="西湖三墩" href="https://hz.sydc.anjuke.com/xzl-zu/xihuqu-xhsandun/" target="_self" _soj="SearchBar">西湖三墩</a>
                          <a title="万达广场" alt="万达广场" href="https://hz.sydc.anjuke.com/xzl-zu/gongshu-wandaguangchanghangzhou/" target="_self" _soj="SearchBar">万达广场</a>
                          <a title="古墩路" alt="古墩路" href="https://hz.sydc.anjuke.com/xzl-zu/xihuqu-gudunlu/" target="_self" _soj="SearchBar">古墩路</a>
                          <a title="景芳" alt="景芳" href="https://hz.sydc.anjuke.com/xzl-zu/jianggan-jingfang/" target="_self" _soj="SearchBar">景芳</a>
                          <a title="金沙湖" alt="金沙湖" href="https://hz.sydc.anjuke.com/xzl-zu/qtxq-jshhz/" target="_self" _soj="SearchBar">金沙湖</a>
                          <a title="滨江周边" alt="滨江周边" href="https://hz.sydc.anjuke.com/xzl-zu/binjiang-binjiangqu/" target="_self" _soj="SearchBar">滨江周边</a>
                          <a title="九堡科技园" alt="九堡科技园" href="https://hz.sydc.anjuke.com/xzl-zu/jianggan-jbkjyhz/" target="_self" _soj="SearchBar">九堡科技园</a>
                          <a title="西溪" alt="西溪" href="https://hz.sydc.anjuke.com/xzl-zu/xihuqu-xixi/" target="_self" _soj="SearchBar">西溪</a>
                          <a title="北干" alt="北干" href="https://hz.sydc.anjuke.com/xzl-zu/xiaoshan-beigan/" target="_self" _soj="SearchBar">北干</a>
                          <a title="四桥南" alt="四桥南" href="https://hz.sydc.anjuke.com/xzl-zu/binjiang-sqnhz/" target="_self" _soj="SearchBar">四桥南</a>
                        </div>
                    </div>
                </div>

                <!-- 买写字楼 -->
                <div style="display: none" class="tab-contents clearfix" id="content_Rd4">

                    <div class="details float_l">
                        <p>热门区域</p>
                        <div class="areas">
                            <a title="江干" alt="江干" class="hot-word" href="https://hz.sydc.anjuke.com/xzl-shou/jianggan/" target="_self" _soj="SearchBar">江干</a>
                            <a title="西湖" alt="西湖" class="hot-word" href="https://hz.sydc.anjuke.com/xzl-shou/xihuqu/" target="_self" _soj="SearchBar">西湖</a>
                            <a title="余杭" alt="余杭" class="hot-word" href="https://hz.sydc.anjuke.com/xzl-shou/yuhang/" target="_self" _soj="SearchBar">余杭</a>
                            <a title="萧山" alt="萧山" href="https://hz.sydc.anjuke.com/xzl-shou/xiaoshan/" target="_self" _soj="SearchBar">萧山</a>
                            <a title="滨江" alt="滨江" href="https://hz.sydc.anjuke.com/xzl-shou/binjiang/" target="_self" _soj="SearchBar">滨江</a>
                            <a title="拱墅" alt="拱墅" href="https://hz.sydc.anjuke.com/xzl-shou/gongshu/" target="_self" _soj="SearchBar">拱墅</a>
                            <a title="上城" alt="上城" href="https://hz.sydc.anjuke.com/xzl-shou/hzshangcheng/" target="_self" _soj="SearchBar">上城</a>
                            <a title="下城" alt="下城" href="https://hz.sydc.anjuke.com/xzl-shou/xiacheng/" target="_self" _soj="SearchBar">下城</a>
                            <a title="临安" alt="临安" href="https://hz.sydc.anjuke.com/xzl-shou/linanshi/" target="_self" _soj="SearchBar">临安</a>
                            <a title="钱塘新区" alt="钱塘新区" href="https://hz.sydc.anjuke.com/xzl-shou/qtxq/" target="_self" _soj="SearchBar">钱塘新区</a>
                            <a title="富阳" alt="富阳" href="https://hz.sydc.anjuke.com/xzl-shou/fuyangshi/" target="_self" _soj="SearchBar">富阳</a>
                            <a title="杭州周边" alt="杭州周边" href="https://hz.sydc.anjuke.com/xzl-shou/hangzhou/" target="_self" _soj="SearchBar">杭州周边</a>
                            <a title="桐庐" alt="桐庐" href="https://hz.sydc.anjuke.com/xzl-shou/tonglu/" target="_self" _soj="SearchBar">桐庐</a>
                            <a title="淳安" alt="淳安" href="https://hz.sydc.anjuke.com/xzl-shou/chunan/" target="_self" _soj="SearchBar">淳安</a>
                            <a title="建德" alt="建德" href="https://hz.sydc.anjuke.com/xzl-shou/jiandeshi/" target="_self" _soj="SearchBar">建德</a>
                        </div>
                    </div>
                    <i class="solid-line line-mag float_l" style="height: 121px"></i>
                    <div class="details float_l">
                        <p>热门板块</p>
                        <div class="areas">
                            <a title="钱江世纪城" alt="钱江世纪城" class="hot-word" href="https://hz.sydc.anjuke.com/xzl-shou/xiaoshan-qianjiangsjc/" target="_self" _soj="SearchBar">钱江世纪城</a>
                            <a title="钱江新城" alt="钱江新城" class="hot-word" href="https://hz.sydc.anjuke.com/xzl-shou/jianggan-qianjiangxc/" target="_self" _soj="SearchBar">钱江新城</a>
                            <a title="未来科技城" alt="未来科技城" class="hot-word" href="https://hz.sydc.anjuke.com/xzl-shou/yuhang-weilaikejicheng/" target="_self" _soj="SearchBar">未来科技城</a>
                            <a title="区政府" alt="区政府" href="https://hz.sydc.anjuke.com/xzl-shou/binjiang-quzhengfuhz/" target="_self" _soj="SearchBar">区政府</a>
                            <a title="临平" alt="临平" href="https://hz.sydc.anjuke.com/xzl-shou/yuhang-linping/" target="_self" _soj="SearchBar">临平</a>
                            <a title="西溪" alt="西溪" href="https://hz.sydc.anjuke.com/xzl-shou/xihuqu-xixi/" target="_self" _soj="SearchBar">西溪</a>
                            <a title="西湖三墩" alt="西湖三墩" href="https://hz.sydc.anjuke.com/xzl-shou/xihuqu-xhsandun/" target="_self" _soj="SearchBar">西湖三墩</a>
                            <a title="城厢" alt="城厢" href="https://hz.sydc.anjuke.com/xzl-shou/xiaoshan-chengxiang/" target="_self" _soj="SearchBar">城厢</a>
                            <a title="北干" alt="北干" href="https://hz.sydc.anjuke.com/xzl-shou/xiaoshan-beigan/" target="_self" _soj="SearchBar">北干</a>
                            <a title="临安城区" alt="临安城区" href="https://hz.sydc.anjuke.com/xzl-shou/linanshi-linanchenqu/" target="_self" _soj="SearchBar">临安城区</a>
                            <a title="西兴" alt="西兴" href="https://hz.sydc.anjuke.com/xzl-shou/binjiang-xixing/" target="_self" _soj="SearchBar">西兴</a>
                            <a title="万达广场" alt="万达广场" href="https://hz.sydc.anjuke.com/xzl-shou/gongshu-wandaguangchanghangzhou/" target="_self" _soj="SearchBar">万达广场</a>
                            <a title="南星" alt="南星" href="https://hz.sydc.anjuke.com/xzl-shou/hzshangcheng-nanxing/" target="_self" _soj="SearchBar">南星</a>
                            <a title="西湖" alt="西湖" href="https://hz.sydc.anjuke.com/xzl-shou/xihuqu-xihujingqu/" target="_self" _soj="SearchBar">西湖</a>
                            <a title="景芳" alt="景芳" href="https://hz.sydc.anjuke.com/xzl-shou/jianggan-jingfang/" target="_self" _soj="SearchBar">景芳</a>
                            <a title="申花" alt="申花" href="https://hz.sydc.anjuke.com/xzl-shou/gongshu-shenghuags/" target="_self" _soj="SearchBar">申花</a>
                            <a title="小营" alt="小营" href="https://hz.sydc.anjuke.com/xzl-shou/hzshangcheng-xiaoyinghz/" target="_self" _soj="SearchBar">小营</a>
                            <a title="黄龙" alt="黄龙" href="https://hz.sydc.anjuke.com/xzl-shou/xihuqu-hzhuanglong/" target="_self" _soj="SearchBar">黄龙</a>
                        </div>
                    </div>
                </div>
                <!-- end买写字楼 -->
                <!-- 买商铺 -->
                <div style="display: none" class="tab-contents clearfix" id="content_Rd6">

                    <div class="details float_l">
                        <p>热门区域</p>
                        <div class="areas">
                            <a title="上城" alt="上城" class="hot-word" href="https://hz.sydc.anjuke.com/sp-shou/hzshangcheng/" target="_self" _soj="SearchBar">上城</a>
                            <a title="西湖" alt="西湖" class="hot-word" href="https://hz.sydc.anjuke.com/sp-shou/xihuqu/" target="_self" _soj="SearchBar">西湖</a>
                            <a title="余杭" alt="余杭" class="hot-word" href="https://hz.sydc.anjuke.com/sp-shou/yuhang/" target="_self" _soj="SearchBar">余杭</a>
                            <a title="萧山" alt="萧山" href="https://hz.sydc.anjuke.com/sp-shou/xiaoshan/" target="_self" _soj="SearchBar">萧山</a>
                            <a title="江干" alt="江干" href="https://hz.sydc.anjuke.com/sp-shou/jianggan/" target="_self" _soj="SearchBar">江干</a>
                            <a title="滨江" alt="滨江" href="https://hz.sydc.anjuke.com/sp-shou/binjiang/" target="_self" _soj="SearchBar">滨江</a>
                            <a title="拱墅" alt="拱墅" href="https://hz.sydc.anjuke.com/sp-shou/gongshu/" target="_self" _soj="SearchBar">拱墅</a>
                            <a title="下城" alt="下城" href="https://hz.sydc.anjuke.com/sp-shou/xiacheng/" target="_self" _soj="SearchBar">下城</a>
                            <a title="钱塘新区" alt="钱塘新区" href="https://hz.sydc.anjuke.com/sp-shou/qtxq/" target="_self" _soj="SearchBar">钱塘新区</a>
                            <a title="临安" alt="临安" href="https://hz.sydc.anjuke.com/sp-shou/linanshi/" target="_self" _soj="SearchBar">临安</a>
                            <a title="富阳" alt="富阳" href="https://hz.sydc.anjuke.com/sp-shou/fuyangshi/" target="_self" _soj="SearchBar">富阳</a>
                            <a title="杭州周边" alt="杭州周边" href="https://hz.sydc.anjuke.com/sp-shou/hangzhou/" target="_self" _soj="SearchBar">杭州周边</a>
                            <a title="桐庐" alt="桐庐" href="https://hz.sydc.anjuke.com/sp-shou/tonglu/" target="_self" _soj="SearchBar">桐庐</a>
                            <a title="淳安" alt="淳安" href="https://hz.sydc.anjuke.com/sp-shou/chunan/" target="_self" _soj="SearchBar">淳安</a>
                            <a title="建德" alt="建德" href="https://hz.sydc.anjuke.com/sp-shou/jiandeshi/" target="_self" _soj="SearchBar">建德</a>
                        </div>
                    </div>
                    <i class="solid-line line-mag float_l" style="height: 121px"></i>
                    <div class="details float_l">
                        <p>热门板块</p>
                        <div class="areas">
                            <a title="西湖" alt="西湖" class="hot-word" href="https://hz.sydc.anjuke.com/sp-shou/xihuqu-xihujingqu/" target="_self" _soj="SearchBar">西湖</a>
                            <a title="湖滨" alt="湖滨" class="hot-word" href="https://hz.sydc.anjuke.com/sp-shou/hzshangcheng-hubin/" target="_self" _soj="SearchBar">湖滨</a>
                            <a title="临平" alt="临平" class="hot-word" href="https://hz.sydc.anjuke.com/sp-shou/yuhang-linping/" target="_self" _soj="SearchBar">临平</a>
                            <a title="区政府" alt="区政府" href="https://hz.sydc.anjuke.com/sp-shou/binjiang-quzhengfuhz/" target="_self" _soj="SearchBar">区政府</a>
                            <a title="未来科技城" alt="未来科技城" href="https://hz.sydc.anjuke.com/sp-shou/yuhang-weilaikejicheng/" target="_self" _soj="SearchBar">未来科技城</a>
                            <a title="城厢" alt="城厢" href="https://hz.sydc.anjuke.com/sp-shou/xiaoshan-chengxiang/" target="_self" _soj="SearchBar">城厢</a>
                            <a title="龙翔附近" alt="龙翔附近" href="https://hz.sydc.anjuke.com/sp-shou/hzshangcheng-hzlxfj/" target="_self" _soj="SearchBar">龙翔附近</a>
                            <a title="拱墅周边" alt="拱墅周边" href="https://hz.sydc.anjuke.com/sp-shou/gongshu-gongshuqu/" target="_self" _soj="SearchBar">拱墅周边</a>
                            <a title="凤起" alt="凤起" href="https://hz.sydc.anjuke.com/sp-shou/xiacheng-fengqi/" target="_self" _soj="SearchBar">凤起</a>
                            <a title="吴山/清波门" alt="吴山/清波门" href="https://hz.sydc.anjuke.com/sp-shou/hzshangcheng-wushanhz/" target="_self" _soj="SearchBar">吴山/清波门</a>
                            <a title="北干" alt="北干" href="https://hz.sydc.anjuke.com/sp-shou/xiaoshan-beigan/" target="_self" _soj="SearchBar">北干</a>
                            <a title="大关" alt="大关" href="https://hz.sydc.anjuke.com/sp-shou/gongshu-daguan/" target="_self" _soj="SearchBar">大关</a>
                            <a title="西湖三墩" alt="西湖三墩" href="https://hz.sydc.anjuke.com/sp-shou/xihuqu-xhsandun/" target="_self" _soj="SearchBar">西湖三墩</a>
                            <a title="钱江世纪城" alt="钱江世纪城" href="https://hz.sydc.anjuke.com/sp-shou/xiaoshan-qianjiangsjc/" target="_self" _soj="SearchBar">钱江世纪城</a>
                            <a title="长河" alt="长河" href="https://hz.sydc.anjuke.com/sp-shou/binjiang-hzchanghe/" target="_self" _soj="SearchBar">长河</a>
                            <a title="西兴" alt="西兴" href="https://hz.sydc.anjuke.com/sp-shou/binjiang-xixing/" target="_self" _soj="SearchBar">西兴</a>
                            <a title="临安城区" alt="临安城区" href="https://hz.sydc.anjuke.com/sp-shou/linanshi-linanchenqu/" target="_self" _soj="SearchBar">临安城区</a>
                            <a title="老余杭" alt="老余杭" href="https://hz.sydc.anjuke.com/sp-shou/yuhang-laoyuhang/" target="_self" _soj="SearchBar">老余杭</a>
                        </div>
                    </div>
                </div>
                <!-- end买商铺 -->

                <!-- 租商铺 -->
                <div style="display: none" class="tab-contents clearfix" id="content_Rd7">

                    <div class="details float_l">
                        <p>热门区域</p>
                        <div class="areas">
                            <a title="西湖" alt="西湖" class="hot-word" href="https://hz.sydc.anjuke.com/sp-zu/xihuqu/" target="_self" _soj="SearchBar">西湖</a>
                            <a title="滨江" alt="滨江" class="hot-word" href="https://hz.sydc.anjuke.com/sp-zu/binjiang/" target="_self" _soj="SearchBar">滨江</a>
                            <a title="余杭" alt="余杭" class="hot-word" href="https://hz.sydc.anjuke.com/sp-zu/yuhang/" target="_self" _soj="SearchBar">余杭</a>
                            <a title="江干" alt="江干" href="https://hz.sydc.anjuke.com/sp-zu/jianggan/" target="_self" _soj="SearchBar">江干</a>
                            <a title="下城" alt="下城" href="https://hz.sydc.anjuke.com/sp-zu/xiacheng/" target="_self" _soj="SearchBar">下城</a>
                            <a title="拱墅" alt="拱墅" href="https://hz.sydc.anjuke.com/sp-zu/gongshu/" target="_self" _soj="SearchBar">拱墅</a>
                            <a title="上城" alt="上城" href="https://hz.sydc.anjuke.com/sp-zu/hzshangcheng/" target="_self" _soj="SearchBar">上城</a>
                            <a title="萧山" alt="萧山" href="https://hz.sydc.anjuke.com/sp-zu/xiaoshan/" target="_self" _soj="SearchBar">萧山</a>
                            <a title="钱塘新区" alt="钱塘新区" href="https://hz.sydc.anjuke.com/sp-zu/qtxq/" target="_self" _soj="SearchBar">钱塘新区</a>
                            <a title="临安" alt="临安" href="https://hz.sydc.anjuke.com/sp-zu/linanshi/" target="_self" _soj="SearchBar">临安</a>
                            <a title="富阳" alt="富阳" href="https://hz.sydc.anjuke.com/sp-zu/fuyangshi/" target="_self" _soj="SearchBar">富阳</a>
                            <a title="桐庐" alt="桐庐" href="https://hz.sydc.anjuke.com/sp-zu/tonglu/" target="_self" _soj="SearchBar">桐庐</a>
                            <a title="淳安" alt="淳安" href="https://hz.sydc.anjuke.com/sp-zu/chunan/" target="_self" _soj="SearchBar">淳安</a>
                            <a title="杭州周边" alt="杭州周边" href="https://hz.sydc.anjuke.com/sp-zu/hangzhou/" target="_self" _soj="SearchBar">杭州周边</a>
                            <a title="建德" alt="建德" href="https://hz.sydc.anjuke.com/sp-zu/jiandeshi/" target="_self" _soj="SearchBar">建德</a>
                        </div>
                    </div>
                    <i class="solid-line line-mag float_l" style="height: 121px"></i>
                    <div class="details float_l">
                        <p>热门板块</p>
                        <div class="areas">
                            <a title="区政府" alt="区政府" class="hot-word" href="https://hz.sydc.anjuke.com/sp-zu/binjiang-quzhengfuhz/" target="_self" _soj="SearchBar">区政府</a>
                            <a title="长河" alt="长河" class="hot-word" href="https://hz.sydc.anjuke.com/sp-zu/binjiang-hzchanghe/" target="_self" _soj="SearchBar">长河</a>
                            <a title="未来科技城" alt="未来科技城" class="hot-word" href="https://hz.sydc.anjuke.com/sp-zu/yuhang-weilaikejicheng/" target="_self" _soj="SearchBar">未来科技城</a>
                            <a title="临平" alt="临平" href="https://hz.sydc.anjuke.com/sp-zu/yuhang-linping/" target="_self" _soj="SearchBar">临平</a>
                            <a title="西湖三墩" alt="西湖三墩" href="https://hz.sydc.anjuke.com/sp-zu/xihuqu-xhsandun/" target="_self" _soj="SearchBar">西湖三墩</a>
                            <a title="钱江世纪城" alt="钱江世纪城" href="https://hz.sydc.anjuke.com/sp-zu/xiaoshan-qianjiangsjc/" target="_self" _soj="SearchBar">钱江世纪城</a>
                            <a title="西兴" alt="西兴" href="https://hz.sydc.anjuke.com/sp-zu/binjiang-xixing/" target="_self" _soj="SearchBar">西兴</a>
                            <a title="钱江新城" alt="钱江新城" href="https://hz.sydc.anjuke.com/sp-zu/jianggan-qianjiangxc/" target="_self" _soj="SearchBar">钱江新城</a>
                            <a title="古墩路" alt="古墩路" href="https://hz.sydc.anjuke.com/sp-zu/xihuqu-gudunlu/" target="_self" _soj="SearchBar">古墩路</a>
                            <a title="景芳" alt="景芳" href="https://hz.sydc.anjuke.com/sp-zu/jianggan-jingfang/" target="_self" _soj="SearchBar">景芳</a>
                            <a title="西湖" alt="西湖" href="https://hz.sydc.anjuke.com/sp-zu/xihuqu-xihujingqu/" target="_self" _soj="SearchBar">西湖</a>
                            <a title="翠苑" alt="翠苑" href="https://hz.sydc.anjuke.com/sp-zu/xihuqu-cuiyuan/" target="_self" _soj="SearchBar">翠苑</a>
                            <a title="武林" alt="武林" href="https://hz.sydc.anjuke.com/sp-zu/xiacheng-wulin/" target="_self" _soj="SearchBar">武林</a>
                            <a title="万达广场" alt="万达广场" href="https://hz.sydc.anjuke.com/sp-zu/gongshu-wandaguangchanghangzhou/" target="_self" _soj="SearchBar">万达广场</a>
                            <a title="北干" alt="北干" href="https://hz.sydc.anjuke.com/sp-zu/xiaoshan-beigan/" target="_self" _soj="SearchBar">北干</a>
                            <a title="湖滨" alt="湖滨" href="https://hz.sydc.anjuke.com/sp-zu/hzshangcheng-hubin/" target="_self" _soj="SearchBar">湖滨</a>
                            <a title="紫金港" alt="紫金港" href="https://hz.sydc.anjuke.com/sp-zu/xihuqu-zijingang/" target="_self" _soj="SearchBar">紫金港</a>
                            <a title="城厢" alt="城厢" href="https://hz.sydc.anjuke.com/sp-zu/xiaoshan-chengxiang/" target="_self" _soj="SearchBar">城厢</a>
                        </div>
                    </div>
                </div>
                <!-- end商业地产 -->
                <!-- 卖房 -->
                <div style="display: none" class="tab-contents clearfix" id="content_Rd8">

                    <div class="publish">
                        <p class="saler-title">房东委托</p>
                        <!-- 卖房对应的搜索框 -->
                        <form class="search" action="https://www.anjuke.com/mobile?from=navigation" method="GET" id="commlist">
                            <input type="hidden" value="sy_tab" name="from" id="search_soj">
                            <div class="name-list">
                                <input type="text" name="kw" class="" id="salerIpt" maxlength="100" autocomplete="off" placeholder="请输入并选择小区" value="">
                            </div>
                            <a href="javascript:;" style="position: relative"><i class="sale-btn-icon"></i><input hidefocus="true" id="salerSubmit" type="submit" class="free-pub" value="免费发布房源"></a>
                        </form>
                    </div>
                    <div class="steps">
                        <ul>
                            <li>
                                <i>1</i>
                                <p>在安居客发房</p>
                                <em>简单2步即可完成发布，方便<br>快捷免费！</em>
                            </li>
                            <li>
                                <i>2</i>
                                <p>优质经纪人全程服务</p>
                                <em>我们挑选优质经纪人为您服<br>务，拒绝骚扰</em>
                            </li>
                            <li>
                                <i>3</i>
                                <p>大量买家</p>
                                <em>优质经纪人协助您完成办理手续</em>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- end卖房 -->
        </div>
        </div>
        <a style="display: block;height: 0px;font-size: 0px;line-height: 0px" data-trace="{Anjuke_home_Property_viewed_SearchBar:1}"></a>
    </div>
    <!-- //welcome -->
    <div class="welcome"> 
      <div class="container"> 
        <div class="welcome-info">
          <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
            <ul id="myTab" class=" nav-tabs" role="tablist">
              <li role="presentation"><router-link to="/classify" id="home-tab" role="tab" data-toggle="tab" >
                <i class="fa fa-laptop" aria-hidden="true" style="color:#5b91f2"></i> 
                <h5>Web网站</h5>
              </router-link></li>
              <li role="presentation"><router-link to="/classify" role="tab" id="carl-tab" data-toggle="tab"> 
                <i class="fa fa-mobile" aria-hidden="true" style="color:#f57df5"></i>
                <h5>App开发</h5>
              </router-link></li>
              <li role="presentation"><router-link to="/classify" role="tab" id="james-tab" data-toggle="tab"> 
                <i class="fa fa-book" aria-hidden="true"></i>
                <h5>微信公众号</h5>
              </router-link></li>
              <li role="presentation"><router-link to="/classify" role="tab" id="decor-tab" data-toggle="tab"> 
                <i class="fa fa-html5" aria-hidden="true" style="color:#5b91f2"></i>
                <h5>HTML5 应用</h5>
              </router-link></li>
              <li role="presentation"><router-link to="/classify" role="tab" id="sports-tab" data-toggle="tab"> 
                <i class="fa fa-weixin" aria-hidden="true"></i>
                <h5>小程序</h5>
              </router-link></li>
            </ul>
            <div class="clearfix"> </div>  
          </div>  
        </div>  	
      </div>  	
    </div> <!-- //welcome -->
    <div class="process-page">
        <div class="process-title">发猿地交易与服务流程</div>
        <div class="process-content content-web">
            <div class="content-text">
                <div class="publish-number">// 01</div>
                <div class="publish-title">发布需求</div>
                <div class="publish-desc">不知道项目如何报价？<br>
                    在这里，3分钟自动估算。<br>
                    覆盖 App、Web、HTML5、微信公众号等常用功能。
                </div>
                <div class="publish-link">
                    <a href="/quote">查看项目报价</a>
                </div>
            </div>
            <div class="content-img">
                <img src="../../assets/index-content-slice-1@2x.png" height="260">
            </div>
        </div>
        <div class="process-content">
            <div class="content-img">
                <img src="../../assets/index-content-slice-2@2x-new.png" height="260">
            </div>
            <div class="content-text">
                <div class="publish-number">// 02</div>
                <div class="publish-title">确认合作</div>
                <div class="publish-desc">海量开发者，技能多样化，<br>
                    实现技能需求匹配，<br>
                    确认合作开发者。
                </div>
            </div>
        </div>
        <div class="process-content content-web">
            <div class="content-text">
                <div class="publish-number">// 03</div>
                <div class="publish-title">资金托管</div>
                <div class="publish-desc">项目款分阶段托管，自助验收支付开发者。<br>
                    高达 1000 万元保险赔付机制，<br>
                    全方位保障开发进度。
                </div>
            </div>
            <div class="content-img">
                <img src="../../assets/index-content-slice-3@2x.png" height="260">
            </div>
        </div>
        <div class="process-content">
            <div class="content-img">
                <img src="../../assets/index-content-slice-4@2x.png" height="260">
            </div>
            <div class="content-text">
                <div class="publish-number">// 04</div>
                <div class="publish-title">无忧交付</div>
                <div class="publish-desc">云计算软件协作工具 Coding.net，<br>
                    提供代码托管、文档管理、代码质量报告等，<br>
                    让项目过程的每一步都有迹可循，随时监管。
                </div>
                <div class="publish-link">
                    <a href="https://coding.net">使用 Coding.net</a>
                </div>
            </div>
        </div>
        <div class="process-content last-content content-web">
            <div class="content-text">
                <div class="publish-number">// 05</div>
                <div class="publish-title">无忧质保</div>
                <div class="publish-desc">项目质保期内，开发者义务修复BUG及调优，<br>
                    保障运营无忧。
                </div>
            </div>
            <div class="content-img">
                <img src="../../assets/index-content-slice-5@2x.png" height="260">
            </div>
        </div>
    </div>	
  </div>
</template>

<script>
import img_404 from "@/assets/404_images/404.png";
import img_404_cloud from "@/assets/404_images/404_cloud.png";
import img_3 from "@/assets/indexImage/3.jpg";
import img_5 from "@/assets/indexImage/5.jpg";
import img_8 from "@/assets/indexImage/8.jpg";
import img_4 from "@/assets/indexImage/parallax-bg.jpg";
import img_6 from "@/assets/indexImage/slider.jpg";
import SNavBar from '@/components/NavBar/studio';
import CNavBar from '@/components/NavBar/company';
import VNavBar from '@/components/NavBar/viewer';

import $ from 'jquery';

export default {
  name:'index',
  data() {
    return {
      img_404,
      img_404_cloud,
      img_3,
      img_5,
      img_8,
      img_4,
      img_6,
      roles: [{
          value: '3',
          label: '企业'
        }, {
          value: '2',
          label: '工作室'
        }],
      value: '',
      loginForm: {
          username: '',
          password: '',
          roleId: ''
        },
      registerForm: {
        username:'',
        password:'',
        passwordAgain:'',
        email:'',
        address:'',
        telephone:'',
        roleId:'',
        unitName:'',
        },
      tempUser: {
        username: '',
        password: '',
        mail: '',
        roleId: '',
        userId: ''
      },
      user: {
        username:'',
        unitName: '',
        },
      loginRules: {
        username: [{required: true, trigger: 'blur', message: "请输入用户名"}],
        password: [{required: true, trigger: 'blur', message: "请输入密码"}]
      },
      loading: false,
      isLogined: false,
      dialogStatus: 'login',
      dialogFormVisible1: false,
      dialogFormVisible2: false,
      textMap: {
        login: '登录',
        register: '注册'
      },
      checked: true
    };
  },
  methods: {
    showLogin() {
        // let user;
        // this.loginForm.username = "";
        // this.loginForm.password = "";
        this.dialogFormVisible1 = true
      },
    showRegister() {
        // let user;
        this.tempUser.username = "";
        this.tempUser.password = "";
        this.dialogStatus = 'register';
        this.dialogFormVisible2 = true
    },
    getLoginInfo() {
        //查询用户信息
        this.api({
          url: "/login/getInfo",
          method: "post",
          data:this.loginForm
        }).then(data => {
          //设置了一个全局变量用来保存登录的状态
          this.$root.loginedRoleId = data.userPermission.roleId;
          //全局的登录状态为true
          this.$root.userIsLogined = true;
          this.loginForm.roleId = data.userPermission.roleId;
          this.$root.username = this.loginForm.username;
          this.user.username =  this.loginForm.username;
          this.getUserInfo();
          this.$router.push({path: '/'});
          
        })
    },
    getUserInfo() {
        //查询用户信息
        this.api({
          url: "/user/getInfo",
          method: "post",
          data:this.user
        }).then(data => {
          this.$root.unitName = data.userInfo.unit_name;
          if (this.$root.loginedRoleId == 1) {
            this.$router.push({path: '/user/companyInfoExamined'});
          } 
        }).catch(() => {
            this.$message.error("查询失败")
          })
      },
    handleLogin() {
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            this.loading = true
            this.$store.dispatch('Login', this.loginForm).then(data => {
              this.loading = false
              if ("success" === data.result) {
                this.getLoginInfo();
                // this.isLogined = true;
                this.dialogFormVisible1 = false;
              } else {
                this.$message.error("账号/密码错误");
              }
            }).catch(() => {
              this.loading = false
            })
          } else {
            return false
          }
        })
      },  
    handleRegister() {
      this.api({
        url: "/register/register",
        method: "post",
        data: this.registerForm
      }).then(data => {
        this.$message.success("注册成功！");
        this.dialogFormVisible2 = false;
      }) 
    },
    loginOut(){
      this.$confirm('您即将退出, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // this.$message({
          //   type: 'success',
          //   message: '已退出'
          // });
          this.$root.userIsLogined = false;
          this.$root.loginedRoleId = -1;
        }).catch(() => {
          // this.$message({
          //   type: 'info',
          //   message: '已取消退出'
          // });          
        });     
    }, 
  },
  computed: {
    message() {
      return "页面找不到了......";
    }
  },
  components:{SNavBar,CNavBar,VNavBar},
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
@import "~@/styles/font-awesome.css";
@import "~@/styles/bootstrap.css";
@import ".~@/styles/style.css";
@import "~@/styles/animate.min.css";
@import "~@/styles/menu.css";
@import "./index.css";
@import "~@/styles/fonts.googleapis.com1.css";
@import "~@/styles/fonts.googleapis.com2.css";
@import "~@/styles/fonts.googleapis.com3.css";

.el-carousel {
    overflow-x: hidden;
    position: relative;
}
.el-carousel__container {
    position: relative;
    height: 500px;
}
.el-carousel__item h3 {
    color: #a6a7a8;
    font-size: 18px;
    opacity: 0.3;
    line-height: 500px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
    opacity: 0.3;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
    opacity: 0.3;
  }
  .el-carousel__container {
    position: relative;
    height: 500px;
}
.el-dialog__title {
    line-height: 24px;
    font-size: 18px;
    color: #303133;
    float: right;
}
.el-button {
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    background: transparent;
    border-color: transparent;
    color: #fff;
    -webkit-appearance: none;
    text-align: center;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    outline: 0;
    margin: 0;
    -webkit-transition: .1s;
    transition: .1s;
    padding: 12px 20px;
    font-size: 13px;
    border-radius: 4px;
}
.el-button:hover {
    background: #dae7f5;
    border-color: #fFF;
    color: #000;
}
.btn-default {
  width: 40px;
  height: 40px;
  border: none;
  position: absolute;
  top: 0.5px;
  outline: none;
  box-shadow: none;
  padding: 0;
  border-radius: inherit;
  -webkit-appearance: none;
  -webkit-transition: .5s all;
  -moz-transition: .5s all;
  transition: .5s all;
  background: transparent;
}
.search2 {
  width: 80%;
  padding: 0.5em 2em 0.5em 1em;
    font-size: 1em;
    color: #999;
    outline: none;
    border: 1px solid #cccccc;
    background: none;
    -webkit-appearance: none;
    transition: 0.5s all;
    border-radius: 20px;
    -webkit-transition: 0.5s all;  
}
.w3ls-header {
    background: transparent;
    padding: 2em 2em;
} 
.wscn-http404 {
  position: relative;
  width: 1200px;
  margin: 20px auto 60px;
  padding: 0 100px;
  overflow: hidden;
  .pic-404 {
    position: relative;
    float: left;
    width: 600px;
    padding: 150px 0;
    overflow: hidden;
    &__parent {
      width: 100%;
    }
    &__child {
      position: absolute;
      &.left {
        width: 80px;
        top: 17px;
        left: 220px;
        opacity: 0;
        animation-name: cloudLeft;
        animation-duration: 2s;
        animation-timing-function: linear;
        animation-fill-mode: forwards;
        animation-delay: 1s;
      }
      &.mid {
        width: 46px;
        top: 10px;
        left: 420px;
        opacity: 0;
        animation-name: cloudMid;
        animation-duration: 2s;
        animation-timing-function: linear;
        animation-fill-mode: forwards;
        animation-delay: 1.2s;
      }
      &.right {
        width: 62px;
        top: 100px;
        left: 500px;
        opacity: 0;
        animation-name: cloudRight;
        animation-duration: 2s;
        animation-timing-function: linear;
        animation-fill-mode: forwards;
        animation-delay: 1s;
      }
      @keyframes cloudLeft {
        0% {
          top: 17px;
          left: 220px;
          opacity: 0;
        }
        20% {
          top: 33px;
          left: 188px;
          opacity: 1;
        }
        80% {
          top: 81px;
          left: 92px;
          opacity: 1;
        }
        100% {
          top: 97px;
          left: 60px;
          opacity: 0;
        }
      }
      @keyframes cloudMid {
        0% {
          top: 10px;
          left: 420px;
          opacity: 0;
        }
        20% {
          top: 40px;
          left: 360px;
          opacity: 1;
        }
        70% {
          top: 130px;
          left: 180px;
          opacity: 1;
        }
        100% {
          top: 160px;
          left: 120px;
          opacity: 0;
        }
      }
      @keyframes cloudRight {
        0% {
          top: 100px;
          left: 500px;
          opacity: 0;
        }
        20% {
          top: 120px;
          left: 460px;
          opacity: 1;
        }
        80% {
          top: 180px;
          left: 340px;
          opacity: 1;
        }
        100% {
          top: 200px;
          left: 300px;
          opacity: 0;
        }
      }
    }
  }
  .bullshit {
    position: relative;
    float: left;
    width: 300px;
    padding: 150px 0;
    overflow: hidden;
    &__oops {
      font-size: 32px;
      font-weight: bold;
      line-height: 40px;
      color: #1482f0;
      opacity: 0;
      margin-bottom: 20px;
      animation-name: slideUp;
      animation-duration: 0.5s;
      animation-fill-mode: forwards;
    }
    &__headline {
      font-size: 20px;
      line-height: 24px;
      color: #1482f0;
      opacity: 0;
      margin-bottom: 10px;
      animation-name: slideUp;
      animation-duration: 0.5s;
      animation-delay: 0.1s;
      animation-fill-mode: forwards;
    }
    &__info {
      font-size: 13px;
      line-height: 21px;
      color: grey;
      opacity: 0;
      margin-bottom: 30px;
      animation-name: slideUp;
      animation-duration: 0.5s;
      animation-delay: 0.2s;
      animation-fill-mode: forwards;
    }
    &__return-home {
      display: block;
      float: left;
      width: 110px;
      height: 36px;
      background: #1482f0;
      border-radius: 100px;
      text-align: center;
      color: #ffffff;
      opacity: 0;
      font-size: 14px;
      line-height: 36px;
      cursor: pointer;
      animation-name: slideUp;
      animation-duration: 0.5s;
      animation-delay: 0.3s;
      animation-fill-mode: forwards;
    }
    @keyframes slideUp {
      0% {
        transform: translateY(60px);
        opacity: 0;
      }
      100% {
        transform: translateY(0);
        opacity: 1;
      }
    }
  }
}
.process-page {
    text-align: center;
    margin-right: auto;
    margin-left: auto;
    padding-top: 4rem;
    font-family: "PingFang SC","Helvetica Neue",Helvetica,"Hiragino Sans GB",Arial,"Microsoft YaHei","微软雅黑",sans-serif,"Segoe UI Emoji","Segoe UI Symbol";
  }
.process-title {
    font-size: 3.5rem;
    color: #2D3238;
    letter-spacing: 0;
  }
.process-content{
    width: 60rem;
    height: 20rem;
    display: table;
    table-layout: fixed;
    margin-left: auto;
    margin-right: auto;
    text-align: center;
    border-bottom: 1px solid rgba(151,159,168,.2);
  }
.content-web {
    display: table;
  }
.content-text {
    display: table-cell;
    width: 40%;
    vertical-align: middle;
  }
.publish-number{
    text-align: left;
    margin-bottom: .5rem;
    font-size: 1rem;
    color: #2D3238;
  }
.publish-title{
    font-size: 2rem;
    color: #2D3238;
    letter-spacing: 0;
    text-align: left;
  }
.publish-desc{
    font-size: 1rem;
    color: #979FA8;
    line-height: 21px;
    margin-bottom: 1rem;
    margin-top: 1rem;
    text-align: left;
  }
.publish-link{
    font-size: 1rem;
    color: #4289DB;
    letter-spacing: 0;
    text-align: left;
    margin-bottom: 0;
  }
.content-img{
    display: table-cell;
    width: 60%;
    vertical-align: middle;
  }
.content-phone{
    display: none;
  }
.last-content{
    border-bottom: none;
  }
 h3.w3ls-title.w3ls-title2 {
    // text-align: center;
    margin: 0 6em 1em;
	  font-size: 2.5em;
  }
  .login-body2 {
    padding: 3em;
    background-color: #fff;
    -webkit-box-shadow:0px 0px 4px 1px rgb(189, 189, 189);
    -moz-box-shadow:0px 0px 4px 1px rgb(189, 189, 189);
    -o-box-shadow:0px 0px 4px 1px rgb(189, 189, 189);
    -ms-box-shadow:0px 0px 4px 1px rgb(189, 189, 189);
    box-shadow:0px 0px 0px 0px rgb(189, 189, 189);
    width: 40%;
    margin: 0.5em 2.5em 0;
  }
  .login-page el-form {
      position: absolute;
      left: 0;
      right: 0;
      width: 400px;
      padding: 35px 35px 15px 35px;
      margin: 120px auto;
    }
  .login-page el-input[type="text"], .login-page el-input[type="password"] {
    font-size: 1em;
    padding: 0.9em 1em;
    width: 100%;
    color: #999;
    outline: none;
    border: 1px solid #E2DCDC;
    background: #FFFFFF;
    margin: 0 0 1em 0;
	  -webkit-transition:.5s all;
	  -moz-transition:.5s all;
  	-o-transition:.5s all;
  	-ms-transition:.5s all;
  	transition:.5s all;
  	-webkit-appearance:none;
    }
  .login-page el-input[type="submit"] {
    border: none;
    outline: none;
    cursor: pointer;
    color: #fff;
    background: #0280e1;
    width: 100%;
    padding: .8em 1em;
    font-size: 1em;
    margin: 0.5em 0 0;
    -webkit-transition:.5s all;
	  -moz-transition:.5s all;
	  -o-transition:.5s all;
  	-ms-transition:.5s all;
	  transition:.5s all;
    text-transform: uppercase;
	  -webkit-appearance:none;
    }
  .login-page el-form-item {
      border: 1px solid #E2DCDC;
      background: #FFFFFF;
      border-radius: 5px;
      color: #999;
    }
  .login-page input[type="submit"] {
    font-size: 2em;
    border: none;
    outline: none;
    cursor: pointer;
    color: #fff;
    background: #0280e1;
    width: 15%;
    padding: .6em 1em;
    font-size: 1em;
    margin: 1em -8.5em 0;
    -webkit-transition:.5s all;
	  -moz-transition:.5s all;
	  -o-transition:.5s all;
  	-ms-transition:.5s all;
	  transition:.5s all;
    text-transform: uppercase;
	  -webkit-appearance:none;
    text-align: center;
    }
  .login-page input[type="reset"] {
    font-size: 2em;
    border: none;
    outline: none;
    cursor: pointer;
    color: #fff;
    background: #0280e1;
    width: 15%;
    padding: .6em 1em;
    font-size: 1em;
    margin: 0.5em 8.5em 0;
    -webkit-transition:.5s all;
	  -moz-transition:.5s all;
	  -o-transition:.5s all;
  	-ms-transition:.5s all;
	  transition:.5s all;
    text-transform: uppercase;
	  -webkit-appearance:none;
    text-align: center;
    }
</style>
