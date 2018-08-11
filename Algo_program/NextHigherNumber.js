 


var getNumber= function(n){
 	var num = new Array();
 	for(var i=1;i<=n;i++){
 		num.push(i);
 	}
 	return num;
 };


 var getIndex = function(n){
 	for(var i=n.length-1;i>=0;i--){
 		if(n[i-1]<n[i]){
 			return i-1;
 		}
 	}
 	return -1;
 }

var swap = function(n,i,j){
	var s = n[i];
	n[i]=n[j];
	n[j]=s;
	return n;
} 

var getPivot = function(n){
	for(var i=n.length-1;i>0;i--){
		if(n[i]>n[i-1]){
			return i-1;
		}
	}
}

var findSmallestGreater = function(n, index){
	var min = n[index+1];
	var indexFound = index+1;
	for(var i=index;i<n.length;i++){
		if(n[i]>n[index] && n[i]<min){
			min = n[i];
			indexFound = i;
		}
	}
	return indexFound;
}

var getNext = function(n){
	if(n.length<2){
		return n;
	}
	if(n===2){
		return swap(n,0,1);
	}

	var pivot = getPivot(n);
	var index = findSmallestGreater(n,pivot);
	n = swap(n,pivot,index);
	var two = n.slice(pivot+1);
	var one = n.splice(0,pivot+1);
 	return one.concat(two.sort());
};


(function(){
	var n = getNumber(3);
	console.log(n);
	for(var i=0;i<10;i++)
	{
		n = getNext(n);
		console.log(n);
	}
})();


