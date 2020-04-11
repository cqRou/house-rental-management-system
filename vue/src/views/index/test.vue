<template>
  <div>
      <!-- Header Starts -->
      <div class="navbar-wrapper">
          <div class="navbar-inverse" role="navigation">
            <div class="container">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
              </div>
              <!-- Nav Starts -->
              <div class="navbar-collapse  collapse">
                <ul class="nav navbar-nav navbar-right">
                  <li class="active"><a href="index.php">Home</a></li>
                  <li><a href="about.php">About</a></li>
                  <li><a href="agents.php">Agents</a></li>         
                  <li><a href="blog.php">Blog</a></li>
                  <li><a href="contact.php">Contact</a></li>
                </ul>
              </div>
              <!-- #Nav Ends -->
            </div>
          </div>
      </div>
      <!-- #Header Starts -->

      <div class="container">
        <!-- Header Starts -->
        <div class="header">
            <a href="index.php"><img src="images/logo.png" alt="Realestate"></a>
            <ul class="pull-right">
              <li><a href="buysalerent.php">Buy</a></li>
              <li><a href="buysalerent.php">Sale</a></li>         
              <li><a href="buysalerent.php">Rent</a></li>
            </ul>
        </div>
        <!-- #Header Starts -->
      </div>

      <div class="">
          <div id="slider" class="sl-slider-wrapper">
            <div class="sl-slider">
              <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-25" data-slice2-rotation="-25" data-slice1-scale="2" data-slice2-scale="2">
                <div class="sl-slide-inner">
                  <div class="bg-img bg-img-1"></div>
                  <h2><a href="#">2 Bed Rooms and 1 Dinning Room Aparment on Sale</a></h2>
                  <blockquote>              
                  <p class="location"><span class="glyphicon glyphicon-map-marker"></span> 1890 Syndey, Australia</p>
                  <p>Until he extends the circle of his compassion to all living things, man will not himself find peace.</p>
                  <cite>$ 20,000,000</cite>
                  </blockquote>
                </div>
              </div>
              <div class="sl-slide" data-orientation="vertical" data-slice1-rotation="10" data-slice2-rotation="-15" data-slice1-scale="1.5" data-slice2-scale="1.5">
                <div class="sl-slide-inner">
                  <div class="bg-img bg-img-2"></div>
                  <h2><a href="#">2 Bed Rooms and 1 Dinning Room Aparment on Sale</a></h2>
                  <blockquote>              
                  <p class="location"><span class="glyphicon glyphicon-map-marker"></span> 1890 Syndey, Australia</p>
                  <p>Until he extends the circle of his compassion to all living things, man will not himself find peace.</p>
                  <cite>$ 20,000,000</cite>
                  </blockquote>
                </div>
              </div>
              <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="3" data-slice2-rotation="3" data-slice1-scale="2" data-slice2-scale="1">
                <div class="sl-slide-inner">
                  <div class="bg-img bg-img-3"></div>
                  <h2><a href="#">2 Bed Rooms and 1 Dinning Room Aparment on Sale</a></h2>
                  <blockquote>              
                  <p class="location"><span class="glyphicon glyphicon-map-marker"></span> 1890 Syndey, Australia</p>
                  <p>Until he extends the circle of his compassion to all living things, man will not himself find peace.</p>
                  <cite>$ 20,000,000</cite>
                  </blockquote>
                </div>
              </div> 
              <div class="sl-slide" data-orientation="vertical" data-slice1-rotation="-5" data-slice2-rotation="25" data-slice1-scale="2" data-slice2-scale="1">
                <div class="sl-slide-inner">
                  <div class="bg-img bg-img-4"></div>
                  <h2><a href="#">2 Bed Rooms and 1 Dinning Room Aparment on Sale</a></h2>
                  <blockquote>              
                  <p class="location"><span class="glyphicon glyphicon-map-marker"></span> 1890 Syndey, Australia</p>
                  <p>Until he extends the circle of his compassion to all living things, man will not himself find peace.</p>
                  <cite>$ 20,000,000</cite>
                  </blockquote>
                </div>
              </div>       
              <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-5" data-slice2-rotation="10" data-slice1-scale="2" data-slice2-scale="1">
                <div class="sl-slide-inner">
                  <div class="bg-img bg-img-5"></div>
                  <h2><a href="#">2 Bed Rooms and 1 Dinning Room Aparment on Sale</a></h2>
                  <blockquote>              
                  <p class="location"><span class="glyphicon glyphicon-map-marker"></span> 1890 Syndey, Australia</p>
                  <p>Until he extends the circle of his compassion to all living things, man will not himself find peace.</p>
                  <cite>$ 20,000,000</cite>
                  </blockquote>
                </div>
              </div>
            </div><!-- /sl-slider -->
            <nav id="nav-dots" class="nav-dots">
              <span class="nav-dot-current"></span>
              <span></span>
              <span></span>
              <span></span>
              <span></span>
            </nav>

          </div><!-- /slider-wrapper -->
      </div>

      <div class="banner-search">
        <div class="container"> 
          <!-- banner -->
          <h3>Buy, Sale & Rent</h3>
          <div class="searchbar">
            <div class="row">
              <div class="col-lg-6 col-sm-6">
                <input type="text" class="form-control" placeholder="Search of Properties">
                <div class="row">
                  <div class="col-lg-3 col-sm-3 ">
                    <select class="form-control">
                      <option>Buy</option>
                      <option>Rent</option>
                      <option>Sale</option>
                    </select>
                  </div>
                  <div class="col-lg-3 col-sm-4">
                    <select class="form-control">
                      <option>Price</option>
                      <option>$150,000 - $200,000</option>
                      <option>$200,000 - $250,000</option>
                      <option>$250,000 - $300,000</option>
                      <option>$300,000 - above</option>
                    </select>
                  </div>
                  <div class="col-lg-3 col-sm-4">
                  <select class="form-control">
                      <option>Property</option>
                      <option>Apartment</option>
                      <option>Building</option>
                      <option>Office Space</option>
                    </select>
                    </div>
                    <div class="col-lg-3 col-sm-4">
                    <button class="btn btn-success"  onclick="window.location.href='buysalerent.php'">Find Now</button>
                    </div>
                </div>
                
                
              </div>
              <div class="col-lg-5 col-lg-offset-1 col-sm-6 ">
                <p>Join now and get updated with all the properties deals.</p>
                <button class="btn btn-info"   data-toggle="modal" data-target="#loginpop">Login</button>        </div>
            </div>
          </div>
        </div>
      </div>
      <!-- banner -->
      <div class="container">
        <div class="properties-listing spacer"> <a href="buysalerent.php" class="pull-right viewall">View All Listing</a>
          <h2>Featured Properties</h2>
          <div id="owl-example" class="owl-carousel">
            <div class="properties">
              <div class="image-holder"><img src="images/properties/1.jpg" class="img-responsive" alt="properties"/>
                <div class="status sold">Sold</div>
              </div>
              <h4><a href="property-detail.php">Royal Inn</a></h4>
              <p class="price">Price: $234,900</p>
              <div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">5</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">1</span> </div>
              <a class="btn btn-primary" href="property-detail.php">View Details</a>
            </div>
            <div class="properties">
              <div class="image-holder"><img src="images/properties/2.jpg" class="img-responsive" alt="properties"/>
                <div class="status new">New</div>
              </div>
              <h4><a href="property-detail.php">Royal Inn</a></h4>
              <p class="price">Price: $234,900</p>
              <div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">5</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">1</span> </div>
              <a class="btn btn-primary" href="property-detail.php">View Details</a>
            </div>
            <div class="properties">
              <div class="image-holder"><img src="images/properties/3.jpg" class="img-responsive" alt="properties"/></div>
              <h4><a href="property-detail.php">Royal Inn</a></h4>
              <p class="price">Price: $234,900</p>
              <div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">5</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">1</span> </div>
              <a class="btn btn-primary" href="property-detail.php">View Details</a>
            </div>
            <div class="properties">
              <div class="image-holder"><img src="images/properties/4.jpg" class="img-responsive" alt="properties"/></div>
              <h4><a href="property-detail.php">Royal Inn</a></h4>
              <p class="price">Price: $234,900</p>
              <div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">5</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">1</span> </div>
              <a class="btn btn-primary" href="property-detail.php">View Details</a>
            </div>
            <div class="properties">
              <div class="image-holder"><img src="images/properties/1.jpg" class="img-responsive" alt="properties"/>
                <div class="status sold">Sold</div>
              </div>
              <h4><a href="property-detail.php">Royal Inn</a></h4>
              <p class="price">Price: $234,900</p>
              <div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">5</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">1</span> </div>
              <a class="btn btn-primary" href="property-detail.php">View Details</a>
            </div>
            <div class="properties">
              <div class="image-holder"><img src="images/properties/2.jpg" class="img-responsive" alt="properties"/>
                <div class="status sold">Sold</div>
              </div>
              <h4><a href="property-detail.php">Royal Inn</a></h4>
              <p class="price">Price: $234,900</p>
              <div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">5</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">1</span> </div>
              <a class="btn btn-primary" href="property-detail.php">View Details</a>
            </div>
            <div class="properties">
              <div class="image-holder"><img src="images/properties/3.jpg" class="img-responsive" alt="properties"/>
                <div class="status new">New</div>
              </div>
              <h4><a href="property-detail.php">Royal Inn</a></h4>
              <p class="price">Price: $234,900</p>
              <div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">5</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">1</span> </div>
              <a class="btn btn-primary" href="property-detail.php">View Details</a>
            </div>
            <div class="properties">
              <div class="image-holder"><img src="images/properties/4.jpg" class="img-responsive" alt="properties"/></div>
              <h4><a href="property-detail.php">Royal Inn</a></h4>
              <p class="price">Price: $234,900</p>
              <div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">5</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">1</span> </div>
              <a class="btn btn-primary" href="property-detail.php">View Details</a>
            </div>
            <div class="properties">
              <div class="image-holder"><img src="images/properties/1.jpg" class="img-responsive" alt="properties"/></div>
              <h4><a href="property-detail.php">Royal Inn</a></h4>
              <p class="price">Price: $234,900</p>
              <div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">5</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">1</span> </div>
              <a class="btn btn-primary" href="property-detail.php">View Details</a>
            </div>
            <div class="properties">
              <div class="image-holder"><img src="images/properties/2.jpg" class="img-responsive" alt="properties"/></div>
              <h4><a href="property-detail.php">Royal Inn</a></h4>
              <p class="price">Price: $234,900</p>
              <div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">5</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">1</span> </div>
              <a class="btn btn-primary" href="property-detail.php">View Details</a>
            </div>
            <div class="properties">
              <div class="image-holder"><img src="images/properties/3.jpg" class="img-responsive" alt="properties"/></div>
              <h4><a href="property-detail.php">Royal Inn</a></h4>
              <p class="price">Price: $234,900</p>
              <div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">5</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">1</span> </div>
              <a class="btn btn-primary" href="property-detail.php">View Details</a>
            </div>     
          </div>
        </div>
        <div class="spacer">
          <div class="row">
            <div class="col-lg-6 col-sm-9 recent-view">
              <h3>About Us</h3>
              <p>The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.<br><a href="about.php">Learn More</a></p> 
            </div>
            <div class="col-lg-5 col-lg-offset-1 col-sm-3 recommended">
              <h3>Recommended Properties</h3>
              <div id="myCarousel" class="carousel slide">
                <ol class="carousel-indicators">
                  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                  <li data-target="#myCarousel" data-slide-to="1" class=""></li>
                  <li data-target="#myCarousel" data-slide-to="2" class=""></li>
                  <li data-target="#myCarousel" data-slide-to="3" class=""></li>
                </ol>
                <!-- Carousel items -->
                <div class="carousel-inner">
                  <div class="item active">
                    <div class="row">
                      <div class="col-lg-4"><img src="images/properties/1.jpg" class="img-responsive" alt="properties"/></div>
                      <div class="col-lg-8">
                        <h5><a href="property-detail.php">Integer sed porta quam</a></h5>
                        <p class="price">$300,000</p>
                        <a href="property-detail.php" class="more">More Detail</a> </div>
                    </div>
                  </div>
                  <div class="item">
                    <div class="row">
                      <div class="col-lg-4"><img src="images/properties/2.jpg" class="img-responsive" alt="properties"/></div>
                      <div class="col-lg-8">
                        <h5><a href="property-detail.php">Integer sed porta quam</a></h5>
                        <p class="price">$300,000</p>
                        <a href="property-detail.php" class="more">More Detail</a> </div>
                    </div>
                  </div>
                  <div class="item">
                    <div class="row">
                      <div class="col-lg-4"><img src="images/properties/3.jpg" class="img-responsive" alt="properties"/></div>
                      <div class="col-lg-8">
                        <h5><a href="property-detail.php">Integer sed porta quam</a></h5>
                        <p class="price">$300,000</p>
                        <a href="property-detail.php" class="more">More Detail</a> </div>
                    </div>
                  </div>
                  <div class="item">
                    <div class="row">
                      <div class="col-lg-4"><img src="images/properties/4.jpg" class="img-responsive" alt="properties"/></div>
                      <div class="col-lg-8">
                        <h5><a href="property-detail.php">Integer sed porta quam</a></h5>
                        <p class="price">$300,000</p>
                        <a href="property-detail.php" class="more">More Detail</a> </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    <!-- <div class="footer">

      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-sm-3">
            <h4>Information</h4>
            <ul class="row">
              <li class="col-lg-12 col-sm-12 col-xs-3"><a href="about.php">About</a></li>
              <li class="col-lg-12 col-sm-12 col-xs-3"><a href="agents.php">Agents</a></li>         
              <li class="col-lg-12 col-sm-12 col-xs-3"><a href="blog.php">Blog</a></li>
              <li class="col-lg-12 col-sm-12 col-xs-3"><a href="contact.php">Contact</a></li>
            </ul>
          </div>
          <div class="col-lg-3 col-sm-3">
            <h4>Newsletter</h4>
            <p>Get notified about the latest properties in our marketplace.</p>
            <form class="form-inline" role="form">
              <input type="text" placeholder="Enter Your email address" class="form-control">
              <button class="btn btn-success" type="button">Notify Me!</button>
            </form>
          </div>    
          <div class="col-lg-3 col-sm-3">
            <h4>Follow us</h4>
            <a href="#"><img src="images/facebook.png" alt="facebook"></a>
            <a href="#"><img src="images/twitter.png" alt="twitter"></a>
            <a href="#"><img src="images/linkedin.png" alt="linkedin"></a>
            <a href="#"><img src="images/instagram.png" alt="instagram"></a>
          </div>
          <div class="col-lg-3 col-sm-3">
            <h4>Contact us</h4>
            <p><b>Bootstrap Realestate Inc.</b><br>
            <span class="glyphicon glyphicon-map-marker"></span> 8290 Walk Street, Australia <br>
            <span class="glyphicon glyphicon-envelope"></span> hello@bootstrapreal.com<br>
            <span class="glyphicon glyphicon-earphone"></span> (123) 456-7890</p>
          </div>
        </div>
        <p class="copyright">Copyright 2013. All rights reserved.	</p>
      </div>
    </div> -->
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
import "@/styles/dashboard/bootstrap/js/bootstrap.js";
import "@/styles/dashboard/script.js";
import "@/styles/dashboard/owl-carousel/owl.carousel.js";
import "@/styles/dashboard/slitslider/js/modernizr.custom.79639.js";
import "@/styles/dashboard/slitslider/js/jquery.ba-cond.min.js";
import "@/styles/dashboard/slitslider/js/jquery.slitslider.js";


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
                // this.getLoginInfo();
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
@import "~@/styles/dashboard/style.css";
@import "~@/styles/dashboard/bootstrap/css/bootstrap.css";
@import "~@/styles/dashboard/owl-carousel/owl.carousel.css";
@import "~@/styles/dashboard/owl-carousel/owl.theme.css";
@import "~@/styles/dashboard/slitslider/css/style.css";
@import "~@/styles/dashboard/slitslider/css/custom.css";

  // <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

</style>