
function clearForm(){
	localStorage.clear();
    document.getElementById("form").reset();
    document.getElementById("myDropdown").selectedIndex=-1;  
 }
 
 function fillForm(){
	 var retrieveObject = localStorage.getItem('testObject');
     
	 if(retrieveObject!=null){ 
	    console.log('retrievedObject: ' + JSON.parse(retrieveObject));
	    var retrieveData = JSON.parse(retrieveObject);
		
	    document.getElementById("userName").value = retrieveData.name;
	    document.getElementById("isemail").value = retrieveData.email;
	    document.getElementById("myDropdown").value = retrieveData.city;
	    document.getElementById("phone").value = retrieveData.num;
	    document.getElementById("organisationName").value = retrieveData.org;
	    document.getElementById("message").value = retrieveData.msg;
	  }else{
		  document.getElementById("myDropdown").selectedIndex=-1; 
	  }
	  
 }
 
 
function toHome(){
    window.location.href="../HTML/Home.htm";
}

function toContact(){
    window.location.href="../HTML/Contact.htm";
}

var flagName = false;
var flagEmail = false;
var flagOrg = false;
var flagCity = false;
var flagContact = false;
var flagMessage = false;

function checkName(){
     var f_name = /^[A-Za-z]{1,20}$/;
     var name =  document.getElementById("userName").value;
      if(!f_name.test(name) || name.length>20) {
       document.getElementById("userName").style.borderColor="red";
       document.getElementById("userName").value=name.slice(0,name.length-1);
       flagName = false;
       alert("Username should only have character and can be 20 character long");
       return false;
      }
      document.getElementById("userName").style.borderColor="";
      flagName = true;
      return true;
}


function checkEmail(){
       var f_email= /^(([\-\w]+)\.?)+@(([\-\w]+)\.?)+\.[a-zA-Z]{2,4}$/;
       var email = document.getElementById("isemail").value;
       if (!f_email.test(email)) {
         document.getElementById("isemail").style.borderColor="red";
         document.getElementById("isemail").value="";
         flagEmail = false;
         alert("Please enter a valid mail Id");
       return false;
      }
      document.getElementById("isemail").style.borderColor="";
      flagEmail = true;
      return true;
}

function checkOrgName(){
     var f_name = /^[A-Za-z]{1,20}$/;
     var name =  document.getElementById("organisationName").value;
      if(!f_name.test(name)) {
       document.getElementById("organisationName").style.borderColor="red";
       document.getElementById("organisationName").value="";
       flagOrg = false;
       alert("Organisation name should only have character and can be 20 characters long");
       return false;
      }
      document.getElementById("organisationName").style.borderColor="";
      flagOrg = true;
      return true;
}

function checkMessage(){
    var message= document.getElementById("message");
         if(message.length>250){
          document.getElementById("message").style.borderColor="red";
          flagMessage  =  false;
          alert("Message should not be more than 250 characters");
          return false;
    }
    flagMessage = true;
    return true;
}

function checkContact(){
     var f_phone = /^[0-9]{8,10}$/;
     var contact = document.getElementById("phone").value;
     if(!f_phone.test(contact)) {
         document.getElementById("phone").style.borderColor="red";
         document.getElementById("phone").value="";
         flagContact = false;
         alert("Please enter a valid contact number");
         return false;
     }
     document.getElementById("phone").style.borderColor="";
     flagContact = true;
     return true;
}

function checkCity(){
       var city = document.getElementById("myDropdown").value;
       if(city==-1) {
         document.getElementById("myDropdown").style.borderColor="red";
         flagCity = false;
         alert("Please select a valid city");
         return false;
     }
     flagCity = true;
     document.getElementById("myDropdown").style.borderColor="";
     fillCity();
     return true;
}

function validateForm(){
         if(!flagName){
             return false;
         }
         if(!flagCity){
             return false;
         }
         if(!flagContact){
             return false;
         }
         if(!flagOrg){
             return false;
         }
         if(!flagMessage){
             return false;
         }
         if(!flagEmail){
             return false;
         }
		 
		 
		      var name1 = document.getElementById("userName").value;
			  var email1 = document.getElementById("isemail").value;
			  var city1 = document.getElementById("myDropdown").value;
			  var num1 = document.getElementById("phone").value;
			  var org1 = document.getElementById("organisationName").value;
			  var msg1 = document.getElementById("message").value;
			  
			  
			  var testObject = { 'name':name1,'email':email1,'city':city1,'num':num1,'org':org1,'msg':msg1};
				
              // Put the object into storage
              localStorage.setItem('testObject', JSON.stringify(testObject));

              //Retrieve the object from storage
              document.getElementById("form").submit();
         
         return true;
}

function fillCity(){
    var city = document.getElementById("myDropdown").value;
    document.getElementById("cityname").value="Selected City is:"+city;
}

