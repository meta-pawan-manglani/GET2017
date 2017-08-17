function initializeField(){
	document.getElementById("search").disabled=true;
	document.getElementById("remove").disabled=true;
	document.getElementById("value").value="";
}
function Node(data) {
    this.data = data;
    this.next = null;
}
function SinglyList() {
    this._length = 0;
    this.head = null;
	
	this.printList=function(){
		var printer="";
		var iterator=this.head;
		if(this.head==null){
			printer = "List is Empty";
		}else{
		  while(iterator){
			printer = printer+(iterator.data+" ");
			iterator=iterator.next;
		   }
		}
		document.getElementById("displ").innerHTML = printer;
	};
	
	this.add = function() {
		
		var val = document.getElementById("value").value;
		val = val.trim();
		document.getElementById("value").value = "";
		if(val.length==0){
	      alert("Please Enter an element");
	      return "";
        }
        var node = new Node(val);
        currentNode = this.head;
 
    // 1st use-case: an empty list
    if (!currentNode) {
        this.head = node;
        this._length++;
		document.getElementById("search").disabled=false;
	    document.getElementById("remove").disabled=false;
        currentNode = node;
        return currentNode;
    }
 
    // 2nd use-case: a non-empty list
    while (currentNode.next) {
        currentNode = currentNode.next;
    }
 
        document.getElementById("search").disabled=false;
	    document.getElementById("remove").disabled=false;
    currentNode.next = node;
 
    this._length++;
    return this.head;
};


SinglyList.prototype.search = function() {
    var currentNode = this.head,
        length = this._length,
        count = 1;
	    var val = document.getElementById("value").value;
		val = val.trim();
		document.getElementById("value").value="";
    // 1st use-case: an invalid document.getElementById("search").value
		if(val.length==0){
	      alert("Please Enter an element");
	      return "";
        }
       var result = "\nelement "+val +" found at ";
    // 2nd use-case: a valid document.getElementById("search").value
	var flag = false;
    while (currentNode!=null) {
		if(currentNode.data == val){
			flag = true;
			result += "\n"+ count;
		}
        currentNode = currentNode.next;
        count++;
    }
	if(!flag){
		result = "Element not found";
	}
    return result;
};


SinglyList.prototype.remove = function() {
    var currentNode = this.head,
        length = this._length,
        count = 0,
        beforeNodeToDelete = null,
        nodeToDelete = null,
        deletedNode = null;
		
		var val = document.getElementById("value").value;
		val = val.trim();
		document.getElementById("value").value="";
 
    // 1st use-case: an invalid document.getElementById("value").value
    if (val.length==0) {
        alert("Please Enter an element");
	    return "";
    }
 
    // 2nd use-case: the first node is removed
    if (val == this.head.data) {
        this.head = currentNode.next;
        deletedNode = currentNode;
        currentNode = null;
		if(this.head==null){
		document.getElementById("search").disabled=true;
	    document.getElementById("remove").disabled=true;
		}
        this._length--;  
        return "element "+deletedNode.data +" has been  deleted ";
    }
 
    // 3rd use-case: any other node is removed
	var flag=false;
	while(currentNode.next!=null){
    if(currentNode.next.data==val) {
		flag = true;
        beforeNodeToDelete = currentNode;
        nodeToDelete = currentNode.next;
		break;
     }
	beforeNodeToDelete = currentNode;
     nodeToDelete = currentNode.next;
	currentNode = currentNode.next;
	count++;
	}
	if(!flag){
		return "element "+val +" is not in list";
	}else{
     beforeNodeToDelete.next = nodeToDelete.next;
     deletedNode = nodeToDelete;
     nodeToDelete = null;
     this._length--;
	}
    return "element "+val +" has been  deleted ";
};
	
}
 

var linkedList= new SinglyList();

function addNode(){
	linkedList.head=linkedList.add();
}

function print(){
	linkedList.printList();
}

function searchNode(){
	var search=linkedList.search();
	document.getElementById("displ").innerHTML=search;
}
function removeNode(){
	var del=linkedList.remove();
	document.getElementById("displ").innerHTML=del;
}