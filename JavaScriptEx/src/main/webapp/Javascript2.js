function convertToINR()
{
	//read the DollarInput store in variable
	const DollarInput=document.getElementById('DollarInput').value;

    //convert the DollarInput to INR
     const INR=(parseInt(DollarInput))*84;
     //set the output to INR field
     document.getElementById('INROutput').value=INR.toFixed(2);
     }
 
 