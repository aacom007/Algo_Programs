/**
* possible path to index i,j from 0,0 using DP
 */


var possiblePaths = function(mat,x,y, matrix){
	printMat(matrix);
	for(var i=1;i<=x;i++){
		for(var j=1;j<=y;j++){
			console.log("left: "+matrix[i-1][j]+" top"+matrix[i][j-1]+" diag:"+matrix[i-1][j-1]);
			matrix[i][j] = Math.max(matrix[i-1][j-1], Math.max(matrix[i-1][j], matrix[i][j-1]))+1;	
		}
	}
	//if(x===3 && y===3){
		console.log("Total number of paths :"+ matrix[x][y]);
	//}
};


var printMat = function(matrix){
	for(var i=0;i<matrix.length;i++){
		//matrix[i]=[];
		for(var j=0;j<matrix[0].length;j++){
			//matrix[i][j]=0;
			console.log(matrix[i][j]);
		}
	}
};

(function(){
	var matrix=[]
	var mat = [
	['a','b','c','d','g','g'],
	['p','q','r','s','d','d'], 
	['u','v','w','x','w','g'],
	['t','o','m','p','e','r']];

	for(var i=0;i<mat.length;i++){
		matrix[i]=[];
		for(var j=0;j<mat[0].length;j++){
			matrix[i][j]=0;
		}
	}

	var x = 0;
	var y = 2;
	var line = "";
	possiblePaths(mat,3,5, matrix);
	for(var i=0;i<matrix.length;i++){
		for(var j=0;j<matrix[0].length;j++){
			line +=(matrix[i][j]) + ", ";
		}
		console.log(line+"");
		line ="";
	}

})();
 
