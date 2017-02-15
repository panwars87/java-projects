<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
  <head>
    <title>Spring MVC Angular JS HTML5</title>

    <link href="starter-template.css" rel="stylesheet">
	<spring:url value="/resources/css/bootstrap.css" var="bootstrap" />
	<spring:url value="/resources/css/starter-template.css" var="startertemplate" />
	<link href="${bootstrap}" rel="stylesheet" />
	<link href="${startertemplate}" rel="stylesheet" />
	
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="${pageContext.request.contextPath}">Spring MVC</a>
        </div>
     	<div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}">Home</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">

      <div class="starter-template">
        <h2><b><a href="https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/?couponCode=eduspring75coupon" target="_blank">%75 Discount Coupon (Only for the attendees of this udemy course)</a></b></h2>
        <br/>
        <p class="lead"><b>Java Spring Framework 4 and Core Spring Certification <font color="green">udemy</font> course</b></p>
        <h3><a href="https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/?couponCode=eduspring75coupon" target="_blank">https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/?couponCode=eduspring75coupon</a></h3>
        <br/><br/>
        <a href="https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/?couponCode=eduspring75coupon" target="_blank"><img width="800" alt="ss" src="<%=request.getContextPath()%>/resources/images/promo.PNG"></a>
        <br/><br/>
       	<b>More info and questions: <a href="mailto:tunatore@gmail.com ">Tuna Tore</a></b>    
  
      
<em><strong>Course Description</strong></em><br/> <br/>
By attending this course, you will be able to learn the details of the latest <strong>Spring Framework 4x </strong>version with code examples.  <br/> <br/>
This course also provides you the answers of all <strong>Core Spring Framework 4x Certification </strong>questions inside the official study guide. (in total 162 questions). 
Therefore, after completing this course, you will learn the answers of questions with code examples and able to pass the certification.  
The course will start with the configuration of the course environment such as downloading and installing the <strong>Java JDK</strong> and <strong>STS (Spring Tool Suite).</strong> I will also provide you the links for downloading the source codes and slides used in this course. By downloading those materials, you  will be able to configure your environment and also other commercial applications in an easy way. This course will provide you two sample application including the configurations of <strong>Spring Framework</strong> and its dependencies; one of them is configured as a Java Standard Edition program and the other one is a Web-based application. (names are<strong>spring</strong>, <strong>spring-web</strong>) <br/> <br/>
The course's content is based on the following sections; <br/> <br/>

<ul>
	<li><strong>Spring Container, </strong><strong>Dependency, and IOC (Inversion of Control)</strong></li>
	<li><strong>Aspect Oriented Programming</strong></li>
	<li><strong>JDBC, Transactions, and ORM (Hibernate)</strong></li>
	<li><strong>Spring MVC</strong></li>
	<li><strong>Spring Security</strong></li>
	<li><strong>Messaging (JMS)</strong></li>
	<li><strong>REST</strong></li>
	<li><strong>Unit Testing with JUnit</strong></li>
	<li><strong>Library Management with Maven</strong></li>
</ul>

If you attend this course, I will also answer all of your questions related to the course or code examples through comments. You will be able to ask me any questions related to the <strong>Spring Framework</strong> or <strong>Core Spring Certification</strong> through udemy, emails and the contact form inside my technical blog. <br/> <br/>

<ul>
	<li>Installing <strong>Spring Tool Suite and Java JDK 8.0</strong></li>
	<li>Learn how to use<strong> Maven by editing pom xml </strong>for library management</li>
	<li>Provides information about <strong>Core Spring Framework 4.x certification </strong>and passing scores</li>
	<li>You will learn how to <strong>debug, test and run</strong> Spring Framework applications</li>
	<li>Understand how to use <strong>Spring Framework's Container</strong></li>
	<li>Understand how to use <strong>constructor and setter injection </strong>works</li>
	<li>Learn the <strong>bean life cycle </strong>in Spring Framework</li>
	<li>Understand the usage of <strong>BeanFactoryPostProcessors and BeanPostProcessors</strong></li>
	<li>How to use <strong>@ComponentScan </strong>annotation</li>
	<li>Understand the usage of <strong>&lt;context:component-scan/&gt; </strong>tag in <strong>application-context xml</strong> file</li>
	<li>How to define <strong>scopes for beans </strong>in XML configuration and annotation configuration</li>
	<li>How to use <strong>@Bean </strong>annotation with <strong>@Scope </strong>annotation</li>
	<li>How to configure <strong>PropertyPlaceholderConfigurer</strong> in XML configuration or Java based Configuration</li>
	<li>How to use <strong>@Autowired </strong>and <strong>@Qualifier </strong>annotations</li>
	<li>How to use <strong>@PostConstruct </strong>and <strong>@Predestroy </strong>JSR-250 annotations</li>
	<li>How to configure <strong>init-method </strong>and<strong> destroy-method </strong>in Spring XML Configuration</li>
	<li>Understand how to use <strong>&lt;bean/&gt;</strong> tag in XML configuration</li>
	<li>How to use <strong>&lt;context-annotation-config&gt;</strong> tag in XML configuration</li>
	<li>How to use <strong>ClassPathXmlApplicationContext, FileSystemXmlApplicationContext, XmlWebApplicationContext and AnnotationConfigApplicationContext</strong></li>
	<li>How to configure <strong>JUnit </strong>with Spring Framework applications</li>
	<li>How to use <strong>@RunWith(SpringJUnit4ClassRunner class)</strong></li>
	<li>How to use <strong>@ContextConfiguration</strong></li>
	<li>Understand the usage of <strong>@Value</strong> annotation</li>
	<li>Learn how to configure profiles with <strong>@Profile </strong>annotation</li>
	<li>Learn how to use <strong>Bean Inheritance</strong> in Spring Framework</li>
	<li>How use <strong>abstract beans </strong>in Spring Framework</li>
	<li>How to use <strong>&lt;context:property-placeholder/&gt;</strong></li>
	<li>How to configure <strong>PropertySourcesPlaceholderConfigurer</strong> in JavaConfig</li>
	<li>How to implement <strong>FactoryBean interface</strong> in Spring Framework</li>
	<li>How to use <strong>@Configuration </strong>annotation in Spring Framework</li>
	<li>How to define <strong>AnnotationConfigApplicationContext</strong></li>
	<li>How to use <strong>AbstractJUnit4SpringContextTests</strong></li>
	<li>How to implement <strong>ApplicationContextAware</strong> interface</li>
	<li>See how to use <strong>&lt;util:properties/&gt; </strong>in XML configuration files</li>
	<li>Understand how to use basic <strong>SpEL (Spring Expression Language)</strong> in properties</li>
	<li>How to define <strong>inner beans </strong>in XML configuration</li>
	<li>How to get beans from application-context xml with <strong>getBean() </strong>method</li>
	<li>How to close Application Context with <strong>ConfigurableApplicationContext</strong></li>
	<li>How to use <strong>@PropertySource </strong>annotation</li>
	<li>Understand the usage of <strong>Aspect Oriented Programming (AOP)</strong></li>
	<li>Learn <strong>cross cutting concerns </strong>in programming</li>
	<li>Learn the following concepts; <strong>pointcut, jointpoint, advice and aspect</strong></li>
	<li>How to use <strong>@Aspect</strong> annotation</li>
	<li>Learn how to use <strong>&lt;aop:config&gt;, &lt;aop:pointcut&gt;, &lt;aop:after&gt;, &lt;aop:before&gt;, &lt;aop:after-throwing&gt;, &lt;aop:after-returning&gt;, &lt;aop:around&gt;</strong> and <strong>&lt;aop:aspect&gt;</strong> tags in XML configuration</li>
	<li>Understand the usage of <strong>@EnableAspectJAutoProxy </strong>annotation</li>
	<li>Understand the usage of <strong>&lt;aop:aspectj-autoproxy /&gt;</strong></li>
	<li>How to define named pointcuts</li>
	<li>Learn how to use <strong>@Pointcut, @Before, @After, @AfterThrowing, @AfterReturning and @Around</strong>annotations</li>
	<li>Learn the difference between <strong>checked and unchecked exceptions</strong> in Java Programming</li>
	<li>Learn <strong>DataAccessException</strong> in Spring Framework</li>
	<li>Learn how to define<strong> DriverManagerDataSource </strong>or <strong>BasicDataSource</strong> in XML configuration</li>
	<li>Understand how to use J<strong>DBCTemplate</strong> when accessing databases</li>
	<li>Learn how to define <strong>&lt;jdbc:embedded-database/&gt;</strong> and <strong>&lt;jdbc:script/&gt;</strong></li>
	<li>Learn the usages of <strong>RowMapper, RowCallbackHandler and ResultSetExtractor</strong></li>
	<li>Learn how to define <strong>DataSourceTransactionManager</strong></li>
	<li>How to use <strong>@Transactional</strong> annotation</li>
	<li>Understand how to use <strong>TransactionTemplate</strong></li>
	<li>Learn the usage of <strong>Propagation</strong> object</li>
	<li>Learn the usage of <strong>@Transactional(rollbackFor=YourExceptionclass)</strong></li>
	<li>Learn the usage of <strong>@Transactional(noRollbackFOr=YourExceptionclass)</strong></li>
	<li>Learn the usage of <strong>@Rollback(value=false)</strong> annotation</li>
	<li>Learn how to configure <strong>entityManagerFactory </strong>with <strong>Hibernate </strong>in Spring Framework</li>
	<li>How to use <strong>@Entity and @PersistentContext </strong>annotations</li>
	<li>Understand what is <strong>MVC (Model View Controller)</strong></li>
	<li>How to use <strong>DispatcherServlet</strong></li>
	<li>Understand how to edit <strong>web xml </strong>file for configurations</li>
	<li>Understand the usage of <strong>@Controller </strong>and <strong>@RequestMapping </strong>annotations</li>
	<li>How to configure <strong>SimpleUrlHandlerMapping </strong>using XML configuration</li>
	<li>How to configure <strong>ContextLoaderListener </strong>in web xml</li>
	<li>How to define <strong>&lt;contextConfigLocation/&gt;</strong> tag in web xml</li>
	<li>How to use <strong>@RequestParam </strong>and <strong>@PathVariable </strong>annotations</li>
	<li>Understand the usage of <strong>ModelAndView</strong></li>
	<li>How to define<strong> InternalResourceViewResolver </strong>in configuration files</li>
	<li>How to define <strong>DelegatingFilterProxy </strong>in web xml</li>
	<li>How to use <strong>&lt;intercept-url/&gt; </strong>in Spring Security</li>
	<li>How to use <strong>@Secured </strong>and <strong>@RolesAllowed </strong>annotations</li>
	<li>Understand the usage of <strong>&lt;authentication-manager/&gt;</strong> tag in Spring Security</li>
	<li>Understand the usage of <strong>&lt;password-encoder/&gt;</strong></li>
	<li>How to configure <strong>&lt;salt-source/&gt; </strong>in Spring Security</li>
	<li>Understand how to define <strong>&lt;jdbc-user-service/&gt;</strong></li>
	<li>How to configure<strong> &lt;access-denied-handler/&gt;</strong></li>
	<li>Understand how to configure <strong>&lt;form-login/&gt;</strong> in Spring Secuirty</li>
	<li>Understand how to use <strong>JMS (Java Message Service) </strong>in Spring Framework</li>
	<li>How to use <strong>JMSTemplate</strong></li>
	<li>How to implement <strong>MessageListener </strong>interface</li>
	<li>Learn how to configure <strong>ApacheMQ </strong>for messaging in Spring Framework</li>
	<li>Learn how to configure <strong>&lt;jms:listener-container/&gt;</strong></li>
	<li>Learn how to use<strong> topics and queues</strong></li>
	<li>How to configure <strong>MDP (Message Drivern POJOs)</strong></li>
	<li>How to develop <strong>REST </strong>web services with Spring Framework</li>
	<li>How to use <strong>&lt;mvc:annotation-driven /&gt; and @EnableWebMvc</strong></li>
	<li>How to use <strong>RequestMethod </strong>types in Spring Framework</li>
	<li>How to use <strong>@ReponseBody, @RestController, @ExceptionHandler and @ResponseStatus</strong>annotations</li>
	<li>How to use <strong>RestTemplate</strong> in Spring Framework</li>
</ul>

<strong>HD quality (full screen) recorded course</strong> content and you will be able to see the source code clearly <strong>(HD format)</strong> if you attend this <strong>udemy</strong> course as a student.

<div>
	<h3>What are the requirements?</h3>
	<ul>
		<li>Basic Java programming knowledge and enthusiasm to learn the latest Spring Framework 4.x</li>
		<li>Basic knowledge of XML, HTML and Web Development</li>
		<li>Knowledge of simple SQL queries such as SELECT, INSERT, DELETE and UPDATE</li>
	</ul>
</div>

<div>

	<h3>What am I going to get from this course?</h3>
	<ul>
		<li>Over 75 lectures and 9.5 hours of content!</li>
		<li>Learn the latest Spring Framework 4.x in detail with code examples</li>
		<li>Pass Core Spring Framework 4.x certification successfully</li>
		<li>Learn the answers of all questions asked in the official study guide</li>
		<li>Configure Spring Framework based applications in commercial environments</li>
		<li>Learn Spring Framework's Container, Dependency Injection and IOC (Inversion of Control) concepts</li>
		<li>Understand how to code and configure Spring Framework with XML or Java Config</li>
		<li>Understand how to use AOP (Aspect Oriented Programming) wtih Spring Framework</li>
		<li>Understand Spring JDBC and Hibernate ORM integration</li>
		<li>Learn how to use Spring MVC module in Web Applications</li>
		<li>Code Spring Framework based Web applications</li>
		<li>Learn how to use and configure Spring Security Module</li>
		<li>Code REST based web applications using Spring Framework</li>
		<li>Understand the integration of JMS (Java Message Service) API with Spring Framework</li>
		<li>Use @Annotations in Spring Framework applicatons</li>
		<li>Code unit tests using JUnit with Spring Framework</li>
		<li>Learn how to use Maven for library management</li>
		<li>Learn the benefits of using Spring Tool Suite (STS)</li>
		<li>Understand the structure of Spring Web applications</li>
		<li>Learn how to configure Embedded Database source for Spring applications</li>
		<li>Understand how to implement Transaction Support for Spring Applications</li>
	</ul>
	</div>

	<h3>What is the target audience?</h3>
	<ul>
		<li>Programmers with the basic knowledge of Java</li>
		<li>Java Programmers/Developers interested in learning the usage of latest Spring Framework 4.x</li>
		<li>Web developers planning to learn Spring MVC components</li>
		<li>Programmers interested in learning Spring Framework for developing commercial applications</li>
		<li>University Students planning to do web applications using Spring Framework</li>
		<li>Back-end or Front-end Web Developers</li>
		<li>Junior, Senior or Expert Developers interested in understanding the usage of Spring Framework</li>
	</ul>
	<h3><a href="https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/?couponCode=eduspring75coupon" target="_blank">https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/?couponCode=eduspring75coupon</a></h3>
	</div>    
	</div>
  </body>
</html>
