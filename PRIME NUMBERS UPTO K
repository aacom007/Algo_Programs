// PRINT ALL PRIME NUMBER UPTO K
var prime = function(j){
	var p = true;
	for(var i=2;i<=Math.sqrt(j);i++){
		if(j%i==0){
			p = false;
			//console.log(p);
			j++;
			break;
		}
	}
	return p;
};


//If j is prime then all values between 2- Math.sqrt(j) cannot divide it 
	
(function(){
	var arr = [];
	var k = 15;
	var j =1;
	while(arr.length<15){
		if(prime(j)===true){
			arr.push(j);
		}
		j++;
	}
	console.log(arr);
})();

