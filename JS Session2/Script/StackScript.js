function initializeField(){
	document.getElementById("search").disabled=true;
	document.getElementById("remove").disabled=true;
	document.getElementById("value").value="";
}

var Node = function(data){
  this.data = data;
  this.previous = null;
};
var Stack = function(){
  this.top = null;
  this.size = 0;

this.printList=function(){
		var printer="";
		var iterator=this.top;
		if(this.top==null){
			printer = "Stack is Empty";
		}else{
		   while(iterator){
			printer = printer+(iterator.data+" ");
			iterator=iterator.previous;
		   }
		}
		document.getElementById("displ").innerHTML = printer;
	};
Stack.prototype.push = function() {
	var val = document.getElementById("value").value;
	val = val.trim();
	if(val.length==0){
		alert("Please Insert an Element");
		return "";
	}
   var node = new Node(val);
   node.previous = this.top;
   this.top = node;
   this.size += 1;
   document.getElementById("value").value="";
   document.getElementById("search").disabled=false;
   document.getElementById("remove").disabled=false;
  return this.top;
};

Stack.prototype.pop = function() {
  temp = this.top;
  this.top = this.top.previous;
  this.size -= 1;
  if(this.top==null){
	  document.getElementById("search").disabled=true;
	  document.getElementById("remove").disabled=true;
  }
  return "Element "+temp.data+" is deleted";
};

Stack.prototype.search = function() {
	temp = this.top;
	var val = document.getElementById("value").value;
	val = val.trim();
	document.getElementById("value").value="";
	if(val.length==0){
		alert("Please Insert an Element");
		return "";
	}
	var count = 1;
	var flag = false;
	var result = "\nElement "+ val + " found at position ";
	while(temp!=null){
		if(temp.data==val){
			flag = true;
			result+= "\n"+count;
		}
		temp = temp.previous;
		count++;
	 }
	 if(!flag){
		result = "Element is not found";
	 }
	return result;
  };
}

var staack= new Stack();

function addNode(){
	staack.top = staack.push();
}

function print(){
	staack.printList();
}

function searchNode(){
	var result = staack.search();
	document.getElementById("displ").innerHTML=result;
}

function removeNode(){
	var del=staack.pop();
	document.getElementById("displ").innerHTML=del;
}
