var checkValid = function(mat,x,y){
	if(x<mat.length && y<mat[0].length && x > -1 && y > -1){
		return true;
	}
	return false;
}

var printWords = function(mat, x,y, word){
	if(word.length===5){
		return;
	}

	if(checkValid(mat,x,y)){
	word = word.concat(mat[x][y]);
	console.log(word);
		printWords(mat,x+1,y,word);
		printWords(mat,x,y+1,word);
		printWords(mat,x-1,y,word);
		printWords(mat,x,y-1,word);
	} 
	//console.log("Index out of range");
};


(function(){
	var mat = [
	['a','b','c','d'],
	['p','q','r','s'], 
	['u','v','w','x'],
	['t','o','m','p']];
  var x = 0;
	var y = 2;
	printWords(mat, x, y, "");
})();
