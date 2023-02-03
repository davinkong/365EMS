//Cookie
const cookieArr = document.cookie.split("=")
const employeeId = cookieArr[1];
if (employeeId == null){
    window.alert("You are not authorized to access this page...");
    window.location.replace("http://localhost:8080/html/login.html");
}
let ifEmpty = document.getElementById("list-all");

if (ifEmpty == null){
    //alert("No Requests")
    document.write("<h2 style='text-align: center'>No Requests at this time...</h2>")
}