function sum(x) {
if(arguments.length > 1){
var sum = 0;
for(var index = 0;index<arguments.length;index++)
sum=sum+arguments[index];
document.getElementById("sum").innerHTML = sum;
}
   return function(y) {
       if (typeof y !== 'undefined') {
           x = x + y;
           return arguments.callee;
       } else {
           document.getElementById("sum2").innerHTML = x;
       }
   }
}