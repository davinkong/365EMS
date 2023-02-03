let loginForm = document.getElementById('login-form')
let loginUsername = document.getElementById('login-username')
let loginPassword = document.getElementById('login-password')


const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/employees'

const handleSubmit = async (e)=>{
    e.preventDefault();

    let bodyObj = {
        'username': loginUsername.value,
        'password': loginPassword.value,
    }

    const response = await fetch(`${baseUrl}/login`, {
        method: 'POST',
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()



    if(response.status === 200){
        document.cookie = `employeeId=${responseArr[1]}; path=/; expires=Tue, 19 Jan 2038 03:14:07 GMT`
        window.location.replace(responseArr[0])

    }else{
        alert("Wrong Username Or Password!")
        window.location.replace("http://localhost:8080/html/login.html")
    }


}

loginForm.addEventListener("submit", handleSubmit)
