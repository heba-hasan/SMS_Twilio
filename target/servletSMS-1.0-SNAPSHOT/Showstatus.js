//var send_button=document.getElementsByClassName("sub");
//import { Stat } from './newjavascript.js';
//console.log(Stat);

//document.addEventListener("DOMContentLoaded", function() {
//    var messageStatus = document.getElementById('messageStatus').dataset.status;
//    console.log("Message Status:", messageStatus);
//    // Use the messageStatus variable as needed
//});
function showstatus()
{
        console.log();

   if(Stat)
{
    console.log(Stat);
    setTimeout(()=>{
            var Status=document.getElementsByClassName("status")[0];
            Status.innerText="Delieverd";
            document.getElementsByClassName("status")[0].style.color='green';
                    document.getElementsByClassName("status")[0].style.display='visible';

    },5000);

    
}

else
   {
    setTimeout(()=>{
            var Status=document.getElementsByClassName("status")[0];
            Status.innerText="Failed!";
            document.getElementsByClassName("status")[0].style.color='red';
                    document.getElementsByClassName("status")[0].style.display='visible';

    },5000);

     
}

} 
