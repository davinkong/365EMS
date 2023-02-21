//Cookie
const cookieArr = document.cookie.split("=")
const employeeId = cookieArr[1];

//DOM Elements
const submitForm = document.getElementById("info-form")
const infoContainer = document.getElementById("info-container")

//Modal Elements
let firstNameInfo = document.getElementById(`first-name-info`)
let lastNameInfo = document.getElementById(`last-name-info`)
let emailInfo = document.getElementById(`email-input`)
let streetInfo = document.getElementById(`street-info`)
let cityInfo = document.getElementById(`city-info`)
let stateInfo = document.getElementById(`state-info`)
let zipCodeInfo = document.getElementById(`zip-code-info`)
let phoneNumberInfo = document.getElementById(`phone-info`)
let updateNoteBtn = document.getElementById('update-info-button')

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/info/"

if (employeeId == null){
    window.alert("You are not authorized to access this page...");
    window.location.replace("http://localhost:8080/html/login.html");
}
const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        firstName: document.getElementById("first-name-input").value,
        lastName: document.getElementById("last-name-input").value,
        email: document.getElementById("email-input").value,
        street: document.getElementById("street-input").value,
        city: document.getElementById("city-input").value,
        state: document.getElementById("state-input").value,
        zipCode: document.getElementById("zip-code-input").value,
        phoneNumber: document.getElementById("phone-input").value,
        //need to call the end point for the server
    }
    // let fileElement = document.getElementById("photo-input")
    // let file = fileElement.files[0];
    // let formData = new FormData();
    // formData.set('file', file);
    // await addPhotoFile(formData);
    await addInfo(bodyObj);
    document.getElementById("first-name-input").value = ''
    document.getElementById("last-name-input").value = ''
    document.getElementById("email-input").value = ''
    document.getElementById("street-input").value = ''
    document.getElementById("city-input").value = ''
    document.getElementById("state-input").value = ''
    document.getElementById("zip-code-input").value = ''
    document.getElementById("phone-input").value = ''

}

async function addInfo(obj) {
    const response = await fetch(`${baseUrl}employee/${employeeId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        window.location.replace("http://localhost:8080/html/employeeInfo/employeePage.html")
        return getInfo(employeeId);

    }
}
async function addPhotoFile(obj) {
    const response = await fetch(`${baseUrl}employee/file`, {
        method: "POST",
        body: obj,
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
      //  return getInfo(employeeId);
    }
}
async function getInfo(employeeId) {
    await fetch(`${baseUrl}employee/${employeeId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => postInformation(data))
        .catch(err => console.error(err))

    console.log(employeeId)
}
async function getImage(imageName) {
    await fetch(`${baseUrl}${imageName}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => postInformation(data))
        .catch(err => console.error(err))

}
async function getInfoById(informationId){
    await fetch(baseUrl + informationId, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => populateModal(data))
        .catch(err => console.error(err.message))

}


async function handleInfoEdit(informationId){
    let bodyObj = {
        id: informationId,
        street: streetInfo.value,
        city: cityInfo.value,
        state: stateInfo.value,
        zipCode: zipCodeInfo.value,
        phoneNumber: phoneNumberInfo.value
    }
    console.log(bodyObj);
    await fetch(baseUrl + `employee` , {
        method: "PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err))
    console.log("Edit");
    return getInfo(employeeId);

}

async function handleDelete(informationId){
    await fetch(baseUrl + informationId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))
    console.log("delete");
    return getInfo(employeeId);
}



const postInformation = (array) => {
    infoContainer.innerHTML = ''
    array.forEach(obj => {
        let infoForm = document.createElement("div")
        infoForm.classList.add("m-2")
        infoForm.innerHTML = `
            <div class="form-group">
       
                <div class="card">
                    <div class="header">
                        <h1 style="text-align: center">${obj.firstName} ${obj.lastName} </h1>
                        <h5 style="text-align: center">${obj.email}</h5>
                    </div>
                    <div class="body">
                        <table class="table">
                       
                            <tr>
                                <th>Street:</th>
                                <td>${obj.street}</td>
                            </tr>
                            <tr>
                                <th>City:</th>
                                <td>${obj.city}</td>
                            </tr>
                            <tr>
                                <th>State:</th>
                                <td>${obj.state}</td>
                            </tr>
                            <tr>
                                <th>Zip Code:</th>
                                <td>${obj.zipCode}</td>
                            </tr>
                            <tr>
                                <th>Phone number:</th>
                                <td>${obj.phoneNumber.toString().substring(0,3)}-${obj.phoneNumber.toString().substring(3,6)}-${obj.phoneNumber.toString().substring(6)}</td>
                            </tr>
        
                            
                        </table>
                        <div class="d-flex justify-content-between">
                                <button onclick="getInfoById(${obj.id})" type="button" class="btn btn-edit"
                                data-bs-toggle="modal" data-bs-target="#info-edit-modal">
                                Edit address
                                </button>
                        </div>
                    </div>
                </div>
            </div>
        `
        infoContainer.append(infoForm);
        document.getElementById('form-button').style.display="none";
    })
}
function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

const populateModal = (obj) =>{
    console.log(obj);

    streetInfo.innerText = ''
    streetInfo.innerText = obj.street
    cityInfo.innerText = ''
    cityInfo.innerText = obj.city
    stateInfo.innerText = ''
    stateInfo.innerText = obj.state
    zipCodeInfo.innerText = ''
    zipCodeInfo.innerText = obj.zipCode
    phoneNumberInfo.innerText = ''
    phoneNumberInfo.innerText = obj.phoneNumber

    updateNoteBtn.setAttribute('data-info-id', obj.id)
}


getInfo(employeeId);

submitForm.addEventListener("submit", handleSubmit)

updateNoteBtn.addEventListener("click", (e)=>{
    console.log("reaching");
    let informationId = e.target.getAttribute('data-info-id')
    handleInfoEdit(informationId);
})