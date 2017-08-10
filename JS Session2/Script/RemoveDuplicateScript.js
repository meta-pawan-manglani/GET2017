function initializeField(){
	document.getElementById("inpt").value="";
}
function checkData(){
        
		var str = document.getElementById("inpt").value;
		str = str.trim();
		document.getElementById("inpt").value="";
		var prevPos=0;
		var curPos=0;
		var curLength=0;
		var result=str;
if(str.length==0){
	alert("Please Insert an Element");
}else{
		while(curPos<str.length){
			if(str.charAt(prevPos)==str.charAt(curPos)){
				curPos++;
				curLength++;
			}else if(curLength>1){
				str = str.slice(0,prevPos) + str.slice(curPos);
				result+="->"+str;
				prevPos = prevPos-1>0?prevPos-1:0;
				curPos = prevPos;
				curLength=0;
			}
			else{
				prevPos = curPos;
				curLength=0;
			}
		}
		if(curLength>1){
			str = str.slice(0,prevPos) + str.slice(curPos,str.length);
		}
		if(str.length==0){
			result+="-> EMPTY";
		}
}
document.getElementById("result").innerHTML=result;
}