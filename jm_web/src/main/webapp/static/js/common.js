
function isEmail(str) {
   var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
   return reg.test(str);
}

/**
 * 
 * @param diffDay
 * @returns {Date}
 */
function getDate(diffDay) {
	var d=new Date(); 
	d.setDate(d.getDate() + diffDay); 
	return d;
}