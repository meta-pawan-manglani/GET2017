function initializeField(){
	document.getElementById("search").disabled=true;
	document.getElementById("remove").disabled=true;
	document.getElementById("value").value="";
}

var Node = function(data) {
  this.data = data;
  this.next = null;
};
var Queue = function() {
  this.first = null;
  this.size = 0;

  
  this.printList=function(){
		var printer="";
		var iterator=this.first;
		if(this.first==null){
			printer = "Queue is Empty";
		}else{
		  while(iterator){
			printer = printer+(iterator.data+" ");
			iterator=iterator.next;
		  }
		}
		document.getElementById("displ").innerHTML = printer;
	};

	
Queue.prototype.enqueue = function() {
  var node = new Node(document.getElementById("value").value);
  document.getElementById("value").value="";
  node.data = node.data.trim();
  if(node.data.length==0){
	  alert("Please Enter an element");
	  return "";
  }else{
     if (this.first==null){
        this.first = node;
     } else {
          n = this.first;
          while (n.next!=null) {
           n = n.next;
          }
         n.next = node;
        }
		document.getElementById("search").disabled=false;
	    document.getElementById("remove").disabled=false;
  }
  this.size += 1;
  return "Element "+node.data+" is added";
};

Queue.prototype.dequeue = function() {
  temp = this.first;
  this.first = this.first.next;
  this.size -= 1;
  if(this.first==null){
	  document.getElementById("search").disabled=true;
	  document.getElementById("remove").disabled=true;
  }
  return "Element "+temp.data+" is deleted";
};

Queue.prototype.search = function() {
	temp = this.first;
	var val = document.getElementById("value").value;
	document.getElementById("value").value="";
	val = val.trim();
	var result = "\nElement found at position ";
	if(val.length==0){
		alert("Please Insert an element");
		return "";
	}
	var count=1;
	var flag = false;
	if(temp==null){
		result = "Queue is EMPTY";
	}else {
	  while(temp!=null){
		if(temp.data==val){
			flag = true;
			result +=  "\n"+count;
		}
		temp = temp.next;
		count++;
	}
	if(!flag){
		result = "Element is not found";
	 }
	}
	 return result;
}


}
var que= new Queue();

function addNode(){
	var first = que.enqueue();
}

function print(){
	que.printList();
}

function removeNode(){
	var del=que.dequeue();
	document.getElementById("displ").innerHTML=del;
}
function searchNode(){
	var result = que.search();
	document.getElementById("displ").innerHTML=result;
}
