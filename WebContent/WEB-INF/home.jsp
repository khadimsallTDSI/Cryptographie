<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Roboto');

a:hover, a:focus {
	text-decoration: none;
	outline: none;
}

body {
	font-family: 'Roboto', sans-serif;
}
/*
1.1 Header Area
***************************************************/
/*Bootstrap Reset*/
.navbar-nav>li>a {
	padding-top: 0;
	padding-bottom: 0;
}

.mainmenu {
	background-color: transparent;
	border-color: transparent;
	margin-bottom: 0;
	border: 0px !important;
}

.navbar-nav>li:last-child>a {
	padding-right: 0px;
	margin-right: 0px;
}

.dropdown-menu {
	padding: 0px 0;
	margin: 0 0 0;
	border: 0px solid transition !important;
	border: 0px solid rgba(0, 0, 0, .15);
	border-radius: 0px;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
}
/*=-====Main Menu=====*/
.navbar-nav .open .dropdown-menu>li>a {
	padding: 16px 15px 16px 25px;
}

.header_bottom {
	background: #0071ba
}

.header_area .header_bottom .mainmenu a, .navbar-default .navbar-nav>li>a
	{
	font-size: 16px;
	text-transform: capitalize;
	padding: 16px 15px;
	font-family: 'Roboto', sans-serif;
}

.header_area .mainmenu .active a, .header_area .mainmenu .active a:focus,
	.header_area .mainmenu .active a:hover, .header_area .mainmenu li a:hover,
	.header_area .mainmenu li a:focus, .navbar-default .navbar-nav>.open>a,
	.navbar-default .navbar-nav>.open>a:focus, .navbar-default .navbar-nav>.open>a:hover
	{
	color: #0071ba;
	background: #54c6d4;
	outline: 0;
}
/*-----./ Main Menu-----*/
.navbar-default .navbar-toggle {
	border-color: #fff
} /*Toggle Button*/
.navbar-default .navbar-toggle .icon-bar {
	background-color: #fff
} /*Toggle Button*/

/*==========Sub Menu=v==========*/
.mainmenu .collapse ul>li:hover>a {
	background: #54c6d4;
}

.mainmenu .collapse ul ul>li:hover>a, .navbar-default .navbar-nav .open .dropdown-menu>li>a:focus,
	.navbar-default .navbar-nav .open .dropdown-menu>li>a:hover {
	background: #CBEAF0;
}

.mainmenu .collapse ul ul ul>li:hover>a {
	background: blue;
}

.mainmenu .collapse ul ul, .mainmenu .collapse ul ul.dropdown-menu {
	background: #98D7E1;
}

.mainmenu .collapse ul ul ul, .mainmenu .collapse ul ul ul.dropdown-menu
	{
	background: #0a1464
}

.mainmenu .collapse ul ul ul ul, .mainmenu .collapse ul ul ul ul.dropdown-menu
	{
	background: #e4eeb8
}

/******************************Drop-down menu work on hover**********************************/
.mainmenu {
	background: none;
	border: 0 solid;
	margin: 0;
	padding: 0;
	min-height: 20px
}

@media only screen and (min-width: 767px) {
	.mainmenu .collapse ul li {
		position: relative;
	}
	.mainmenu .collapse ul li:hover>ul {
		display: block
	}
	.mainmenu .collapse ul ul {
		position: absolute;
		top: 100%;
		left: 0;
		min-width: 250px;
		display: none
	}
	/*******/
	.mainmenu .collapse ul ul li {
		position: relative
	}
	.mainmenu .collapse ul ul li:hover>ul {
		display: block
	}
	.mainmenu .collapse ul ul ul {
		position: absolute;
		top: 0;
		left: 100%;
		min-width: 250px;
		display: none
	}
	/*******/
	.mainmenu .collapse ul ul ul li {
		position: relative
	}
	.mainmenu .collapse ul ul ul li:hover ul {
		display: block
	}
	.mainmenu .collapse ul ul ul ul {
		position: absolute;
		top: 0;
		left: -100%;
		min-width: 250px;
		display: none;
		z-index: 1
	}
}

/* End Responsive Menu */
</style>
</head>
<body>
	<c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom }">
		<p>Vous êtes ${ sessionScope.prenom } ${ sessionScope.nom } !</p>
	</c:if>
<!-- 	<ul>
		<li><a href="/projetweb/">Accueil</a></li>
		<li><a href="/projetweb/gen">Cles Asymetrique</a></li>
		<li><a href="/projetweb/secret">Cle Secrete</a></li>

		<li><a href="/projetweb/chiffrement">Chiffrement Symetrique</a></li>
		<li><a href="/projetweb/asym">Chiffrement Asymetrique</a></li>
		<li><a href="/projetweb/formulaire">Chiffrement symetrique d
				un fichier</a></li>
		<li><a href="/projetweb/Asymfile">Chiffrement Asymetrique d
				un fichier</a></li>



		<li><a href="/projetweb/test">Test</a></li>
		<li><a href="/projetweb/Bonjour">bonjour</a></li>
		<li><a href="/projetweb/formulaire">Inscription</a></li>
		<li><a href="/projetweb/session">session</a></li>
		<li><a href="/projetweb/dao">dao</a></li>

	</ul>
 -->


	<link
		href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->


	<div id="header-area" class="header_area">
		<div class="header_bottom">
			<div class="container">
				<div class="row">
					<nav role="navigation" class="navbar navbar-default mainmenu">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" data-target="#navbarCollapse"
								data-toggle="collapse" class="navbar-toggle">
								<span class="sr-only">CryptoJava</span> <span class="icon-bar"></span>
								<span class="icon-bar"></span> <span class="icon-bar"></span>
							</button>
						</div>
						<!-- Collection of nav links and other content for toggling -->
						<div id="navbarCollapse" class="collapse navbar-collapse">
							<ul id="fresponsive" class="nav navbar-nav dropdown">
								<li class="active"><a href="/Cryptojava/secret">Accueil</a></li>
								<li><a href="#" data-toggle="dropdown"
									class="dropdown-toggle">Generation de Cles<span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="/Cryptojava/secret">Clés Symetrique</a></li>
										<li><a href="/Cryptojava/gen">Clés Asymetrique</a></li>
									</ul></li>

								<li><a href="#" data-toggle="dropdown"
									class="dropdown-toggle">Chiffrement <span class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="/Cryptojava/chiffrement">Chiffrement
												Symetrique</a></li>
										<li><a href="/Cryptojava/asym">Chiffrement Asymetrique</a></li>
										<li><a  href="/Cryptojava/formulaire">Chiffrement symetrique fichier</a></li>
										<li><a href="/Cryptojava/Asymfile">Chiffrement Asymetrique fichier </a></li>
									</ul></li>

								<li><a href="/Cryptojava/signature">Signer un message</a></li>
								<li><a href="/Cryptojava/historique">Historique des cles</a></li>
								
								
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
		<!-- /.header_bottom -->

	</div>
	<br>
   <div class="jumbotron ">
  <h1 class="display-4">Crypto java</h1>
  <p class="lead"><legend>Aplication Cryptographique en java</legend></p>
  <hr class="my-4">
</div>
      

	<script type="text/javascript">

(function($){
	$(document).ready(function(){
		$('ul.dropdown-menu [data-toggle=dropdown]').on('click', function(event) {
			event.preventDefault(); 
			event.stopPropagation(); 
			$(this).parent().siblings().removeClass('open');
			$(this).parent().toggleClass('open');
		});
	});
})(jQuery);
</script>


</body>
</html>