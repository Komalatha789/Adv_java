function convertTocelsius()
{
	//read the fahrenheitInput store in variable
	const FahrenheitInput=document.getElementById('fahrenheitInput').value;

    //convert the FahrenheitInput to celsius
     const celsiustemparature=(parseFloat(FahrenheitInput)-32)*5/9;
     //set the output to celsius field
     document.getElementById('CelsiusOutput').value=celsiustemparature.toFixed(2);
     }