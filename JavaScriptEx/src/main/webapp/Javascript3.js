function Reverse()
{
	//read the Input and set to variable
	let string=document.getElementById('StringInput').value

    //reverse the string
     let rev=string.split('').reverse().join('')
     //set the output 
     document.getElementById('ReversestringOutput').value=rev
     }
 