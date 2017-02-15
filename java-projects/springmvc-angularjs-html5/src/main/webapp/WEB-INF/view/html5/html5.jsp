<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sample HTML5 Layout</title>
    <link href="${pageContext.request.contextPath}/resources/css/html5style.css" rel="stylesheet" />    
</head>
<body>
    <header>
        <h1>HEADER</h1>
    </header>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <c:url value="/about.html" var="about" />
            <li><a href="${about}">Promo and About</a></li>
        </ul>
    </nav>
   <section>
        <h1>SECTION STARTS</h1>
    <article>
    <h4>Article</h4>
	        <figure>
            	<img src="${pageContext.request.contextPath}/resources/images/html5.png" height="95px" width="95px" />
            <figcaption><b>HTML5 Logo</b></figcaption>
        </figure>
    </article>    
  
    <article>	
    <b>Article</b>
    <h1>autofocus example</h1>	
    <form>
    	<table>
    		<tr><td>Title:</td><td><input name="title"></td></tr>
  			<tr><td>Name:</td><td><input name="name" autofocus></td></tr>
  			<tr><td>Surname:</td><td><input name="surname"></td></tr>
  			<tr><td><input type="submit" value="Submit Details"/></td></tr>
  		</table>
	</form>
    </article>
    <article>	
    <b>Article</b>
    <h1>placeholder example</h1>		
    <form>
    	<table>
    		<tr><td>Title:</td><td><input name="title" placeholder="Please enter your title here" style="width: 250px" ></td></tr>
    		<tr><td>Name:</td><td><input name="name" placeholder="Please enter your name here" style="width: 250px"></td></tr>
  			<tr><td>Surname:</td><td><input name="surname" placeholder="Please enter your surname here" style="width: 250px" ></td></tr>
  			<tr><td><input type="submit" value="Submit Details"/></td></tr>
  		</table>
	</form>
    </article>    
    <article>	
    <b>Article</b>
    <h1>required example</h1>		
    <form>
    	<table>
    		<tr><td>Title:</td><td><input name="title" placeholder="Please enter your title here" style="width: 250px" required="required"></td></tr>
  			<tr><td>Surname:</td><td><input name="surname" placeholder="Please enter your surname here" style="width: 250px" ></td></tr>
  			<tr><td><input type="submit" value="Submit Details"/></td></tr>
  		</table>
	</form>
    </article> 
    <article>	
    <b>Article</b>
    <h1>input type email example</h1>		
    <form>
    	<table>
    		<tr><td>Title:</td><td><input name="title" placeholder="Please enter your title here" style="width: 250px" ></td></tr>
  			<tr><td>Name:</td><td><input name="name" placeholder="Please enter your name here" style="width: 250px"></td></tr>
  			<tr><td>Email:</td><td><input type="email" placeholder="Please enter your email here" style="width: 250px" required="required"></td></tr>
  			<tr><td>Surname:</td><td><input name="surname" placeholder="Please enter your surname here" style="width: 250px" ></td></tr>
  			<tr><td><input type="submit" value="Submit Details"/></td></tr>
  		</table>
	</form>
    </article> 
    <article>	
    <b>Article</b>
    <h1>input pattern example</h1>		
    <form>
    	<table>
    		<tr><td>Phone number:</td><td><input name="phone" pattern="[(][0-9]{3}[)][0-9]{7}" title="(123)4567890" style="width: 250px" required="required"></td></tr>
  			<tr><td><input type="submit" value="Submit"/></td></tr>
  		</table>
	</form>
    </article> 
    <article>	
    <b>Article</b>
    <h1>input URL example</h1>		
    <form>
    	<table>
    		<tr><td>URL:</td><td>
    		<input style="width: 400px" name="url" pattern="https?://.+" title="Please enter URL" required="required"/></td></tr>
  			<tr><td><input type="submit" value="Submit"/></td></tr>

  		</table>
	</form>
    </article>
    <article>
    <b>Article</b>
    <h1>input tel example</h1>	
    <form>
    	<table>
    		<tr><td>Tel number</td><td>
    		<input type="tel" pattern="[0-9]{10}" name="tel" title="Phone Number" required="required"/></td></tr>
  			<tr><td><input type="submit" value="Submit"/></td></tr>
		</table>
	</form>
    </article>
    <article>	
    <b>Article</b>
    <h1>input number example</h1>		
    <form>
    	<table>
    		<tr><td>number:</td><td><input type="number" required /></td></tr>
  			<tr><td><input type="submit" value="Submit"/></td></tr>
  		</table>
	</form>
    </article>   
   	<article>	
   	<b>Article</b>
    <h1>input time example</h1>		
    	<table>
    		<tr><td>Time:<input type="time" /></td><td></td></tr>
  		</table>
    </article>  
    <article>	
    <b>Article</b>
    <h1>input min/max maxlength example</h1>		
    <form>
    	<table>
    		<tr><td>min/max:</td><td><input type="number" min="0" max="100" required placeholder="Input min 0 max 100 number here" style="width: 350px" title="Input min 0 max 100 number here"/></td></tr>
    		<tr><td>minlength/maxlength :</td><td><input type="text" maxlength="5" required placeholder="maxlength 5 here" style="width: 350px" title="Input maxlength 5 here"/></td></tr>
  			<tr><td><input type="submit" value="Submit"/></td></tr>
  		</table>
	</form>
    </article> 
    <article>	
    <b>Article</b>
    <h1>input range example</h1>		
    	<table>
    		<tr><td>range:</td><td><input type="range" min="1" max="50" value="25"></td></tr>    		
  		</table>
    </article> 
    <article>	
    <b>Article</b>
    <h1>input date example</h1>		
    <form>
    	<table>
    		<tr><td>date:</td><td><input type="date"></td></tr>    		
  			<tr><td><input type="submit" value="Submit"/></td></tr>
  		</table>
	</form>
    </article> 
    <article>	
    <b>Article</b>
    <h1>input color example</h1>		
    	<table>
    		<tr><td>color:</td><td><input type="color"></td></tr>    		
  		</table>
    </article> 
    <article>	
    <b>Article</b>
    <h1>input datalist example</h1>		
    	<label>Go to browser list: 
    	<input name="browsers" type="text" list="suggestions"></label>
		<datalist id="suggestions">
 			<option value="CR"  label="Chrome">
 			<option value="FI"  label="Firefox">
 			<option value="IE"  label="Internet Explorer">
		</datalist>
    </article>
    <article>	
    <b>Article</b>
    	<h1>editable content with contenteditable=true </h1>		
		<div id="editHere" contenteditable="true">You can edit this text</div>
    </article>    
    <article>	
    <b>Article</b>    
    	<c:url value="/audiovideo.html" var="audiovideo" />
		<a href="${audiovideo}">Audio Video HTML5</a><br/>
	</article> 
	<article>
	<b>Article</b>
    	<h1>input progress bar example</h1>		
		<progress value="3" max="100"></progress>
    </article>
    <article>	
    	<b>Article</b>
    	<h1>input pattern</h1>		
    <form>
    <table >
    	<tr><td>[s][a-z]{4}[g]:</td><td><input type="text" pattern="[s][a-z]{4}[g]" required="required"></td></tr>    		
  		<tr><td><input type="submit" value="Submit"/></td></tr>
  	</table>
	</form>
    </article> 
    <article>	
    <b>Article</b>
	    <h1>Local and Session storage example</h1>		
	    <button onclick="writeToConsole()" type="button">Console Logging Example</button>
	    <button onclick="sessionStorageExample()" type="button">Store Date() In SessionStorage</button>    
	    <button onclick="localStorageItemExample()" type="button">Store username and lastlogin in LocalStorage</button>    
	    <button onclick="writeToConsoleLocalStorage()" type="button">Console Logging LocalStorage</button>    
	    <button onclick="displayLocalStorage()" type="button">Display Items in LocalStorage</button>   	
	   	<button onclick="deleteLocalStorage()" type="button">Delete Items in LocalStorage</button>   	
   	<table>
   		<tr><td><b>Session</b></td><td><div id="storageSessionResult"></div></td></tr>
   	</table>
    </article> 
    <h1>SECTION END</h1>
    </section>
    
    <footer>
      <h1>FOOTER</h1>
    </footer>
    
<script>
//##########console example
function writeToConsole() {
	console.log('Console Log Example');
	console.error('Console Error Example');
	console.warn('Console Warn Example');
	console.info('Console Info Example');
}
//##########sessionStorage example
function sessionStorageExample() {
	//sessionStorageExample will be deleted if you close the browser
    if(typeof(Storage) !== "undefined") {   	
    	if(sessionStorage.dateVariable == null)
    	sessionStorage.dateVariable = new Date();  
    	
		document.getElementById("storageSessionResult").innerHTML = sessionStorage.dateVariable;
    } else {
        document.getElementById("storageSessionResult").innerHTML = "Browser does not support storage!";
    }
}
//##########localStorage example
function localStorageItemExample() {
	if(typeof(Storage) !== "undefined") {
	   localStorage.setItem('username','javaspring@springweb.com');
	   localStorage.setItem('lastlogin',new Date());
	}
}
//##########localStorage example
function writeToConsoleLocalStorage() {
		console.log("localStorage username: " + localStorage.getItem('username'));
		console.log("localStorage lastlogin: " + localStorage.getItem('lastlogin'))
}
//##########localStorage example
function displayLocalStorage() {
		alert("localStorage username: " + localStorage.getItem('username'));
		alert("localStorage lastlogin: " + localStorage.getItem('lastlogin'))
}
//##########localStorage example
function deleteLocalStorage() {
	localStorage.clear();
}
</script>
<script type="text/javascript">
	document.getElementById("storageSessionResult").innerHTML = sessionStorage.dateVariable;
	if(localStorage.getItem('username') != null) {
		alert('Local Storage Username and Lastlogin: ' + localStorage.getItem('username') + "\n" + localStorage.getItem('lastlogin'));	
	}
</script>
</body>
</html>