function initializeField(){
	document.getElementById("search").disabled=true;
	document.getElementById("remove").disabled=true;
	document.getElementById("value").value="";
}


function Node(data){
	this.data = data;
	this.prev=null;
	this.next=null;
}

function DoublyLinkedList(){
	this.head=null;
	this.prev=null;
	this.next=null;

	this.printList=function(){
		var printer="";
		var iterator=this.head;
		if(iterator==null){
			printer = "List is Empty";
		}else{
		  while(iterator){
			printer = printer+(iterator.data+" ");
			iterator=iterator.next;
		 } 
		}
		document.getElementById("displ").innerHTML = printer;
	};
	
	this.printListR=function(){
		var printer="";
		var iterator=this.head;
		if(iterator==null){
			printer = "List is Empty";
		}else{
			while(iterator.next!=null){
			iterator=iterator.next;
		  }
		  while(iterator!=null){
			printer = printer+(iterator.data+" ");
			iterator=iterator.prev;
		 }
	    }
		document.getElementById("displ").innerHTML = printer;
	};
	
DoublyLinkedList.prototype.add = function() {
    var node = new Node(document.getElementById("value").value);
	document.getElementById("value").value="";
	node.data = node.data.trim();
        currentNode = this.head;
		if(node.data.length==0){
			alert("Please Insert an element");
			return this.head;
		}
 
    document.getElementById("search").disabled=false;
	document.getElementById("remove").disabled=false;
    // 1st use-case: an empty list
    if (!currentNode) {
        this.head = node;
        currentNode = node;
        return currentNode;
    }
 
    // 2nd use-case: a non-empty list
    while (currentNode.next) {
        currentNode = currentNode.next;
    }
 
    currentNode.next = node;
	node.prev = currentNode;
    return this.head;
};

DoublyLinkedList.prototype.search = function() {
        var currentNode = this.head,
        count = 1,
        message = {failure: 'Failure: non-existent node in this list.'};
		 // 1st use-case: an invalid document.getElementById("search").value
	  if (document.getElementById("value").value.length==0) {
        alert("Please Enter an element");
		return "";
      }
	   
	   var flag = false;
 
		var val = document.getElementById("value").value;
		document.getElementById("value").value="";
   
    // 2nd use-case: a valid document.getElementById("search").value
	
	var result = "\nElement  "+ val + "  found at position ";
    while (currentNode!=null) {
		if(currentNode.data == val){
			flag = true;
			result += "\n"+count;
		}
        currentNode = currentNode.next;
        count++;
    }
	if(!flag){
		result = "Element not found";
	}
    return result;
};

DoublyLinkedList.prototype.remove = function() {
    var currentNode = this.head,
        count = 0,
        message = {failure: 'Failure: non-existent node in this list.'},
        beforeNodeToDelete = null,
        nodeToDelete = null,
        deletedNode = null;
		var val = document.getElementById("value").value.trim();
		document.getElementById("value").value="";
 
    // 1st use-case: an invalid document.getElementById("value").value
    if (val.length==0) {
        alert("Please Insert an element");
		return "";
    }
	
 
    // 2nd use-case: the first node is removed
    if (val == this.head.data) {
        this.head = currentNode.next;
        deletedNode = currentNode;
        currentNode = null;
	    this.head.prev = null;
		if(this.head==null){
         document.getElementById("search").disabled=true;
	    document.getElementById("remove").disabled=true;
		}
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
		return "element "+val+" is not in list";
	}else{
      beforeNodeToDelete.next = nodeToDelete.next;
       if(nodeToDelete.next!=null){
         nodeToDelete.next.prev = beforeNodeToDelete;
       }
        deletedNode = nodeToDelete;
        nodeToDelete = null;
	}
    return "element "+deletedNode.data +" has been  deleted ";
};

	
}

var linkedList= new DoublyLinkedList();

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
function printR(){
	linkedList.printListR();
}
