//Cookie
const cookieArr = document.cookie.split("=")
const employeeId = cookieArr[1];
if (employeeId == null){
    window.location.replace("http://localhost:8080/html/login.html");
    window.alert("You are not authorized to access this page...");

}
function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}