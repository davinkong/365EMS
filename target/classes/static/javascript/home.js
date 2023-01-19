
//Cookie
const cookieArr = document.cookie.split("=")
const employeeId = cookieArr[1];


function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}
if (employeeId == null){
    document.getElementById("logout").style.display="none";
    document.getElementById("navbarDropdownMenuLink").style.display="none";
    document.getElementById("emp-page").style.display="none";
    document.getElementById("fto").style.display="none";
}else {
    document.getElementById("login").style.display="none";
    document.getElementById("register").style.display="none";

}
console.log(employeeId)




